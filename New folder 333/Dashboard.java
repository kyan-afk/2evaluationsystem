import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.border.EmptyBorder;

public class Dashboard extends JFrame {

    private JPanel contentPane;
    private JButton addSubjectButton;
    private JButton removeSubjectButton;
    private JButton showStudyLoadButton;
    private JButton recommendedSubjectsButton;
    private JButton exitButton;

    // Data structures to store subjects and study load
    private Map<String, List<String>> studyLoad = new HashMap<>(); // Year + Semester -> List of subjects
    private Map<String, String> subjectPrerequisites = new HashMap<>(); // Subject -> Prerequisite
    private Map<String, Map<String, String[]>> subjectsByYearSemester = new HashMap<>(); // Year -> Semester -> Subjects
    private Map<String, String> grades = new HashMap<>(); // Subject -> Grade (Pass, Fail, Not Taken)

    private String currentYear; // Current year selected by the user
    private String currentSemester; // Current semester selected by the user
    // In Dashboard.java
public void setGrades(Map<String, String> grades) {
    this.grades = grades;
}
    public Dashboard(String currentYear, String currentSemester) {
        this.currentYear = currentYear;
        this.currentSemester = currentSemester;

        System.out.println("Dashboard created with Year: " + currentYear + ", Semester: " + currentSemester); // Debug statement

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Initialize subject prerequisites, subjects by year/semester, and study load
        initializePrerequisites();
        initializeSubjectsByYearSemester();
        initializeStudyLoad(); // Call the method to populate studyLoad

        // Title Label
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        titleLabel.setBounds(350, 20, 150, 30);
        contentPane.add(titleLabel);

        // Add Subject Button
        addSubjectButton = new JButton("Add Subject");
        addSubjectButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        addSubjectButton.setBounds(50, 80, 150, 30);
        contentPane.add(addSubjectButton);

        // Remove Subject Button
        removeSubjectButton = new JButton("Remove Subject");
        removeSubjectButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        removeSubjectButton.setBounds(220, 80, 150, 30);
        contentPane.add(removeSubjectButton);

        // Show Study Load Button
        showStudyLoadButton = new JButton("Show Study Load");
        showStudyLoadButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        showStudyLoadButton.setBounds(390, 80, 150, 30);
        contentPane.add(showStudyLoadButton);

        // Recommended Subjects Button
        recommendedSubjectsButton = new JButton("Recommended Subjects");
        recommendedSubjectsButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        recommendedSubjectsButton.setBounds(560, 80, 180, 30);
        contentPane.add(recommendedSubjectsButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        exitButton.setBounds(350, 130, 100, 30);
        contentPane.add(exitButton);

        // Action Listeners
        addSubjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Subject button clicked."); // Debug statement
                
                // Open Add Subject Screen with all necessary parameters
                AddSubjectScreen addSubjectScreen = new AddSubjectScreen(
                    studyLoad, 
                    subjectPrerequisites,  
                    grades,                
                    currentYear, // Use currentYear
                    currentSemester, // Use currentSemester
                    subjectsByYearSemester  
                );
                addSubjectScreen.setVisible(true);
                dispose(); // Close the Dashboard
            }
        });

        // In Dashboard.java
removeSubjectButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Format the key as "Year Semester"
        String currentYearSemester = currentYear + " " + currentSemester; 
        List<String> currentSubjects = studyLoad.get(currentYearSemester);
        
        if (currentSubjects == null || currentSubjects.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No subjects available to remove.");
        } else {
            RemoveSubjectScreen removeSubjectScreen = new RemoveSubjectScreen(currentSubjects, currentYear, currentSemester);
            removeSubjectScreen.setVisible(true);
        }
    }
});        
      showStudyLoadButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ShowStudyLoadScreen showStudyLoadScreen = new ShowStudyLoadScreen(studyLoad, grades, currentYear, currentSemester);
        showStudyLoadScreen.setVisible(true);
        dispose();
    }
});

        recommendedSubjectsButton.addActionListener(e -> {
    RecommendedSubjectsScreen recommendedSubjectsScreen = new RecommendedSubjectsScreen(
        studyLoad, 
        subjectPrerequisites, 
        grades, // Pass grades map
        currentYear, 
        currentSemester
    );
    recommendedSubjectsScreen.setVisible(true);
    dispose();
});
        
        exitButton.addActionListener(e -> {
            login loginFrame = new login();
            loginFrame.setVisible(true);
            dispose();
        });
    }

    // Initialize subjects by year and semester
    private void initializeSubjectsByYearSemester() {
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
    }

    // Initialize subject prerequisites
    private void initializePrerequisites() {
        // FIRST YEAR
        subjectPrerequisites.put("IT-OOPROG21", "CC-COMPROG11");
        subjectPrerequisites.put("CC-DISCRET12", "CC-INTCOM11");
        subjectPrerequisites.put("CC-QUAMETH22", "CC-DISCRET12");
        subjectPrerequisites.put("NSTP 102", "NSTP 101");

        // SECOND YEAR
        subjectPrerequisites.put("IT-SAD21", "IT-OOPROG21");
        subjectPrerequisites.put("CC-APPSDEV22", "IT-OOPROG21, IT-SAD21");
        subjectPrerequisites.put("CC-ACCTG21", "MATH 101");
        subjectPrerequisites.put("IT-PLATECH22", "CC-DIGILOG21");

        // THIRD YEAR
        subjectPrerequisites.put("IT-IMDBSYS31", "CC-APPSDEV22");
        subjectPrerequisites.put("IT-NETWORK31", "CC-DATACOM22");
        subjectPrerequisites.put("IT-INFOSEC32", "IT-IMDBSYS31, IT-NETWORK31");
        subjectPrerequisites.put("IT-TESTQUA31", "CC-APPSDEV22");
        subjectPrerequisites.put("CC-HCI31", "IT-SAD21");
        subjectPrerequisites.put("IT-INTPROG32", "IT-IMDBSYS31");

        // FOURTH YEAR
        subjectPrerequisites.put("IT-CPSTONE40", "IT-CPSTONE30");
    }

    // Initialize the study load with example data
    private void initializeStudyLoad() {
        // Example data for demonstration purposes
        List<String> firstYearFirstSemester = List.of(
                "ENGL 100: Communication Arts",
                "SOCIO 102: Gender and Society",
                "MATH 100: College Mathematics"
        );
        List<String> firstYearSecondSemester = List.of(
                "SOCIO 101: The Contemporary World",
                "RIZAL 101: Life, Works & Writings of Dr. Jose Rizal",
                "IT-OOPROG21: Object Oriented Programming"
        );
        studyLoad.put("1st Year First Semester", new ArrayList<>(firstYearFirstSemester));
        studyLoad.put("1st Year Second Semester", new ArrayList<>(firstYearSecondSemester));
    }
}