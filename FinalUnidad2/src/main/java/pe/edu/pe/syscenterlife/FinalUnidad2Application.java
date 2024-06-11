package pe.edu.pe.syscenterlife;

import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class FinalUnidad2Application {

    public class Conexion {

        public static Connection getConexion() {
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/BD_JUEGO";
                String usr = "root";
                String psw = "";
                con = DriverManager.getConnection(url, usr, psw);
                System.out.println("Conexion exitosa!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return con;
        }

        public static void main(String[] args) {
            Conexion.getConexion();
        }
    }
}
