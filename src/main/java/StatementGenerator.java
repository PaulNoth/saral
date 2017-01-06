import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class StatementGenerator {
    private Scope scope;
    private MethodVisitor methodVisitor;
    private ExpressionGenerator expressionGenerator;

    public StatementGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.scope = scope;
        this.methodVisitor = methodVisitor;
        this.expressionGenerator = new ExpressionGenerator(methodVisitor, scope);
    }

    public void generate(PrintStatement statement) {
        Expression expression = statement.getExpression();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        expression.accept(expressionGenerator);
        Type type = expression.getType();
        String exprDescriptor = "(" + type.getDescriptor() + ")V";
        ClassType owner = new ClassType("java.io.PrintStream");
        String fieldDescriptor = owner.getDescriptor();
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, fieldDescriptor, "println", exprDescriptor, false);
    }

    public void generate(VariableDeclaration statement) {
        Expression expression = statement.getExpression();
        String name = statement.getName();
        int index = scope.getLocalVariableIndex(name);
        Type type = expression.getType();
        expression.accept(expressionGenerator);
        if(type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ISTORE, index);
        } else {
            methodVisitor.visitVarInsn(Opcodes.ASTORE, index);
        }
        scope.addLocalVariable(new LocalVariable(name, expression.getType()));
    }

    public void generate(FunctionCall functionCall) {
        functionCall.accept(expressionGenerator);
    }
}
