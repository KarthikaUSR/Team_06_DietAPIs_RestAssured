package pojo;

public class UserLoginPojo {

	private String AdminBearerToken;
	private String DietecianBearerToken;
	private String PatientBearerToken;
	
	public String getAdminBearerToken() {
		return AdminBearerToken;
	}
	public void setAdminBearerToken(String adminBearerToken) {
		this.AdminBearerToken = adminBearerToken;
	}
	public String getDietecianBearerToken() {
		return DietecianBearerToken;
	}
	public void setDietecianBearerToken(String dietecianBearerToken) {
		this.DietecianBearerToken = dietecianBearerToken;
	}
	public String getPatientBearerToken() {
		return PatientBearerToken;
	}
	public void setPatientBearerToken(String patientBearerToken) {
		this.PatientBearerToken = patientBearerToken;
	}
	
	private String userLoginEmail;
	private String password;
	
	
	public String getBearerToken() {
		return AdminBearerToken;
	}
	public void setBearerToken(String bearerToken) {
		this.AdminBearerToken = bearerToken;
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
