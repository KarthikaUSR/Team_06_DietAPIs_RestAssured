package utils;



public class EndPoints {
	
	public static final String BASEURL ="https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician";
	public static final String USERLOGIN="/login";
	public static final String GET_ALL_PATIENTS="/patient";
	public static final String INVALID="/PATIENTS";
	public static final String PATIENTSMORBIDITYDETAILS="/patient/testReports/";//{PATIENTID}
	public static final String PATIENTCREATION="/patient";
	public static final String PATIENTUPDATION="/patient/457";//{{PatientID}}
	public static final String PATIENTADDNEWREPORTS="/patient/newReports/457";//{{PatientID}}
	public static final String PATIENTADDNEWREPORTSINVALIDPATIENTID="/patient/newReports/4572222";//{{PatientID}}
    public static final String PATIENTADDNEWREPORTSNOREPORTS="/patient/newReports/426";//{{PatientID}}
	public static final String PATIENTVIEWBYFILEID="/patient/testReports/viewFile/66c441299a552e3960c05841";//{{Fileid}}
	//Bhavana EndPoints
	
	public static final String DELETE_PATIENT_BY_ID="/patient/515";//515,518,519,524
	public static final String DELETE_PATIENT_INVALIDENDPOINT_BY_ID="/PATIENTS";
	public static final String DELETE_PATIENT_BY_INVALID_ID="/patient/343545";//
	public static final String GET_PATIENT_BY_FILEID="/patient/testReports/viewFile/66c4ae2b21e15d41dc592b7a";
	public static final String GET_PATIENT_BY_INVALID_FILEID="/patient/testReports/viewFile/1";
	public static final String GET_PATIENT_BY_INVALIDENDPOINT_BY_FILEID="/patient/Reports/File/66c1babce30dde112fb9002b";
	public static final String GET_PATIENT_MORBIDITY_DETAILS= "/patient/testReports/519";
	public static final String GET_PATIENT_MORBIDITY_DETAILS_INVALIDFILEID="patient/testReports/643546456456";
	public static final String GET_PATIENT_MORBIDITY_DETAILS_INVALIDENDPOINT="patient/tesReports/PATIENTS";
	
	
	
	
	
	
	

	 
	

}
