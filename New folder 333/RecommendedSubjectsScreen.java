import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import javax.swing.border.EmptyBorder;

public class RecommendedSubjectsScreen extends JFrame {

    private JPanel contentPane;
    private Map<String, List<String>> studyLoad;
    private Map<String, String> subjectPrerequisites;
    private Map<String, String> grades; // Add grades map
    private String currentYear;
    private String currentSemester;

    // Updated constructor to include grades
    public RecommendedSubjectsScreen(Map<String, List<String>> studyLoad,
                                     Map<String, String> subjectPrerequisites,
                                     Map<String, String> grades,
                                     String currentYear,
                                     String currentSemester) {
        this.studyLoad = studyLoad;
        this.subjectPrerequisites = subjectPrerequisites;
        this.grades = grades; // Initialize grades
        this.currentYear = currentYear;
        this.currentSemester = currentSemester;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Recommended Subjects");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(300, 20, 250, 30);
        contentPane.add(titleLabel);

        // Display recommended subjects
        int y = 80;
        for (Map.Entry<String, String> entry : subjectPrerequisites.entrySet()) {
            String subject = entry.getKey();
            String prerequisite = entry.getValue();
            JLabel subjectLabel = new JLabel(subject + " (Prerequisite: " + prerequisite + ")");
            subjectLabel.setBounds(50, y, 500, 20);
            contentPane.add(subjectLabel);
            y += 30;
        }

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        exitButton.setBounds(350, y + 20, 100, 30);
        contentPane.add(exitButton);

        // Action Listener for Exit Button
        exitButton.addActionListener(e -> {
            Dashboard dashboard = new Dashboard(currentYear, currentSemester);
            dashboard.setVisible(true);
            dispose(); // Close the Recommended Subjects Screen
        });
    }
}