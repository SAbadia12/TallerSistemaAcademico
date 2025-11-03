package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.ConexionBD;
import com.uniajc.tallersistemaacademico.model.Estudiantes;
import com.uniajc.tallersistemaacademico.model.PeriodosAcademicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAO {

    // Metodo insertar
    public void insertarEstudiante(Estudiantes estudiante){

        String sql = "INSERT INTO estudiantes (indetificacion, nombre, correo_insitucional, correo_personal, telefono, es_vocero, comentarios, tipo_documento, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, estudiante.getIdentificacion());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getCorreo_institucional());
            stmt.setString(4, estudiante.getCorreo_personal());
            stmt.setInt(5, estudiante.getTelefono());
            stmt.setInt(6, estudiante.getEs_vocero());
            stmt.setString(7, estudiante.getComentarios());
            stmt.setString(8, estudiante.getTipo_documento());
            stmt.setString(9, estudiante.getGenero());

            stmt.executeUpdate();
            System.out.println("Estudiante insertado con éxito");
        }catch (Exception e){
            System.out.println("Error al insertar el estudiante:");
            e.printStackTrace();
        }
    }

    // Metodo listar
    public List<Estudiantes> listarEstudiantes(){

        List<Estudiantes> lista = new ArrayList<>();

        String sql = "SELECT * FROM estudiantes";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("estudiante_id");
                int identificacion = rs.getInt("identificacion");
                String nombre = rs.getString("nombre");
                String correoInstitucional = rs.getString("correo_institucional");
                String correoPersonal = rs.getString("correo_personal");
                int telefono = rs.getInt("telefono");
                int esVocero = rs.getInt("es_vocero");
                String comentarios = rs.getString("comentarios");
                String tipoDocumento = rs.getString("tipo_documento");
                String genero = rs.getString("genero");

                Estudiantes estudiante = new Estudiantes(id, identificacion, nombre, correoInstitucional, correoPersonal, telefono, esVocero, comentarios, tipoDocumento, genero);
                lista.add(estudiante);
            }
        }catch (Exception e){
            System.out.println("Error al listar los estudiantes:");
            e.printStackTrace();
        }
        return lista;
    }

    // Metodo actualizar
    public void actualizarEstudiante(Estudiantes estudiante){
        String sql = "UPDATE estudiantes SET identifiacion = ?, nombre = ?, correo_institucional = ?, correo_personal = ?, telefono = ?, es_vocero = ?, comentarios = ?, tipo_documento = ?, genero = ? WHERE estudiante_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, estudiante.getIdentificacion());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getCorreo_institucional());
            stmt.setString(4, estudiante.getCorreo_personal());
            stmt.setInt(5, estudiante.getTelefono());
            stmt.setInt(6, estudiante.getEs_vocero());
            stmt.setString(7, estudiante.getComentarios());
            stmt.setString(8, estudiante.getTipo_documento());
            stmt.setString(9, estudiante.getGenero());
            stmt.setInt(10, estudiante.getEstudiante_id());

            int filas = stmt.executeUpdate();
            if (filas > 0){
                System.out.println("Estudiante actualizado con éxito");
            }else{
                System.out.println("No se encontró el estudiante con el id: " + estudiante.getEstudiante_id());
            }
        }catch (Exception e){
            System.out.println("Error al actualizar el estudiante:");
            e.printStackTrace();
        }
    }

    // Metodo Eliminar
    public void eliminarEstudiante(int id){
        String sql = "DELETE FROM estudiantes WHERE estudiante_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            if (filas > 0){
                System.out.println("Estudainte eliminado correctamente");
            }else{
                System.out.println("No se encontró el estudiante con ID: " + id);
            }

        }catch (Exception e){
            System.out.println("Error al eliminar el estudiante:");
            e.printStackTrace();
        }
    }
}
