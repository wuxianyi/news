<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>一元科技－JavaDemoSystem</title>
<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/styles/global.css"/>
<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/styles/global_color.css"/>
<script type="text/javascript" src="resource/js/jquery.js"></script>
</head>
<body class="index">
<div id="index_navi">
  <ul id="menu">
    <li><a href="<%=request.getContextPath() %>/jsp/index.jsp"  class="index_off"></a></li>
    <c:if test="${sessionScope.isCharge!='1' }">
    	<li><a href="<%=request.getContextPath() %>/emps" class="emp_off"></a></li>
    </c:if>
	<li><a href="<%=request.getContextPath() %>/newss"  class="news_off"></a></li>
	<li><a href="<%=request.getContextPath() %>/categories" class="category_off"></a></li>
	<c:if test="${sessionScope.isCharge=='2' }">
		<li><a href="<%=request.getContextPath() %>/depts"  class="dept_off"></a></li>
	</c:if>
  </ul>
</div>
</body>
</html>