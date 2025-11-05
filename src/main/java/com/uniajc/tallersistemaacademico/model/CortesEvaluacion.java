package com.uniajc.tallersistemaacademico.model;

public class CortesEvaluacion {

    private int corte_evaluacion_id;
    private int curso_id; //Foranea de cursos
    private int periodo_academico_id; //Foranea de periodos academicos
    private String nombre_corte;
    private double porcentaje;
    private String comentarios_corte;

    public CortesEvaluacion(int curso_id, int periodo_academico_id, String nombre_corte, double porcentaje, String comentarios_corte) {
        this.curso_id = curso_id;
        this.periodo_academico_id = periodo_academico_id;
        this.nombre_corte = nombre_corte;
        this.porcentaje = porcentaje;
        this.comentarios_corte = comentarios_corte;
    }

    public CortesEvaluacion(int corte_evaluacion_id, int curso_id, int periodo_academico_id, String nombre_corte, double porcentaje, String comentarios_corte) {
        this.corte_evaluacion_id = corte_evaluacion_id;
        this.curso_id = curso_id;
        this.periodo_academico_id = periodo_academico_id;
        this.nombre_corte = nombre_corte;
        this.porcentaje = porcentaje;
        this.comentarios_corte = comentarios_corte;
    }

    public int getCorte_evaluacion_id() {
        return corte_evaluacion_id;
    }

    public void setCorte_evaluacion_id(int corte_evaluacion_id) {
        this.corte_evaluacion_id = corte_evaluacion_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getPeriodo_academico_id() {
        return periodo_academico_id;
    }

    public void setPeriodo_academico_id(int periodo_academico_id) {
        this.periodo_academico_id = periodo_academico_id;
    }

    public String getNombre_corte() {
        return nombre_corte;
    }

    public void setNombre_corte(String nombre_corte) {
        this.nombre_corte = nombre_corte;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getComentarios_corte() {
        return comentarios_corte;
    }

    public void setComentarios_corte(String comentarios_corte) {
        this.comentarios_corte = comentarios_corte;
    }
}
