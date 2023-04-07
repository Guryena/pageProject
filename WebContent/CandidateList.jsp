<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VMS</title>
<%@ include file="topmenu.jsp"%>
<link rel="stylesheet" href="vote_style.css?ver=1">
</head>
<body>
	<div class="table">
		<table width="800" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>후보번호</td>
				<td>성명</td>
				<td>소속정당</td>
				<td>학력</td>
				<td>주민번호</td>
				<td>지역구</td>
				<td>대표번호</td>
			</tr>
			<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.m_no}</td>
					<td>${member.m_name}</td>
					<td>${member.p_code}</td>
					<td>${member.p_school}</td>
					<td>${member.m_jumin}</td>
					<td>${member.m_city}</td>
					<td>${member.phone}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<footer><%@ include file="footer.jsp"%></footer>
</html>