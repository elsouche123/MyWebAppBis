package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addAnnonce")
public class AnnonceAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/AnnonceAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String adress = req.getParameter("adress");
        String mail = req.getParameter("mail");

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Annonce enregistrée !</h1>");
        resp.getWriter().println("<p>Titre : " + title + "</p>");
        resp.getWriter().println("<p>Description : " + description + "</p>");
        resp.getWriter().println("<p>Adresse : " + adress + "</p>");
        resp.getWriter().println("<p>Email : " + mail + "</p>");
    }
}
