package common;

import utils.PropertyReader;

public class Api_Base {
	
	private String auth_key = null; 
	private String base_url = null;
	private String content_type = null;
	private String UserResource = null;
	private String AuthResource = null;  
	private String username = null;
	private String password = null;
	
	public void set_authkey(String auth_key )
	{
		this.auth_key=auth_key; 
	}
	public String get_authkey()
	{
		return auth_key;
    }
	
	public void set_baseUrl(String base_url )
	{
		this.base_url=base_url;
	}
	
	public String get_baseUrl() 
	{
		return base_url;
	}
	
	public void set_content_type(String content_type)
	{
		this.content_type=content_type;  
	}
	
	public String get_content_type()
	{
		return content_type; 
	}
	
	public void set_UserResource(String UserResource)
	{
		this.UserResource=UserResource;
	}
	
	public String get_UserResource()
	{
		return UserResource;
	}
	
	public void set_AuthResource(String AuthResource)
	{
		this.AuthResource=AuthResource;
	}
	
	public String get_AuthResource()
	{
		return AuthResource;
	}
	
	public void set_username(String username)
	{
		this.username=username;
	}
	
	public String get_username()
	{
		return username;
	}
	
	public void set_password(String password)
	{
		this.password=password;
	}
	
	public String get_password()
	{
		return password;
	}
	
}

