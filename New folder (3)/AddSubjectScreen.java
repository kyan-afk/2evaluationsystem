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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class AddSubjectScreen extends JFrame {

    // private JPanel contentPane;
//     private Map<String, List<String>> studyLoad;
//     private Map<String, String> subjectPrerequisites;
//     private Map<String, String> grades; // Assuming grades are passed from GradeInputScreen
// 
//     public AddSubjectScreen(Map<String, List<String>> studyLoad, Map<String, String> subjectPrerequisites, Map<String, String> grades) {
//         this.studyLoad = studyLoad;
//         this.subjectPrerequisites = subjectPrerequisites;
//         this.grades = grades;
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setBounds(100, 100, 800, 600);
//         contentPane = new JPanel();
//         contentPane.setBackground(new Color(255, 255, 255));
//         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//         setContentPane(contentPane);
//         contentPane.setLayout(null);
       public AddSubjectScreen(Map<String, List<String>> studyLoad, Map<String, String> subjectPrerequisites, Map<String, String> grades, String currentYear, String currentSemester) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Add Subject");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(350, 20, 150, 30);
        contentPane.add(titleLabel);

        // Display subjects with prerequisites
        int y = 80;
        for (Map.Entry<String, String> entry : subjectPrerequisites.entrySet()) {
            String subject = entry.getKey();
            String prerequisite = entry.getValue();
            String grade = grades.get(subject);

            // Check if the subject is failed or not taken
            if ("Fail".equals(grade) || "Not Taken".equals(grade)) {
                JCheckBox checkBox = new JCheckBox(subject + " (Prerequisite: " + prerequisite + ")");
                checkBox.setBounds(50, y, 500, 20);
                contentPane.add(checkBox);
                y += 30;
            }
        }

        // Add Button
        JButton addButton = new JButton("Add Selected");
        addButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        addButton.setBounds(300, y, 150, 30);
        contentPane.add(addButton);

        // Action Listener for Add Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add selected subjects to study load
                for (Component component : contentPane.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            String subject = checkBox.getText().split(" ")[0]; // Extract subject code
                            studyLoad.computeIfAbsent("Current Year", k -> new ArrayList<>()).add(subject);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Selected subjects added to study load.");
                dispose(); // Close the Add Subject Screen
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true); // Reopen the Dashboard
            }
        });
    }
}