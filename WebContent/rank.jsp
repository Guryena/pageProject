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
				<td>순위</td>
				<td>후보번호</td>
				<td>성명</td>
				<td>소속정당</td>
				<td>지역구</td>
				<td>득표수</td>
				<td>득표율</td>
			</tr>
			<c:forEach items="${rank}" var="ranking">
				<tr>
					<td>${ranking.rank}</td>
					<td>${ranking.m_no}</td>
					<td>${ranking.m_name}</td>
					<td>${ranking.p_code}</td>
					<td>${ranking.m_city}</td>
					<td>${ranking.m_getVote}</td>
					<td>${ranking.m_per}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<footer><%@ include file="footer.jsp"%></footer>
</html>