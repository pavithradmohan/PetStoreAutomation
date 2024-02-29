package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;

//created to perform CRUD operations.
public class UserEndPoints {
	
	static Response response;

    public static Response createUser(User payload){

        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
        .when()
                .post(Routes.userPost_url);

        return response;
    }
    
    public static Response readUser(String username) {

        response = given()
                .accept(ContentType.JSON)
                .pathParam("username", username)
        .when()
                .get(Routes.userGet_url);

        return response;
    }
    
    public static Response updateUser(String username, User payload) {

        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
        .when()
                .put(Routes.userUpdate_url);

        return response;
    }
    public static Response deleteUser(String username) {

        response = given()
                .accept(ContentType.JSON)
                .pathParam("username", username)
        .when()
                .delete(Routes.userDelete_url);

        return response;
    }


}
