
public class CompilationUnit {

    private ClassDeclaration classDeclaration;

    public CompilationUnit(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public String getClassName() {
        return classDeclaration.getClassName();
    }

    public byte[] getByteCode() {
        ClassGenerator classGenerator = new ClassGenerator();
        return classGenerator.generateByteCode(classDeclaration);
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }
}
