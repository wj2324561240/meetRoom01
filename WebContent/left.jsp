<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>
<title>左侧</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"></div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>会议室预约管理
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="roomList.jsp" target="rightFrame">会议室管理</a><i></i></li>
        <li><cite></cite><a href="meetList.jsp" target="rightFrame">会议管理</a><i></i></li>
        <li><cite></cite><a href="userList.jsp" target="rightFrame">用户管理</a><i></i></li>
        <s:if test="#session.isAdmin">
        <li><cite></cite><a href="groupList.jsp" target="rightFrame">部门管理</a><i></i></li>
        </s:if>
        <s:if test="#session.isAdmin">
        <li><cite></cite><a href="equipmentList.jsp" target="rightFrame">设备管理</a><i></i></li>
        </s:if>
        <li><cite></cite><a href="user_findByIdUser.action?user.oid=${userid}" target="rightFrame">个人资料</a><i></i></li>
        </ul>    
    </dd>
    
    </dl>

</body>
</html>
