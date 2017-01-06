import java.util.List;
import java.util.stream.Collectors;

public class ClassDeclarationVisitor extends EnkelBaseVisitor<ClassDeclaration>{

    private Scope scope;

    @Override
    public ClassDeclaration visitClassDeclaration(EnkelParser.ClassDeclarationContext ctx) {
        String className = ctx.className().getText();
        FunctionSignatureVisitor functionSignatureVisitor = new FunctionSignatureVisitor();
        List<EnkelParser.FunctionContext> methodsCtx = ctx.classBody().function();
        MetaData metaData = new MetaData(ctx.className().getText());
        scope = new Scope(metaData);

        List<FunctionSignature> signatures = methodsCtx.stream()
                .map(method -> method.functionDeclaration().accept(functionSignatureVisitor))
                .peek(scope::addSignature)
                .collect(Collectors.toList());

        List<Function> methods = methodsCtx.stream()
                .map(method -> method.accept(new FunctionVisitor(scope)))
                .collect(Collectors.toList());
        return new ClassDeclaration(className, methods);
    }
}
