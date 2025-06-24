package servlets;

import dao.AnnonceDAO;
import models.Annonce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/annonce/add")
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

        if (title == null || title.isEmpty() ||
                description == null || description.isEmpty() ||
                adress == null || adress.isEmpty() ||
                mail == null || mail.isEmpty()) {

            req.setAttribute("error", "Tous les champs sont obligatoires !");
            req.setAttribute("title", title);
            req.setAttribute("description", description);
            req.setAttribute("adress", adress);
            req.setAttribute("mail", mail);
            req.getRequestDispatcher("/AnnonceAdd.jsp").forward(req, resp);
            return;
        }

        Annonce annonce = new Annonce(
                title,
                description,
                adress,
                mail,
                new Timestamp(System.currentTimeMillis())
        );

        try {
            AnnonceDAO dao = new AnnonceDAO();
            boolean success = dao.create(annonce);

            if (success) {
                req.getSession().setAttribute("message", "Annonce ajoutée avec succès !");
                resp.sendRedirect(req.getContextPath() + "/annonce/liste");
            } else {
                req.setAttribute("error", "Erreur lors de l'enregistrement !");
                req.setAttribute("title", title);
                req.setAttribute("description", description);
                req.setAttribute("adress", adress);
                req.setAttribute("mail", mail);
                req.getRequestDispatcher("/AnnonceAdd.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Exception : " + e.getMessage());
            req.setAttribute("title", title);
            req.setAttribute("description", description);
            req.setAttribute("adress", adress);
            req.setAttribute("mail", mail);
            req.getRequestDispatcher("/AnnonceAdd.jsp").forward(req, resp);
        }
    }
}
