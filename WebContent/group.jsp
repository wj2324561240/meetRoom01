<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>
<title>部门修改</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/checktext.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="groupList.jsp">部门管理</a></li>
    <li><a href="group.jsp">部门修改</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <form action="group_addGroup.action" method="post">
    <ul class="forminfo">
    <li><input name="group.groupid" type="hidden" class="dfinput" value="${group.groupid}" /></li>
    <li><label>部门名称</label><input name="group.groupname" type="text" class="dfinput" value="${group.groupname}" /></li>
    <li><label>部门人数</label><input name="group.membernumber" type="text" class="dfinput" value="${group.membernumber}"  /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
    	<label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </li>
    </ul>
    </form>
    
    </div>



</body>
</html>
