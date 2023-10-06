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
					<li class="selected"><a href="${pageContext.request.contextPath}/blog/${authUserId}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/${authUserId}/admin/write">글작성</a></li>
				</ul>
				
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		<c:forEach items="${ list }" var="vo" varStatus="idx">
			      		<tr>
							<td>${ idx.count }</td>
							<td>${ vo.name }</td>
							<td>0</td>
							<td>${ vo.description }</td>
							<td><a href="${pageContext.request.contextPath}/blog/${authUserId}/admin/category/delete/${vo.no}">
								<img src="${pageContext.request.contextPath}/assets/images/delete.jpg">
							</a></td>
						</tr> 
		      		</c:forEach>  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      			<form name="cat-add" action="${pageContext.request.contextPath}/blog/${authUserId}/admin/category/add" method="post">	
			      	<table id="admin-cat-add">
			      		<tr>
			      			<th class="t">카테고리명</th>
			      			<td><input type="text" name="name"></td>
			      		</tr>
			      		<tr>
			      			<th class="t">설명</th>
			      			<td><input type="text" name="description"></td>
			      		</tr>
			      	</table> 
	      			<input type="submit" id="admin-cat-add-btn" value="카테고리 추가">  		      		
      			</form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/blog/footer.jsp"></c:import>
	</div>
</body>
</html>