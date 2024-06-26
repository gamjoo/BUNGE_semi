package common.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import common.action.Action;
import common.action.ActionForward;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class mycommlistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, NamingException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String m_id= (String)session.getAttribute("m_id");
		
		if(m_id != null) {

			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("mypage/commlist.jsp");
			
			return forward;

		} else {
			response.setContentType("text/html; charset=utf-8");
			String message = "로그인 후 이용 가능합니다.";
			out.print("<script>");
			out.print("alert('" + message + "');");
			out.print("location.href='login.com';");
			out.print("</script>");
			out.close();
			
		}
		return null;
	}
}
