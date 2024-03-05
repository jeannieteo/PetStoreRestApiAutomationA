package testapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payloads.User;
import utilities.ExcelReaders;

public class dataUserTest {
	//create multiple users and then delete all users
	@Test(priority = 1, dataProvider="getUserData", dataProviderClass=ExcelReaders.class)
	public void test_PostmanyUsers(String uid, String username, String firstname, String lastname, String email, String password, String phone)
	{
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(uid));
		userPayload.setFirstName(firstname);
		userPayload.setLastName(lastname);
		userPayload.setPassword(password);
		userPayload.setEmail(email);
		userPayload.setPhone(phone);
		userPayload.setUsername(username);
		userPayload.setUserStatus(0);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider="getUsername", dataProviderClass=ExcelReaders.class)
	public void test_DeletemanyUsers(String username)
	{
		
		Response response = UserEndPoints.deleteUser(username);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
