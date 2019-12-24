<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
    <li><a href="meetList.jsp">会议管理</a></li>
    <li><a href="meet.jsp">会议信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <form action="meet_updateMeet.action" method="post">
    <ul class="forminfo">
    <li><input name="meet.meetid" type="hidden" value="${meet.meetid}" /></li>
    <li><label>会议名称</label><input name="meet.meetname" type="text" class="dfinput"  value="${meet.meetname}" /></li>
    <li><label>开始时间</label><input name="meet.starttime" type="text" class="dfinput"  value="${meet.starttime}" /></li>
    <li><label>结束时间</label><input name="meet.endtime" type="text" class="dfinput"  value="${meet.endtime}" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
    	<label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </li>
    </ul>
    </form>
    
    </div>



</body>
</html>
