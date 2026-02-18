public class Trainee {

    private String name;
    private String email;
    private String mobile;
    private String year;
    private String month;
    private String day;
    private String statusMCQ;
    private String statusDropdown;

    public Trainee(String name, String email, String mobile,
                   String year, String month, String day,
                   String statusMCQ, String statusDropdown) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.year = year;
        this.month = month;
        this.day = day;
        this.statusMCQ = statusMCQ;
        this.statusDropdown = statusDropdown;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getYear() { return year; }
    public String getMonth() { return month; }
    public String getDay() { return day; }
    public String getStatusMCQ() { return statusMCQ; }
    public String getStatusDropdown() { return statusDropdown; }
}
