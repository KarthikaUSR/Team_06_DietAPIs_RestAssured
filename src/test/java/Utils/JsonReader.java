package Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.DieticianPojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

/*
    ObjectMapper objectMapper = new ObjectMapper();
    File jsonFile = new File(
            "/Users/magizh/Documents/Numpy_Hackathons/Team_06_DietAPIs_RestAssured/src/test/resources/Data/Dietician_Creation_Data.json");

    List<DieticianPojo> dieticianList = new ArrayList<>();

		if (!jsonFile.exists()) {
        System.err.println("The file does not exist: " + jsonFile.getAbsolutePath());
        return dieticianList;
    }

		try {

        JsonNode rootNode = objectMapper.readTree(jsonFile);


        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {

                String contactNumber = node.path("ContactNumber").asText();
                String dateOfBirth = node.path("DateOfBirth").asText();
                String education = node.path("Education").asText();
                String email = node.path("Email").asText();
                String firstname = node.path("Firstname").asText();
                String hospitalCity = node.path("HospitalCity").asText();
                String hospitalName = node.path("HospitalName").asText();
                String hospitalPincode = node.path("HospitalPincode").asText();
                String hospitalStreet = node.path("HospitalStreet").asText();
                String lastname = node.path("Lastname").asText();


                DieticianPojo dieticianPayload = new DieticianPojo();
                dieticianPayload.setContactNumber(contactNumber);
                dieticianPayload.setDateOfBirth(dateOfBirth);
                dieticianPayload.setEducation(education);
                dieticianPayload.setEmail(email);
                dieticianPayload.setFirstname(firstname);
                dieticianPayload.setHospitalCity(hospitalCity);
                dieticianPayload.setHospitalName(hospitalName);
                dieticianPayload.setHospitalStreet(hospitalStreet);
                dieticianPayload.setHospitalPincode(hospitalPincode);
                dieticianPayload.setLastname(lastname);

                // Add to list
                dieticianList.add(dieticianPayload);
            }
        } else {
            System.err.println("Expected JSON array, but got something else.");
        }

    } catch (
    IOException e) {
        e.printStackTrace();
    }

		return dieticianList;
		*/

}


