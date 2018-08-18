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
 * @author Bruno
 */
public class AssuntoController {    
    
    public int getID() {
        try {
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT max(id) FROM assunto");
            rs.first();
            int id = rs.getInt("max(id)") + 1;  
            Conexao.FecharConexao();
            return id;         
        } catch (SQLException e) {
            return 0;
        }        
    }
    
    public void saveAssunto (String nome) {
        try {
           Connection con = Conexao.getConexao(); 
           PreparedStatement pst = con.prepareStatement("INSERT INTO assunto (id,nome) VALUES (?,?)");
           pst.setInt(1, getID());
           pst.setString(2, nome);
           pst.execute();            
           Conexao.FecharConexao();           
        } catch (SQLException e) {
            System.out.println(e);           
        }
    }
    
    public Assunto getAssunto (int id) {        
        Assunto assunto = new Assunto();
        try {            
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM assunto WHERE id = " + Integer.toString(id));            
            rs.first();            
            assunto.setId(rs.getInt("id"));
            assunto.setNome(rs.getString("nome"));               
            Conexao.FecharConexao();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return assunto;
    }
    
    public ArrayList<Assunto> getAssuntos () {
        ArrayList assuntos = new ArrayList<Assunto>();
        try {            
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM assunto");            
            while (rs.next()) {                
                Assunto a = new Assunto();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
               assuntos.add(a);
            }
            Conexao.FecharConexao();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return assuntos;
    }
    
    public Boolean delAssunto(String id) {
        try {
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            st.execute("DELETE FROM assunto WHERE id = " + id);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
    }
    
}
