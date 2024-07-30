package com.banco.bancorestapi.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    private Integer  cuentaOrigenId;
    private Integer  cuentaDestinoId;
    private double monto;
    private LocalDateTime fecha;

    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public Integer  getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(Integer  cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public Integer  getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Integer  cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}