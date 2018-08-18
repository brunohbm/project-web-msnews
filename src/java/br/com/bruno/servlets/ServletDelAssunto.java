/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.servlets;

import br.com.bruno.banco.AssuntoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hope
 */
public class ServletDelAssunto extends HttpServlet {

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            AssuntoController assuntoController = new AssuntoController();
            String id = request.getParameter("assunto");
            if (id != null && assuntoController.delAssunto(id)){        
                response.sendRedirect("index.jsp?mensagem=Deletado");
            } else {        
                response.sendRedirect("index.jsp?mensagem=Erro");                  
            }
    }   
}
