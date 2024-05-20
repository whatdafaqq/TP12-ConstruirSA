/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP12;

/**
 *
 * @author Ramiro
 */
    public class Empleado {
    private int id_empleado;
    private long dni;
    private String apellido;
    private String nombre;
    private int acceso;
    private boolean estado;

    public Empleado(int id_empleado, long dni, String apellido, String nombre, int acceso, boolean estado) {
        this.id_empleado = id_empleado;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.acceso = acceso;
        this.estado = estado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

