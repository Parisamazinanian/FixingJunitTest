package correct;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({TestEmpListSize.class, TestEmpShuffle.class})
public class TestSuit {
}
