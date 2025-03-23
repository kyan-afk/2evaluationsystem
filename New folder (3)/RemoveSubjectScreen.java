// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.List;
// import java.util.Map;
// 
// public class RemoveSubjectScreen extends JFrame {
// 
//     private JPanel contentPane;
//     private Map<String, List<String>> studyLoad;
// 
//     public RemoveSubjectScreen(Map<String, List<String>> studyLoad) {
//         this.studyLoad = studyLoad;
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setBounds(100, 100, 800, 600);
//         contentPane = new JPanel();
//         contentPane.setBackground(new Color(255, 255, 255));
//         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//         setContentPane(contentPane);
//         contentPane.setLayout(null);
// 
//         // Title Label
//         JLabel titleLabel = new JLabel("Remove Subject");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(300, 20, 200, 30);
//         contentPane.add(titleLabel);
// 
//         // Display subjects in the study load
//         int y = 80;
//         for (Map.Entry<String, List<String>> entry : studyLoad.entrySet()) {
//             JLabel yearSemesterLabel = new JLabel(entry.getKey());
//             yearSemesterLabel.setBounds(50, y, 200, 20);
//             contentPane.add(yearSemesterLabel);
//             y += 30;
// 
//             for (String subject : entry.getValue()) {
//                 JCheckBox checkBox = new JCheckBox(subject);
//                 checkBox.setBounds(70, y, 200, 20);
//                 contentPane.add(checkBox);
//                 y += 30;
//             }
//         }
// 
//         // Remove Button
//         JButton removeButton = new JButton("Remove Selected");
//         removeButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
//         removeButton.setBounds(300, y, 150, 30);
//         contentPane.add(removeButton);
// 
//         // Action Listener for Remove Button
//         removeButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // Remove selected subjects
//                 for (Component component : contentPane.getComponents()) {
//                     if (component instanceof JCheckBox) {
//                         JCheckBox checkBox = (JCheckBox) component;
//                         if (checkBox.isSelected()) {
//                             String subject = checkBox.getText();
//                             for (List<String> subjects : studyLoad.values()) {
//                                 subjects.remove(subject);
//                             }
//                         }
//                     }
//                 }
//                 JOptionPane.showMessageDialog(null, "Selected subjects removed.");
//                 dispose(); // Close the Remove Subject Screen
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
// import javax.swing.border.EmptyBorder;
// 
// public class RemoveSubjectScreen extends JFrame {
// 
//     private JPanel contentPane;
//     private Map<String, List<String>> studyLoad;
// 
//     public RemoveSubjectScreen(Map<String, List<String>> studyLoad) {
//         this.studyLoad = studyLoad;
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setBounds(100, 100, 800, 600);
//         contentPane = new JPanel();
//         contentPane.setBackground(new Color(255, 255, 255));
//         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//         setContentPane(contentPane);
//         contentPane.setLayout(null);
// 
//         // Title Label
//         JLabel titleLabel = new JLabel("Remove Subject");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(300, 20, 200, 30);
//         contentPane.add(titleLabel);
// 
//         // Display subjects in the study load
//         int y = 80;
//         for (Map.Entry<String, List<String>> entry : studyLoad.entrySet()) {
//             JLabel yearSemesterLabel = new JLabel(entry.getKey());
//             yearSemesterLabel.setBounds(50, y, 200, 20);
//             contentPane.add(yearSemesterLabel);
//             y += 30;
// 
//             for (String subject : entry.getValue()) {
//                 JCheckBox checkBox = new JCheckBox(subject);
//                 checkBox.setBounds(70, y, 200, 20);
//                 contentPane.add(checkBox);
//                 y += 30;
//             }
//         }
// 
//         // Remove Button
//         JButton removeButton = new JButton("Remove Selected");
//         removeButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
//         removeButton.setBounds(300, y, 150, 30);
//         contentPane.add(removeButton);
// 
//         // Action Listener for Remove Button
//         removeButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // Remove selected subjects
//                 for (Component component : contentPane.getComponents()) {
//                     if (component instanceof JCheckBox) {
//                         JCheckBox checkBox = (JCheckBox) component;
//                         if (checkBox.isSelected()) {
//                             String subject = checkBox.getText();
//                             for (List<String> subjects : studyLoad.values()) {
//                                 subjects.remove(subject);
//                             }
//                         }
//                     }
//                 }
//                 JOptionPane.showMessageDialog(null, "Selected subjects removed.");
//                 dispose(); // Close the Remove Subject Screen
//                 Dashboard dashboard = new Dashboard();
//                 dashboard.setVisible(true); // Reopen the Dashboard
//             }
//         });
//     }
// }

// public class RemoveSubjectScreen extends JFrame {
// 
//     private JPanel contentPane;
//     private List<String> subjects;
// 
//     public RemoveSubjectScreen(List<String> subjects) {
//         this.subjects = subjects;
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setBounds(100, 100, 800, 600);
//         contentPane = new JPanel();
//         contentPane.setBackground(new Color(255, 255, 255));
//         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//         setContentPane(contentPane);
//         contentPane.setLayout(null);
// 
//         // Title Label
//         JLabel titleLabel = new JLabel("Remove Subject");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(300, 20, 200, 30);
//         contentPane.add(titleLabel);
// 
//         // Display subjects with remove buttons
//         int y = 80;
//         for (String subject : subjects) {
//             // Subject Label
//             JLabel subjectLabel = new JLabel(subject);
//             subjectLabel.setBounds(50, y, 200, 20);
//             contentPane.add(subjectLabel);
// 
//             // Remove Button
//             JButton removeButton = new JButton("Remove");
//             removeButton.setBounds(300, y, 100, 20);
//             removeButton.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     // Remove the subject from the list
//                     subjects.remove(subject);
//                     // Refresh the screen to reflect the changes
//                     refreshScreen();
//                 }
//             });
//             contentPane.add(removeButton);
// 
//             y += 30; // Move to the next line
//         }
// 
//         // Exit Button
//         JButton exitButton = new JButton("Exit to Dashboard");
//         exitButton.setBounds(300, y + 20, 200, 30);
//         exitButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // Close the current window
//                 dispose();
//                 // Optionally, open the dashboard window here
//                 // new DashboardScreen().setVisible(true);
//             }
//         });
//         contentPane.add(exitButton);
//     }
// 
//     // Refresh the screen after removing a subject
//     private void refreshScreen() {
//         contentPane.removeAll(); // Clear all components
//         contentPane.revalidate(); // Revalidate the layout
//         contentPane.repaint(); // Repaint the panel
// 
//         // Re-add components with the updated subject list
//         JLabel titleLabel = new JLabel("Remove Subject");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(300, 20, 200, 30);
//         contentPane.add(titleLabel);
// 
//         int y = 80;
//         for (String subject : subjects) {
//             JLabel subjectLabel = new JLabel(subject);
//             subjectLabel.setBounds(50, y, 200, 20);
//             contentPane.add(subjectLabel);
// 
//             JButton removeButton = new JButton("Remove");
//             removeButton.setBounds(300, y, 100, 20);
//             removeButton.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     subjects.remove(subject);
//                     refreshScreen();
//                 }
//             });
//             contentPane.add(removeButton);
// 
//             y += 30;
//         }
// 
//         // Re-add the exit button
//         JButton exitButton = new JButton("Exit to Dashboard");
//         exitButton.setBounds(300, y + 20, 200, 30);
//         exitButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 dispose();
//                 // new DashboardScreen().setVisible(true);
//             }
//         });
//         contentPane.add(exitButton);
//     }
// 
//     public static void main(String[] args) {
//         // Example usage
//         List<String> subjects = new java.util.ArrayList<>();
//         subjects.add("Math");
//         subjects.add("Physics");
//         subjects.add("Chemistry");
// 
//         RemoveSubjectScreen frame = new RemoveSubjectScreen(subjects);
//         frame.setVisible(true);
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.EmptyBorder;

public class RemoveSubjectScreen extends JFrame {

    private JPanel contentPane; // Declare contentPane
    private List<String> subjects; // Declare subjects

    public RemoveSubjectScreen(List<String> subjects) {
        this.subjects = subjects; // Initialize subjects

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel(); // Initialize contentPane
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Remove Subject");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(300, 20, 200, 30);
        contentPane.add(titleLabel);

        // Display subjects with remove buttons
        int y = 80;
        for (String subject : subjects) {
            // Subject Label
            JLabel subjectLabel = new JLabel(subject);
            subjectLabel.setBounds(50, y, 200, 20);
            contentPane.add(subjectLabel);

            // Remove Button
            JButton removeButton = new JButton("Remove");
            removeButton.setBounds(300, y, 100, 20);
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the subject from the list
                    subjects.remove(subject);
                    // Refresh the screen to reflect the changes
                    refreshScreen();
                }
            });
            contentPane.add(removeButton);

            y += 30; // Move to the next line
        }

        // Exit Button
        JButton exitButton = new JButton("Exit to Dashboard");
        exitButton.setBounds(300, y + 20, 200, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                dispose();
                // Optionally, open the dashboard window here
                // new DashboardScreen().setVisible(true);
            }
        });
        contentPane.add(exitButton);
    }

    // Refresh the screen after removing a subject
    private void refreshScreen() {
        contentPane.removeAll(); // Clear all components
        contentPane.revalidate(); // Revalidate the layout
        contentPane.repaint(); // Repaint the panel

        // Re-add components with the updated subject list
        JLabel titleLabel = new JLabel("Remove Subject");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(300, 20, 200, 30);
        contentPane.add(titleLabel);

        int y = 80;
        for (String subject : subjects) {
            JLabel subjectLabel = new JLabel(subject);
            subjectLabel.setBounds(50, y, 200, 20);
            contentPane.add(subjectLabel);

            JButton removeButton = new JButton("Remove");
            removeButton.setBounds(300, y, 100, 20);
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subjects.remove(subject);
                    refreshScreen();
                }
            });
            contentPane.add(removeButton);

            y += 30;
        }

        // Re-add the exit button
        JButton exitButton = new JButton("Exit to Dashboard");
        exitButton.setBounds(300, y + 20, 200, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // new DashboardScreen().setVisible(true);
            }
        });
        contentPane.add(exitButton);
    }
}    