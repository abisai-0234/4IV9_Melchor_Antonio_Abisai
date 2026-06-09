package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    
    private static final String URL = 
            "jdbc:mysql://localhost:3307/futbool?serverTimezone=America/Mexico_City";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "24032009";     
    public static Connection getConexion() throws Exception {
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver no encontrado");
        }
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }   
    
    public static boolean probarConexion() throws Exception {
        try {
            Connection con = getConexion();
            System.out.println("Conexion exitosa a la base de datos de futbool");
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return false;
        }
    }
}
