package Authentication;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Authentication {
    public void buildAuthentication() {
        JFrame frame = new JFrame();

        JLabel user = new JLabel("User Name");
        JLabel password = new JLabel("Password");

        user.setVerticalAlignment(SwingConstants.CENTER);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        password.setVerticalAlignment(SwingConstants.CENTER);
        password.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField userField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton login = new JButton("Login");
        JButton clear = new JButton("Clear");

        user.setBounds(5, 5, 200, 60);
        password.setBounds(5, 65, 200, 60);

        userField.setBounds(205, 5, 180, 60);
        passwordField.setBounds(205, 65, 180, 60);

        clear.setBounds(5, 125, 190, 60);
        login.setBounds(205, 125, 180, 60);

        frame.add(user);
        frame.add(password);
        frame.add(userField);
        frame.add(passwordField);
        frame.add(clear);
        frame.add(login);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
