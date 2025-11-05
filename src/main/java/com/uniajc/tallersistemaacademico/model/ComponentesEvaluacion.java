package com.uniajc.tallersistemaacademico.model;

public class ComponentesEvaluacion {

    private int componente_evaluacion_id;
    private int corte_evaluacion_id; //Foranea de cortes evaluacion
    private String nombre_componente;
    private double porcentaje;

    public ComponentesEvaluacion(int corte_evaluacion_id, String nombre_componente, double porcentaje) {
        this.corte_evaluacion_id = corte_evaluacion_id;
        this.nombre_componente = nombre_componente;
        this.porcentaje = porcentaje;
    }

    public ComponentesEvaluacion(int componente_evaluacion_id, int corte_evaluacion_id, String nombre_componente, double porcentaje) {
        this.componente_evaluacion_id = componente_evaluacion_id;
        this.corte_evaluacion_id = corte_evaluacion_id;
        this.nombre_componente = nombre_componente;
        this.porcentaje = porcentaje;
    }

    public int getComponente_evaluacion_id() {
        return componente_evaluacion_id;
    }

    public void setComponente_evaluacion_id(int componente_evaluacion_id) {
        this.componente_evaluacion_id = componente_evaluacion_id;
    }

    public int getCorte_evaluacion_id() {
        return corte_evaluacion_id;
    }

    public void setCorte_evaluacion_id(int corte_evaluacion_id) {
        this.corte_evaluacion_id = corte_evaluacion_id;
    }

    public String getNombre_componente() {
        return nombre_componente;
    }

    public void setNombre_componente(String nombre_componente) {
        this.nombre_componente = nombre_componente;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
