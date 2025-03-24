import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class ShowStudyLoadScreen extends JFrame {

    private Map<String, List<String>> studyLoad;
    private Map<String, String> grades;
    private String currentYear;
    private String currentSemester;

    public ShowStudyLoadScreen(Map<String, List<String>> studyLoad,
                               Map<String, String> grades,
                               String currentYear,
                               String currentSemester) {
        this.studyLoad = studyLoad;
        this.grades = grades;
        this.currentYear = currentYear;
        this.currentSemester = currentSemester;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Study Load");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(350, 20, 150, 30);
        contentPane.add(titleLabel);

        // Display passed subjects
    int y = 80;
    JLabel passedLabel = new JLabel("Passed Subjects:");
    passedLabel.setFont(new Font("Arial", Font.BOLD, 16));
    passedLabel.setBounds(50, y, 200, 20);
    contentPane.add(passedLabel);
    y += 30;

    for (Map.Entry<String, String> entry : grades.entrySet()) {
        if ("Pass".equals(entry.getValue())) {
            JLabel subjectLabel = new JLabel(entry.getKey());
            subjectLabel.setBounds(70, y, 300, 20);
            contentPane.add(subjectLabel);
            y += 30;
        }
    }

    // Display added subjects (study load)
    JLabel addedLabel = new JLabel("Added Subjects:");
    addedLabel.setFont(new Font("Arial", Font.BOLD, 16));
    addedLabel.setBounds(50, y, 200, 20);
    contentPane.add(addedLabel);
    y += 30;

    String key = currentYear + " " + currentSemester;
    List<String> currentStudyLoad = studyLoad.getOrDefault(key, new ArrayList<>());

    for (String subject : currentStudyLoad) {
        JLabel subjectLabel = new JLabel(subject);
        subjectLabel.setBounds(70, y, 300, 20);
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
            new Dashboard(currentYear, currentSemester).setVisible(true);
            dispose();
        });
    }
}