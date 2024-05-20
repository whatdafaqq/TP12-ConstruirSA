/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP12;
import java.time.LocalDate;
/**
 *
 * @author Ramiro
 */
public class Movimiento {
    private int id_movimiento;
    private int id_empleado;
    private int id_herramineta;
    private LocalDate fecha_prestada;
    private LocalDate fecha_devuelta;
    private int cantida_retirada;

    public Movimiento(int id_movimiento, int id_empleado, int id_herramineta, LocalDate fecha_prestada, LocalDate fecha_devuelta, int cantida_retirada) {
        this.id_movimiento = id_movimiento;
        this.id_empleado = id_empleado;
        this.id_herramineta = id_herramineta;
        this.fecha_prestada = fecha_prestada;
        this.fecha_devuelta = fecha_devuelta;
        this.cantida_retirada = cantida_retirada;
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_herramineta() {
        return id_herramineta;
    }

    public void setId_herramineta(int id_herramineta) {
        this.id_herramineta = id_herramineta;
    }

    public LocalDate getFecha_prestada() {
        return fecha_prestada;
    }

    public void setFecha_prestada(LocalDate fecha_prestada) {
        this.fecha_prestada = fecha_prestada;
    }

    public LocalDate getFecha_devuelta() {
        return fecha_devuelta;
    }

    public void setFecha_devuelta(LocalDate fecha_devuelta) {
        this.fecha_devuelta = fecha_devuelta;
    }

    public int getCantida_retirada() {
        return cantida_retirada;
    }

    public void setCantida_retirada(int cantida_retirada) {
        this.cantida_retirada = cantida_retirada;
    }
}
