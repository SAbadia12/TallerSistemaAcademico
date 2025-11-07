package com.uniajc.tallersistemaacademico.model;

public class Calificaciones {

    private int calificacion_id;
    private int estudiante_id; //Foranea de estudiantes
    private int componente_evaluacion_id; //Foranea de componentes de evaluacion
    private double nota;
    private String comentarios_califiacion;

    public Calificaciones(int estudiante_id, int componente_evaluacion_id, double nota, String comentarios_califiacion) {
        this.estudiante_id = estudiante_id;
        this.componente_evaluacion_id = componente_evaluacion_id;
        this.nota = nota;
        this.comentarios_califiacion = comentarios_califiacion;
    }

    public Calificaciones(int calificacion_id, int estudiante_id, int componente_evaluacion_id, double nota, String comentarios_califiacion) {
        this.calificacion_id = calificacion_id;
        this.estudiante_id = estudiante_id;
        this.componente_evaluacion_id = componente_evaluacion_id;
        this.nota = nota;
        this.comentarios_califiacion = comentarios_califiacion;
    }

    public int getCalificacion_id() {
        return calificacion_id;
    }

    public void setCalificacion_id(int calificacion_id) {
        this.calificacion_id = calificacion_id;
    }

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public int getComponente_evaluacion_id() {
        return componente_evaluacion_id;
    }

    public void setComponente_evaluacion_id(int componente_evaluacion_id) {
        this.componente_evaluacion_id = componente_evaluacion_id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentarios_califiacion() {
        return comentarios_califiacion;
    }

    public void setComentarios_califiacion(String comentarios_califiacion) {
        this.comentarios_califiacion = comentarios_califiacion;
    }
}
