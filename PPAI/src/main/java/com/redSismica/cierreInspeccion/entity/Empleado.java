package main.java.com.redSismica.cierreInspeccion.entity;

public class Empleado {
    private String apellido;
    private String mail;
    private String nombre;
    private String telefono;
    private Rol rol;

    public Empleado( String apellido, String mail, String nombre, String telefono, Rol rol) {
        this.apellido = apellido;
        this.mail = mail;
        this.nombre = nombre;
        this.telefono = telefono;
        this.rol = rol;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public boolean esResponsableReparacion() {
        return rol != null && rol.sosResponsableReparacion();
    }
}
