package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.ConexionBD;
import com.uniajc.tallersistemaacademico.model.Docentes;
import com.uniajc.tallersistemaacademico.model.Estudiantes;
import com.uniajc.tallersistemaacademico.model.PeriodosAcademicos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAO {

    // Metodo insertar
    public String insertarEstudiante(Estudiantes estudiante){

        String sql = "{CALL sp_crear_estudiante(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, estudiante.getIdentificacion());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getCorreo_institucional());
            stmt.setString(4, estudiante.getCorreo_personal());
            stmt.setInt(5, estudiante.getTelefono());
            stmt.setInt(6, estudiante.getEs_vocero());
            stmt.setString(7, estudiante.getTipo_documento());
            stmt.setString(8, estudiante.getGenero());
            stmt.setString(9, estudiante.getComentarios());

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
    public List<Estudiantes> listarEstudiantes(){

        List<Estudiantes> lista = new ArrayList<>();

        String sql = "{CALL sp_listar_estudiantes()}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estudiantes estudiante = new Estudiantes(
                        rs.getInt("estudiante_id"),
                        rs.getInt("identificacion"),
                        rs.getString("nombre"),
                        rs.getString("correo_institucional"),
                        rs.getString("correo_personal"),
                        rs.getInt("telefono"),
                        rs.getInt("es_vocero"),
                        rs.getString("tipo_documento"),
                        rs.getString("genero"),
                        rs.getString("comentarios")
                );
                lista.add(estudiante);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los estudiantes:");
            e.printStackTrace();
        }
        return lista;
    }

    // Metodo actualizar
    public String actualizarEstudiante(Estudiantes estudiante){
        String sql = "{CALL sp_actualizar_estudiante(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, estudiante.getEstudiante_id());
            stmt.setInt(2, estudiante.getIdentificacion());
            stmt.setString(3, estudiante.getNombre());
            stmt.setString(4, estudiante.getCorreo_institucional());
            stmt.setString(5, estudiante.getCorreo_personal());
            stmt.setInt(6, estudiante.getTelefono());
            stmt.setInt(7, estudiante.getEs_vocero());
            stmt.setString(8, estudiante.getTipo_documento());
            stmt.setString(9, estudiante.getGenero());
            stmt.setString(10, estudiante.getComentarios());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("resultado"); // Captura el mensaje del SP
                }
            }

        }catch (Exception e){
            //System.out.println("Error al actualizar el docente:");
            e.printStackTrace();
            return "Error: Fallo en la ejecución.";
        }

        return "Error: No se recibió respuesta del procedimiento";
    }

    // Metodo Eliminar
    public String eliminarEstudiante(int id){
        String sql = "{CALL sp_eliminar_estudiante(?)}";

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
