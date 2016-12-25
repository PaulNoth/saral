public class ClassDeclaration {

    private String className;
    private ClassBody classBody;

    public ClassDeclaration(String className, ClassBody classBody) {
        this.className = className;
        this.classBody = classBody;
    }

    public String getClassName() {
        return className;
    }

    public ClassBody getClassBody() {
        return classBody;
    }
}
