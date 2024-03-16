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
    private int attempt;
    private int originalAttempt;
    public Authentication(int attempt) {
        auths = new HashMap<>(4);
        String default_user = "Admin";
        auths.put(default_user, default_user.hashCode());
        this.attempt = this.originalAttempt = attempt;
    }
    public void buildAuthentication() {
        login();
    }

    private void login() {
        JFrame frame = new JFrame("Exercise 2 AUTHENTICATION SYSTEM");

        JLabel user = new JLabel("User Name");
        JLabel password = new JLabel("Password");
        JLabel logAttempt = new JLabel("You have " + Integer.toString(originalAttempt) + " Left !");

        user.setVerticalAlignment(SwingConstants.CENTER);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        password.setVerticalAlignment(SwingConstants.CENTER);
        password.setHorizontalAlignment(SwingConstants.CENTER);
        logAttempt.setVerticalAlignment(SwingConstants.CENTER);
        logAttempt.setHorizontalAlignment(SwingConstants.CENTER);

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

        logAttempt.setBounds(100, 300, 200, 50);

        clear.addActionListener(e -> {
            userField.setText("");
            passwordField.setText("");
        });
        login.addActionListener(e -> {
            String user_name = userField.getText();
            String password_credential = new String(passwordField.getPassword());
            boolean isUser = false;
            if(--attempt == 0) {
                page("Locked", "You have tried all " + Integer.toString(originalAttempt) + " attempt !\nYou have been locked out !");
                frame.dispose();
            }
            for (var entry : auths.entrySet()) {
                if (Objects.equals(entry.getKey(), user_name) && Objects.equals(entry.getValue(), password_credential.hashCode())) {
                    isUser = true;
                    break;
                }
            }

            if(isUser) {
                page("DashBoard", "Welcome to DashBoard");
                frame.dispose();
                return;
            }
            userField.setText("");
            passwordField.setText("");
            logAttempt.setText("You have " + Integer.toString(attempt) + " Left !");
        });

        register.addActionListener(e -> {
            register();
            frame.dispose();
        });

        frame.add(user);
        frame.add(password);
        frame.add(userField);
        frame.add(passwordField);
        frame.add(clear);
        frame.add(login);
        frame.add(register);
        frame.add(logAttempt);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void register() {
        JFrame frame = new JFrame("Register");

        JLabel user = new JLabel("User Name");
        JLabel password = new JLabel("Password");
        JLabel confirm = new JLabel("Re-Type Password");
        JLabel info = new JLabel("");


        user.setVerticalAlignment(SwingConstants.CENTER);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        password.setVerticalAlignment(SwingConstants.CENTER);
        password.setHorizontalAlignment(SwingConstants.CENTER);
        confirm.setVerticalAlignment(SwingConstants.CENTER);
        confirm.setHorizontalAlignment(SwingConstants.CENTER);
        info.setVerticalAlignment(SwingConstants.CENTER);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField userField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmField = new JPasswordField();

        JButton login = new JButton("Login");
        JButton clear = new JButton("Clear");
        JButton register = new JButton("Register");

        user.setBounds(5, 5, 200, 60);
        password.setBounds(5, 65, 200, 60);
        confirm.setBounds(5, 125, 200, 60);

        userField.setBounds(205, 5, 175, 60);
        passwordField.setBounds(205, 65, 175, 60);
        confirmField.setBounds(205, 125, 175, 60);

        clear.setBounds(5, 190, 190, 60);
        login.setBounds(5, 255, 190, 60);
        register.setBounds(205, 190, 175, 60);

        info.setBounds(100, 300, 200, 50);


        clear.addActionListener(e -> {
            userField.setText("");
            passwordField.setText("");
        });
        login.addActionListener(e -> {
            login();
            frame.dispose();
        });

        register.addActionListener(e -> {
            String user_name = userField.getText();
            String password_credential = new String(passwordField.getPassword());
            String confirmation = new String(confirmField.getPassword());
            boolean isExist = false;

            if(password_credential.isEmpty()) {
                info.setText("Password Empty !");
                userField.setText("");
                passwordField.setText("");
                confirmField.setText("");
                return;
            };

            if(!password_credential.equals(confirmation)) {
                info.setText("Password Not Match !");
                userField.setText("");
                passwordField.setText("");
                confirmField.setText("");
                return;
            };

            for (var entry : auths.entrySet()) {
                if (Objects.equals(entry.getKey(), user_name)) {
                    info.setText("UserName Already Exist !");
                    userField.setText("");
                    passwordField.setText("");
                    confirmField.setText("");
                    return;
                }
            }

            auths.put(user_name, password_credential.hashCode());

            login();
            frame.dispose();
        });


        frame.add(user);
        frame.add(password);
        frame.add(userField);
        frame.add(passwordField);
        frame.add(clear);
        frame.add(login);
        frame.add(register);
        frame.add(confirm);
        frame.add(confirmField);
        frame.add(info);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void page(String title, String text) {
        JFrame frame = new JFrame(title);
        JLabel label = new JLabel(text);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.setBounds(0, 100, 400, 200);

        frame.add(label);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
