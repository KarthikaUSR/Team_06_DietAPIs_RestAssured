package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static RequestSpecification reqSpec;
    public static ResponseSpecification response;

//    public static RequestSpecification requestSpec;
//    public static ResponseSpecification responseSpec;


    public RequestSpecification requestSpecification() throws IOException {

        if(reqSpec == null)
        {
//            BasicAuthScheme basicAuth = new BasicAuthScheme();
//            basicAuth.setUserName(PropertiesFile.getProperty("username"));
//            basicAuth.setPassword(PropertiesFile.getProperty("password"));
//            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            reqSpec = new RequestSpecBuilder().setBaseUri(getPropertyFileValue("baseURL"))
//                    .setAuth(basicAuth)
//                    .addFilter(RequestLoggingFilter.logRequestTo(log))
//                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();
            return reqSpec;
        }
        return reqSpec;
    }
    public ResponseSpecification responseSpecification() {
        response = new ResponseSpecBuilder().build();
        return response;
    }

    public static String getProjectPath() {
        String path=System.getProperty("user.dir");
        return path;
    }

    public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
        Properties properties=new Properties();

        properties.load(new FileInputStream(getProjectPath()+"\\Config\\config.properties"));
        Object object=properties.get(key);
        String value=(String)object;
        return value;
    }

    public void addBasicAuth(String userEmail,String password) {
        reqSpec=reqSpec.auth().preemptive().basic(userEmail, password);
    }

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
    public int getStatusCode(Response response) {
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    public void addHeader(String key,String value){
        reqSpec= RestAssured.given().header(key,value);
    }

    public void addPathParam(String key,String value) {
        reqSpec=reqSpec.pathParam(key, value);
    }
}
