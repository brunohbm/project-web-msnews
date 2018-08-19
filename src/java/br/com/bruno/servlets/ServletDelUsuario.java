package br.com.bruno.servlets;

import br.com.bruno.banco.UserController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDelUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UserController userCtr = new UserController();
            String id = request.getParameter("user");
            if (userCtr.deleteUser(id)) {                        
                response.sendRedirect("index.jsp?erro=Deletado com sucesso");
            } else {        
                response.sendRedirect("index.jsp?erro=Erro ao deletar");                  
            }
    }
}
