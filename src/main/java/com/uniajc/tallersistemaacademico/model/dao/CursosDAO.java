package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.ConexionBD;
import com.uniajc.tallersistemaacademico.model.Cursos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursosDAO {
    // Metodo insertar
    public String insertarCurso(Cursos curso){

        String sql = "{CALL sp_crear_curso(?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, curso.getNombre_curso());
            stmt.setInt(2, curso.getPeriodo_academico_id());
            stmt.setInt(3, curso.getDocente_id());
            stmt.setString(4, curso.getDescripcion_curso());
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
    public List<Cursos> listarCursos(){

        List<Cursos> lista = new ArrayList<>();

        String sql = "{CALL sp_listar_cursos()}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            DocentesDAO docenteDAO = new DocentesDAO();
            PeriodosAcademicosDAO periodoDAO = new PeriodosAcademicosDAO();

            while (rs.next()) {

                Cursos curso = new Cursos(
                        rs.getInt("curso_id"),
                        rs.getString("nombre_curso"),
                        rs.getInt("periodo_academico_id"),
                        rs.getInt("docente_id"),
                        rs.getString("descripcion_curso"),
                        docenteDAO.obtenerNombreDocentePorId(rs.getInt("docente_id")),
                        periodoDAO.obtenerNombrePeriodoAcademico(rs.getInt("periodo_academico_id"))
                );
                lista.add(curso);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los estudiantes:");
            e.printStackTrace();
        }
        return lista;
    }

    // Metodo actualizar
    public String actualizarCurso(Cursos curso){
        String sql = "{CALL sp_actualizar_curso(?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, curso.getCurso_id());
            stmt.setString(2, curso.getNombre_curso());
            stmt.setInt(3, curso.getPeriodo_academico_id());
            stmt.setInt(4, curso.getDocente_id());
            stmt.setString(5, curso.getDescripcion_curso());
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
    public String eliminarCurso(int id){
        String sql = "{CALL sp_eliminar_curso(?)}";

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
