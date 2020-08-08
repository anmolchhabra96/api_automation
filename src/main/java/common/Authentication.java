package common;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.simple.JSONObject;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class Authentication {
	
    Response response;
	Api_Base base = new Api_Base();
	
	public Response getAuthToken() throws IOException, URISyntaxException
	{	
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", base.get_username()); // Cast
		requestParams.put("password", base.get_password());
		RestAssured.baseURI= base.get_baseUrl();   
		response = given().contentType(ContentType.JSON).
		body(requestParams.toJSONString()).
		when().
		post(base.get_AuthResource()).then().contentType(base.get_content_type()).extract().response();     
	    return response;   
	}

}
