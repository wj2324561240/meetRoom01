<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>
<title>添加会议</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery1.js"></script>
<script type="text/javascript" src="js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="js/checktext.js"></script>
<script type="text/javascript">
$(function(){
	$('#datetimepicker').datetimepicker();
	$('#datetimepicker').datetimepicker({value:'2017/04/15 05:03',step:10});
	
	$('#datetimepicker1').datetimepicker();
	$('#datetimepicker1').datetimepicker({value:'2017/04/15 05:03',step:10});
})

</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="meetList.jsp">会议管理</a></li>
    <li><a href="addmeet.jsp">添加会议</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>会议信息</span></div>
    
    <form action="meet_addMeet.action" method="post">
    <ul class="forminfo">
    <li><input name="meet.meetid" type="hidden" value="${meet.meetid}" /></li>
    <li><label>会议名称</label><input name="meet.meetname" type="text" class="dfinput" id="meetname" value="${meet.meetname}" /></li>
     <li><label>开始时间</label><input name="meet.starttime" type="text" class="dfinput" id="datetimepicker"  value="${meet.starttime}" /></li>
    <li><label>结束时间</label><input name="meet.endtime" type="text" class="dfinput"  id="datetimepicker1"  value="${meet.endtime}" /></li>
    <li><input name="meet.user.oid" type="hidden"  class="dfinput"  value="${session.userid}" /></li>
    <li><label>会议室</label>
		<cite>
		<s:action name="room_findkxBoardroom"></s:action>
		
		<select name="meet.room.boardroomid" class="dfinput" id="boardroomid">
			<s:iterator var="rl" value="#attr.roomkx">
				<option value="<s:property value="#rl.boardroomid"/>">
					<s:property value="#rl.boardroomtype"/>
				</option>
			</s:iterator>
		</select>
		</cite>
	</li>
	<li><label>设备</label>
		<cite>
		<s:action name="equipment_findAllEquipment"></s:action>

		<select name="meet.equipment.equipmentid" class="dfinput">
			<s:iterator var="el" value="#attr.equipmentList">
				<option value="<s:property value="#el.equipmentid"/>">
					<s:property value="#el.equipmentname"/>
				</option>
			</s:iterator>
		</select>
		</cite>
	</li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
    	<label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </li>
    </ul>
    </form>
    
    </div>
</body>
</html>
