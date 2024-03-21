
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultaUsuario extends ConexionBD {
    
    // METODO CREAR USUARIO
    
    public boolean crear (Usuario u){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into usuarios (nombre, correo, telefono) values (?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setInt(3, u.getTelefono());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    //METODO EDITAR
    
    public boolean editar (Usuario u){
        PreparedStatement ps = null;
        Connection con = getConexion();
       String sql = "update usuarios set nombre=?, correo=?, telefono=? where id=?";
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1, u.getNombre());
           ps.setString(2, u.getCorreo());
           ps.setInt(3, u.getTelefono());
           ps.setInt(4, u.getId());
           ps.execute();
           return true;
       }catch(SQLException e){
           System.err.println(e);
           return false;
       }
    }
    
         //METODO ELIMINAR
    public boolean eliminar (Usuario u){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "delete from usuarios where id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    //METODO BUSCAR 
    
    public boolean buscar (Usuario u){
        PreparedStatement ps = null;
        Connection con  = getConexion();
        ResultSet rs = null;
        String sql = "select * from usuarios where id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                u.setId(Integer.parseInt(rs.getString("id")));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(Integer.parseInt(rs.getString("telefono")));
                return true;
            }
            return false;
        }catch(SQLException e){
                    System.err.println(e);
                    return false;
                    }
    }

    
}
