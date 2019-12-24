<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>
<title>设备管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/delete.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="equipmentList.jsp">设备管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span><a href="equipment.jsp">添加</a></li>
        </ul>
        
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>设备编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>设备名称</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:if test="#attr.equipmentList==null">
  			<s:action name="equipment_findAllEquipment"></s:action>
  		</s:if> 
        <s:iterator value="#attr.equipmentList" var="el">
        <tr>
        <td>${el.equipmentid}</td>
        <td>${el.equipmentname}</td>
        <td>
        	<a href="equipment_findByIdEquipment.action?equipment.equipmentid=${el.equipmentid}" class="tablelink">查看</a>     
        	<a href="equipment_deleteEquipment.action?equipment.equipmentid=${el.equipmentid}" class="tablelink" onclick="javascript:return delcfm();"
        	>删除</a>
        </td>
        </tr>
        </s:iterator>
        </tbody>
    </table>
   
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>


</body>
</html>
