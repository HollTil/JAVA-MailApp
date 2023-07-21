package UI;
import Helper.Validator;
import Mail.Mail;
import Sender.Sender;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TerminalUI {
    public static Mail runTerminal() throws Exception {
        Mail mail = new Mail();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("Bitte gib die Email-Adresse des Empfängers ein: ");
                String recipient = scanner.nextLine();

                if (Validator.isValid(recipient)) {
                    mail.setRecipient(recipient);
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Bitte gib einen Betreff an: ");
                String subject = scanner.nextLine();
                
                if (Validator.subjectValid(subject)) {
                    mail.setSubject(subject);
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }


        System.out.println("Bitte gib deine Nachricht ein: ");
        String message = scanner.nextLine();
        mail.setMessage(message);

        return mail;
    }
}
