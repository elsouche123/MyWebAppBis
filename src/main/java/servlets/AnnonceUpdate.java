package servlets;

import dao.AnnonceDAO;
import models.Annonce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/annonce/update")
public class AnnonceUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idStr = req.getParameter("id");
            if (idStr == null || idStr.isEmpty()) {
                req.getSession().setAttribute("error", "Identifiant manquant !");
                resp.sendRedirect(req.getContextPath() + "/annonce/liste");
                return;
            }

            int id = Integer.parseInt(idStr);
            AnnonceDAO dao = new AnnonceDAO();
            Annonce annonce = dao.find(id);

            if (annonce != null) {
                req.setAttribute("annonce", annonce);
                req.getRequestDispatcher("/AnnonceUpdate.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("error", "Annonce introuvable !");
                resp.sendRedirect(req.getContextPath() + "/annonce/liste");
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("error", "Erreur : " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/annonce/liste");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String adress = req.getParameter("adress");
            String mail = req.getParameter("mail");

            Annonce annonce = new Annonce(id, title, description, adress, mail, new java.sql.Timestamp(System.currentTimeMillis()));

            if (title == null || title.isEmpty() ||
                    description == null || description.isEmpty() ||
                    adress == null || adress.isEmpty() ||
                    mail == null || mail.isEmpty()) {

                req.setAttribute("error", "Tous les champs sont obligatoires !");
                req.setAttribute("annonce", annonce);
                req.getRequestDispatcher("/AnnonceUpdate.jsp").forward(req, resp);
                return;
            }

            AnnonceDAO dao = new AnnonceDAO();

            if (dao.update(annonce)) {
                req.getSession().setAttribute("message", "Annonce mise à jour avec succès !");
                resp.sendRedirect(req.getContextPath() + "/annonce/liste");
            } else {
                req.setAttribute("error", "Erreur lors de la mise à jour !");
                req.setAttribute("annonce", annonce);
                req.getRequestDispatcher("/AnnonceUpdate.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Erreur : " + e.getMessage());
            req.getRequestDispatcher("/AnnonceUpdate.jsp").forward(req, resp);
        }
    }
}

