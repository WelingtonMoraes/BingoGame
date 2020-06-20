/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author welin
 */
public class Login {
    public static Connection getConexao(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/game","root","usbw");
            System.out.println("conectado com sucesso");
        }catch(SQLException e){
            System.err.println("erro na conexao");
        }
        return conn;
    }
    
    public void login(){
        Login.getConexao();
    }
}