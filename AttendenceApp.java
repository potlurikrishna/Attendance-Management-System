import java.time.LocalDate;

public class AttendenceApp {

    public static void main(String[] args) {

        String name = "Potluri Krishna Balamohan";
        String email = "krishnapotluri2003@gmail.com";
        String mobile = "7842469927";

        LocalDate today = LocalDate.now();

        String year = String.valueOf(today.getYear());
        String month = String.valueOf(today.getMonthValue());
        String day = String.valueOf(today.getDayOfMonth());

        String statusMCQ = "Present";
        String statusDropdown = "Present";

        Trainee trainee = new Trainee(
                name, email, mobile,
                year, month, day,
                statusMCQ, statusDropdown
        );

        FormService service = new FormService();
        service.submitAttendance(trainee);
    }
}
