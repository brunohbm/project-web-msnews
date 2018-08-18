/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.servlets;

import br.com.bruno.banco.UserController;
import br.com.bruno.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hope
 */
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserController logContr = new UserController();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        if (logContr.checkUser(new Usuario(login, senha))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("logado", true);
            response.sendRedirect("index.jsp");
        } else {                   
            response.sendRedirect("login.jsp?erro=true");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
