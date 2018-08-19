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
    
    private Connection connection;
    private PreparedStatement prepStatment;
    private Statement statement;
    private ResultSet resultSet;
    private AssuntoController assuntoCtr = new AssuntoController();
    
     private int getID() {
        try {
            setStatment("SELECT max(id) FROM noticia");
            resultSet.first();
            int id = resultSet.getInt("max(id)") + 1;  
            Conexao.FecharConexao();
            return id;         
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
            return 0;
        }        
    }
     
     public ArrayList<Noticia> getNoticiasByAssunto(String id) {
         if(id.equals("0")){
            return getNoticias(false);
         }
         
         ArrayList<Noticia> noticias = new ArrayList<>();
         try {
            setStatment("SELECT * FROM noticia WHERE id_assunto = " + id + " ORDER BY data_hora DESC");
            fillArray(noticias, resultSet);
            Conexao.FecharConexao();
         } catch (Exception ex) {
            System.out.println(ex);
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
            setStatment("SELECT * FROM noticia ORDER BY data_hora DESC " + s);
            fillArray(noticias, resultSet);
            Conexao.FecharConexao();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return noticias;
    }
     
     public Noticia getNoticia (String id) {
        Noticia noticia = new Noticia();
        try {
            setStatment("SELECT * FROM noticia WHERE id = " + id);
            resultSet.first();
            noticia.setId(resultSet.getInt("id"));
            noticia.setAssunto(assuntoCtr.getAssunto(resultSet.getInt("id_assunto")));
            noticia.setLegenda(resultSet.getString("legenda"));
            noticia.setResumo(resultSet.getString("resumo"));
            noticia.setDescricao(resultSet.getString("descricao"));
            noticia.setData(resultSet.getDate("data_hora"));
            noticia.setImagem(resultSet.getString("imagem"));               
            
            Conexao.FecharConexao();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
        return noticia;
    }
     
     public boolean saveNoticia (Noticia noticia) {
         try {
             setPreparedStatment(("INSERT INTO noticia ("
                     + "id,id_assunto,legenda,resumo,descricao,imagem) "
                     + "VALUES (?,?,?,?,?,?)"));
             prepStatment.setInt(1, getID());
             prepStatment.setInt(2, noticia.getAssunto().getId());
             prepStatment.setString(3, noticia.getLegenda());
             prepStatment.setString(4, noticia.getResumo());
             prepStatment.setString(5, noticia.getDescricao());
             prepStatment.setString(6, noticia.getImagem());  
             prepStatment.execute();
             Conexao.FecharConexao();
             return true;
         } catch (SQLException sqlEx) {
             System.out.println(sqlEx);
             return false;
         }
     }
     
      public void delNoticia(String id) {
        try {
            connection = Conexao.getConexao();
            statement = connection.createStatement();
            statement.execute("DELETE FROM noticia WHERE id = " + id);  
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
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
