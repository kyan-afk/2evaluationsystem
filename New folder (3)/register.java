import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameInputtextfield;
    private JTextField idNumberinputtextfield_1;
    private JPasswordField passwordField;
    private JTextField genderInputtextfield_3;
    private JComboBox<String> yearInputcombobox;
    private JComboBox<String> semisterInputcombobox_1;

    /**
     * Create the frame.
     */
    public register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 607, 439);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Oliver Colao\\Desktop\\evaluation system\\res\\login (1) (1).png"));
        lblNewLabel.setBounds(364, 62, 177, 143);
        contentPane.add(lblNewLabel);

        nameInputtextfield = new JTextField();
        nameInputtextfield.setBounds(103, 102, 157, 23);
        contentPane.add(nameInputtextfield);
        nameInputtextfield.setColumns(10);

        // Initialize the instance variable
        yearInputcombobox = new JComboBox<>(new String[]{"1st Year", "2nd Year", "3rd Year", "4th Year"});
        yearInputcombobox.setMaximumRowCount(4);
        yearInputcombobox.setBounds(103, 238, 157, 23);
        contentPane.add(yearInputcombobox);

        JLabel lblNewLabel_2 = new JLabel("Register");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
        // lblNewLabel_2.setBounds(79, 27, 156, 64);
        lblNewLabel_2.setBounds(79, 27, 181, 64);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Name");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_3.setBounds(30, 105, 63, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("ID Number ");
        lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_3_1.setBounds(30, 139, 63, 14);
        contentPane.add(lblNewLabel_3_1);

        JLabel lblNewLabel_3_2 = new JLabel("Password");
        lblNewLabel_3_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_3_2.setBounds(30, 173, 63, 14);
        contentPane.add(lblNewLabel_3_2);

        JLabel lblNewLabel_3_3 = new JLabel("Program");
        lblNewLabel_3_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_3_3.setBounds(30, 207, 63, 14);
        contentPane.add(lblNewLabel_3_3);

        JLabel lblNewLabel_3_4 = new JLabel("Year");
        lblNewLabel_3_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_3_4.setBounds(30, 241, 63, 14);
        contentPane.add(lblNewLabel_3_4);

        idNumberinputtextfield_1 = new JTextField();
        idNumberinputtextfield_1.setColumns(10);
        idNumberinputtextfield_1.setBounds(103, 136, 157, 23);
        contentPane.add(idNumberinputtextfield_1);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(103, 170, 157, 23);
        contentPane.add(passwordField);

        genderInputtextfield_3 = new JTextField();
        genderInputtextfield_3.setColumns(10);
        genderInputtextfield_3.setBounds(102, 204, 80, 23);
        contentPane.add(genderInputtextfield_3);

        JButton continueButton_1 = new JButton("Continue ");
        continueButton_1.setHorizontalAlignment(SwingConstants.LEFT);
        continueButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        continueButton_1.setBounds(176, 329, 95, 23);
        contentPane.add(continueButton_1);

        JButton removeButton = new JButton("Remove");
        removeButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        removeButton.setBackground(new Color(255, 165, 0));
        removeButton.setBounds(71, 329, 95, 23);
        contentPane.add(removeButton);

        JLabel lblNewLabel_3_4_1 = new JLabel("Semester ");
        lblNewLabel_3_4_1.setForeground(Color.WHITE);
        lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_3_4_1.setBounds(30, 275, 63, 14);
        contentPane.add(lblNewLabel_3_4_1);

        // Initialize the instance variable
        semisterInputcombobox_1 = new JComboBox<>(new String[]{"First Semester", "Second Semester"});
        semisterInputcombobox_1.setMaximumRowCount(2);
        semisterInputcombobox_1.setBounds(103, 272, 157, 23);
        contentPane.add(semisterInputcombobox_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLUE);
        panel_1.setBounds(0, 0, 297, 402);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Oliver Colao\\Desktop\\evaluation system\\res\\loginpng1.jpg"));
        lblNewLabel_1.setBounds(295, 204, 329, 223);
        contentPane.add(lblNewLabel_1);

        // Action Listeners
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all inputs
                nameInputtextfield.setText("");
                idNumberinputtextfield_1.setText("");
                passwordField.setText("");
                genderInputtextfield_3.setText("");
                yearInputcombobox.setSelectedIndex(0);
                semisterInputcombobox_1.setSelectedIndex(0);
            }
        });

        continueButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate inputs
                String name = nameInputtextfield.getText();
                String idNumber = idNumberinputtextfield_1.getText();
                String password = new String(passwordField.getPassword());
                String gender = genderInputtextfield_3.getText();
                String year = (String) yearInputcombobox.getSelectedItem();
                String semester = (String) semisterInputcombobox_1.getSelectedItem();

                if (name.isEmpty() || idNumber.isEmpty() || password.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                } else {
                    // Save the user data to the shared database
                    Main.userDatabase.put(idNumber, password); // Save ID and password
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                    // Navigate back to login and pass the selected year and semester
                    login loginFrame = new login();
                    loginFrame.setSelectedYear(year);
                    loginFrame.setSelectedSemester(semester);
                    loginFrame.setVisible(true);
                    dispose(); // Close the registration window
                }
            }
        });
    }
}