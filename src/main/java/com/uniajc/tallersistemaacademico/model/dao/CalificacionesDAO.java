package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.Calificaciones;
import com.uniajc.tallersistemaacademico.model.ConexionBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CalificacionesDAO {

    // Metodo insertar
    public String insertarCalificacion(Calificaciones califiacion){

        String sql = "{CALL sp_registrar_calificacion(?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, califiacion.getEstudiante_id());
            stmt.setInt(2, califiacion.getComponente_evaluacion_id());
            stmt.setDouble(3, califiacion.getNota());
            stmt.setString(4, califiacion.getComentarios_califiacion());
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
    public List<Calificaciones> listarCalificaciones(){

        List<Calificaciones> lista = new ArrayList<>();

        String sql = "SELECT * FROM calificaciones";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("calificacion_id");
                int estudiante_id = rs.getInt("estudiante_id");
                int componente_evaluacion_id = rs.getInt("componente_evaluacion_id");
                double nota = rs.getDouble("nota");
                String comentarios = rs.getString("comentarios_calificacion");

                Calificaciones calificacion = new Calificaciones(id, estudiante_id, componente_evaluacion_id, nota, comentarios);
                lista.add(calificacion);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los periodos académicos:");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    // Metodo actualizar
    public String actualizarCalificacion(Calificaciones calificacion){
        String sql = "{CALL sp_actualizar_calificacion(?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, calificacion.getCalificacion_id());
            stmt.setDouble(2, calificacion.getNota());
            stmt.setString(3, calificacion.getComentarios_califiacion());
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
    public String eliminarCalificacion(int id){
        String sql = "{CALL sp_eliminar_calificacion(?)}";

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
