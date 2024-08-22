package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import pojo.UserLoginPojo;

import java.io.*;
import java.util.Map;
import java.util.Properties;

import static Utils.RestUtils.getGlobalValue;
import static io.restassured.RestAssured.given;

public class Util1 {

    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;
    Response response;
    //        if (id == null || id.isEmpty()) {
    //            throw new IllegalArgumentException("dietId cannot be null or empty");
    //        }
    @Setter
    public static String dietId;
    public static String token;
    Gson gson = new Gson();
    UserLoginPojo userLoginPojo = new UserLoginPojo();
    String requestBody = gson.toJson(userLoginPojo);


    public RequestSpecification requestSpecification() throws IOException {
        if (reqSpec == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseURL"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
//                    .addHeader("Authorization", "Bearer " + getGlobalValue("adminToken"))
                    .build();
        }
        return reqSpec;
    }
    public RequestSpecification setHeaderRequestSpecification() throws IOException {
        if (reqSpec == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseURL"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .addHeader("Authorization", "Bearer " + getGlobalValue("adminToken"))
                    .build();
        }
        return reqSpec;
    }
    public static void responseSpecification(int expectedStatusCode) throws FileNotFoundException {

        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectContentType("application/json")
                .build();
    }
    public static ResponseSpecification createResponseSpecification(int statusCode) {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
//        responseSpecBuilder.expectStatusCode(statusCode);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        // Add more expectations as needed, e.g., headers, response time, etc.
        return responseSpecBuilder.build();
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public static void setToken(String tokenValue) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("token cannot be null or empty");
        }
        token = tokenValue;
    }
    public static String getToken() {
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("Token is not set");
        }
        return token;
    }
    public static String getDietId() {
        if (dietId == null || dietId.isEmpty()) {
            throw new IllegalStateException("dietId is not set");
        }
        return dietId;
    }
    public static void setDietId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("dietId cannot be null or empty");
        }
        dietId = id;
    }

    public RequestSpecification setup_dietCreation() throws IOException {

        String Bearertoken=getGlobalValue("adminToken");
        //String Bearertoken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBUElQSDJfMUBnbWFpbC5jb20iLCJpYXQiOjE3MjQxMDY3MTEsImV4cCI6MTcyNDEzNTUxMX0.PxNeHz9dXUKmRztOC_gzoKt8wbTevQLaAyUZtrf0C-WIXAovaBVqvqVAf6FG31K035a-iNS1415a7Y552H4SHw";

        reqSpec= RestAssured.given().baseUri(EndPoints.BASEURI)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + Bearertoken);

        return 	reqSpec;

    }
    private Map<String, Object> getJsonDataForKey(String Key) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map<String, Object>> jsonData = mapper.readValue(new File(jsonPath), new TypeReference<Map<String, Map<String, Object>>>() {
        });
        return jsonData.get(Key);

    }

    private final static String jsonPath = "src/test/resources/Data/Dietician_Creation_Data.json";
    public Response dietCreation(String Key) throws IOException, ParseException {

        String jsonbody = new Gson().toJson(getJsonDataForKey(Key));
        System.out.println("Request Body: " + jsonbody);


        RequestSpecification requestSpec = setup_dietCreation()
                .basePath(EndPoints.CREATE_DIETICIAN)
                .contentType("application/json")
                .body(jsonbody).log().all();

      return requestSpec.when().post();

    }

    public Response updateDietician(String Key) throws IOException, ParseException {

        String jsonbody = new Gson().toJson(getJsonDataForKey(Key));
        System.out.println("Request Body: " + jsonbody);


        RequestSpecification requestSpec = setup_dietCreation()
                .basePath(EndPoints.UPDATE_DIETICIAN_BY_ID)
                .contentType("application/json")
                .body(jsonbody).log().all();

        return requestSpec.when().put();

    }


    public void userLogin() throws IOException {

        userLoginPojo.setUserLoginEmail(getGlobalValue("userEmail"));
        userLoginPojo.setPassword(getGlobalValue("password"));
        String requestBody = gson.toJson(userLoginPojo);
        reqSpec = given().
                spec(requestSpecification())
//                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .body(requestBody)
                .log().all();
    }

    public void dieticianLogin() throws IOException {

        userLoginPojo.setUserLoginEmail(getGlobalValue("dietEmail"));
        userLoginPojo.setPassword(getGlobalValue("dietPassword"));
        String requestBody = gson.toJson(userLoginPojo);
        reqSpec = given().
                spec(requestSpecification())
//                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .body(requestBody)
                .log().all();
    }

    public void patientLogin() throws IOException {

        userLoginPojo.setUserLoginEmail(getGlobalValue("patEmail"));
        userLoginPojo.setPassword(getGlobalValue("patPassword"));
        String requestBody = gson.toJson(userLoginPojo);
        reqSpec = given().
                spec(requestSpecification())
//                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .body(requestBody)
                .log().all();
    }

    public void userLoginInvalidCredential() throws IOException {

        userLoginPojo.setUserLoginEmail(getGlobalValue("userEmal"));
        userLoginPojo.setPassword(getGlobalValue("pasword"));
        String requestBody = gson.toJson(userLoginPojo);
        reqSpec = given().
                spec(requestSpecification())
//                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .body(requestBody)
                .log().all();
    }

    public void userLoginInvalidContentType() throws IOException {

        userLoginPojo.setUserLoginEmail(getGlobalValue("userEmail"));
        userLoginPojo.setPassword(getGlobalValue("password"));
        String requestBody = gson.toJson(userLoginPojo);
        reqSpec = given().
                spec(requestSpecification())
                .contentType(ContentType.TEXT)
//                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .body(requestBody)
                .log().all();
    }

    public Response addReqType(String httpMethod){
        if (httpMethod.equalsIgnoreCase("POST")) {
            return reqSpec.when().post(EndPoints.USERLOGIN);
        } else if (httpMethod.equalsIgnoreCase("GET")) {
            return  reqSpec.when().get(EndPoints.USERLOGOUT);
        }else if (httpMethod.equalsIgnoreCase("PUT")) {
            return reqSpec.when().get(EndPoints.USERLOGOUT);
        }else if (httpMethod.equalsIgnoreCase("DELETE")) {
            return reqSpec.when().get(EndPoints.USERLOGOUT);
        }
//        else if (httpMethod.equalsIgnoreCase("DELETE")) {
//            response = reqSpec.when().get(EndPoints.USERLOGOUT);
//        }
        throw new IllegalArgumentException("Invalid HTTP method: " + httpMethod);
    }

}
