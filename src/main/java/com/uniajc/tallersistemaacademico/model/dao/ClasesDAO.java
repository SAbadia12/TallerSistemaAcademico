package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.Clases;
import com.uniajc.tallersistemaacademico.model.ConexionBD;
import com.uniajc.tallersistemaacademico.model.PeriodosAcademicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClasesDAO {
    // Metodo insertar
    public boolean insertarClases(Clases clase){

        String sql = "INSERT INTO clases (curso_id, numero_clase, fecha_clase, tema_clase, descripcion_clase, comentarios_clase) VALUES (?, ?, ?, ? , ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, clase.getCurso_id());
            stmt.setInt(2, clase.getNumero_clase());
            stmt.setDate(3, java.sql.Date.valueOf(clase.getFecha_clase()));
            stmt.setString(4, clase.getTema_clase());
            stmt.setString(5, clase.getDescripcion_clase());
            stmt.setString(6, clase.getComentarios_clase());

            return stmt.executeUpdate() > 0;
            //System.out.println("Periodo Académico insertado con éxito");
        }catch (Exception e){
            //System.out.println("Error al insertar el periodo académico:");
            e.printStackTrace();
            return false;
        }
    }

    // Metodo listar
    public List<Clases> listarClases(){

        List<Clases> lista = new ArrayList<>();

        String sql = "SELECT * FROM clases";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("clase_id");
                int curso_id = rs.getInt("curso_id");
                int numero_clase = rs.getInt("numero_clase");
                java.time.LocalDate fecha_clase = rs.getDate("fecha_clase").toLocalDate();
                String tema = rs.getString("tema_clase");
                String descripcion = rs.getString("descripcion_clase");
                String comentarios = rs.getString("comentarios_clase");

                Clases clase = new Clases(id, curso_id, numero_clase, fecha_clase, tema, descripcion, comentarios);
                lista.add(clase);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los periodos académicos:");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    // Metodo actualizar
    public boolean actualizarClase(Clases clase){
        String sql = "UPDATE clases SET curso_id = ?, numero_clase = ?, fecha_clase = ?, tema_clase = ?, descripcion_clase = ?, comentarios_clase = ? WHERE clase_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, clase.getCurso_id());
            stmt.setInt(2, clase.getNumero_clase());
            stmt.setDate(3, java.sql.Date.valueOf(clase.getFecha_clase()));
            stmt.setString(4, clase.getTema_clase());
            stmt.setString(5, clase.getDescripcion_clase());
            stmt.setString(6, clase.getComentarios_clase());
            stmt.setInt(7, clase.getClase_id());

            int filas = stmt.executeUpdate();
            /*if (filas > 0){
                System.out.println("Periodo Académico actualizado con éxito");
            }else{
                System.out.println("No se encontró el periodo con el id: " + periodo.getPeriodo_academico_id());
            }*/
            return filas > 0;
        }catch (Exception e){
            //System.out.println("Error al actualizar el periodo académico:");
            e.printStackTrace();
            return false;
        }
    }

    // Metodo Eliminar
    public boolean eliminarClase(int id){
        String sql = "DELETE FROM clases WHERE clase_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            /*if (filas > 0){
                System.out.println("Periodo Académico eliminado correctamente");
            }else{
                System.out.println("No se encontró el periodo con ID: " + id);
            }*/
            return filas > 0;

        }catch (Exception e){
            //System.out.println("Error al eliminar el periodo académico:");
            e.printStackTrace();
            return false;
        }
    }
}
