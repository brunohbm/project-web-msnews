/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.servlets;

import br.com.bruno.banco.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hope
 */
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UserController userController = new UserController();
            String id = request.getParameter("user");
            if (userController.deleteUser(id)) {                        
                response.sendRedirect("index.jsp?erro=Deletado");
            } else {        
                response.sendRedirect("index.jsp?erro=Erro");                  
            }
    }
}
