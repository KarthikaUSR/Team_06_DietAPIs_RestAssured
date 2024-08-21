package pojo;

public class UserLoginPojo {
	
	private String userLoginEmail;
	private String password;
	private String BearerToken;
	
	private String AdminBearerToken;
	private String DieticianBearerToken;
	private String PatientBearerToken;
	
	public String getBearerToken() {
		return BearerToken;
	}
	public void setBearerToken(String bearerToken) {
		this.BearerToken = bearerToken;
	}
	
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