package com.uniajc.tallersistemaacademico.model;

public class Cursos {
    private int curso_id;
    private String nombre_curso;
    private int periodo_academico_id; //Foranea de peridos academicos
    private int docente_id; //Foranea de docentes
    private String descripcion_curso;
    private String nombreDocente;
    private String nombrePeriodo;

    public Cursos(String nombre_curso, int periodo_academico_id, int docente_id, String descripcion_curso) {
        this.nombre_curso = nombre_curso;
        this.periodo_academico_id = periodo_academico_id;
        this.docente_id = docente_id;
        this.descripcion_curso = descripcion_curso;
    }

    public Cursos(int curso_id, String nombre_curso, int periodo_academico_id, int docente_id, String descripcion_curso) {
        this.curso_id = curso_id;
        this.nombre_curso = nombre_curso;
        this.periodo_academico_id = periodo_academico_id;
        this.docente_id = docente_id;
        this.descripcion_curso = descripcion_curso;
    }

    // Constructor para el SP


    public Cursos(int curso_id, String nombre_curso, int periodo_academico_id, int docente_id, String descripcion_curso, String nombreDocente, String nombrePeriodo) {
        this.curso_id = curso_id;
        this.nombre_curso = nombre_curso;
        this.periodo_academico_id = periodo_academico_id;
        this.docente_id = docente_id;
        this.descripcion_curso = descripcion_curso;
        this.nombreDocente = nombreDocente;
        this.nombrePeriodo = nombrePeriodo;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public int getPeriodo_academico_id() {
        return periodo_academico_id;
    }

    public void setPeriodo_academico_id(int periodo_academico_id) {
        this.periodo_academico_id = periodo_academico_id;
    }

    public int getDocente_id() {
        return docente_id;
    }

    public void setDocente_id(int docente_id) {
        this.docente_id = docente_id;
    }

    public String getDescripcion_curso() {
        return descripcion_curso;
    }

    public void setDescripcion_curso(String descripcion_curso) {
        this.descripcion_curso = descripcion_curso;
    }
}
