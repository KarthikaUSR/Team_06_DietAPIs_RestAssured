package utils;

public class EndPoints {
	
	public static final String BASEURL ="https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician";

	public static final String USERLOGIN="/login";
	public static final String USERLOGOUT= "/logoutdietician";
	public static final String CREATE_DIETICIAN="/dietician";
	public static final String UPDATE_DIETICIAN_BY_ID="/dietician/{{dieticianId}}";
	public static final String GET_ALL_DIETICIANS="/dietician";
	public static final String GET_DIETICIAN_BY_ID="/dietician/{{dieticianId}}";
	public static final String GET_ALL_PATIENTS="/patient";
	public static final String INVALID_USERLOGIN="/login123";
	public static final String PATIENTLOGIN="/patient";
	public static final String GET_ALL_MORBIDITIES="/morbidity";
	public static final String MORBIDITY_CONDITION_BY_TESTNAME="/morbidity/Fasting Glucose";


}
