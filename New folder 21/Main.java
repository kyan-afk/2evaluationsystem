import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // Shared user database
    public static Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Start the application with the login screen
        EventQueue.invokeLater(() -> {
            try {
                login frame = new login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

