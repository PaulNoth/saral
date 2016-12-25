import java.util.List;
import java.util.stream.Collectors;

public class ClassBodyVisitor extends EnkelBaseVisitor<ClassBody> {

    private StatementVisitor statementVisitor;

    public ClassBodyVisitor(StatementVisitor statementVisitor) {
        this.statementVisitor = statementVisitor;
    }

    @Override
    public ClassBody visitClassBody(EnkelParser.ClassBodyContext ctx) {
        List<ClassScopeInstruction> instructionList = ctx.statement().stream()
                .map(statement -> statement.accept(statementVisitor)).collect(Collectors.toList());
        return new ClassBody(instructionList);
    }
}
