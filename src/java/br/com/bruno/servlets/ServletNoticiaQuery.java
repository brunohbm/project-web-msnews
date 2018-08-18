/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.servlets;

import br.com.bruno.banco.NoticiaController;
import br.com.bruno.modelos.Noticia;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hope
 */
public class ServletNoticiaQuery extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        NoticiaController nc = new NoticiaController();
        Noticia noticia = nc.getNoticia(id);
        request.setAttribute("noticia", noticia);
        RequestDispatcher rd = request.getRequestDispatcher("news.jsp");
        rd.forward(request, response);
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
