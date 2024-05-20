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
public class Herramienta {
    private int id_herramienta;
    private String nombre;
    private String descripcion;
    private int stock;
    private boolean estado;

    public Herramienta(int id_herramienta, String nombre, String descripcion, int stock, boolean estado) {
        this.id_herramienta = id_herramienta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.estado = estado;
    }

    public int getId_herramienta() {
        return id_herramienta;
    }

    public void setId_herramienta(int id_herramienta) {
        this.id_herramienta = id_herramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
