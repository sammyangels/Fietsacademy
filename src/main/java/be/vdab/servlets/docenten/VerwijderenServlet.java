package be.vdab.servlets.docenten;

import be.vdab.services.DocentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/docenten/verwijderen.htm", name = "VerwijderenServlet")
public class VerwijderenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String REDIRECT_URL = "%s/docenten/zoeken.htm";
    private final transient DocentService docentService = new DocentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        docentService.delete(Long.parseLong(request.getParameter("id")));
        response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
