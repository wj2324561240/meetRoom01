<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>

<title>会议室管理</title>
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
    <li><a href="roomList.jsp">会议室管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
     <div class="right_top" style="height:60px;">
    	<form action="room_findByTJ.action" method="post">
			 <label>会议室名:</label><input name="room.boardroomtype" type="text" class="scinput" />
			<a style="margin-left:20px;"></a>
			 <label>&nbsp;</label><input name="" type="submit" class="btn" value="查询" />
			 <a style="margin-left:8px;"></a>
        	<label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
       </form>
	</div>
    <div class="tools">
    
    	<ul class="toolbar">
    	<s:if test="#session.isAdmin">
        <li class="click"><span><img src="images/t01.png" /></span><a href="room.jsp">添加</a></li>
        </s:if>
        </ul>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>会议室名</th>
        <th>会议室容纳人数</th>
        <th>状态</th>
        <s:if test="#session.isAdmin">
        <th>操作</th>
        </s:if>
        </tr>
        </thead>
        <tbody>
        
        <s:if test="#attr.roomList==null">
  			<s:action name="room_findAllBoardroom"></s:action>
  		</s:if> 
        <s:iterator value="#attr.roomList" var="rl">
        <tr>
        <td>${rl.boardroomid}</td>
        <td>${rl.boardroomtype}</td>
        <td>
        	${rl.boardroomconten}
        </td>
        <td>
        	<s:if test="%{#rl.state==0}">占用</s:if>
        	<s:if test="%{#rl.state==1}">空闲</s:if>
        </td>
        <td>
        	<s:if test="#session.isAdmin">
        	<a href="room_findByIdRoom?room.boardroomid=${rl.boardroomid}" class="tablelink">查看</a> 
        	<a href="room_deleteRoom?room.boardroomid=${rl.boardroomid}" class="tablelink" onclick="javascript:return delcfm();"
        	>删除</a>
        	</s:if>
        </td>
        </tr>
        </s:iterator>
        </tbody>
    </table>
    <div class="pagin">
    	<s:iterator value="%{#attr.roompageBean}">
    	<div class="message">共<i class="blue"><s:property value="allRow" /></i>条记录，共<s:property value="totalPage" />页，
    	当前显示第&nbsp;<i class="blue"><s:property value="currentPage" />&nbsp;</i>页</div>
       
        <ul class="paginList">
        <s:if test="%{currentPage == 1}">    
          			 第一页  上一页    
         </s:if>
					<s:else>
						<a href="room_findByTJ.action?page=1">第一页</a>
						<a href="room_findByTJ.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
					</s:else>

					<s:if test="%{currentPage != totalPage}">
						<a href="room_findByTJ.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
						<a href="room_findByTJ.action?page=<s:property value="totalPage"/>">最后一页</a>
					</s:if>

					<s:else>    
         			下一页  最后一页    
         </s:else>
        </ul>
        </s:iterator>
    </div>
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>


</body>
</html>
