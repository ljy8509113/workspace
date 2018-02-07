package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieHelper {
	private Map<String, Cookie> cookieMap = new HashMap<>();
	
	
	public CookieHelper(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				cookieMap.put(c.getName(), c);
			}
		}
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	public String getValue(String name) throws UnsupportedEncodingException {
		if(cookieMap.get(name) != null)
			return URLDecoder.decode(cookieMap.get(name).getValue(), "utf-8");
		else
			return null;
	}
	
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}
	
	public static Cookie createCookie(String name, String value) throws UnsupportedEncodingException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
}
