package Helper;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Validator {

    /**
     * Validates subject line. Checks if subject is not NULL or Empty.
     * @param subject
     * @return
     */

    public static boolean subjectValid(String subject){
        if (subject == null || subject.isBlank()) {       // prüft, dass das feld nicht leer ist
            throw new NullPointerException("ERROR: subject adress cannot be null or empty!");// erzeugt eine eigene exception
        }
        return true;
    }


    /**
     * Validates e-mail address. Checks if this not null or empty.
     * Checks if the e-mail address has correct chars sequence.
     *
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail address valid, false if not.
     */
    public static boolean isValid(String email){
        if (email == null || email.isBlank()) {       // prüft, dass das feld nicht leer ist
            throw new NullPointerException("ERROR: E-Mail adress cannot be null or empty!");// erzeugt eine eigene exception
        }

        String cleanMail = email.trim();

        if(!containsMailSign(cleanMail)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not contain or has to many '@' sign!");
        }

        if(!isUsernameValid(cleanMail)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not start with valid username!");
        }

        if(!areDomainAndRootDomainValid(cleanMail, true)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not contain a valid root domain name!");
        }

        if(!areDomainAndRootDomainValid(cleanMail, false)) {
            throw new NoSuchElementException("ERROR: E-Mail address does not contain valid domain name!");
        }

        return true;
    }

    /**
     * Validates whether the String contains "@"-sign.
     * Verify that "@" sign count == 1.
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail contains "@"-sign, false if not.
     */
    private static boolean containsMailSign(String email) {
        //TODO: varify that @ sign count == 1
        int count = 0;
                //email.length() - email.replace("@", "").length();
                // löscht die @-zeichen aus der email-adresse

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') count++;
        }

        return count == 1;
    }

    /**
     * Validates whether the username contains at least 3 chars before @ sign.
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail starts with at least 3 chars before @, false if not.
     */
    private static boolean isUsernameValid(String mail){
        String[] splitEmail = mail.split("@"); // trennt den email string am @ in 2 strings
        return splitEmail[0] != null && splitEmail[0].length() >= 3; //der "username" ist nicht leer && größer als 3 Zeichen

    }

    /**
     * Validates whether the domain name contains at least 3 chars after @ sign.
     * Validates whether the root domain name contains at least 2 chars.
     * @param email String - valid e-mail address as a text.
     * @param isRoot boolean - true if the root name should be validated, false if domain.
     * @return boolean - true if e-mail contains "."
     * and at least 2 chars at the end, false if not.
     */
    private static boolean areDomainAndRootDomainValid(String email, boolean isRoot) {
        String[] splitEmail = email.split("@");     // trennt den email string am @ in 2 strings
        if (splitEmail != null && splitEmail.length == 2) { // besagt, dass nur 2 strings in der email enthalten sein dürfen

            String domainPart = splitEmail[1];
            //if (domainPart.charAt(0) != '.'
            //        && domainPart.charAt(domainPart.length()-1) != '.') return false;
            if (domainPart.charAt(0) != '.'
                    && domainPart.charAt(domainPart.length()-1) != '.') {

                //TODO: validate duplicate of "." I.E. ".."
                String[] domainParts = splitEmail[1].split("\\.");

                if (domainParts != null && domainParts.length > 1) {

                    if (isRoot){
                        //Validate only root domain
                        String rootDomain = domainParts[domainParts.length - 1]; //prüft nur die rootDomain
                        //searches for "de, en, "
                        return rootDomain.length() >= 2; // rootDomain muss größer als 2 Zeichen sein
                    } else {
                        //Validate only domain before root
                        String rootDomain = domainParts[domainParts.length - 2]; // prüft nur die domain
                        return rootDomain.length() >= 3; // domain muss mehr als 3 Zeichen haben
                    }

                }
            }
        }
        return false;
    }
}
