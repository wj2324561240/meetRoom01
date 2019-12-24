﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会议管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	
	$(function(){
		
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	
    });  
    if (!isEmpty('<%=session.getAttribute("errMsg")%>')) {
		alert('<%=session.getAttribute("errMsg")%>');
		<%session.removeAttribute("errMsg");%>
		return;
	}
});  
	
	function isEmpty(str) {
		if (null == str || undefined == str) {
			return true;
		}
		if ( str == "" || "null" == str || "undefined" == str) 
			return true;
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		return re.test(str);
	}
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
  	<form action="user_loginUser.action" method="post">
    <ul>
    <li><input name="_curUser.username" type="text" class="loginuser" value="请输入用户名" onclick="JavaScript:this.value=''"/></li>
    <li><input name="_curUser.password" type="password" class="loginpwd"  onclick="JavaScript:this.value=''"/></li>
    <li><input name="" type="submit" class="loginbtn"  value="登录" /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    <div class="loginbm">javaweb课程设计  第16组</div>
	
</body>
</html>
