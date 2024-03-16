package Authentication;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Authentication {
    private final Map<String, Integer> auths;
    public Authentication() {
        auths = new HashMap<>(4);
        String default_user = "Admin";
        auths.put(default_user, default_user.hashCode());
    }
    public void buildAuthentication() {
        login();
    }

    private void login() {
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
        JButton register = new JButton("Register");

        user.setBounds(5, 5, 200, 60);
        password.setBounds(5, 65, 200, 60);

        userField.setBounds(205, 5, 175, 60);
        passwordField.setBounds(205, 65, 175, 60);

        clear.setBounds(5, 125, 190, 60);
        register.setBounds(5, 190, 190, 60);
        login.setBounds(205, 125, 175, 60);

        clear.addActionListener(e -> {
            userField.setText("");
            passwordField.setText("");
        });
        login.addActionListener(e -> {
            String user_name = userField.getText();
            String password_credential = new String(passwordField.getPassword());
            boolean isUser = false;

            for (var entry : auths.entrySet()) {
                if (Objects.equals(entry.getKey(), user_name) && Objects.equals(entry.getValue(), password_credential.hashCode())) {
                    isUser = true;
                    break;
                }
            }

            if(isUser) {
                landingPage();
                frame.dispose();
                return;
            }
            userField.setText("");
            passwordField.setText("");
        });

        frame.add(user);
        frame.add(password);
        frame.add(userField);
        frame.add(passwordField);
        frame.add(clear);
        frame.add(login);
        frame.add(register);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void landingPage() {
        JFrame frame = new JFrame("DashBoard");

        JLabel label = new JLabel("Welcome to DashBoard");
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.setBounds(100, 100, 200, 200);

        frame.add(label);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
