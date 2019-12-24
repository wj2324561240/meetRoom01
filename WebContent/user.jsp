<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>

<title>信息修改</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/checktext.js"></script>
<script type="text/javascript">
function isEmail(){ 
	var str=document.getElementById("email").value;
	//alert(str);
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
	if(reg.test(str)){
		return true;
	}else{
		alert("邮箱格式错误");
		document.getElementById("email").value="";
		return false;
	}
	//alert(reg.test(str));
	//return ; 
} 
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="userList.jsp">用户管理</a></li>
    <li><a href="user.jsp">用户信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <form action="user_updateUser.action" method="post">
    <ul class="forminfo">
    <li><input name="user.oid" type="hidden" class="dfinput" readonly value="${user.oid}" /></li>
    <li><label>用户名</label><input name="user.username" type="text" class="dfinput" readonly value="${user.username}" /></li>
    <li><label>年龄</label><input name="user.age" type="text" class="dfinput" value="${user.age}"  /></li>
    <li><label>性别</label><cite><input name="user.sex" type="radio" value="男" checked="checked" ${user.sex == "男"?'checked':''}/>男&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="user.sex"  type="radio" value="女" ${user.sex == "女"?'checked':''}/>女</cite></li>
    <li><label>手机号码</label><input name="user.phone" type="text" class="dfinput" value="${user.phone}"  /></li>
    <li><label>邮箱</label><input name="user.email" type="text" class="dfinput" id="email" onblur="isEmail();" value="${user.email}"  /></li>
	<li><label>角色</label><input name="user.role" type="text" readonly class="dfinput" value="${user.role}"  /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
    	<label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </li>
    </ul>
    </form>
    
    </div>



</body>
</html>
