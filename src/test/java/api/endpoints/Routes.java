package api.endpoints;

public class Routes {
	
	 public static String baseUrl = "https://petstore.swagger.io/v2";
	 
	  // User model
	    public static String userPost_url = baseUrl + "/user";
	    public static String userGet_url = baseUrl + "/user/{username}";
	    public static String userUpdate_url = baseUrl + "/user/{username}";
	    public static String userDelete_url = baseUrl + "/user/{username}";

}
