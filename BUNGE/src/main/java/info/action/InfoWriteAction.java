package info.action;

import java.io.IOException;

import common.action.Action;
import common.action.ActionForward;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookcover = request.getParameter("bookcover");
		String booktitle = request.getParameter("booktitle");
		System.out.println("bookcover : " + bookcover);
		System.out.println("booktitle : " + booktitle);
		
		request.setAttribute("bookcover", bookcover);
		request.setAttribute("booktitle", booktitle);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("Infoboard/InfoWrite.jsp");
		return forward;
	}
}
