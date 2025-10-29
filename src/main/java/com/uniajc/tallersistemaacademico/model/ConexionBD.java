package com.uniajc.tallersistemaacademico.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class ConexionBD {
    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                // Crear instancia del properties
                Properties props = new Properties();
                InputStream input = ConexionBD.class.getClassLoader().getResourceAsStream("config.properties");
                props.load(input);

                // Obtener datos del config.properties
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");
                String driver = props.getProperty("db.driver");

                // Cargar el driver y conectar
                Class.forName(driver);
                conexion = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión exitosa a la base de datos.");
            } catch (Exception e) {
                System.out.println("Error al conectar a la base de datos:");
                e.printStackTrace();
            }
        }
        return conexion;
    }
}
