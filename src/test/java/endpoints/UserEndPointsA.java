package endpoints;
//For Create, Read, Update, Delete
import io.restassured.response.Response;
import payloads.User;
import java.util.ResourceBundle;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserEndPointsA {
	
	static ResourceBundle geturls()	{//getting the routes from the route.properties file
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload){
		
		//get the post_url from route.properties
		String postURL = geturls().getString("post_url");
		
		Response response =
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.header("api-key","special-key")
		.when()
			.post(postURL);
		return response;
		
	}
	
	public static Response readUser(String userName){
		
		//get the post_url from route.properties
		String getURL = geturls().getString("get_url");
		
		Response response =
		RestAssured
		.given()
			.pathParam("username", userName)
			.header("api-key","special-key")
		.when()
			.get(getURL);
		return response;
	}
	
	public static Response updateUser(String userName, User payload){
		
		//get the update_url from route.properties
		String updateURL = geturls().getString("update_url");
		
		Response response =
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
			.header("api-key","special-key")
		.when()
			.post(updateURL);
		return response;
	}
	
	public static Response deleteUser(String userName){
		//get the delete_url from route.properties
		String deleteURL = geturls().getString("delete_url");
		Response response =
		RestAssured
		.given()
			.pathParam("username", userName)
			.header("api-key","special-key")
		.when()
			.delete(deleteURL);
		return response;
	}
}
