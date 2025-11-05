package com.uniajc.tallersistemaacademico.model.dao;

import com.uniajc.tallersistemaacademico.model.ComponentesEvaluacion;
import com.uniajc.tallersistemaacademico.model.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComponentesEvaluacionDAO {
    // Metodo insertar
    public boolean insertarComponenteEvaluacion(ComponentesEvaluacion componente){

        String sql = "INSERT INTO componentes_evaluacion (corte_evaluacion_id, nombre_componente, porcentaje) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, componente.getCorte_evaluacion_id());
            stmt.setString(2, componente.getNombre_componente());
            stmt.setDouble(3, componente.getPorcentaje());

            return stmt.executeUpdate() > 0;
            //System.out.println("Periodo Académico insertado con éxito");
        }catch (Exception e){
            //System.out.println("Error al insertar el periodo académico:");
            e.printStackTrace();
            return false;
        }
    }

    // Metodo listar
    public List<ComponentesEvaluacion> listarComponentesEvaluacion(){

        List<ComponentesEvaluacion> lista = new ArrayList<>();

        String sql = "SELECT * FROM componentes_evaluacion";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("componente_evaluacion_id");
                int corte_id = rs.getInt("corte_evaluacion_id");
                String nombre = rs.getString("nombre_componente");
                double porcentaje = rs.getDouble("porcentaje");

                ComponentesEvaluacion componente = new ComponentesEvaluacion(id, corte_id, nombre, porcentaje);
                lista.add(componente);
            }
        }catch (Exception e){
            //System.out.println("Error al listar los periodos académicos:");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    // Metodo actualizar
    public boolean actualizarComponentesEvaluacion(ComponentesEvaluacion componente){
        String sql = "UPDATE componentes_evaluacion SET corte_evaluacion_id = ?, nombre_componente = ?, porcentaje = ? WHERE componente_evaluacion_id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, componente.getCorte_evaluacion_id());
            stmt.setString(2, componente.getNombre_componente());
            stmt.setDouble(3, componente.getPorcentaje());
            stmt.setInt(4, componente.getComponente_evaluacion_id());


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
    public boolean eliminarComponenteEvaluacion(int id){
        String sql = "DELETE FROM componentes_evaluacion WHERE componente_evaluacion_id = ?";

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
