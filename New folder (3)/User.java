public class User {
    private String password;
    private String year;
    private String semester;

    public User(String password, String year, String semester) {
        this.password = password;
        this.year = year;
        this.semester = semester;
    }

    public String getPassword() {
        return password;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }
}