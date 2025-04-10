/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservas;

/**
 *
 * @author genes
 */
public class Habitacion {
    private String numero;
    private String estado;
    private String tipo;
    private int precio;

    public Habitacion(String numero, String estado, String tipo, int precio) {
        this.numero = numero;
        this.estado = estado;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

