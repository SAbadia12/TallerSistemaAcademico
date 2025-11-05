package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.ConexionBD;
import com.uniajc.tallersistemaacademico.model.Docentes;
import com.uniajc.tallersistemaacademico.model.Estudiantes;

import java.lang.classfile.instruction.ReturnInstruction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocentesDAO {

    // Metodo insertar
    public String insertarDocente(Docentes docente){

        String sql = "{CALL sp_crear_docente(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, docente.getNombre_docente());
            stmt.setInt(2, docente.getIdentificacion());
            stmt.setString(3, docente.getTipo_identificacion());
            stmt.setString(4, docente.getGenero());
            stmt.setString(5, docente.getCorreo());
            stmt.setString(6, docente.getTitulo_estudios());
            stmt.setString(7, docente.getIdiomas());
            stmt.setString(8, docente.getCertificaciones());

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
    public List<Docentes> listarDocentes(){

        List<Docentes> lista = new ArrayList<>();

        String sql = "{CALL sp_listar_docentes()}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Docentes docente = new Docentes(
                        rs.getInt("docente_id"),
                        rs.getString("nombre_docente"),
                        rs.getInt("identifiacion"),
                        rs.getString("tipo_identificacion"),
                        rs.getString("genero"),
                        rs.getString("correo"),
                        rs.getString("titulo_estudios"),
                        rs.getString("idiomas"),
                        rs.getString("certificaciones")
                );
                lista.add(docente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;

    }

    // Metodo actualizar
    public String actualizarDocente(Docentes docente){
        String sql = "{CALL sp_actualizar_docente(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, docente.getDocente_id());
            stmt.setString(2, docente.getNombre_docente());
            stmt.setInt(3, docente.getIdentificacion());
            stmt.setString(4, docente.getTipo_identificacion());
            stmt.setString(5, docente.getGenero());
            stmt.setString(6, docente.getCorreo());
            stmt.setString(7, docente.getTitulo_estudios());
            stmt.setString(8, docente.getIdiomas());
            stmt.setString(9, docente.getCertificaciones());

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
    public String eliminarDocente(int id){
        String sql = "{CALL sp_eliminar_docente(?)}";

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

    public Docentes obtenerDocentePorId(int id) {
        String sql = "{CALL sp_obtener_docente(?)}";

        try (Connection conn = ConexionBD.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Docentes(
                            rs.getInt("docente_id"),
                            rs.getString("nombre_docente"),
                            rs.getInt("identificacion"),
                            rs.getString("tipo_identificacion"),
                            rs.getString("genero"),
                            rs.getString("correo"),
                            rs.getString("titulo_estudios"),
                            rs.getString("idiomas"),
                            rs.getString("certificaciones")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Si no se encuentra el docente
    }

    public String obtenerNombreDocentePorId(int id) {
        String sql = "SELECT nombre_docente FROM docentes WHERE docente_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre_docente");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Desconocido"; // Si no se encuentra el docente
    }

}
