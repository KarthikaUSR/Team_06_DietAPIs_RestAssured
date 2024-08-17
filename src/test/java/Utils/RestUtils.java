package Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.UserLogin_Pojo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;
    public static Response response;
    public static String adminToken;

    public RequestSpecification requestSpecification() throws IOException {
//        System.out.println("========admin token ======="+ adminToken );
        if (reqSpec == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseURL"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();

//            if(adminToken != null){
//                reqSpec.header("Authorization", "Bearer " + adminToken);
//            }else {
//                System.out.println("~~~Admin token is null!~~~");
//            }
        }
        return reqSpec;
    }
    public ResponseSpecification responseSpecification() {
        if (resSpec == null) {
            resSpec = new ResponseSpecBuilder().build();
        }
        return resSpec;
    }

    // Initialize Request Specification if null
    private static void initializeRequestSpec() throws IOException {
        if (reqSpec == null) {
            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseURL"))
                    .setContentType(ContentType.JSON)
                    .build();
        }
    }
    // Initialize Response Specification if null
    private static void initializeResponseSpec() {
        if (resSpec == null) {
            resSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();
        }
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

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

        UserLogin_Pojo userobj = new UserLogin_Pojo();
        userobj.setUserLoginEmail(getGlobalValue("adminEmail"));
        userobj.setPassword(getGlobalValue("password"));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonbody = objectMapper.writeValueAsString(userobj);
//        System.out.println("Request Body: " + jsonbody);
        response = given()
                .spec(reqSpec)
                .body(jsonbody)
                .when()
                .post(Endpoints.USERLOGIN)
                .then()
                .log().all()  // Log request and response
                .extract().response();
        String token=response.body().jsonPath().getString("token");
        System.out.println("BearerToken : "+token);
//        userobj.setBearerToken(token);

    }



    public void addHeader(String key,String value){
        reqSpec= given().header(key,value);

    }
    public void updateAuthorizationHeader() {
        if (adminToken != null) {
            reqSpec.header("Authorization", "Bearer " + adminToken);
        }
    }
    public static void addBasicAuth(String userEmail,String password) {
        reqSpec=reqSpec.auth().preemptive().basic(userEmail, password);
    }
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
    public Response addReqType(String reqType,String endPoint) {
        switch (reqType) {
            case "GET":
                response=reqSpec.log().all().get(endPoint);
                break;
            case "POST":
                response=reqSpec.log().all().post(endPoint);
                break;
            case "PUT":
                response=reqSpec.log().all().put(endPoint);
                break;
            case "PATCH":
                response=reqSpec.log().all().patch(endPoint);
                break;
            case "DELETE":
                response=reqSpec.log().all().delete(endPoint);
                break;
            default:
                break;
        }
        return response;
    }

}
