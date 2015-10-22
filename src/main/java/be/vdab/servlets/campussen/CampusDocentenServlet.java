package be.vdab.servlets.campussen;

import be.vdab.services.CampusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/campussen/docenten.htm", name = "CampusDocentenServlet")
public class CampusDocentenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/campussen/docenten.jsp";
    private final transient CampusService campusService = new CampusService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("campussen", campusService.findAll());
        String id = request.getParameter("id");
        if (id != null) {
            request.setAttribute("campus", campusService.read(Long.parseLong(id)));
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
