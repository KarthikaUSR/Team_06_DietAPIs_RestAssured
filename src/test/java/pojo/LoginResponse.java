package pojo;

import java.util.List;

public class LoginResponse {
	
	String token;
	String type;
	String userId;
	String loginUserEmail;
	List<String> roles;
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getLoginUserEmail() {
			return loginUserEmail;
		}
		public void setLoginUserEmail(String loginUserEmail) {
			this.loginUserEmail = loginUserEmail;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}

}
