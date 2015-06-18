package be.vdab.servlets.docenten;

import be.vdab.dao.DocentDAO;
import be.vdab.services.DocentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet(urlPatterns = "/docenten/zoeken.htm", name = "ZoekenServlet")
public class ZoekenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/docenten/zoeken.jsp";
    private final transient DocentService docentService = new DocentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getQueryString() != null) {
            try {
                request.setAttribute("docent",
                        docentService.read(Long.parseLong(request.getParameter("id"))));
            } catch (NumberFormatException ex) {
                request.setAttribute("fouten",
                        Collections.singletonMap("id", "tik een getal"));
            }
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
