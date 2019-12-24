<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="checkUser.jsp" %>

<title>用户管理</title>
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
    <li><a href="userList.jsp">用户管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="right_top" style="height:60px;">
    	 <form action="user_findByTJ.action" method="post">
        <label>用户名:</label><input name="user.username" type="text" class="scinput" />
			<a style="margin-left:20px;"></a>
			 <label>&nbsp;</label><input name="" type="submit" class="btn" value="查询" />
			 <a style="margin-left:8px;"></a>
        	<label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
       </form>
	</div>
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<s:if test="#session.isAdmin">
        <li class="click"><span><img src="images/t01.png" /></span><a href="adduser.jsp">添加</a></li>     
        <li class="click"><span><img src="images/t04.png" /></span><a href="user_dbToExcel.action" id="dbToExcel">导出用户信息</a></li>    
        </s:if>
        </ul>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>手机号码</th>
        <th>邮箱</th>
        <th>角色</th>
        <th>所属部门</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:if test="#attr.userList==null">
  			<s:action name="user_findAllUser"></s:action>
  		</s:if> 
        <s:iterator value="#attr.userList" var="ul">
        <tr>
        <td>${ul.oid}</td>
        <td>${ul.username}</td>
        <td>${ul.age}</td>
        <td>${ul.sex}</td>
        <td>${ul.phone}</td>
        <td>${ul.email}</td>
        <td>${ul.role}</td>
        <td>${ul.group.groupname}</td>
        <td><a href="user_findByIdUser.action?user.oid=${ul.oid}" class="tablelink">查看</a>    
        <s:if test="#session.isAdmin"> <a href="user_deleteUser.action?user.oid=${ul.oid}" class="tablelink" onclick="javascript:return delcfm();"
        >删除</a> </s:if></td>
        </tr>
        </s:iterator>
        </tbody>
    </table>
    
    <div class="pagin">
    	<s:iterator value="%{#attr.pageBean}">
    	<div class="message">共<i class="blue"><s:property value="allRow" /></i>条记录，共<s:property value="totalPage" />页，
    	当前显示第&nbsp;<i class="blue"><s:property value="currentPage" />&nbsp;</i>页</div>
       
        <ul class="paginList">
        <s:if test="%{currentPage == 1}">    
          			 第一页  上一页    
         </s:if>
					<s:else>
						<a href="user_findByTJ.action?page=1">第一页</a>
						<a href="user_findByTJ.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
					</s:else>

					<s:if test="%{currentPage != totalPage}">
						<a href="user_findByTJ.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
						<a href="user_findByTJ.action?page=<s:property value="totalPage"/>">最后一页</a>
					</s:if>

					<s:else>    
         			下一页  最后一页    
         </s:else>
        </ul>
        </s:iterator>
    </div>
			
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>


</body>
</html>
