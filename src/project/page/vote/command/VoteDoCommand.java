package project.page.vote.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.vote.dao.VoteDoDAO;

public class VoteDoCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String v_jumin = request.getParameter("v_jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String v_confirm = request.getParameter("v_confirm");
		
		VoteDoDAO dao = new VoteDoDAO();
		dao.voteDo(v_jumin, v_name, m_no, v_time, v_area, v_confirm);
		
	}
	
}
