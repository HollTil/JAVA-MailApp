import Mail.Mail;
import Sender.Sender;

public class Main {
    public static void main(String[] args) {
        test();
    }
    private static void test(){
        Mail mail = new Mail();

        mail.setRecipient("detilman83@gmail.com");
        mail.setSubject("Test mit JAVA Mail App");
        mail.setMessage("Hallo, jetzt haben Sie auch eine Email von mir...");

        try {
            Sender sender = new Sender();
           // for (int i = 0; i<100; i++) {  <= for-Schleife für vielfaches Senden an eine Email-Adresse
                sender.send(mail);
           // }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}