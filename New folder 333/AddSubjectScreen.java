import javax.swing.*;
import java.awt.*;
import java.util.*; // Import java.util.List explicitly
import javax.swing.border.EmptyBorder;

public class AddSubjectScreen extends JFrame {

    public AddSubjectScreen(Map<String, java.util.List<String>> studyLoad,
                            Map<String, String> subjectPrerequisites,
                            Map<String, String> grades,
                            String currentYear,
                            String currentSemester,
                            Map<String, Map<String, String[]>> subjectsByYearSemester) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Determine next semester
        String[] next = getNextSemester(currentYear, currentSemester);
        String nextYear = next[0], nextSemester = next[1];

        JLabel titleLabel = new JLabel("Add Subjects for " + nextYear + " " + nextSemester);
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        contentPane.add(titleLabel);

        // Get subjects for next semester
        String[] nextSemesterSubjects = subjectsByYearSemester.getOrDefault(nextYear, new HashMap<>())
                .getOrDefault(nextSemester, new String[0]);

        // Filter failed and not taken subjects
        java.util.List<String> failedSubjects = new ArrayList<>();
        java.util.List<String> notTakenSubjects = new ArrayList<>();

        for (Map.Entry<String, String> entry : grades.entrySet()) {
            String subject = entry.getKey();
            String grade = entry.getValue();
            if ("Fail".equals(grade)) {
                failedSubjects.add(subject);
            } else if ("Not Taken".equals(grade)) {
                notTakenSubjects.add(subject);
            }
        }

        // Display Failed Subjects
        addSubjectSection("Failed Subjects", failedSubjects, contentPane);

        // Display Not Taken Subjects
        addSubjectSection("Not Taken Subjects", notTakenSubjects, contentPane);

        // Display Next Semester Subjects
        addSubjectSection("Next Semester Subjects", Arrays.asList(nextSemesterSubjects), contentPane);

        // Add Button
        JButton addButton = new JButton("Add Selected");
        addButton.addActionListener(e -> {
            String key = nextYear + " " + nextSemester;
            java.util.List<String> selected = new ArrayList<>();
            for (Component comp : contentPane.getComponents()) {
                if (comp instanceof JCheckBox) {
                    JCheckBox cb = (JCheckBox) comp;
                    if (cb.isSelected() && cb.isEnabled()) {
                        selected.add(cb.getText().split(": ")[0]);
                    }
                }
            }
            studyLoad.computeIfAbsent(key, k -> new ArrayList<>()).addAll(selected);
            JOptionPane.showMessageDialog(this, "Subjects added successfully!");
            dispose();
            new Dashboard(currentYear, currentSemester).setVisible(true);
        });
        contentPane.add(addButton);
    }

    // Helper method to add a section of subjects
    private void addSubjectSection(String sectionTitle, java.util.List<String> subjects, JPanel contentPane) {
        JLabel sectionLabel = new JLabel(sectionTitle);
        sectionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(sectionLabel);

        if (subjects.isEmpty()) {
            contentPane.add(new JLabel("No subjects available."));
        } else {
            for (String subject : subjects) {
                JCheckBox checkBox = new JCheckBox(subject);
                checkBox.setBounds(50, 80, 500, 20);
                contentPane.add(checkBox);
            }
        }
    }

    // Determine the next semester based on the current year and semester
    private String[] getNextSemester(String year, String semester) {
        String nextYear = year;
        String nextSemester = "First Semester";
        if (semester.equals("First Semester")) {
            nextSemester = "Second Semester";
        } else {
            switch (year) {
                case "1st Year": nextYear = "2nd Year"; break;
                case "2nd Year": nextYear = "3rd Year"; break;
                case "3rd Year": nextYear = "4th Year"; break;
                default: nextYear = year; // Handle 4th year case
            }
        }
        return new String[]{nextYear, nextSemester};
    }
}