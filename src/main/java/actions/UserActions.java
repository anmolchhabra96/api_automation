package actions;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URISyntaxException;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import common.Api_Base;

public class UserActions{

	Response response;
	
	Api_Base base = new Api_Base();
	
	public Response getUserApiResponse(String auth_key,String resource,String methodtype) throws IOException, URISyntaxException
	{	
		if(methodtype.equals("get"))
		{
		RestAssured.baseURI= base.get_baseUrl();   
		response = given().header("Authorization",auth_key). 
		when().
		get(resource).then().contentType(base.get_content_type()).extract().response();     
	    return response; 
		}
		else
		{
		RestAssured.baseURI= base.get_baseUrl();   
		response = given().header("Authorization",auth_key). 
		when().
		post(resource).then().contentType(base.get_content_type()).extract().response();     
	    return response; 
		}
	}
	
}
