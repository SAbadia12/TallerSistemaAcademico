package com.uniajc.tallersistemaacademico.model;

import java.time.LocalDate;

public class PeriodosAcademicos {

    private int periodo_academico_id;
    private String nombre_periodo;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public PeriodosAcademicos(String nombre_periodo, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.nombre_periodo = nombre_periodo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public PeriodosAcademicos(int periodo_academico_id, String nombre_periodo, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.periodo_academico_id = periodo_academico_id;
        this.nombre_periodo = nombre_periodo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getPeriodo_academico_id() {
        return periodo_academico_id;
    }

    public void setPeriodo_academico_id(int periodo_academico_id) {
        this.periodo_academico_id = periodo_academico_id;
    }

    public String getNombre_periodo() {
        return nombre_periodo;
    }

    public void setNombre_periodo(String nombre_periodo) {
        this.nombre_periodo = nombre_periodo;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
