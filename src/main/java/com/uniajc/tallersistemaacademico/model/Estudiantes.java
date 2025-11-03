package com.uniajc.tallersistemaacademico.model;

public class Estudiantes {

    private int estudiante_id;
    private int identificacion;
    private String nombre;
    private String correo_institucional;
    private String correo_personal;
    private int telefono;
    private int es_vocero;
    private String comentarios;
    private String tipo_documento;
    private String genero;

    public Estudiantes(int identificacion, String nombre, String correo_institucional, String correo_personal, int telefono, int es_vocero, String comentarios, String tipo_documento, String genero) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo_institucional = correo_institucional;
        this.correo_personal = correo_personal;
        this.telefono = telefono;
        this.es_vocero = es_vocero;
        this.comentarios = comentarios;
        this.tipo_documento = tipo_documento;
        this.genero = genero;
    }

    public Estudiantes(int estudiante_id, int identificacion, String nombre, String correo_institucional, String correo_personal, int telefono, int es_vocero, String comentarios, String tipo_documento, String genero) {
        this.estudiante_id = estudiante_id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo_institucional = correo_institucional;
        this.correo_personal = correo_personal;
        this.telefono = telefono;
        this.es_vocero = es_vocero;
        this.comentarios = comentarios;
        this.tipo_documento = tipo_documento;
        this.genero = genero;
    }

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_institucional() {
        return correo_institucional;
    }

    public void setCorreo_institucional(String correo_institucional) {
        this.correo_institucional = correo_institucional;
    }

    public String getCorreo_personal() {
        return correo_personal;
    }

    public void setCorreo_personal(String correo_personal) {
        this.correo_personal = correo_personal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEs_vocero() {
        return es_vocero;
    }

    public void setEs_vocero(int es_vocero) {
        this.es_vocero = es_vocero;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
