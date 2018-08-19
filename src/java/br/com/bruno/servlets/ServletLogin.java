package br.com.bruno.servlets;

import br.com.bruno.banco.UserController;
import br.com.bruno.modelos.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserController userCtr = new UserController();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        if (userCtr.checkUser(new Usuario(login, senha))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("logado", true);
            response.sendRedirect("index.jsp");
        } else {                   
            response.sendRedirect("login.jsp?erro=true");
        }
    }
    
}
