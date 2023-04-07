package project.page.vote.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.vote.dao.VoteDAO;
import project.page.vote.dto.VoteDTO;

public class VoteListCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDAO dao = new VoteDAO();
		
		List<VoteDTO> vos = dao.voteList();
		
		request.setAttribute("voteList", vos);

	}

}
