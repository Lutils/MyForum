<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.3">
<title>帖子内容</title>
<%@include file="../common/import.jsp"%>
</head>
<body>
	<div class="container" style="box-shadow: 0px 0px 1px #666;">
		<img src="${pageContext.request.contextPath}/resources/imgs/logo.png"
			class="img-responsive" alt="安徽大学">
		<div class="page-header">
			<h4>${article.title }</h4>
		</div>
		<div class="row">
			<div class="panel panel-default" style="border-radius : 0;">
				<div class="panel-body">
					<div class="col-md-2">
						<center>
							<a href="${pageContext.request.contextPath}/user/info/${author.uid}" target="_blank">
							<img alt="headimg" style="width: 70%;" src="<c:url value="${author.headimg }"/>" class="img-thumbnail"></a>
							<br><br>楼主 :<a href="${pageContext.request.contextPath}/user/info/${author.uid}" target="_blank">${author.username }</a>
						</center>
					</div>
					<div class="col-md-8">
						<c:out value="${article.content }" escapeXml="false"></c:out>
					</div>
				</div>
				<h6 style="float: right;">
					发布时间:
					<fmt:formatDate value="${article.date }"
						pattern="MM/dd HH:mm:ss" />
				</h6>
			</div>
		</div>
		
		<h5>共${fn:length(commentList) }条评论</h5>
		
		<%-- 评论列表 --%>
		<c:forEach var="c" items="${commentList }" varStatus="st">
			<div class="row">
				<div class="panel panel-default" style="border-radius : 0;">
					<div class="panel-body">
						<div class="col-md-2">
							<center>
								<a href="${pageContext.request.contextPath}/user/info/${c.uid}" target="_blank">
									<img alt="headimg" style="width: 70%;" src="<c:url value="${c.uimg }"/>" class="img-thumbnail"> 
								</a>
								<br><br>
								<c:if test="${c.uid eq article.uid }">楼主:</c:if>
								<a href="${pageContext.request.contextPath}/user/info/${c.uid}" target="_blank">${c.cuser }</a>
							</center>
						</div>
						<div class="col-md-8">
							<c:out value="${c.content }" escapeXml="false"></c:out>
						</div>
					</div>
					<h6 style="float: right;">
						<%-- ${fn:length(commentList)-st.index }楼 --%>
						${st.index+1 }楼
						回复时间:
						<fmt:formatDate value="${c.date }"
							pattern="MM/dd HH:mm:ss" />
					</h6>
				</div>
			</div>
		</c:forEach>
		
		<%-- 评论框 --%>
		<c:choose>
			<c:when test="${!empty user }">
				<div style="padding-top: 300px;">
					<div id="content" style="height:240px;"></div>
					<br>
					<button type="button" class="btn btn-primary" id="addbtn"
						onclick="reply()" style="float: right;">回复</button>
				</div>
			</c:when>
			<c:otherwise>
				<center>
					<h3>登陆后才可进行回帖！</h3>
				</center>
			</c:otherwise>
		</c:choose>
	<%@include file="../common/foot.jsp"%>
	<%@include file="../common/editor.jsp"%>
	</div>
<script type="text/javascript">
	/*回帖*/
	function reply(){
		var url = "${pageContext.request.contextPath}/comment/add";
		var params = {
			content : editor.$txt.html(),
			aid : '${article.aid }',
			uid : '${user.uid }'
		};
		$.post(url, params, function(data) {
			alert(data.data);
			location.href = "${pageContext.request.contextPath}/article/details/${article.aid }";
		}, "json");
	}
</script>
</body>
</html>
