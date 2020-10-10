<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>橡树科技－JavaDemoSystem</title>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery.js"></script>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/layui/css/layui.css" />
        <script type="text/javascript" src="<%=request.getContextPath() %>/resource/layui/layui.js"></script>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/resource/styles/global_color.css" />
        
        <script language="javascript" type="text/javascript">
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //重置密码
            function resetPwd() {
                alert("请至少选择一条数据！");
                //document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function del(id) {
                var flag = confirm("确定删除该用户");
            	if (flag) {
            		$("#deleteForm").attr("action","emp/"+id);
            		$("#deleteForm").submit();
            	}
            }
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
            }
        </script>
        </head>
        <body>
        <form id="deleteForm" action="" method="post">
        	<input type="hidden" name="_method" value="delete"/>
        </form>
<div id="header"> <img src="resource/images/logo.png"  alt="logo" class="left"/> <a href="logout">[退出]</a> </div>
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
          <form id="mForm" action="emps" method="post">
    <div class="search_add">
    			<input type="hidden" name="currPage" id="currPage"/>
    			<input type="hidden" name="pageSize" id="pageSize"/>
              <div> 
              	姓名：<input type="text" name="name" value="${svo.name }" class="text_search width150" />
              </div>
              <div>部门名称：
		        <input type="text" name="deptName" value="${svo.deptName }" class="text_search width150"/>
		      </div>
      <div>
        <input type="submit" value="搜索" class="btn_search"/>
      </div>
              <input type="button" value="密码重置" class="btn_add" onClick="resetPwd();"/>
              <input type="button" value="增加" class="btn_add" onClick="location.href='emp'"/>
            </div>
    <div id="operate_result_info" class="operate_fail"> <img src="resource/images/close.png"  onClick="this.parentNode.style.display='none';"/> <span>删除失败！数据并发错误。</span> </div>
    <div id="data">
              <table id="datalist">
        <tr>
             	<th>姓名</th>
                <th>用户名</th>
                <th>密码</th>
                <th>出生日期</th>
                <th>入职日期</th>
                <th>部门</th>
                <th>角色</th>
                <th class="width200">操作</th>
        </tr>
        <c:forEach items="${pageUtil.list}" var="empVo">
	         <tr>
	           <td>${empVo.name }</td>
	           <td>${empVo.username }</td>
	           <td>${empVo.password }</td>
	           <td>${empVo.birthday }</td>
	           <td>${empVo.startDate }</td>
	           <td>${empVo.deptName }</td>
	           <td>
	           	  <c:if test="${empVo.isCharge==0 }">部门主管</c:if>
	           	  <c:if test="${empVo.isCharge==1 }">普通员工</c:if>
	           	  <c:if test="${empVo.isCharge==2 }">超级管理员</c:if>
	           </td>
	           <td class="td_modi">
	           <c:if test="${sessionScope.isCharge==2 }">
	           	<input type="button" value="修改" class="btn_modify" onclick="location.href='emp/${empVo.id }'"/>
	     		<input type="button" value="删除" class="btn_delete" onclick="del(${empVo.id})"/>
	           </c:if>
	     	   </td>
	         </tr>
         </c:forEach>
      </table>
            </div>
    <div id="page" style="text-align: center;"></div>
  </form>
        </div>
<div id="footer">
          <p>[源自橡树的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
          <p>版权所有(C)橡树信息科技有限公司 </p>
        </div>
</body>
<script>
layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  //完整功能
  laypage.render({
    elem: 'page'
    ,count: ${pageUtil.count}
    ,limit: ${pageUtil.pageSize}
    ,curr: ${pageUtil.currPage}
    ,limits: [5,10,15]
    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
    ,jump: function(obj, first){
	    //obj包含了当前分页的所有参数，比如：
	    var currPage = obj.curr //得到当前页，以便向服务端请求对应页的数据。
	    var pageSize = obj.limit //得到每页显示的条数
	    
	    //首次不执行
	    if(!first){
	        $("#currPage").val(currPage);
	       	$("#pageSize").val(pageSize);
	       	$("#mForm").submit();
	    }
	  }
  });
});
</script>

</html>
