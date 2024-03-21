
package Modelo;


public class Usuario {
    private int id;
    private String nombre, correo;
    private int telefono;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
        public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
        public int getTelefono(){
        return telefono;
    }
    
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
}
