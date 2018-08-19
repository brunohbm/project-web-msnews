package br.com.bruno.servlets;

import br.com.bruno.banco.NoticiaController;
import br.com.bruno.modelos.Noticia;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletGetAssunto extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        NoticiaController noticiaCtr = new NoticiaController();
        ArrayList<Noticia> noticias = noticiaCtr.getNoticiasByAssunto(id);
        request.setAttribute("noticias", noticias);
        RequestDispatcher rd = request.getRequestDispatcher("query.jsp");
        rd.forward(request, response);
    }
    
}
