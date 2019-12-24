package com.meet.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Pluto
 */
public class SessionUtil {
	public static int getCurrentUserId() {
		return (int) getSession().getAttribute("userid");
	}
	
    public static HttpSession getSession() {
    	return ServletActionContext.getRequest().getSession();
    }
    
    public static HttpServletRequest getRequest() {
    	return ServletActionContext.getRequest();
    }
}
