package project.page.vote.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.vote.dao.MemberDAO;
import project.page.vote.dto.MemberDTO;

public class CandidateListCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		
		List<MemberDTO> vos = dao.memberList();
		
		request.setAttribute("members", vos);

	}

}
