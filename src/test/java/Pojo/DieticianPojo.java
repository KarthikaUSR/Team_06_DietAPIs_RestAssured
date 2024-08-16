package Pojo;
import java.time.OffsetDateTime;

public class DieticianPojo {
	
	    private String contactNumber;
	    private String dateOfBirth;
	    private String education;
	    private String email;
	    private String firstname;
	    private String hospitalCity;
	    private String hospitalName;
	    private String hospitalPincode;
	    private String hospitalStreet;
	    private String lastname;

	    // Getters and Setters
	    public String getContactNumber() {
	        return contactNumber;
	    }

	    public void setContactNumber(String contactNumber) {
	        this.contactNumber = contactNumber;
	    }

	    public String getDateOfBirth() {
	        return dateOfBirth;
	    }

	    public void setDateOfBirth(String dateOfBirth2) {
	        this.dateOfBirth = dateOfBirth2;
	    }

	    public String getEducation() {
	        return education;
	    }

	    public void setEducation(String education) {
	        this.education = education;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getHospitalCity() {
	        return hospitalCity;
	    }

	    public void setHospitalCity(String hospitalCity) {
	        this.hospitalCity = hospitalCity;
	    }

	    public String getHospitalName() {
	        return hospitalName;
	    }

	    public void setHospitalName(String hospitalName) {
	        this.hospitalName = hospitalName;
	    }

	    public String getHospitalPincode() {
	        return hospitalPincode;
	    }

	    public void setHospitalPincode(String hospitalPincode) {
	        this.hospitalPincode = hospitalPincode;
	    }

	    public String getHospitalStreet() {
	        return hospitalStreet;
	    }

	    public void setHospitalStreet(String hospitalStreet) {
	        this.hospitalStreet = hospitalStreet;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    @Override
	    public String toString() {
	        return "Dietician{" +
	                "contactNumber='" + contactNumber + '\'' +
	                ", dateOfBirth=" + dateOfBirth +
	                ", education='" + education + '\'' +
	                ", email='" + email + '\'' +
	                ", firstname='" + firstname + '\'' +
	                ", hospitalCity='" + hospitalCity + '\'' +
	                ", hospitalName='" + hospitalName + '\'' +
	                ", hospitalPincode='" + hospitalPincode + '\'' +
	                ", hospitalStreet='" + hospitalStreet + '\'' +
	                ", lastname='" + lastname + '\'' +
	                '}';
	    }
	}


