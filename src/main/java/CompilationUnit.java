public class CompilationUnit {

    private ClassDeclaration classDeclaration;

    public CompilationUnit(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public String getClassName() {
        return classDeclaration.getClassName();
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }
}
