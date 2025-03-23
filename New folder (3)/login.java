import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idLogintextfield;
    private JPasswordField passwordField;
    private String selectedYear = "1st Year"; // Default values
    private String selectedSemester = "First Semester"; // Default values

    /**
     * Create the frame.
     */
    public login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 607, 439);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setBounds(346, 196, 195, 27);
        contentPane.add(passwordField);

        JLabel lblNewLabel_2 = new JLabel("Login");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 38));
        lblNewLabel_2.setBounds(358, 66, 156, 64);
        contentPane.add(lblNewLabel_2);

        idLogintextfield = new JTextField();
        idLogintextfield.setBounds(346, 158, 195, 27);
        contentPane.add(idLogintextfield);
        idLogintextfield.setColumns(10);

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(255, 165, 0));
        registerButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        registerButton.setBounds(346, 256, 89, 23);
        contentPane.add(registerButton);

        JButton signinButton_1 = new JButton("Sign in");
        signinButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        signinButton_1.setBounds(452, 256, 82, 23);
        contentPane.add(signinButton_1);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Oliver Colao\\Desktop\\evaluation system\\res\\login (1) (1).png"));
        lblNewLabel.setBounds(63, 53, 177, 143);
        contentPane.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLUE);
        panel_1.setBounds(296, 0, 297, 402);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Oliver Colao\\Desktop\\evaluation system\\res\\loginpng1.jpg"));
        lblNewLabel_1.setBounds(0, 196, 329, 223);
        contentPane.add(lblNewLabel_1);

        // Action Listeners
        signinButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idLogintextfield.getText();
                String password = new String(passwordField.getPassword());

                // Validate login credentials using the shared database
                if (Main.userDatabase.containsKey(id) && Main.userDatabase.get(id).equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    // Open Grade Input Screen with the selected year and semester
                    GradeInputScreen gradeInputScreen = new GradeInputScreen(selectedYear, selectedSemester);
                    gradeInputScreen.setVisible(true);
                    dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Please check your username and password.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration screen
                register regFrame = new register();
                regFrame.setVisible(true);
                dispose(); // Close the login window
            }
        });
    }

    // Setters for selected year and semester
    public void setSelectedYear(String year) {
        this.selectedYear = year;
    }

    public void setSelectedSemester(String semester) {
        this.selectedSemester = semester;
    }
}