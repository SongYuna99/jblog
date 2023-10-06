<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/blog/header.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${ viewPost.title }</h4>
					<p>${ viewPost.contents }<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${ list }" var="vo">
						<li><a href="${pageContext.request.contextPath}/blog/${authUserId}/${vo.categoryNo}/${vo.no}">${ vo.title }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/blog/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/blog/footer.jsp"></c:import>
	</div>
</body>
</html>