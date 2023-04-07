package project.page.vote.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.page.vote.command.VoteCommand;
import project.page.vote.command.VoteDoCommand;
import project.page.vote.command.VoteListCommand;
import project.page.vote.command.CandidateListCommand;
import project.page.vote.command.RankingCommand;

/**
 * Servlet implementation class PageController
 */
@WebServlet("*.do")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()...");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		VoteCommand command = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		System.out.println("uri : " + uri);
		System.out.println("contextPath: " + contextPath);
		System.out.println("com : " + com);
		
		if (com.equals("/CandidateList.do")) {
			command = new CandidateListCommand();
			command.execute(request, response);
			viewPage = "/CandidateList.jsp";
		}
		else if(com.equals("/VoteList.do")) {
			command = new VoteListCommand();
			command.execute(request, response);
			viewPage = "/VoteList.jsp";
		}
		else if(com.equals("/rank.do")) {
			command = new RankingCommand();
			command.execute(request, response);
			viewPage = "/rank.jsp";
		}
		
		else if (com.equals("/Vote.do")) {
			viewPage = "/Vote.jsp";
		}
		
		else if(com.equals("/VoteDo.do")) {
			command = new VoteDoCommand();
			command.execute(request, response);
			
			viewPage = "/VoteList.do";
		}
		else if(com.equals("/Home.do")) {
			viewPage = "/home_test.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	
		
	}

}
