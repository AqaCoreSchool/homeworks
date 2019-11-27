package orangetest;

public class Main {
    public static void main(String[] args) {
        OrangeTest test = new OrangeTest();
        test.testPrecondition();
        test.testPunchIn();
        test.testPunchOut();
        test.testCheckRecord();
        test.close();
    }
}
