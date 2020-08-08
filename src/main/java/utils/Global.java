package utils;

import java.io.IOException;
import java.net.URISyntaxException;

import common.Api_Base;

public class Global{

	
	Api_Base base = new Api_Base();
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
}
