package com.uniajc.tallersistemaacademico.model;

import java.time.LocalDate;

;
public class Asistencias {

    private int asistencia_id;
    private int estudiante_id;
    private int curso_id;
    private LocalDate fecha_clase;
    private EstadoAsistencia estado_asistencia;

    private String novedades;

    public Asistencias(int estudiante_id, int curso_id, LocalDate fecha_clase, EstadoAsistencia estado_asistencia, String novedades) {
        this.estudiante_id = estudiante_id;
        this.curso_id = curso_id;
        this.fecha_clase = fecha_clase;
        this.estado_asistencia = estado_asistencia;
        this.novedades = novedades;
    }

    public Asistencias(int asistencia_id, int estudiante_id, int curso_id, LocalDate fecha_clase, EstadoAsistencia estado_asistencia, String novedades) {
        this.asistencia_id = asistencia_id;
        this.estudiante_id = estudiante_id;
        this.curso_id = curso_id;
        this.fecha_clase = fecha_clase;
        this.estado_asistencia = estado_asistencia;
        this.novedades = novedades;
    }

    public int getAsistencia_id() {
        return asistencia_id;
    }

    public void setAsistencia_id(int asistencia_id) {
        this.asistencia_id = asistencia_id;
    }

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public LocalDate getFecha_clase() {
        return fecha_clase;
    }

    public void setFecha_clase(LocalDate fecha_clase) {
        this.fecha_clase = fecha_clase;
    }

    public EstadoAsistencia getEstado_asistencia() {
        return estado_asistencia;
    }

    public void setEstado_asistencia(EstadoAsistencia estado_asistencia) {
        this.estado_asistencia = estado_asistencia;
    }

    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }
}
