<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>

<title>会议室修改</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/checktext.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="roomList.jsp">会议室管理</a></li>
    <li><a href="room.jsp">会议室信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <form action="room_addRoom.action" method="post">
    <ul class="forminfo">
    <li><input name="room.boardroomid" type="hidden" class="dfinput" value="${room.boardroomid}" /></li>
    <li><label>会议室名</label><input name="room.boardroomtype" type="text" class="dfinput" value="${room.boardroomtype}" /></li>
    <li><label>会议室容纳人数</label><input name="room.boardroomconten" type="text" class="dfinput" value="${room.boardroomconten}"  />
    </li>
    <li>
		<cite><input name="room.state" type="radio" value="0" checked="checked" ${room.state == "0"?'checked':''}/>占用&nbsp;&nbsp;&nbsp;&nbsp;
	    <input name="room.state" type="radio" value="1" ${room.state == "1"?'checked':''}/>空闲</cite>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
    	<label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </li>
    </ul>
    </form>
    
    </div>



</body>
</html>
