package UI;

import javax.swing.*;

public class SwingUI {
    private JPanel panel1;
    private JButton ok;
    private JLabel emailAdressLabel;
    private JTextField emailAdressTextfield;
    private JLabel subjectLabel;
    private JTextField subjectTextfield;

    private JTextField emailTextfield;
    private JLabel messageLabel;
    private JTextField messageTextfield;
    private JButton sendButton;
    private JButton clearButton;

    public SwingUI (){
        JFrame frame = new JFrame("Mailapp");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}