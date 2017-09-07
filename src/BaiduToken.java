import java.util.Map;

import com.alibaba.fastjson.JSON;


public class BaiduToken {
	
	// ==============================这是请求token必要参数================================
	private static final String CLIENT_ID = "xIQ8UzPO4rXC2bGNHrt6wAzD";
	private static final String CLIENT_SECRET = "2d2ae02a83c421866f45ac9c6d05c47e";
	private static final String URL = "https://openapi.baidu.com/oauth/2.0/token";
	// ==============================这是百度返回参数的字段名==============================
	private static final String ACCESS_TOKEN = "access_token";
	// private static final String SESSION_KEY = "session_key";
	// private static final String SCOPE = "scope";
	// private static final String REFRESH_TOKEN = "refresh_token";
	// private static final String SESSION_SECRET = "session_secret";
	// private static final String EXPIRES_IN = "expires_in";
	
	public static String getToken(){
		String param = "grant_type=client_credentials"
				+ "&client_id="+ CLIENT_ID
				+ "&client_secret=" + CLIENT_SECRET;
		
		String result = HttpRequestUtil.sendGet(URL, param);
		return (String)JSON.parseObject(result, Map.class).get(ACCESS_TOKEN);
	}
	
}
