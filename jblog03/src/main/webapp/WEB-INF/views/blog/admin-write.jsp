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
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/blog/${authUserId}/admin/basic">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/${authUserId}/admin/category">카테고리</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/blog/${authUserId}/admin/write">글작성</a></li>
				</ul>
				
				<form action="${pageContext.request.contextPath}/blog/${authUserId}/admin/write" method="post">
			      	<table class="admin-cat-write">
			      		<tr>
			      			<th class="t">제목</th>
			      			<td>
				      			<select name="categoryNo">
				      				<c:forEach items="${ list }" var="vo" varStatus="idx">
				      					<option value="${ vo.no }">${ vo.name }</option>
				      				</c:forEach>
				      			</select>
				      			<input type="text" size="60" name="title">
				      		</td>
			      		</tr>
			      		<tr>
			      			<th class="t">내용</th>
			      			<td><textarea name="contents"></textarea></td>
			      		</tr>
			      		<tr>
			      			<th>&nbsp;</th>
			      			<td class="s"><input type="submit" value="포스트하기"></td>
			      		</tr>
			      	</table>
				</form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/blog/footer.jsp"></c:import>
	</div>
</body>
</html>