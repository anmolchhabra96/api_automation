package api_test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import actions.UserActions;
import common.Api_Base;
import common.Authentication;
import utils.Global;

public class UsersTest extends UserActions{
	
	Response response;
	Global global = new Global();
	Authentication auth = new Authentication();
	Api_Base base = new Api_Base(); 
	String users_resource;
	String authentication_key;
	
	@BeforeTest
	public void setup_urls() throws IOException, URISyntaxException
	{
		global.setBaseUrl();
		global.setUserResource();
		global.setContentType();
		global.setAuthResource();
		global.setusername();
		global.setPassword();
		response=auth.getAuthToken(); 
        String json_parser = response.getBody().asString();	
		JsonPath json = new JsonPath(json_parser);		
		String auth_key = json.get("token");
		global.setAuthKey(auth_key); 
		users_resource=base.get_UserResource();
		authentication_key = "Bearer"+" "+base.get_authkey();  
	}
	
	
	@Test(priority=1) 
	public void verifyUsersApiResponse() throws IOException, URISyntaxException
	{	
		
		response=getUserApiResponse(authentication_key,users_resource,"get"); 
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 200, "Status returned is correct");
		 
		System.out.println(response.getBody().asString());   
		
		System.out.println("Test case 1 Passed");
	}
	
	@Test(priority=2) 
	public void verifyUsersApiResponseWithInvalidAuthToken() throws IOException, URISyntaxException
	{	
		String authentication_key = "123456";
		
		response=response=getUserApiResponse(authentication_key,users_resource,"get"); 
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 401, "Status returned is correct");  
		
		System.out.println("Test case 2 Passed");
	}
	
	@Test(priority=3) 
	public void verifyInvalidResource() throws IOException, URISyntaxException
	{	
		String users_resource = "invalid resource";
		response=response=getUserApiResponse(authentication_key,users_resource,"get"); 
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 404, "Status returned is correct");  
		
		System.out.println("Test case 3 Passed");
	}
	
	@Test(priority=4) 
	public void verifyRequestMethod() throws IOException, URISyntaxException
	{	
		response=response=getUserApiResponse(authentication_key,users_resource,"post"); 
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 405, "Status returned is correct");  
		
		System.out.println("Test case 4 Passed");
	} 
	
	

}
