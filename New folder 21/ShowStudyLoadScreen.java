// import javax.swing.*;
// import java.awt.*;
// import java.util.List;
// import java.util.Map;
// 
// public class ShowStudyLoadScreen extends JFrame {
// 
//     private JPanel contentPane;
//     private Map<String, List<String>> studyLoad;
// 
//     public ShowStudyLoadScreen(Map<String, List<String>> studyLoad) {
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
//         JLabel titleLabel = new JLabel("Study Load");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(350, 20, 150, 30);
//         contentPane.add(titleLabel);
// 
//         // Display study load
//         int y = 80;
//         for (Map.Entry<String, List<String>> entry : studyLoad.entrySet()) {
//             JLabel yearSemesterLabel = new JLabel(entry.getKey());
//             yearSemesterLabel.setBounds(50, y, 200, 20);
//             contentPane.add(yearSemesterLabel);
//             y += 30;
// 
//             for (String subject : entry.getValue()) {
//                 JLabel subjectLabel = new JLabel(subject);
//                 subjectLabel.setBounds(70, y, 200, 20);
//                 contentPane.add(subjectLabel);
//                 y += 30;
//             }
//         }
//     }
// }

// import javax.swing.*;
// import java.awt.*;
// import java.util.List;
// import java.util.Map;
// import javax.swing.border.EmptyBorder;
// 
// public class ShowStudyLoadScreen extends JFrame {
// 
//     private JPanel contentPane;
//     private Map<String, List<String>> studyLoad;
// 
//     public ShowStudyLoadScreen(Map<String, List<String>> studyLoad) {
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
//         JLabel titleLabel = new JLabel("Study Load");
//         titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
//         titleLabel.setBounds(350, 20, 150, 30);
//         contentPane.add(titleLabel);
// 
//         // Display study load
//         int y = 80;
//         for (Map.Entry<String, List<String>> entry : studyLoad.entrySet()) {
//             JLabel yearSemesterLabel = new JLabel(entry.getKey());
//             yearSemesterLabel.setBounds(50, y, 200, 20);
//             contentPane.add(yearSemesterLabel);
//             y += 30;
// 
//             for (String subject : entry.getValue()) {
//                 JLabel subjectLabel = new JLabel(subject);
//                 subjectLabel.setBounds(70, y, 200, 20);
//                 contentPane.add(subjectLabel);
//                 y += 30;
//             }
//         }
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import javax.swing.border.EmptyBorder;

public class ShowStudyLoadScreen extends JFrame {

    private JPanel contentPane;
    private Map<String, List<String>> studyLoad;

    public ShowStudyLoadScreen(Map<String, List<String>> studyLoad) {
        this.studyLoad = studyLoad;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Study Load");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(350, 20, 150, 30);
        contentPane.add(titleLabel);

        // Display study load
        int y = 80;
        for (Map.Entry<String, List<String>> entry : studyLoad.entrySet()) {
            JLabel yearSemesterLabel = new JLabel(entry.getKey());
            yearSemesterLabel.setBounds(50, y, 200, 20);
            contentPane.add(yearSemesterLabel);
            y += 30;

            for (String subject : entry.getValue()) {
                JLabel subjectLabel = new JLabel(subject);
                subjectLabel.setBounds(70, y, 200, 20);
                contentPane.add(subjectLabel);
                y += 30;
            }
        }

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        exitButton.setBounds(350, y + 20, 100, 30);
        contentPane.add(exitButton);

        // Action Listener for Exit Button
        exitButton.addActionListener(e -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            dispose(); // Close the Show Study Load Screen
        });
    }
}
