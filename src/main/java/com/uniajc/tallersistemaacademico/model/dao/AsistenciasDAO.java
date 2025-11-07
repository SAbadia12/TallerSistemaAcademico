package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AsistenciasDAO {

    // Metodo insertar
    public String insertarAsistencia(Asistencias asistencia){

        String sql = "{CALL sp_registrar_asistencia(?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, asistencia.getEstudiante_id());
            stmt.setInt(2, asistencia.getCurso_id());
            stmt.setDate(3, java.sql.Date.valueOf(asistencia.getFecha_clase()));
            stmt.setString(4, String.valueOf(asistencia.getEstado_asistencia()).toLowerCase());
            stmt.setString(5, asistencia.getNovedades());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("resultado"); // Captura el mensaje del SP
                }
            }

            //System.out.println("Docente insertado con éxito");
        }catch (Exception e){
            //System.out.println("Error al insertar el Docente:");
            e.printStackTrace();
            return "Error: Fallo en la ejecución";
        }
        return "Error: No se recibió respuesta del procedimiento almacenado";
    }

    // Metodo listar
    public List<Asistencias> listarAsistencias(){

        List<Asistencias> lista = new ArrayList<>();

        String sql = "SELECT * FROM asistencias";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("asistencia_id");
                int estudiante_id = rs.getInt("estudiante_id");
                int curso_id = rs.getInt("curso_id");
                java.time.LocalDate fecha_clase = rs.getDate("fecha_clase").toLocalDate();
                EstadoAsistencia estado_asistenica = EstadoAsistencia.valueOf(rs.getString("estado_asistencia"));
                String novedades = rs.getString("novedades");

                Asistencias asistencia = new Asistencias(id, estudiante_id, curso_id, fecha_clase, estado_asistenica, novedades);
                lista.add(asistencia);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los periodos académicos:");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    // Metodo actualizar
    public String actualizarAsistencia(Asistencias asistencia){
        String sql = "{CALL sp_actualizar_asistencia(?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, asistencia.getAsistencia_id());
            stmt.setString(2, String.valueOf(asistencia.getEstado_asistencia()).toLowerCase());
            stmt.setString(3, asistencia.getNovedades());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("resultado"); // Captura el mensaje del SP
                }
            }

            //System.out.println("Docente insertado con éxito");
        }catch (Exception e){
            //System.out.println("Error al insertar el Docente:");
            e.printStackTrace();
            return "Error: Fallo en la ejecución";
        }
        return "Error: No se recibió respuesta del procedimiento almacenado";
    }

    // Metodo Eliminar
    public String eliminarAsistencia(int id){
        String sql = "{CALL sp_eliminar_asistencia(?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("resultado"); // Captura el mensaje del SP
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: Fallo en la ejecución.";
        }

        return "Error: No se recibió respuesta del procedimiento.";
    }
}
