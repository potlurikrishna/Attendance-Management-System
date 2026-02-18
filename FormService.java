import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FormService {

    private static final String FORM_URL =
        "https://docs.google.com/forms/u/0/d/e/1FAIpQLScYwNx_2KiVaYD5jDG6oreQU-XOZRlG_3B5fMgp0nC_-gvErQ/formResponse";

    private static final String NAME_FIELD = "entry.2005620554";
    private static final String EMAIL_FIELD = "entry.1045781291";
    private static final String MOBILE_FIELD = "entry.1065046570";
    private static final String DATE_FIELD = "entry.235823893";
    private static final String STATUS_MCQ_FIELD = "entry.1590177917";
    private static final String STATUS_DROPDOWN_FIELD = "entry.355760391";

    public void submitAttendance(Trainee trainee) {
        try {

            URL url = new URL(FORM_URL);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty(
                    "Content-Type",
                    "application/x-www-form-urlencoded");

            String parameters =
                NAME_FIELD + "=" + URLEncoder.encode(trainee.getName(), "UTF-8") + "&" +
                EMAIL_FIELD + "=" + URLEncoder.encode(trainee.getEmail(), "UTF-8") + "&" +
                MOBILE_FIELD + "=" + URLEncoder.encode(trainee.getMobile(), "UTF-8") + "&" +
                STATUS_MCQ_FIELD + "=" + URLEncoder.encode(trainee.getStatusMCQ(), "UTF-8") + "&" +
                STATUS_DROPDOWN_FIELD + "=" + URLEncoder.encode(trainee.getStatusDropdown(), "UTF-8") + "&" +
                DATE_FIELD + "_year=" + trainee.getYear() + "&" +
                DATE_FIELD + "_month=" + trainee.getMonth() + "&" +
                DATE_FIELD + "_day=" + trainee.getDay();

            OutputStream os = connection.getOutputStream();
            os.write(parameters.getBytes());
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                System.out.println("Form submitted successfully!");
            } else {
                System.out.println("Submission failed. Code: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
