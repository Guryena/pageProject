package project.page.vote.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface VoteCommand {
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
