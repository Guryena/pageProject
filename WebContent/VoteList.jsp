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
		<table width="1000" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>주민번호</td>
				<td>이름</td>
				<td>생년월일</td>
				<td>성별</td>
				<td>나이</td>
				<td>투표번호</td>
				<td>투표시간</td>
				<td>투표장소</td>
				<td>유권확인</td>
			</tr>
			<c:forEach items="${voteList}" var="vote">
				<tr>
					<td>${vote.v_jumin}</td>
					<td>${vote.v_name}</td>
					<td>${vote.v_birth}</td>
					<td>${vote.v_age}</td>
					<td>${vote.v_gender}</td>
					<td>${vote.m_no}</td>
					<td>${vote.v_time}</td>
					<td>${vote.v_area}</td>
					<td>${vote.v_confirm}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<footer><%@ include file="footer.jsp"%></footer>
</html>