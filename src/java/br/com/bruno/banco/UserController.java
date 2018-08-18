/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.banco;

import br.com.bruno.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController {
    
    public int getID() {
        try {
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT max(id) FROM usuario");
            rs.first();
            int id = rs.getInt("max(id)") + 1;  
            Conexao.FecharConexao();
            return id;         
        } catch (SQLException e) {
            return 0;
        }        
    }

    public boolean checkUser(Usuario user) {        
        try {
            Connection con = Conexao.getConexao();
            Statement state = con.createStatement();            
            ResultSet rs = state.executeQuery("SELECT * FROM usuario WHERE login = '" + user.getLogin() + "' AND senha = '" + user.getSenha() + "'");            
            if(rs.first()) {
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
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (id, login, senha) VALUES (?,?,?)");
            ps.setInt(1, getID());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.execute();
            Conexao.FecharConexao();
            return true;
        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
            return false;
        }        
    }
    
    public boolean deleteUser(String id){        
        try {
            Connection con = Conexao.getConexao();
            Statement statment;
            statment = con.createStatement();
            statment.execute("DELETE FROM usuario WHERE id = "+ id);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }                
    }
    
    public ArrayList<Usuario> getUsers(){
      ArrayList<Usuario> users = new ArrayList<>();
        try {
            Connection connection = Conexao.getConexao();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario");            
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setSenha(resultSet.getString("senha"));
                users.add(user);
            }
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
      return users;
    }
    
}
