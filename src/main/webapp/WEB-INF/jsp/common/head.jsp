<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<a href="${pageContext.request.contextPath}/index.jsp">
	<img src="${pageContext.request.contextPath}/resources/imgs/logo.png" class="img-responsive" alt="安徽大学">
</a>
<div class="search" style="float: right;padding-right: 35px;">
	<form action="${pageContext.request.contextPath}/article/search" method="post" class="navbar-form navbar-left" role="search" style="float: right;">
	    <input type="text"  name="key" class="form-control" placeholder="Search">
	  	<button type="submit" class="btn btn-default">
	  		<span class="glyphicon glyphicon-search"></span> 搜索
	  	</button>
	</form>
</div>
