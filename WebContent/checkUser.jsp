<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  
  Object username = session.getAttribute("username");  
  if(null == username){  
      response.sendRedirect("login.jsp");  
  }  
%>  
