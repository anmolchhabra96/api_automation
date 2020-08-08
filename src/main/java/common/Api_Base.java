package common;


public class Api_Base {
	
	public static  String auth_key = null;
	public static  String base_url = null;
	public static  String content_type = null;
	public static  String UserResource = null;
	public static  String AuthResource = null; 
	public static  String username = null;
	public static  String password = null;
	
	public void set_authkey(String auth_key )
	{
		Api_Base.auth_key=auth_key;
	}
	public String get_authkey()
	{
		return auth_key;
    }
	
	public void set_baseUrl(String base_url )
	{
		Api_Base.base_url=base_url;
	}
	
	public String get_baseUrl() 
	{
		return base_url;
	}
	
	public void set_content_type(String content_type)
	{
		Api_Base.content_type=content_type;  
	}
	
	public String get_content_type()
	{
		return content_type; 
	}
	
	public void set_UserResource(String UserResource)
	{
		Api_Base.UserResource=UserResource;
	}
	
	public String get_UserResource()
	{
		return UserResource;
	}
	
	public void set_AuthResource(String AuthResource)
	{
		Api_Base.AuthResource=AuthResource;
	}
	
	public String get_AuthResource()
	{
		return AuthResource;
	}
	
	public void set_username(String username)
	{
		Api_Base.username=username;
	}
	
	public String get_username()
	{
		return username;
	}
	
	public void set_password(String password)
	{
		Api_Base.password=password;
	}
	
	public String get_password()
	{
		return password;
	}
	
}

