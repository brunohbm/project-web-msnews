/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.servlets;

import br.com.bruno.banco.AssuntoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Bruno Henrique
 */
@WebServlet(name = "ServletSaveAssunto", urlPatterns = {"/ServletSaveAssunto"})
public class ServletSaveAssunto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            AssuntoController assuntoController = new AssuntoController();
            String nome = request.getParameter("nome");
            if ("".equals(nome)) {        
                response.sendRedirect("index.jsp?mensagem=Erro");                
            } else {        
                assuntoController.saveAssunto(nome);
                response.sendRedirect("index.jsp?mensagem=Salvo");
            }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }        
}
