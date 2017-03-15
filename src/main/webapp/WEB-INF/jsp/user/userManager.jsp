<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.3">
<title>个人信息</title>
<%@include file="../common/import.jsp"%>
</head>
<body>
	<div class="container" style="box-shadow: 0px 0px 1px #666;">
		<a href="${pageContext.request.contextPath}/index.jsp">
			<img src="${pageContext.request.contextPath}/resources/imgs/logo.png" class="img-responsive" alt="安徽大学">
		</a><br>
		<c:choose>
			<c:when test="${user.uid eq u.uid }">
				<div class="row">
						<div class="col-md-2">
							<div class="info">
								<img alt="headimg" src="<c:url value="${u.headimg }"/>" class="img-thumbnail">
								<center><h3>ID:${u.uid }</h3></center>
							</div>
						</div>
						<div class="col-md-8">
							<h3>
							昵称:${u.username }<br><br>
							<input type="password"  id="password" class="form-control" placeholder="请输入新密码">
							<button class="btn btn-primary" type="btn" onclick="updateUser()" style="float: right;">修改密码</button>
							</h3>
							 <div class="form-group">
							 	<form action="${pageContext.request.contextPath}/user/headimg/${u.uid }" 
							 		enctype="multipart/form-data" method="post">
								    <input type="file" id="imgUpload" name="file" accept="image/*"><br>
									<button class="btn btn-success" type="submit">修改头像</button>
							 	</form>
							 </div>
						</div>
				</div>
				
				<div class="myArticle">
					<c:choose>
						<c:when test="${empty userArticle }">
							<br><h3>未发表过任何帖子！</h3><br>
						</c:when>
						<c:otherwise>
							<h3>发表过的帖子</h3>
							<table class="table table-hover">
								<c:forEach var="ua" items="${userArticle }">
								  <tr>
								  	<td>
									  	<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
									  	<a href="${pageContext.request.contextPath}/article/details/${ua.aid }" target="_blank">
									  		<c:out value="${ua.title }"></c:out>
									  	</a>
									  	<div style="float: right;">
										  	<fmt:formatDate value="${ua.date }" pattern="yyyy/MM/dd HH:mm:ss" />
										  	<button type="button" class="btn btn-danger" onclick="deleteArticle(${ua.aid })">删除</button>
									  	</div>
									</td>
								  </tr>
								</c:forEach>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
			</c:when>
			<c:when test="${empty user }">
				<center>
					<br><br><h3>请登录后在查询！</h3><br><br><br>
				</center>
			</c:when>
			<c:otherwise>
				<center>
					<br><br><h3>仅能修改个人信息！</h3><br><br><br>
				</center>
			</c:otherwise>
		</c:choose>
	</div>
<%@include file="../common/foot.jsp"%>
<script type="text/javascript">
	/*删除帖子*/
	function deleteArticle(aid){
		$.get("${pageContext.request.contextPath}/article/delete/"+aid,function(data){
			alert(data.data);
		},"json");
		location.href = "${pageContext.request.contextPath}/user/manager/${u.uid }"
	}
	/*更新用户资料*/
	function updateUser(){
		var url = "${pageContext.request.contextPath}/user/update/${u.uid }";
		var params = {
			password : $('#password').val()
		};
		$.post(url, params, function(data) {
			alert(data.data);
		}, "json");
	}
</script>
</body>
</html>
