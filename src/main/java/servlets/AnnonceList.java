package servlets;

import impl.AnnonceDAOImpl;
import models.Annonce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/annonce/liste")
public class AnnonceList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            AnnonceDAOImpl dao = new AnnonceDAOImpl();
            List<Annonce> annonces = dao.list();

            req.setAttribute("annonces", annonces);
            req.getRequestDispatcher("/AnnonceList.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Erreur : " + e.getMessage());
            req.getRequestDispatcher("/AnnonceList.jsp").forward(req, resp);
        }
    }
}
