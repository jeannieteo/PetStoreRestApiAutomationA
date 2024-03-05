package endpoints;
//For Create, Read, Update, Delete
import io.restassured.response.Response;
import payloads.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserEndPoints {
		
	public static Response createUser(User payload){
		
		Response response =
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.header("api-key","special-key")
		.when()
			.post(Routes.post_url);
		return response;
		
	}
	
	public static Response readUser(String userName){
		
		Response response =
		RestAssured
		.given()
			.pathParam("username", userName)
			.header("api-key","special-key")
		.when()
			.get(Routes.get_url);
		return response;
	}
	
	public static Response updateUser(String userName, User payload){
		
		Response response =
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
			.header("api-key","special-key")
		.when()
			.post(Routes.update_url);
		return response;
	}
	
	public static Response deleteUser(String userName){
		
		Response response =
		RestAssured
		.given()
			.pathParam("username", userName)
			.header("api-key","special-key")
		.when()
			.delete(Routes.delete_url);
		return response;
	}
}
