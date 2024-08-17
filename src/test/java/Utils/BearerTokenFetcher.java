package Utils;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.UserLogin_Pojo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BearerTokenFetcher {

    private static String token;
    private static Properties properties;

    static {
        try {
            // Load the global config file
            properties = new Properties();
            FileInputStream in = new FileInputStream("/Users/magizh/Documents/Numpy_Hackathons/Backup_Team06_Rest/src/test/resources/global.properties");
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fetchBearerToken(String authUrl, String username, String password) throws JsonProcessingException, JsonProcessingException {
        authUrl = authUrl+Endpoints.USERLOGIN;
        UserLogin_Pojo userobj = new UserLogin_Pojo();
        userobj.setUserLoginEmail(username);
        userobj.setPassword(password);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonbody = objectMapper.writeValueAsString(userobj);
        //System.out.println(jsonbody);
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post(authUrl)
                .then().log().all()
                .extract().response();
        Assert.assertEquals(200, response.statusCode());
        String token = response.body().jsonPath().getString("token");
        System.out.println("BearerToken : " + token);
        userobj.setAdminBearerToken(token);
        setTokenInGlobalConfig(token);
//        return token;

    }


    private static void setTokenInGlobalConfig(String token) {
        try {
            // Set the token in the properties object
            properties.setProperty("adminToken", token);

            // Save the properties back to the file
            FileOutputStream out = new FileOutputStream("/Users/magizh/Documents/Numpy_Hackathons/Backup_Team06_Rest/src/test/resources/global.properties");
            properties.store(out, null);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getBearerToken() {
        return token; // Provide access to the stored token
    }


}


