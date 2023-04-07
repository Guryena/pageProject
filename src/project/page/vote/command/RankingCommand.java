package project.page.vote.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.vote.dao.RankingDAO;
import project.page.vote.dto.RankingDTO;

public class RankingCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		RankingDAO dao = new RankingDAO();
		
		
		List<RankingDTO> vos = dao.rankingList();
		
		request.setAttribute("rank", vos);

	}

}
