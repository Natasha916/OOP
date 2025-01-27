package week4;

public class NotificationService {

    public boolean sendEmail(String email, String message) {
        if (!isValidEmail(email)) {
            return false;         }

        System.out.println("Sending email to " + email + " with message: " + message);
        return true; 
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        System.out.println(service.sendEmail("test@example.com", "Hello!")); 
        System.out.println(service.sendEmail("invalid-email", "Hello!"));    
    }
}
