package testapi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import endpoints.UserEndPoints;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import payloads.User;

public class UserTest {
//only for usermodel
	User userPayload;
	public Logger logger;
	
	//setup data for the tests
	@BeforeClass
	public void setupData()	{
		userPayload = new User();
		userPayload.setId(1234);
		userPayload.setFirstName("Candice");
		userPayload.setLastName("Denzel");
		userPayload.setPassword("looliipop4321");
		userPayload.setEmail("CandiceThen45@email.come");
		userPayload.setPhone("+0099776655");
		userPayload.setUsername("Candice_Nation");
		userPayload.setUserStatus(0);
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser()	{
		logger.info("*** Create User test ***");
		Response response = UserEndPoints.createUser(userPayload);
		
		String res = response.asString();
		System.out.println(res);
		
		String theid = JsonPath.from(res).getString("message");
		response.then().log().all();
		System.out.println("ID created is: " + theid);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*** User Created successful***");
	}
	
	@Test(priority=2)
	public void testGetUser()	{
		logger.info("*** User Get test***");
		Response response = UserEndPoints.readUser("Candice_Nation");
				//UserEndPoints.readUser(userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		//add schema validate etc
		logger.info("*** User Get successful***");
	}
	
	@Test(priority=3)
	public void testDeleteUser()	{
		logger.info("*** User Delete test***");
		Response response = UserEndPoints.deleteUser("Candice_Nation");
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		//add schema validate etc
		logger.info("*** User Delete successful***");
	}
	
}
