package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.ConexionBD;
import com.uniajc.tallersistemaacademico.model.PeriodosAcademicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PeriodosAcademicosDAO {

    // Metodo insertar
    public boolean insertarPeriodoAcademico(PeriodosAcademicos periodo){

        String sql = "INSERT INTO periodos_academicos (nombre_periodo, fecha_inicio, fecha_fin) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, periodo.getNombre_periodo());
            stmt.setDate(2, java.sql.Date.valueOf(periodo.getFecha_inicio()));
            stmt.setDate(3, java.sql.Date.valueOf(periodo.getFecha_fin()));

            return stmt.executeUpdate() > 0;
            //System.out.println("Periodo Académico insertado con éxito");
        }catch (Exception e){
            //System.out.println("Error al insertar el periodo académico:");
            e.printStackTrace();
            return false;
        }
    }

    // Metodo listar
    public List<PeriodosAcademicos> listarPeriodosAcademicos(){

        List<PeriodosAcademicos> lista = new ArrayList<>();

        String sql = "SELECT * FROM periodos_academicos";

        try (Connection conn = ConexionBD.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("periodo_academico_id");
                String nombre = rs.getString("nombre_periodo");
                java.time.LocalDate inicio = rs.getDate("fecha_inicio").toLocalDate();
                java.time.LocalDate fin = rs.getDate("fecha_fin").toLocalDate();

                PeriodosAcademicos periodo = new PeriodosAcademicos(id, nombre, inicio, fin);
                lista.add(periodo);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los periodos académicos:");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    // Metodo actualizar
    public boolean actualizarPeriodoAcademico(PeriodosAcademicos periodo){
        String sql = "UPDATE periodos_academicos SET nombre_periodo = ?, fecha_inicio = ?, fecha_fin = ? WHERE periodo_academico_id = ?";

        try (Connection conn = ConexionBD.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, periodo.getNombre_periodo());
            stmt.setDate(2, java.sql.Date.valueOf(periodo.getFecha_inicio()));
            stmt.setDate(3, java.sql.Date.valueOf(periodo.getFecha_fin()));
            stmt.setInt(4, periodo.getPeriodo_academico_id());

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
    public boolean eliminarPeriodoAcademico(int id){
        String sql = "DELETE FROM periodos_academicos WHERE periodo_academico_id = ?";

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

    //Metodo para obetener el nombre del periodo
    public String obtenerNombrePeriodoAcademico(int id) {
        String sql = "SELECT nombre_periodo FROM periodos_academicos WHERE periodo_academico_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre_periodo");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Desconocido"; // Si no se encuentra el periodo
    }
}
