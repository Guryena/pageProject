function fn_submit(){
		var f = document.voteform;	

		var v_name = f.v_name.value;
		if(v_name == ""){
			alert("성명을 입력해주세요.");
			f.v_name.focus();
			return false;
		}
		
		
		var v_jumin = f.v_jumin.value;
		if(v_jumin == ""){
			alert("주민번호를 입력해주세요.");
			f.v_jumin.focus();
			return false;
		}

		if(f.m_no.value == ""){
			alert("후보번호를 선택해주세요.");
			f.m_no.focus();
			return false;
		}
		
		if(f.v_time.value == ""){
			alert("투표시간을 선택해주세요.");
			f.v_time.focus();
			return false;
		}

		if(f.v_area.value == ""){
			alert("투표장소를 선택해주세요.");
			f.v_area.focus();
			return false;
		}
		
		if(f.v_confirm.checked == "default"){
			alert("유권자확인을 선택해주세요.");
			return false;
		}
		f.submit();
	}


function fn_onload(){
	document.voteform.v_jumin.focus();
	document.voteform.onload();
}

function votelistPage(){
	window.location.href = 'VoteList.do'
}