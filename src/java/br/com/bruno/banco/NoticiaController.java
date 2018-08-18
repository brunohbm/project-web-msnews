/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.banco;

import br.com.bruno.modelos.Noticia;
import br.com.bruno.banco.AssuntoController;
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
public class NoticiaController {
    
     public int getID() {
        try {
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT max(id) FROM noticia");
            rs.first();
            int id = rs.getInt("max(id)") + 1;  
            Conexao.FecharConexao();
            return id;         
        } catch (SQLException e) {
            return 0;
        }        
    }
     
     public ArrayList<Noticia> getNoticiasByAssunto(String id) {
         if(id.equals("0")){
             return getNoticias(false);
         }
         ArrayList<Noticia> noticias = new ArrayList<>();
         try {
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM noticia WHERE id_assunto = " + id + " ORDER BY data_hora DESC");
             fillArray(noticias, rs);
             Conexao.FecharConexao();
         } catch (SQLException SQLex) {
             System.out.println(SQLex);
         }
         return noticias;
     }          
     
     public ArrayList<Noticia> getNoticias (boolean order) {
         ArrayList noticias = new ArrayList<Noticia>();
         String s = "";
         if (order) {
             s = "LIMIT 12";
         }                
        try {           
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM noticia ORDER BY data_hora DESC " + s);            
            fillArray(noticias, rs);
            Conexao.FecharConexao();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return noticias;
    }
     
     public Noticia getNoticia (String id) {
        Noticia n = new Noticia();
        try {
            AssuntoController assCtr = new AssuntoController();
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM noticia WHERE id = " + id);                         
                rs.first();
                n.setId(rs.getInt("id"));
                n.setAssunto(assCtr.getAssunto(rs.getInt("id_assunto")));
                n.setLegenda(rs.getString("legenda"));
                n.setResumo(rs.getString("resumo"));
                n.setDescricao(rs.getString("descricao"));
                n.setData(rs.getDate("data_hora"));
                n.setImagem(rs.getString("imagem"));               
            
            Conexao.FecharConexao();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
     
     public boolean saveNoticia (Noticia noticia) {
         boolean test = false;
         try {
             Connection con = Conexao.getConexao();
             PreparedStatement pst = con.prepareStatement("INSERT INTO noticia ("
                     + "id,id_assunto,legenda,resumo,descricao,imagem) "
                     + "VALUES (?,?,?,?,?,?)");
             pst.setInt(1, getID());
             pst.setInt(2, noticia.getAssunto().getId());
             pst.setString(3, noticia.getLegenda());
             pst.setString(4, noticia.getResumo());
             pst.setString(5, noticia.getDescricao());
             pst.setString(6, noticia.getImagem());  
             pst.execute();
             Conexao.FecharConexao();
             test = true;
         } catch (SQLException e) {
             System.out.println(e);
         }
         
         return test;
     }
     
      public void delNoticia(String id) {
        try {
            Connection con = Conexao.getConexao();
            Statement st = con.createStatement();
            st.execute("DELETE FROM noticia WHERE id = " + id);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
      
      private void fillArray(ArrayList<Noticia> noticias, ResultSet rs) {
          AssuntoController assCtr = new AssuntoController();
          
          try {
              while (rs.next()) {                
               Noticia n = new Noticia();
               n.setId(rs.getInt("id"));
               n.setAssunto(assCtr.getAssunto(rs.getInt("id_assunto")));
               n.setLegenda(rs.getString("legenda"));
               n.setResumo(rs.getString("resumo"));
               n.setDescricao(rs.getString("descricao"));
               n.setData(rs.getDate("data_hora"));
               n.setImagem(rs.getString("imagem"));
               noticias.add(n);
            }
          } catch (SQLException SQLex) {
              System.out.println(SQLex);
          }
          
      }
    
}
