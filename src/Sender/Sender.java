package Sender;
import Mail.Mail;
import SMTP.SMTPConnection;
import javax.mail.*;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.*;

public class Sender {
    private SMTPConnection connection;
    private Session session;
    public Sender() throws Exception {
        this.connection = new SMTPConnection();
        try {
            Session session = this.connection.getConnection();
        } catch (Exception ex){
            System.out.println("LOG: " + ex.getMessage());
            throw new Exception("Connection failed");
        }
    }

    public boolean send(Mail mail) throws AddressException, MessagingException, Exception {



    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(this.connection.getFrom()));

    message.setRecipients(
            Message.RecipientType.TO, InternetAddress.parse(mail.getRecipient()));

    message.setSubject(mail.getSubject());

    // Content besteht aus Bodyparts = text, anhang etc wird zusammengefasst als Content
    MimeBodyPart mimeBodyPart = new MimeBodyPart();
    mimeBodyPart.setContent(mail.getMessage(), "text/html; charset=utf-8");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(mimeBodyPart);

    message.setContent(multipart);
    try {
    Transport.send(message);
    } catch (Exception ex ){
        throw new Exception("Cannot send Message!");
    }
        return true;
    }
}
