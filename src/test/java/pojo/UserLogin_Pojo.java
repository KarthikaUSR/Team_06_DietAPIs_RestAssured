package pojo;

public class UserLogin_Pojo {

    private String userLoginEmail;
    private String password;
    private String AdminBearerToken;
    private String DieticianBearerToken;
    private String PatientBearerToken;

    public String getAdminBearerToken() {
        return AdminBearerToken;
    }
    public void setAdminBearerToken(String adminBearerToken) {
        this.AdminBearerToken = adminBearerToken;
    }
    public String getDieticianBearerToken() {
        return DieticianBearerToken;
    }
    public void setDieticianBearerToken(String dieticianBearerToken) {
        this.DieticianBearerToken = dieticianBearerToken;
    }
    public String getPatientBearerToken() {
        return PatientBearerToken;
    }
    public void setPatientBearerToken(String patientBearerToken) {
        this.PatientBearerToken = patientBearerToken;
    }
    public String getUserLoginEmail() {
        return userLoginEmail;
    }
    public void setUserLoginEmail(String userLoginEmail) {
        this.userLoginEmail = userLoginEmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
