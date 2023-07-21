import Mail.Mail;
import Sender.Sender;
import UI.SwingUI;

public class Main {
    public static void main(String[] args) {
        //test();
        try {
            //Mail mail = TerminalUI.runTerminal();
            //Sender sender = new Sender();
            //sender.send(mail);
            SwingUI ui = new SwingUI();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    private static void test(){
        Mail mail = new Mail();

        mail.setRecipient("detilman83@gmail.com");
        mail.setSubject("Test mit JAVA Mail App");
        mail.setMessage("Hallo, jetzt haben Sie auch eine Email von mir...");

        try {
            Sender sender = new Sender();
           // for (int i = 0; i<100; i++) {  <= for-Schleife für vielfaches Senden an eine Email-Adresse (hier 100x)
                sender.send(mail);
           // }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}