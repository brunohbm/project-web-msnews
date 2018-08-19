/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.banco;

import br.com.bruno.modelos.Assunto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bruno Henrique Bosco Marques
 */
public class AssuntoController {    
    private Connection connection;
    private PreparedStatement prepStatment;
    private Statement statement;
    private ResultSet resultSet;
    
    private int getID() {
        try {
            setStatment("SELECT max(id) FROM assunto");
            resultSet.first();
            int id = resultSet.getInt("max(id)") + 1;  
            Conexao.FecharConexao();
            return id;         
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
            return 0;
        }        
    }
    
    public void saveAssunto (String nome) {
        try {            
            setPreparedStatment("INSERT INTO assunto (id,nome) VALUES (?,?)");
            prepStatment.setInt(1, getID());
            prepStatment.setString(2, nome);
            prepStatment.execute();            
            Conexao.FecharConexao();           
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);           
        }
    }
    
    public Assunto getAssunto (int id) {        
        Assunto assunto = new Assunto();
        try {            
            setStatment("SELECT * FROM assunto WHERE id = " + Integer.toString(id));
            resultSet.first();            
            assunto.setId(resultSet.getInt("id"));
            assunto.setNome(resultSet.getString("nome"));               
            Conexao.FecharConexao();            
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
        return assunto;
    }
    
    public ArrayList<Assunto> getAssuntos () {
        ArrayList assuntos = new ArrayList<Assunto>();
        try {            
            setStatment("SELECT * FROM assunto");
            
            while (resultSet.next()) {                
                Assunto a = new Assunto();
                a.setId(resultSet.getInt("id"));
                a.setNome(resultSet.getString("nome"));
                assuntos.add(a);
            }
            
            Conexao.FecharConexao();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
        return assuntos;
    }
    
    public Boolean delAssunto(String id) {
        try {
            connection = Conexao.getConexao();
            statement = connection.createStatement();
            statement.execute("DELETE FROM assunto WHERE id = " + id);                       
            return true;
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
            return false;
        }        
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
