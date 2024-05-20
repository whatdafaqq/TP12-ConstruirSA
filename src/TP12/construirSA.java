/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP12;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author Ramiro
 */
public class construirSA {
    public static void main(String[] args) {
      Connection conn = null;
        try {
            //carga de driver
            Class.forName("org.mariadb.jdbc.Driver");
            
            //conexion a la bd
        conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/trabajopractico_obrador", "root", "");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver "+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos "+ex.getMessage());
            
        }
        
        //ingreso empleados
        Empleado empleados[] = null;
        try {
            Empleado empleado1 = new Empleado(1, 11000111, "Ramiro", "Moran", 2, true);
            Empleado empleado2 = new Empleado(2, 37666666, "Jose", "Orio", 3, true);
            Empleado empleado3 = new Empleado(3, 40000444, "Eze", "Diaz", 4, true);
            empleados = new Empleado[]{empleado1, empleado2, empleado3};

            String insert = "INSERT INTO empleado(`id_empleado`, `dni`, `apellido`, `nombre`, `acceso`, `estado`) VALUES (?,?,?,?,?,?)";
            for (int i = 0; i < empleados.length; i++) {
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setInt(1, empleados[i].getId_empleado());
                ps.setLong(2, empleados[i].getDni());
                ps.setString(3, empleados[i].getApellido());
                ps.setString(4, empleados[i].getNombre());
                ps.setInt(5, empleados[i].getAcceso());
                ps.setBoolean(6, empleados[i].isEstado());
                int filas = ps.executeUpdate();
                if (filas > 0) {
                    System.out.println("Se ingreso el empleado");
                }
            }
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            if (errorCode != 1062) { // Ignorar empleado repetidos
                System.out.println("[Error " + errorCode + "] " + e.getMessage());
                e.printStackTrace();
            } else {
                System.out.println("[Empleado repetido] " + e.getMessage());
            }
        }
        
        //ingreso herrramientas
        Herramienta herramientas[] = null;
        try {
            Herramienta herramienta1 = new Herramienta(1, "Martillo", "carpintero", 7, true);
            Herramienta herramienta2 = new Herramienta(2, "Tenezas", "armador", 11, true);
            herramientas = new Herramienta[]{herramienta1, herramienta2};

            String insert = "INSERT INTO `herramienta`(`id_herramienta`, `nombre`, `descripcion`, `stock`, `estado`) VALUES (?,?,?,?,?)";
            for (int i = 0; i < herramientas.length; i++) {
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setInt(1, herramientas[i].getId_herramienta());
                ps.setString(2, herramientas[i].getNombre());
                ps.setString(3, herramientas[i].getDescripcion());
                ps.setInt(4, herramientas[i].getStock());
                ps.setBoolean(5, herramientas[i].isEstado());
                int filas = ps.executeUpdate();
                if (filas > 0) {
                    System.out.println("Se ingreso la herramienta");
                }
            }
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            if (errorCode != 1062) { // Ignorar herramienta repetidas
                System.out.println("[Error " + errorCode + "] " + e.getMessage());
                e.printStackTrace();
            } else {
                System.out.println("[Herramienta repetida] " + e.getMessage());
            }
        }
        
        //listar todas las herramientas con stock superior a 10
        try {
            String lista = "SELECT * FROM herramienta WHERE id_herramienta IN(SELECT id_herramienta FROM herramienta WHERE stock >8)";
            PreparedStatement ps = conn.prepareStatement(lista);
            ResultSet res = ps.executeQuery();
            System.out.println("\nLas herramientas que poseen stock mayor a 10 son: ");
            while (res.next()) {
                int id_herramienta = res.getInt("id_herramienta");
                String nombre = res.getString("nombre");
                String descripcion = res.getString("descripcion");
                int stock = res.getInt("stock");
                boolean estado = res.getBoolean("estado");
                System.out.println("id_herramienta: " + id_herramienta);
                System.out.println("Nombre: " + nombre);
                System.out.println("Descripcion: " + descripcion);
                System.out.println("Stock: " + stock);
                System.out.println("Estado: " + estado);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("[Error " + e.getErrorCode() + "] " + e.getMessage());
            e.printStackTrace();
            return;
        }
        
        //Dar de baja el primer empleado ingresado a la base de datos
        try {
            String delete = "DELETE FROM empleado WHERE id_empleado = (SELECT MIN(id_empleado) FROM empleado);";
            PreparedStatement ps = conn.prepareStatement(delete);
            int filas = ps.executeUpdate();
            delete = "SELECT * FROM empleado";
            ps = conn.prepareStatement(delete);
            ResultSet res = ps.executeQuery();
            System.out.println("\nLos empleados que quedan son:");
            while (res.next()) {
                int id_empleado = res.getInt("id_empleado");
                int dni = res.getInt("dni");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                int acceso = res.getInt("acceso");
                boolean estado = res.getBoolean("estado");
                System.out.println("Id: " + id_empleado);
                System.out.println("Dni" + dni);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Acceso: " + acceso);
                System.out.println("Estado: " + estado);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("[Error " + e.getErrorCode() + "] " + e.getMessage());
            e.printStackTrace();
            return;
        }
        
    }
}
