package servlets;

import dao.AnnonceDAO;
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
            AnnonceDAO dao = new AnnonceDAO();
            List<Annonce> annonces = dao.list();
            req.setAttribute("annonces", annonces);

            if (req.getSession().getAttribute("message") != null) {
                req.setAttribute("message", req.getSession().getAttribute("message"));
                req.getSession().removeAttribute("message");
            }

            if (req.getSession().getAttribute("error") != null) {
                req.setAttribute("error", req.getSession().getAttribute("error"));
                req.getSession().removeAttribute("error");
            }

            req.getRequestDispatcher("/AnnonceList.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Erreur : " + e.getMessage());
            req.getRequestDispatcher("/AnnonceList.jsp").forward(req, resp);
        }
    }
}
