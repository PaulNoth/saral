public class ClassDeclarationVisitor extends EnkelBaseVisitor<ClassDeclaration>{

    @Override
    public ClassDeclaration visitClassDeclaration(EnkelParser.ClassDeclarationContext ctx) {
        String className = ctx.className().getText();
        ClassBody classBody = ctx.classBody().accept(new ClassBodyVisitor(new StatementVisitor()));
        return new ClassDeclaration(className, classBody);
    }
}
