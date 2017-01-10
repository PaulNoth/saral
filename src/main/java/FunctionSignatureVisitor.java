import java.util.ArrayList;
import java.util.List;

public class FunctionSignatureVisitor extends EnkelBaseVisitor<FunctionSignature> {

    @Override
    public FunctionSignature visitFunctionDeclaration(EnkelParser.FunctionDeclarationContext ctx) {
        String funName = ctx.functionName().getText();
        List<EnkelParser.FunctionArgumentContext> argumentContextList = ctx.functionArgument();
        List<FunctionParameter> parameters = new ArrayList<>();
        for(int i = 0; i < argumentContextList.size(); i++) {
            EnkelParser.FunctionArgumentContext argCtx = argumentContextList.get(i);
            String name = argCtx.ID().getText();
            Type type = TypeResolver.getFromTypeName(argCtx.type());
            FunctionParameter param = new FunctionParameter(name, type);
            parameters.add(param);
        }
        Type returnType = TypeResolver.getFromTypeName(ctx.type());
        return new FunctionSignature(funName, parameters, returnType);
    }
}
