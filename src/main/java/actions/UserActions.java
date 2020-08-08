package actions;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URISyntaxException;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import common.Api_Base;
import utils.Global;

public class UserActions{

	Response response;
	
	public Response getUserApiResponse(Global global,String auth_key,String resource,String methodtype) throws IOException, URISyntaxException
	{	
		if(methodtype.equals("get"))  
		{
		RestAssured.baseURI= global.getBase().get_baseUrl();   
		response = given().header("Authorization",auth_key). 
		when().
		get(resource).then().contentType(global.getBase().get_content_type()).extract().response();     
	    return response; 
		}
		else
		{
		RestAssured.baseURI= global.getBase().get_baseUrl();   
		response = given().header("Authorization",auth_key). 
		when().
		post(resource).then().contentType(global.getBase().get_content_type()).extract().response();     
	    return response;  
		}
	}
	
}
