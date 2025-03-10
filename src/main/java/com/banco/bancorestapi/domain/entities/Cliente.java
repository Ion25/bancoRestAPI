package com.banco.bancorestapi.domain.entities;

//import com.banco.bancorestapi.domain.otherDomain.valueObjects.Identificacion;
import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private int scoreCredito;

    //@Embedded
    //private Identificacion identificacion;

    // Constructor
    /*
    public Cliente(int id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        //this.identificacion = identificacion;
    }
    */
    /*, Identificacion identificacion*/

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScoreCredito() {
        return scoreCredito;
    }

    public void setScoreCredito(int scoreCredito) {
        this.scoreCredito = scoreCredito;
    }

    /*
    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }
    */
    // Otros métodos de negocio si son necesarios
}
