public class CompilationUnitVisitor extends EnkelBaseVisitor<CompilationUnit> {
    @Override
    public CompilationUnit visitCompilationUnit(EnkelParser.CompilationUnitContext ctx) {
        String className = ctx.classDeclaration().className().getText();
        ClassDeclarationVisitor classVisitor = new ClassDeclarationVisitor();

        EnkelParser.ClassDeclarationContext classCtx = ctx.classDeclaration();
        ClassDeclaration classDeclaration = classCtx.accept(classVisitor);
        return new CompilationUnit(classDeclaration);
    }
}
