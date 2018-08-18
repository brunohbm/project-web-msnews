/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bruno.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bruno Henrique
 * 17/07/2018
 */

public class Conexao {       
    
    public Conexao(){}
    
    public static java.sql.Connection getConexao() {
        Connection conexao = null;
        
        final String driverName = "com.mysql.jdbc.Driver";
        final String serverName = "localhost";
        final String dbName = "mysql";
        final String url = "jdbc:mysql://" + serverName + "/" + dbName;
        final String username = "root";
        final String password = "";
        
        try {
            Class.forName(driverName);
            conexao = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado nego");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar ao banco");
        } finally {
            return conexao;
        }                 
    }
    
    public static boolean FecharConexao () {
        try {
            getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
