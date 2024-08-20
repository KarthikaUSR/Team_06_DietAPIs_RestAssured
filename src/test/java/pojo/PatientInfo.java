package pojo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PatientInfo {
	
	 private String FirstName;
	 private String LastName;
	 private int ContactNumber;
	 private String Email;
	 private String Allergy;
	 private String FoodPreference;
	 private String CuisineCategory;
	 private Date Dateofbirth;
	 private String PatientID;
	 private String PatientFileID;
	 
	 
	 public String getPatientID() {
		return PatientID;
	}

	public void setPatientID(String patientID) {
		this.PatientID = patientID;
	}

	public String getPatientFileID() {
		return PatientFileID;
	}

	public void setPatientFileID(String patientFileID) {
		this.PatientFileID = patientFileID;
	}
	
	
	  

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public int getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.ContactNumber = contactNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getAllergy() {
		return Allergy;
	}

	public void setAllergy(String allergy) {
		this.Allergy = allergy;
	}

	public String getFoodPreference() {
		return FoodPreference;
	}

	public void setFoodPreference(String foodPreference) {
		this.FoodPreference = foodPreference;
	}

	public String getCuisineCategory() {
		return CuisineCategory;
	}

	public void setCuisineCategory(String cuisineCategory) {
		this.CuisineCategory = cuisineCategory;
	}

	public Date getDateofbirth() {
		return Dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.Dateofbirth = dateofbirth;
	}
@Override public String toString() { return "[FirstName=" + FirstName + ", LastName=" + LastName + ","
		  		+ " ContactNumber" + ContactNumber +", Email=" + Email + ", Allergy=" + Allergy + ","
		  		  		 +" FoodPreference" + FoodPreference+ ", CuisineCategory=" + CuisineCategory +", Dateofbirth=" + Dateofbirth + "]"; }


}

