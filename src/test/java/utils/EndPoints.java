package utils;



public class EndPoints {
	
	
	
	public static final String BASEURL ="https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician";

	public static final String USERLOGIN="/login";
	public static final String CREATE_DIETICIAN="/dietician";
	public static final String UPDATE_DIETICIAN_BY_ID="/dietician/{{dieticianId}}";
	public static final String GET_ALL_DIETICIANS="/dietician";
	public static final String GET_DIETICIAN_BY_ID="/dietician/{{dieticianId}}";
	public static final String GET_ALL_PATIENTS="/patient";
	public static final String ADD_NEWREPORTS_WITH_OR_WITHOUT_VITALS= "/patient/newReports/{patientId}";
	public static final String DELETE_PATIENT_BY_ID="/patient/393";
	public static final String DELETE_PATIENT_INVALIDENDPOINT_BY_ID="/patient//";
	public static final String DELETE_PATIENT_BY_INVALID_ID="/patient/1";
	public static final String GET_PATIENT_BY_FILEID="/patient/testReports/viewFile/66c4ae2b21e15d41dc592b7a";
	public static final String GET_PATIENT_BY_INVALID_FILEID="/patient/testReports/viewFile/1";
	public static final String GET_PATIENT_BY_INVALIDENDPOINT_BY_FILEID="/patient/Reports/File/66c4ae2b21e15d41dc592b7a";
	public static final String GET_PATIENT_MORBIDITY_DETAILS= "/patient/testReports/643";
	public static final String GET_PATIENT_MORBIDITY_DETAILS_INVALIDPATIENTID="patient/testReports/643546456456";
	public static final String GET_PATIENT_MORBIDITY_DETAILS_INVALIDENDPOINT="patient/tesReports/";
	
			
	
	
		


	 
	

}
