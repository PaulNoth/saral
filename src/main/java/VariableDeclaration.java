import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class VariableDeclaration implements Instruction, Opcodes {
    Variable variable;

    public VariableDeclaration(Variable variable) {
        this.variable = variable;
    }

    @Override
    public void apply(MethodVisitor mv) {
        final int type = variable.getType();
        if(type == EnkelLexer.NUMBER) {
            int val = Integer.valueOf(variable.getValue());
            mv.visitIntInsn(BIPUSH, val);
            mv.visitVarInsn(ISTORE, variable.getId());
        } else if(type == EnkelLexer.STRING) {
            mv.visitLdcInsn(variable.getValue());
            mv.visitVarInsn(ASTORE, variable.getId());
        }
    }
}