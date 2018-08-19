package br.com.bruno.banco;

import br.com.bruno.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */

public class UserController {
    
    private Connection connection;
    private PreparedStatement prepStatment;
    private Statement statement;
    private ResultSet resultSet;
    
    public int getID() {
        try {
            setStatment("SELECT max(id) FROM usuario");
            resultSet.first();
            int id = resultSet.getInt("max(id)") + 1;  
            Conexao.FecharConexao();
            return id;         
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
            return 0;
        }        
    }

    public boolean checkUser(Usuario user) {        
        try {
            setStatment("SELECT * FROM usuario WHERE login = '" + user.getLogin() + "' AND senha = '" + user.getSenha() + "'");
            if(resultSet.first()) {
                Conexao.FecharConexao();
                return true;
            }            
        } catch (SQLException sqlEX) {            
            System.out.println(sqlEX);
        }
        return false;
    }
    
    public boolean saveUser(Usuario user){
        try {
            setPreparedStatment("INSERT INTO usuario (id, login, senha) VALUES (?,?,?)");
            prepStatment.setInt(1, getID());
            prepStatment.setString(2, user.getLogin());
            prepStatment.setString(3, user.getSenha());
            prepStatment.execute();
            Conexao.FecharConexao();
            return true;
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
            return false;
        }        
    }
    
    public boolean deleteUser(String id){        
        try {
            connection = Conexao.getConexao();
            statement = connection.createStatement();
            statement.execute("DELETE FROM usuario WHERE id = "+ id);  
            Conexao.FecharConexao();
            return true;
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
            return false;
        }                
    }
    
    public ArrayList<Usuario> getUsers(){
      ArrayList<Usuario> users = new ArrayList<>();
        try {
            setStatment("SELECT * FROM usuario");
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setSenha(resultSet.getString("senha"));
                users.add(user);
            }
            Conexao.FecharConexao();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
      return users;
    }
    
    private void setStatment(String query){
       try {
            connection = Conexao.getConexao();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
    }
    
    private void setPreparedStatment(String prepareSQL){
        try {
            connection = Conexao.getConexao(); 
            prepStatment = connection.prepareStatement(prepareSQL);
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
    }
}
