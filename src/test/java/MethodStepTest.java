import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class MethodStepTest {

    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "Sago0/qa_guru_4_5";
    private static final String ISSUE_NAME = "Issue example";

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueName(ISSUE_NAME);
    }
}
