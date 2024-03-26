package common;

import java.io.IOException;

import common.action.Action;
import common.action.ActionForward;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trade.chat.ChatListAction;

@WebServlet("/")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {

        String RequestURI = request.getRequestURI();
        System.out.println("RequestURI = " + RequestURI);

        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        String command = RequestURI.substring(contextPath.length());
        System.out.println("command = " + command);

        ActionForward forward = null;
        Action action = null;

        switch (command) {
            case "/trade/chat":
                action = new ChatListAction();
                break;
        } //switch (command)

        forward = action.execute(request, response);

        if (forward != null) {
            if (forward.isRedirect()) {
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        }//if (forward != null)
    } //doProcess

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doProcess(request, response);
    }
}
