package common;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.simple.JSONObject;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import utils.Global;

public class Authentication {
	
    Response response;
	
	public Response getAuthToken(Global global) throws IOException, URISyntaxException
	{	
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", global.getBase().get_username()); // Cast 
		requestParams.put("password", global.getBase().get_password());
		RestAssured.baseURI= global.getBase().get_baseUrl();   
		response = given().contentType(ContentType.JSON).
		body(requestParams.toJSONString()).
		when().
		post(global.getBase().get_AuthResource()).then().contentType(global.getBase().get_content_type()).extract().response();     
	    return response;   
	}

}
