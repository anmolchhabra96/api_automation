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
import utils.PropertyReader;

public class UsersTest extends UserActions{
	
	Response response;
	Global global = new Global();
	Authentication auth = new Authentication();  
	String users_resource;
	String authentication_key;
	
	@BeforeTest
	public void setup_urls() throws IOException, URISyntaxException
	{
		String values[]=global.setUrls(auth, global); 
		users_resource = values[0];
		authentication_key = values[1];
	}
	
	
	@Test(priority=1) 
	public void verifyUsersApiResponse() throws IOException, URISyntaxException
	{	
		
		response=getUserApiResponse(global,authentication_key,users_resource,"get");  
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 200, "Status returned is correct");
		 
		System.out.println(response.getBody().asString());   
		
		System.out.println("Test case 1 Passed");
	}
	
	@Test(priority=2) 
	public void verifyUsersApiResponseWithInvalidAuthToken() throws IOException, URISyntaxException
	{	
		String authentication_key = "123456";
		
		response=getUserApiResponse(global,authentication_key,users_resource,"get"); 
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 401, "Status returned is correct");  
		
		System.out.println("Test case 2 Passed");
	}
	
	@Test(priority=3) 
	public void verifyInvalidResource() throws IOException, URISyntaxException
	{	
		String users_resource = "invalid resource";
		response=getUserApiResponse(global,authentication_key,users_resource,"get"); 
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 404, "Status returned is correct");  
		
		System.out.println("Test case 3 Passed");
	}
	
	@Test(priority=4) 
	public void verifyRequestMethod() throws IOException, URISyntaxException
	{	
		response=getUserApiResponse(global,authentication_key,users_resource,"post"); 
		
		int status = response.getStatusCode();
		
		Assert.assertEquals(status, 405, "Status returned is correct");  
		
		System.out.println("Test case 4 Passed");
	} 
	
	

}
