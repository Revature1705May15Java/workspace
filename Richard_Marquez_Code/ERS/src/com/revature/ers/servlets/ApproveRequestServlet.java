package com.revature.ers.servlets;

        import com.revature.ers.pojos.User;
        import com.revature.ers.service.Service;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;

        import static com.revature.ers.servlets.LoginServlet.authenticateManager;

public class ApproveRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 8L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authenticateManager(request, response)) {
            response.sendRedirect("/Login");
            return;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String note = request.getParameter("note");

        request.setAttribute("pageTitle", "Manager Home");

        int reqId = Integer.parseInt(request.getParameter("requestId"));
        if (Service.getInstance().approveRequest(reqId, user, note)) {
            request.setAttribute("successMsg", "You have successfully <strong>approved</strong> the request. An email has been sent to the user.");
        } else {
            request.setAttribute("errorMsg", "You were unable to approve this request.");
        }

        request.getRequestDispatcher("/Home").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
