<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>橡树科技－JavaDemoSystem</title>
<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/validform/css/style.css" />
<script src="<%=request.getContextPath() %>/resource/validform/js/jquery-1.9.1.min.js" charset="utf-8"></script>
<script src="<%=request.getContextPath() %>/resource/validform/js/Validform_v5.3.2.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/styles/global.css" tppabs="http://demo.mycodes.net/houtai/isoakJavaDemoSystem/styles/global.css"/>
<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/styles/global_color.css" tppabs="http://demo.mycodes.net/houtai/isoakJavaDemoSystem/styles/global_color.css"/>
<script language="javascript" type="text/javascript">
     $(function(){
     	//组装部门的下拉框
     	$.ajax({
     		url:"../findAllDept",
     		async:false,
     		dataType:"json",
     		success:function(result){
     			var html = "";
     			for(var i=0;i<result.length;i++){
     				var id = result[i].id;
     				var name = result[i].name;
     				html += "<option value='"+id+"'>"+name+"</option>";
     			}
     			$("#deptName").append(html);
     		}
     	});
     	
     	//回显下拉框
     	var deptId = '${emp.deptId}';
     	$("#deptName [value='"+deptId+"']").attr("selected",true);
     	
     	var isCharge = '${emp.isCharge}';
     	$("#isCharge [value='"+isCharge+"']").attr("selected",true);
     
     	$(".main_form").Validform({
        	tiptype:3,
        	datatype:{
        		"username":function(gets){
        			//gets是需要验的值
        			//原来的值
        			var oldUsername = '${emp.username}';
        			var flag = true;
        			if(gets != oldUsername){
        				$.ajax({
        					url:"../checkUsername",
        					data:{param:gets},
        					async:false,
        					success:function(result){
        						if(result != 'y'){
        							flag = result;
        						}
        					}
        				});
        			}
        			return flag;
        		}
        	}
        });
     
     });     
</script>
</head>
<body>
 
<div id="header">
<img src="resource/images/logo.png" tppabs="http://demo.mycodes.net/houtai/isoakJavaDemoSystem/images/logo.png" alt="logo" class="left"/>
<a href="logout">[退出]</a>
</div>
 
 
<div id="navi">
<ul id="menu">
<li><a href="<%=request.getContextPath() %>/jsp/index.jsp"  class="index_off"></a></li>
<c:if test="${sessionScope.isCharge!='1' }">
    <li><a href="<%=request.getContextPath() %>/emps" class="emp_on"></a></li>
</c:if>
<li><a href="<%=request.getContextPath() %>/newss"  class="news_off"></a></li>
<li><a href="<%=request.getContextPath() %>/categories" class="category_off"></a></li>
<c:if test="${sessionScope.isCharge=='2' }">
	<li><a href="<%=request.getContextPath() %>/depts"  class="dept_off"></a></li>
</c:if>
</ul>
</div>
<div id="main">
<form id="mForm" action="../emp" method="post" class="main_form">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="id" value="${emp.id }" />
<div class="text_info clearfix"><span>姓名：</span></div>
<div class="input_info">
<input type="text" name="name" value="${emp.name }" datatype="s2-30"/>
<span class="required">*</span>
</div>
<div class="text_info clearfix"><span>用户名：</span></div>
<div class="input_info">
<input type="text" name="username" value="${emp.username }" datatype="s3-16,username" />
<span class="required">*</span>
</div>
<div class="text_info clearfix"><span>出生日期：</span></div>
<div class="input_info">
<input type="date" name="birthday" value="${emp.birthday }" datatype="*" class="width200"/>
<span class="required">*</span>
</div>
<div class="text_info clearfix"><span>入职时间：</span></div>
<div class="input_info">
<input type="date" name="startDate" value="${emp.startDate }" datatype="*" class="width200"/>
<span class="required">*</span>
</div>
<div class="text_info clearfix"><span>部门：</span></div>
<div class="input_info">
<select id="deptName" name="deptId" datetype="*">
	<option value="">请选择</option>
</select>
<span class="required">*</span>
</div>
<div class="text_info clearfix"><span>角色：</span></div>
<div class="input_info">
<select id="isCharge" name="isCharge" datetype="*">
	<option value="">请选择</option>
	<option value="1">普通员工</option>
	<c:if test="${sessionScope.isCharge==2 }">
		<option value="0">部门主管</option>
		<option value="2">超级管理员</option>
	</c:if>
</select>
<span class="required">*</span>
</div>
<div class="button_info clearfix">
<input type="submit" value="保存" class="btn_save"/>
<input type="button" value="取消" class="btn_save" onclick="location.href='../emps'"/>
</div>
</form>
</div>
 
<div id="footer">
<span>[源自橡树的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
<br/>
<span>版权所有(C)橡树信息科技有限公司 </span>
</div>
</body>
</html>
