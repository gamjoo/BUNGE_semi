package common.join;

import java.io.IOException;

import common.action.Action;
import common.action.ActionForward;
import common.db.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class emailcheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();
		int result = dao.emailcheck(request.getParameter("m_email"));
		response.getWriter().print(result);
		System.out.println(result);
		return null;
	}

}
