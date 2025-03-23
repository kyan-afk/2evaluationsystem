// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import javax.swing.border.EmptyBorder;
// 
// public class AddSubjectScreen extends JFrame {
// 
//     private JPanel contentPane;
//     private Map<String, List<String>> studyLoad;
//     private Map<String, String> subjectPrerequisites;
// 
//     public AddSubjectScreen(Map<String, List<String>> studyLoad, Map<String, String> subjectPrerequisites) {
//         this.studyLoad = studyLoad;
//         this.subjectPrerequisites = subjectPrerequisites;
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setBounds(100, 100, 800, 600);
//         contentPane = new JPanel();
//         contentPane.setBackground(new Color(255, 255, 255));
//         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//         setContentPane(contentPane);
//         contentPane.setLayout(null);
// 
//         // Title Label
//         JLabel titleLabel = new JLabel("Add Subject");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(350, 20, 150, 30);
//         contentPane.add(titleLabel);
// 
//         // Display subjects with prerequisites
//         int y = 80;
//         for (Map.Entry<String, String> entry : subjectPrerequisites.entrySet()) {
//             String subject = entry.getKey();
//             String prerequisite = entry.getValue();
//             JCheckBox checkBox = new JCheckBox(subject + " (Prerequisite: " + prerequisite + ")");
//             checkBox.setBounds(50, y, 500, 20);
//             contentPane.add(checkBox);
//             y += 30;
//         }
// 
//         // Add Button
//         JButton addButton = new JButton("Add Selected");
//         addButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
//         addButton.setBounds(300, y, 150, 30);
//         contentPane.add(addButton);
// 
//         // Action Listener for Add Button
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // Add selected subjects to study load
//                 for (Component component : contentPane.getComponents()) {
//                     if (component instanceof JCheckBox) {
//                         JCheckBox checkBox = (JCheckBox) component;
//                         if (checkBox.isSelected()) {
//                             String subject = checkBox.getText().split(" ")[0]; // Extract subject code
//                             studyLoad.computeIfAbsent("Current Year", k -> new ArrayList<>()).add(subject);
//                         }
//                     }
//                 }
//                 JOptionPane.showMessageDialog(null, "Selected subjects added to study load.");
//                 dispose(); // Close the Add Subject Screen
//             }
//         });
//     }
// }

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.List;
// import java.util.Map;
// import java.array.Lis
// import javax.swing.border.EmptyBorder;
// 
// public class AddSubjectScreen extends JFrame {
// 
//     private JPanel contentPane;
//     private Map<String, List<String>> studyLoad;
//     private Map<String, String> subjectPrerequisites;
// 
//     public AddSubjectScreen(Map<String, List<String>> studyLoad, Map<String, String> subjectPrerequisites) {
//         this.studyLoad = studyLoad;
//         this.subjectPrerequisites = subjectPrerequisites;
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setBounds(100, 100, 800, 600);
//         contentPane = new JPanel();
//         contentPane.setBackground(new Color(255, 255, 255));
//         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//         setContentPane(contentPane);
//         contentPane.setLayout(null);
// 
//         // Title Label
//         JLabel titleLabel = new JLabel("Add Subject");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(350, 20, 150, 30);
//         contentPane.add(titleLabel);
// 
//         // Display subjects with prerequisites
//         int y = 80;
//         for (Map.Entry<String, String> entry : subjectPrerequisites.entrySet()) {
//             String subject = entry.getKey();
//             String prerequisite = entry.getValue();
//             JCheckBox checkBox = new JCheckBox(subject + " (Prerequisite: " + prerequisite + ")");
//             checkBox.setBounds(50, y, 500, 20);
//             contentPane.add(checkBox);
//             y += 30;
//         }
// 
//         // Add Button
//         JButton addButton = new JButton("Add Selected");
//         addButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
//         addButton.setBounds(300, y, 150, 30);
//         contentPane.add(addButton);
// 
//         // Action Listener for Add Button
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // Add selected subjects to study load
//                 for (Component component : contentPane.getComponents()) {
//                     if (component instanceof JCheckBox) {
//                         JCheckBox checkBox = (JCheckBox) component;
//                         if (checkBox.isSelected()) {
//                             String subject = checkBox.getText().split(" ")[0]; // Extract subject code
//                             studyLoad.computeIfAbsent("Current Year", k -> new ArrayList<>()).add(subject);
//                         }
//                     }
//                 }
//                 JOptionPane.showMessageDialog(null, "Selected subjects added to study load.");
//                 dispose(); // Close the Add Subject Screen
//                 Dashboard dashboard = new Dashboard();
//                 dashboard.setVisible(true); // Reopen the Dashboard
//             }
//         });
//     }
// }

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.List;
// import java.util.Map;
// import java.util.ArrayList;
// import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.border.EmptyBorder;

// AddSubjectScreen class for adding a subject
class AddSubjectScreen extends JFrame {
    private Map<String, Map<String, String[]>> subjectsByYearSemester;
    private Map<String, String> subjectPrerequisites;
    private List<String> studyLoad;

    public AddSubjectScreen(Map<String, Map<String, String[]>> subjectsByYearSemester,
                            Map<String, String> subjectPrerequisites,
                            List<String> studyLoad) {
        this.subjectsByYearSemester = subjectsByYearSemester;
        this.subjectPrerequisites = subjectPrerequisites;
        this.studyLoad = studyLoad;

        setTitle("Add Subject");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        setLayout(new FlowLayout());

        // Dropdown for selecting subject
        String[] subjects = {"ENGL 100", "MATH 100", "IT-OOPROG21", "SOCIO 101"};
        JComboBox<String> subjectComboBox = new JComboBox<>(subjects);
        add(subjectComboBox);

        JButton addButton = new JButton("Add Subject");
        JButton cancelButton = new JButton("Cancel");

        // Action to add selected subject
        addButton.addActionListener(e -> {
            String selectedSubject = (String) subjectComboBox.getSelectedItem();
            studyLoad.add(selectedSubject);
            JOptionPane.showMessageDialog(null, "Subject added successfully!");
            dispose(); // Close the window
        });

        // Action to cancel
        cancelButton.addActionListener(e -> dispose());

        add(addButton);
        add(cancelButton);
    }
}
