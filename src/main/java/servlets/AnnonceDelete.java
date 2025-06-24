package servlets;

import dao.AnnonceDAO;
import models.Annonce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/annonce/delete")
public class AnnonceDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idStr = req.getParameter("id");
            if (idStr == null || idStr.isEmpty()) {
                resp.sendRedirect(req.getContextPath() + "/annonce/liste");
                return;
            }

            int id = Integer.parseInt(idStr);
            AnnonceDAO dao = new AnnonceDAO();
            Annonce annonce = dao.find(id);

            if (annonce != null) {
                boolean success = dao.delete(annonce);
                if (success) {
                    req.getSession().setAttribute("message", "Suppression réussie");
                    resp.sendRedirect(req.getContextPath() + "/annonce/liste");
                } else {
                    req.setAttribute("error", "Erreur lors de la suppression !");
                    resp.sendRedirect(req.getContextPath() + "/annonce/liste?error=Erreur suppression");
                }
            } else {
                req.setAttribute("error", "Annonce introuvable !");
                resp.sendRedirect(req.getContextPath() + "/annonce/liste?error=Erreur suppression");
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Erreur : " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/annonce/liste?error=Erreur suppression");
        }
    }

}
