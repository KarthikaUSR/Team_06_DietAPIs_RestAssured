package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import pojo.UserLoginPojo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

import static Utils.JsonUtils.getJsonDataForKey;
import static io.restassured.RestAssured.given;

public class RestUtils {

    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;
    public static Response response;
    public static String adminToken;
    // Method to set dietId

    public static String dietId;

    public static RequestSpecification requestSpecification() throws IOException {
        if (reqSpec == null) {
            PrintStream log = new PrintStream(Files.newOutputStream(Paths.get("logging.txt")));
            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseURL"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
//
                    .setContentType("application/json")
                    .build();
        }
        return reqSpec;
    }

    // Initialize ResponseSpecification
    public static void responseSpecification(int expectedStatusCode) throws FileNotFoundException {

        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectContentType("application/json")
                .build();
    }

    // Optional method to initialize both in one go
    public static void initializeSpecifications(int expectedStatusCode) throws IOException {
        requestSpecification();
        responseSpecification(expectedStatusCode);
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public RequestSpecification setup_dietCreation() throws IOException {

        String Bearertoken=getGlobalValue("adminToken");
        //String Bearertoken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBUElQSDJfMUBnbWFpbC5jb20iLCJpYXQiOjE3MjQxMDY3MTEsImV4cCI6MTcyNDEzNTUxMX0.PxNeHz9dXUKmRztOC_gzoKt8wbTevQLaAyUZtrf0C-WIXAovaBVqvqVAf6FG31K035a-iNS1415a7Y552H4SHw";

        reqSpec= RestAssured.given().baseUri(EndPoints.BASEURI)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + Bearertoken);

        return 	reqSpec;

    }

    //############## CREATE DIETICIAN ###########//
    private final static String jsonPath = "src/test/resources/Data/Dietician_Creation_Data.json";
    public Response dietCreation(String Key) throws IOException, ParseException {
        Response response = null;

        String jsonbody = getJsonDataForKey(Key).toString();

        JSONObject jsonObj = new JSONObject(getJsonDataForKey(Key));
////        String jsonbody=jsonObj.get(Key).toString();

        RequestSpecification requestSpec = setup_dietCreation()
                .basePath(EndPoints.CREATE_DIETICIAN)
                .contentType("application/json")
                .body(jsonbody);

        response = requestSpec.when().post();
        response.prettyPrint();
        // Send the POST request and retrieve the response


        return response;
    }

    /*
        if(Key.equalsIgnoreCase("DietCreationValid"))//PateintCreationValidAdditional
        {

            response =setup_dietCreation()
                    .basePath(EndPoints.CREATE_DIETICIAN)
                    .contentType("application/json")
                    .body(jsonbody)
                    .when()
                    .post();
            response.prettyPrint();
        }
        else if(Key.equalsIgnoreCase("DietCreationValidMandatory"))
        {
            System.out.println("body:"+jsonbody);
            response =setup_dietCreation()
                    .basePath(EndPoints.CREATE_DIETICIAN)
                    .contentType("application/json")
                    .body(jsonbody)
                    .when()
                    .post();
            response.prettyPrint();
        }
        else if(Key.equalsIgnoreCase("DietCreationValidAdditional"))
        {
            response =setup_dietCreation()
                    .basePath(EndPoints.CREATE_DIETICIAN)
                    .contentType("application/json")
                    .body(jsonbody)
                    .when()
                    .post();
            response.prettyPrint();
        }

        else if(Key.equalsIgnoreCase("DietCreationInValidMandatory"))
        {
            response =setup_dietCreation()
                    .basePath(EndPoints.CREATE_DIETICIAN)
                    .contentType("application/json")
                    .body(jsonbody)
                    .when()
                    .post();
            response.prettyPrint();
        }
        else if(Key.equalsIgnoreCase("DietCreationInValidAdditional")) {
            response = setup_dietCreation()
                    .basePath(EndPoints.CREATE_DIETICIAN)
                    .contentType("application/json")
                    .body(jsonbody)
                    .when()
                    .post();
            response.prettyPrint();
        }
        else if(Key.equalsIgnoreCase("Dietician"))
        {
            response =setup_dietCreation()
                    .basePath(EndPoints.CREATE_DIETICIAN)
                    .contentType("application/json")
                    .body(jsonbody)
                    .when()
                    .post();
            response.prettyPrint();
        }
        else if(Key.equalsIgnoreCase("Patient"))
        {
            response =setup_dietCreation()
                    .basePath(EndPoints.CREATE_DIETICIAN)
                    .contentType("application/json")
                    .body(jsonbody)
                    .when()
                    .post();
            response.prettyPrint();
        }
        else {
            System.out.println("Invalid Entry");

        }
        return response;

    }

     */

    private Map<String, Object> getJsonDataForKey(String Key) throws IOException {

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Map<String, Object>> jsonData = mapper.readValue(new File(jsonPath), new TypeReference<Map<String, Map<String, Object>>>() {
            });
            return jsonData.get(Key);

        }



// Method to get dietId
public static void setDietId(String id) {
    if (id == null || id.isEmpty()) {
        throw new IllegalArgumentException("dietId cannot be null or empty");
    }
    dietId = id;
}

public static String getDietId() {
    if (dietId == null || dietId.isEmpty()) {
        throw new IllegalStateException("dietId is not set");
    }
    return dietId;
}



















//    public RequestSpecification requestSpecification() throws IOException {
//
//        if (reqSpec == null) {
//            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
//            reqSpec = new RequestSpecBuilder()
//                    .setBaseUri(getGlobalValue("baseURL"))
//                    .addFilter(RequestLoggingFilter.logRequestTo(log))
//                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
//                    .setContentType(ContentType.JSON)
//                    .addHeader("Authorization", "Bearer " + getGlobalValue("adminToken"))
//                    .build();
//        }
//        return reqSpec;
//    }




//    public ResponseSpecification responseSpecification() {
//        if (resSpec == null) {
//            resSpec = new ResponseSpecBuilder().build();
//        }
//        return resSpec;
//    }

    // set token in header
//    public RequestSpecification setTokenInHeaderRequestSpec() throws IOException {
//
//        if (reqSpec == null) {
//            reqSpec = new RequestSpecBuilder()
//                    .setBaseUri(getGlobalValue("baseURL"))
//                    .setContentType(ContentType.JSON)
//                    .addHeader("Authorization", "Bearer " + getGlobalValue("adminToken"))
//                    .build();
//        }
//        return reqSpec;
//    }







    /*
    public static void fetchBearerToken1() throws IOException {
        initializeRequestSpec();
        initializeResponseSpec();
//        UserLogin_Pojo userobj =  UserLogin_Pojo.builder()
//                .userLoginEmail(getGlobalValue("dietEmail"))
//                .password(getGlobalValue("dietPassword"))
//                .build();


//         UserLogin_Pojo userobj =  UserLogin_Pojo.builder()
//                .userLoginEmail(getGlobalValue("adminEmail"))
//                .password(getGlobalValue("password"))
//                .build();

        UserLoginPojo userobj = new UserLoginPojo();
        userobj.setUserLoginEmail(getGlobalValue("adminEmail"));
        userobj.setPassword(getGlobalValue("password"));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonbody = objectMapper.writeValueAsString(userobj);
//        System.out.println("Request Body: " + jsonbody);
        response = given()
                .spec(reqSpec)
                .body(jsonbody)
                .when()
                .post(EndPoints.USERLOGIN)
                .then()
                .log().all()  // Log request and response
                .extract().response();
        String token=response.body().jsonPath().getString("token");
        System.out.println("BearerToken : "+token);
//        userobj.setBearerToken(token);

    }
*/

    // Initialize Response Specification if null
//    private static void initializeResponseSpec() {
//        if (resSpec == null) {
//            resSpec = new ResponseSpecBuilder()
//                    .expectStatusCode(200)
//                    .build();
//        }
//    }

    //    public Response addReqType(String reqType) {
//        switch (reqType.toUpperCase()) {
//            case "GET":
//                response = reqSpec.when()
//                        .get(Endpoints.)
//                        .then()
//                        .log().all()
//                        .spec(resSpec)
//                        .extract().response();
//                break;
//            case "PUT":
//                response = reqSpec.when()
//                        .put(endpoint)
//                        .then()
//                        .log().all()
//                        .spec(resSpec)
//                        .extract().response();
//                break;
//
//
//            default:
//                break;
//        }
//        return response;
//    }
//    public Response addReqType(String reqType,String endPoint) {
//        switch (reqType) {
//            case "GET":
//                response=reqSpec.log().all().get(endPoint);
//                break;
//            case "POST":
//                response=reqSpec.log().all().post(endPoint);
//                break;
//            case "PUT":
//                response=reqSpec.log().all().put(endPoint);
//                break;
//            case "PATCH":
//                response=reqSpec.log().all().patch(endPoint);
//                break;
//            case "DELETE":
//                response=reqSpec.log().all().delete(endPoint);
//                break;
//            default:
//                break;
//        }
//        return response;
//    }

}

