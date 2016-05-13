/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.google.gson.JsonElement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class DAO {
    public Connection conexion;
    public final static String userDb = "root";
    public final static String passDb = "pepo1606";
    
    
    //Conectar a la Base de datos
    public void conectar() throws SQLException,ClassNotFoundException{
         Class.forName("com.mysql.jdbc.Driver");
         conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/fhir",userDb, passDb);
    }
    //Desconectar a la Base de datos
    public void desconectar() throws SQLException, ClassNotFoundException{
        conexion.close();
    }
    
  
    public boolean isIdentifierExist(String user) throws SQLException{
        String sql = "SELECT identifier FROM patient WHERE identifier->'$.identifier[0].value'='"+user+"'";
        //String sql = "SELECT * FROM usuarios WHERE usuario='"+user+"' OR documento='"+user+"' AND password='"+password+"'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();            
        return rs.next();
    }  
    
    
    
    //Metodo para consultar si un email y contraseñan pertenecen a una cuenta registrada
    public boolean isAcountExists(String email, String password) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE email='"+email+"' AND password='"+password+"'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
    }
    
    //Metodo para consultar si el email recibido ya esta registrado
    public boolean isEmailRegistered(String email) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE email='"+email+"'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
 
        return rs.next();
    }
    
    //Metodo para registrar una cuenta
    public void registerUser(String email, String password, String name) throws SQLException{
        String sql = "INSERT INTO `usuarios`(`email`,`password`,`name`) VALUES ('"+email+"','"+password+"','"+name+"')";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.executeUpdate();
    }
    
    public void registerPacient(JsonElement identifier, JsonElement name, JsonElement telecom, String gender, String birthDate, JsonElement address, JsonElement maritalStatus, JsonElement contact, JsonElement communication, String managingOrganization, String password) throws SQLException {
        String sql = "INSERT INTO 'patient'('name','telecom','gender','birthDate','address','maritalStatus','contact','communication','managingOrganization')"+
                "VALUES ('"+name+"','"+telecom+"','"+gender+"','"+birthDate+"','"+address+"','"+maritalStatus+"','"+contact+"','"+communication+"','"+managingOrganization+"')";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void registerPacient(JsonElement identifier, JsonElement name, JsonElement telecom, String gender, String birthDate, JsonElement address, JsonElement maritalStatus, JsonElement contact, JsonElement communication, String managingOrganization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
