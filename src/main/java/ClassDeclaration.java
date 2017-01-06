import java.util.ArrayList;
import java.util.List;

public class ClassDeclaration {

    private String className;
    private List<Function> methods;

    public ClassDeclaration(String className, List<Function> methods) {
        this.className = className;
        this.methods = new ArrayList<>(methods);
    }

    public String getClassName() {
        return className;
    }

    public List<Function> getMethods() {
        return new ArrayList<>(methods);
    }
}
