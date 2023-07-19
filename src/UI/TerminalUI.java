package UI;

import Mail.Mail;
import Sender.Sender;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TerminalUI {
    public static void runTerminal() throws Exception {
        String recipient;
        String subject;
        String message;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte gib die Email des Empfängers ein: ");
        recipient = scanner.nextLine();


        System.out.println("Bitte gib einen Betreff an: ");
        subject = scanner.nextLine();


        System.out.println("Bitte gib deine Nachricht ein: ");
        message = scanner.nextLine();

        Mail mail = new Mail();
        mail.setRecipient(recipient);
        mail.setSubject(subject);
        mail.setMessage(message);

        Sender sender = new Sender();
        sender.send(mail);
    }
}
