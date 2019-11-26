package automation;

public class Main {
    public static void main(String[] args) {
        Automation automation = new Automation();

        String message = automation.generateMessage();

        automation.login();
        automation.navigate();

        automation.writeNote(message);
        automation.writeNote(message);
        automation.checkRecord(message);
    }
}
