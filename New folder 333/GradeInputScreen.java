import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.EmptyBorder;

public class GradeInputScreen extends JFrame {

    private JPanel contentPane;
    private JButton removeButton;
    private JButton continueButton;

    // Map to store subjects for each year and semester
    private Map<String, Map<String, String[]>> subjectsByYearSemester = new HashMap<>();

    public GradeInputScreen(String year, String semester) {
        // Debug: Print the year and semester passed to the constructor
        System.out.println("GradeInputScreen constructor called with year: " + year + ", semester: " + semester);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Initialize subjects
        initializeSubjects();

        // Debug: Print the subjectsByYearSemester map
        System.out.println("Subjects by Year and Semester: " + subjectsByYearSemester);

        // Title Label
        JLabel titleLabel = new JLabel("Grade Input - " + year + " " + semester);
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(150, 26, 505, 30);
        contentPane.add(titleLabel);

        // Get subjects for the selected year and semester
        Map<String, String[]> yearSubjects = subjectsByYearSemester.get(year);
        if (yearSubjects == null) {
            System.out.println("No subjects found for year: " + year);
            yearSubjects = new HashMap<>();
        }

        String[] subjects = yearSubjects.get(semester);
        if (subjects == null) {
            System.out.println("No subjects found for semester: " + semester);
            subjects = new String[]{"No Subjects Available"};
        }

        // Dynamically create a dropdown for each subject
        int yOffset = 80; // Initial y-position for the first subject
        for (String subject : subjects) {
            // Subject Label
            JLabel subjectLabel = new JLabel(subject + ":");
            subjectLabel.setBounds(50, yOffset, 300, 20);
            contentPane.add(subjectLabel);

            // Grade Dropdown (JComboBox)
            JComboBox<String> gradeComboBox = new JComboBox<>(new String[]{"Not Taken", "Pass", "Fail"});
            gradeComboBox.setBounds(350, yOffset, 150, 25);
            contentPane.add(gradeComboBox);

            yOffset += 40; // Increase y-position for the next subject
        }

        // Remove Button
        removeButton = new JButton("Remove");
        removeButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        removeButton.setBounds(150, yOffset + 20, 100, 30);
        contentPane.add(removeButton);

        // Continue Button
        continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        continueButton.setBounds(270, yOffset + 20, 100, 30);
        contentPane.add(continueButton);

        // Action Listeners
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all dropdown selections
                for (Component component : contentPane.getComponents()) {
                    if (component instanceof JComboBox) {
                        ((JComboBox<?>) component).setSelectedIndex(0);
                    }
                }
            }
        });

        // Replace the continueButton action listener with:
continueButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Map<String, String> grades = new HashMap<>();
        for (Component component : contentPane.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                if (label.getText().endsWith(":")) {
                    // Extract subject code (e.g., "ENGL 100")
                    String subject = label.getText().split(":")[0].trim(); 
                    // Find the corresponding dropdown
                    for (Component comp : contentPane.getComponents()) {
                        if (comp instanceof JComboBox && comp.getBounds().y == label.getBounds().y) {
                            JComboBox<String> comboBox = (JComboBox<String>) comp;
                            String grade = (String) comboBox.getSelectedItem();
                            grades.put(subject, grade); // Use subject code as key
                            break;
                        }
                    }
                }
            }
        }
        // Pass grades to Dashboard
        Dashboard dashboard = new Dashboard(year, semester);
        dashboard.setGrades(grades);
        dashboard.setVisible(true);
        dispose();
    }
});
        // Debug: Print a message when the frame is made visible
        System.out.println("GradeInputScreen frame is now visible.");
    }

    // Initialize subjects for each year and semester
    private void initializeSubjects() {
        // FIRST YEAR
        Map<String, String[]> firstYearSubjects = new HashMap<>();
        firstYearSubjects.put("First Semester", new String[]{
            "ENGL 100: Communication Arts",
            "SOCIO 102: Gender and Society",
            "MATH 100: College Mathematics",
            "PSYCH 101: Understanding the Self",
            "CC-INTCOM11: Introduction to Computing",
            "CC-COMPROG11: Computer Programming 1",
            "PE 101: Movement Competency Training (PATHFit 1)",
            "NSTP 101: National Service Training Program 1"
        });
        firstYearSubjects.put("Second Semester", new String[]{
            "SOCIO 101: The Contemporary World",
            "RIZAL 101: Life, Works & Writings of Dr. Jose Rizal",
            "CC-DIGILOG21: Digital Logic Design",
            "IT-OOPROG21: Object Oriented Programming",
            "CC-DISCRET12: Discrete Structures",
            "CC-QUAMETH22: Quantitative Methods with Probability & Statistics",
            "PE 102: Exercise-based Fitness Activities (PATHFit 2)",
            "NSTP 102: National Service Training Program 2"
        });
        subjectsByYearSemester.put("1st Year", firstYearSubjects);

        // SECOND YEAR
        Map<String, String[]> secondYearSubjects = new HashMap<>();
        secondYearSubjects.put("First Semester", new String[]{
            "STS 101: Science, Technology & Society",
            "PHILO 101: Ethics",
            "IT-SAD21: System Analysis & Design",
            "CC-APPSDEV22: Applications Development & Emerging Technologies",
            "CC-ACCTG21: Accounting for IT",
            "IT-PLATECH22: Platform Technologies with Operating Systems",
            "PE 103: Sports and Dance (PATHFit 3)"
        });
        secondYearSubjects.put("Second Semester", new String[]{
            "IT-IMDBSYS31: Information Management (DB Sys. 1)",
            "IT-NETWORK31: Computer Networks",
            "IT-INFOSEC32: Information Assurance & Security",
            "IT-TESTQUA31: Testing & Quality Assurance",
            "CC-HCI31: Human-Computer Interaction",
            "IT-INTPROG32: Integrative Programming & Technologies"
        });
        subjectsByYearSemester.put("2nd Year", secondYearSubjects);

        // THIRD YEAR
        Map<String, String[]> thirdYearSubjects = new HashMap<>();
        thirdYearSubjects.put("First Semester", new String[]{
            "IT-CPSTONE30: Capstone Project 1",
            "CC-PROFIS10: Professional Issues in Computing"
        });
        thirdYearSubjects.put("Second Semester", new String[]{
            "IT-IMDBSYS32: Information Management (DB Sys. 2)",
            "IT-TESTQUA31: Testing & Quality Assurance",
            "CC-RESCOM31: Methods of Research in Computing"
        });
        subjectsByYearSemester.put("3rd Year", thirdYearSubjects);

        // FOURTH YEAR
        Map<String, String[]> fourthYearSubjects = new HashMap<>();
        fourthYearSubjects.put("First Semester", new String[]{
            "LIT 11: Literatures of the World",
            "CC-PRACT40: Practicum",
            "IT-CPSTONE40: Capstone Project 2"
        });
        subjectsByYearSemester.put("4th Year", fourthYearSubjects);

        // Debug: Print the subjectsByYearSemester map after initialization
        System.out.println("Subjects by Year and Semester after initialization: " + subjectsByYearSemester);
    }
}