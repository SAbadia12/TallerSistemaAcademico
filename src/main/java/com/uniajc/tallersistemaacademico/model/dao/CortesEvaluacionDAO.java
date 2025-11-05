package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.ConexionBD;
import com.uniajc.tallersistemaacademico.model.CortesEvaluacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CortesEvaluacionDAO {

    // Metodo insertar
    public boolean insertarCorteEvaluacion(CortesEvaluacion corte){

        String sql = "INSERT INTO cortes_evaluacion (curso_id, periodo_academico_id, nombre_corte, porcentaje, comentarios_corte) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, corte.getCurso_id());
            stmt.setInt(2, corte.getPeriodo_academico_id());
            stmt.setString(3, corte.getNombre_corte());
            stmt.setDouble(4, corte.getPorcentaje());
            stmt.setString(5, corte.getComentarios_corte());

            return stmt.executeUpdate() > 0;
            //System.out.println("Periodo Académico insertado con éxito");
        }catch (Exception e){
            //System.out.println("Error al insertar el periodo académico:");
            e.printStackTrace();
            return false;
        }
    }

    // Metodo listar
    public List<CortesEvaluacion> listarCortesEvaluacion(){

        List<CortesEvaluacion> lista = new ArrayList<>();

        String sql = "SELECT * FROM cortes_evaluacion";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("corte_evaluacion_id");
                int curso_id = rs.getInt("curso_id");
                int periodo_id = rs.getInt("periodo_academico_id");
                String nombre = rs.getString("nombre_corte");
                double porcentaje = rs.getDouble("porcentaje");
                String comentarios_corte = rs.getString("comentarios_corte");

                CortesEvaluacion corte = new CortesEvaluacion(id, curso_id, periodo_id, nombre, porcentaje, comentarios_corte);
                lista.add(corte);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los periodos académicos:");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    // Metodo actualizar
    public boolean actualizarCortesEvaluacion(CortesEvaluacion corte){
        String sql = "UPDATE cortes_evaluacion SET curso_id = ?, periodo_academico_id = ?, nombre_corte = ?, porcentaje = ?, comentarios_corte = ? WHERE corte_evaluaion_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, corte.getCurso_id());
            stmt.setInt(2, corte.getPeriodo_academico_id());
            stmt.setString(3, corte.getNombre_corte());
            stmt.setDouble(4, corte.getPorcentaje());
            stmt.setString(5, corte.getComentarios_corte());
            stmt.setInt(6, corte.getCorte_evaluacion_id());

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
    public boolean eliminarCorteEvaluacion(int id){
        String sql = "DELETE FROM cortes_evaluacion WHERE corte_evaluacion_id = ?";

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
