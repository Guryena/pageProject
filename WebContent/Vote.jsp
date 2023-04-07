<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VMS</title>

<%@ include file="topmenu.jsp"%>
<link rel="stylesheet" href="vote_style.css?ver=1">
<script src="vote_script.js"></script>

</head>
<body>
	<div class="table">
		<form name="voteform" action="VoteDo.do" method="post">
			<table width="600" cellpadding="0" cellspacing="0" border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="v_name" size="50"></td>
				</tr>
				<tr>
					<td>주민번호</td>
					<td><input type="number" name="v_jumin" size="50"> -를
						제외하고 입력하세요.</td>
				</tr>
				<tr>
					<td>투표번호</td>
					<td><select name="m_no">
							<option value="">투표번호</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
				</tr>
				<tr>
					<td>투표시간</td>
					<td><select name="v_time">
							<option value="">투표시간</option>
							<option value="0930">9:30</option>
							<option value="1330">13:30</option>
					</select></td>
				</tr>
				<tr>
					<td>투표장소</td>
					<td><select name="v_area">
							<option value="">투표시간</option>
							<option value="제1투표장">제1투표장</option>
							<option value="제2투표장">제2투표장</option>
					</select></td>
				</tr>
				<tr>
					<td>유권 확인</td>
					<td><input style="float: none" type="radio" name="v_confirm"
						value="Y">확인 (체크하지 않을시 미확인으로 입력됩니다.) <!-- <input style="float: none" type="radio" name="v_confirm" value="N">미확인 -->
					</td>
				</tr>
				<tr>
					<td colspan="2"><a href="VoteList.do"><button class="btn"
								type="submit" value="투표" onclick="fn_submit(); return false;">투표</button></a>
						&nbsp;&nbsp; <a href="CandidateList.do"><font color="black">후보자
								보기</font></a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<footer><%@ include file="footer.jsp"%></footer>
</html>