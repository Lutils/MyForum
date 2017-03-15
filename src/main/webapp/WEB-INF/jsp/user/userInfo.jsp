<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.3">
<title>TA的信息</title>
<%@include file="../common/import.jsp"%>
</head>
<body>
	<div class="container" style="box-shadow: 0px 0px 1px #666;">
		<a href="${pageContext.request.contextPath}/index.jsp">
			<img src="${pageContext.request.contextPath}/resources/imgs/logo.png" class="img-responsive" alt="安徽大学">
		</a><br>
		<div class="row">
				<div class="col-md-2">
					<div class="info">
						<img alt="headimg" src="<c:url value="${uInfo.headimg }"/>" class="img-thumbnail">
					</div>
				</div>
				<div class="col-md-8">
					<h3>ID:${uInfo.uid }<br>昵称:${uInfo.username }
				</div>
		</div>
	<%@include file="../common/foot.jsp"%>
	</div>
</body>
</html>
