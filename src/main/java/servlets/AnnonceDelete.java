package servlets;

import impl.AnnonceDAOImpl;
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
            AnnonceDAOImpl dao = new AnnonceDAOImpl();
            Annonce annonce = dao.find(id);

            if (annonce != null) {
                boolean success = dao.delete(annonce);
                if (success) {
                    resp.sendRedirect(req.getContextPath() + "/annonce/liste?message=Suppression réussie");
                } else {
                    req.setAttribute("error", "Erreur lors de la suppression !");
                    req.getRequestDispatcher("/AnnonceList.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("error", "Annonce introuvable !");
                req.getRequestDispatcher("/AnnonceList.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Erreur : " + e.getMessage());
            req.getRequestDispatcher("/AnnonceList.jsp").forward(req, resp);
        }
    }

}
