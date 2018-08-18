package br.com.bruno.servlets;

import br.com.bruno.banco.UserController;
import br.com.bruno.modelos.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSaveServlet extends HttpServlet {
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String login = request.getParameter("login");
       String senha = request.getParameter("password");
       Usuario user = new Usuario(login, senha);
       UserController userCTR = new UserController();
       if (userCTR.saveUser(user)) {
           response.sendRedirect("index.jsp?erro=yes");
       } else {
           response.sendRedirect("index.jsp?erro=no");
       }
    }
}
