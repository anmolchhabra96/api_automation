package utils;

import java.io.IOException;
import java.net.URISyntaxException;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import common.Api_Base;
import common.Authentication;

public class Global{

	Api_Base base = new Api_Base(); 
	Response response;
	String users_resource;
	String authentication_key;
	
	public Api_Base getBase()
	{
		return base;
	}
	
	public void setBaseUrl() throws IOException, URISyntaxException
	{
		String base_url=PropertyReader.fileload("base_url"); 
		base.set_baseUrl(base_url); 
	}
	public void setAuthKey(String auth_key) throws IOException, URISyntaxException
	{
		base.set_authkey(auth_key); 
	}
	public void setUserResource() throws IOException, URISyntaxException
	{
		String UserResource=PropertyReader.fileload("UserResource");
		base.set_UserResource(UserResource);
	}
	public void setContentType() throws IOException, URISyntaxException
	{
		String contenttype=PropertyReader.fileload("content_type");
		base.set_content_type(contenttype); 
	} 
	public void setAuthResource() throws IOException, URISyntaxException
	{
		String AuthResource=PropertyReader.fileload("AuthResource");
		base.set_AuthResource(AuthResource); 
	} 
	public void setPassword() throws IOException, URISyntaxException
	{
		String password=PropertyReader.fileload("password");
		base.set_password(password); 
	}
	public void setusername() throws IOException, URISyntaxException
	{
		String username=PropertyReader.fileload("username");
		base.set_username(username);
	}
	
	public void getAuthenticationKey(Authentication auth,Global global) throws IOException, URISyntaxException
	{
		response=auth.getAuthToken(global); 
        String json_parser = response.getBody().asString();	
		JsonPath json = new JsonPath(json_parser);		 
		String auth_key = json.get("token");
		setAuthKey(auth_key); 
		users_resource=getBase().get_UserResource();
		authentication_key = "Bearer"+" "+getBase().get_authkey();
	}
	
	public String[] setUrls(Authentication auth,Global global) throws IOException, URISyntaxException
	{
		setBaseUrl();
		setUserResource(); 
		setContentType();
		setAuthResource();
		setusername();
		setPassword();
		getAuthenticationKey(auth,global);
		String[] value = new String[2];
	    value[0] = users_resource;   // Integer
	    value[1] = authentication_key; // Double
		return value; 
		
	}
}
