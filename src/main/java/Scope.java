import java.util.ArrayList;
import java.util.List;

public class Scope {
    private List<LocalVariable> localVariables;
    private List<FunctionSignature> functionSignatures;
    private final MetaData metaData;

    public Scope(MetaData metaData) {
        this.localVariables = new ArrayList<>();
        this.functionSignatures = new ArrayList<>();
        this.metaData = metaData;
    }

    public Scope(Scope scope) {
        this.metaData = scope.metaData;
        this.functionSignatures = new ArrayList<>(scope.functionSignatures);
        this.localVariables = new ArrayList<>(scope.localVariables);
    }

    public void addSignature(FunctionSignature signature) {
        functionSignatures.add(signature);
    }

    public FunctionSignature getSignature(String methodName) {
        return functionSignatures.stream()
                .filter(signature -> signature.getName().equals(methodName))
                .findFirst()
                .orElseThrow(() -> new MethodSignatureNotFoundException(this,methodName));
    }

    public void addLocalVariable(LocalVariable localVariable) {
        localVariables.add(localVariable);
    }

    public LocalVariable getLocalVariable(String varName) {
        System.out.println(varName);
        return localVariables.stream()
                .filter(variable -> variable.getName().equals(varName))
                .findFirst()
                .orElseThrow(() -> new LocalVariableNotFoundException(this, varName));
    }

    public int getLocalVariableIndex(String varName) {
        LocalVariable localVariable = getLocalVariable(varName);
        return localVariables.indexOf(localVariable);
    }

    public String getClassName() {
        return metaData.getClassName();
    }
}
