package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	
    Faker faker;

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUsers(String userID, String userName, String fName, String lName, String email, String password, String phone) {

        User user = new User();

        user.setId(Integer.parseInt(userID));
        user.setUsername(userName);
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        Response response = UserEndPoints.createUser(user);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    
    @Test(priority = 2,dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName) {

        Response response = UserEndPoints.deleteUser(userName);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
