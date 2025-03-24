import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.border.EmptyBorder;

public class RemoveSubjectScreen extends JFrame {

    private List<String> subjects;
    private String currentYear; // Current year selected by the user
    private String currentSemester; // Current semester selected by the user

    public RemoveSubjectScreen(List<String> subjects, String currentYear, String currentSemester) {
        this.subjects = subjects;
        this.currentYear = currentYear;
        this.currentSemester = currentSemester;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Remove Subjects");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        contentPane.add(titleLabel);

        // Display subjects with remove buttons
        if (subjects.isEmpty()) {
            contentPane.add(new JLabel("No subjects available to remove."));
        } else {
            for (String subject : subjects) {
                JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
                row.add(new JLabel(subject));
                JButton removeBtn = new JButton("Remove");
                removeBtn.addActionListener(e -> {
                    subjects.remove(subject);
                    refresh(contentPane);
                });
                row.add(removeBtn);
                contentPane.add(row);
            }
        }

        // Exit Button
        JButton exitButton = new JButton("Back to Dashboard");
        exitButton.addActionListener(e -> {
            dispose(); // Close this screen
            // Pass currentYear and currentSemester to Dashboard
            new Dashboard(currentYear, currentSemester).setVisible(true);
        });
        contentPane.add(exitButton);
    }

    // Refresh the screen after removing a subject
    private void refresh(JPanel panel) {
        panel.removeAll();
        if (subjects.isEmpty()) {
            panel.add(new JLabel("No subjects available to remove."));
        } else {
            for (String subject : subjects) {
                JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
                row.add(new JLabel(subject));
                JButton removeBtn = new JButton("Remove");
                removeBtn.addActionListener(e -> {
                    subjects.remove(subject);
                    refresh(panel);
                });
                row.add(removeBtn);
                panel.add(row);
            }
        }
        panel.revalidate();
        panel.repaint();
    }
}