package automation;

public class Main {
    public static void main(String[] args) {
        Automation automation = new Automation();

        automation.generateMessage();

        automation.login();
        automation.navigate();

        automation.writeNote();
        automation.writeNote();
        automation.checkRecord();
    }
}
