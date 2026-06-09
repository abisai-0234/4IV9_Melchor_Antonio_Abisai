package Controlador;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void agregar(Persona persona) throws SQLException, Exception {
        String sql = "";
        if (persona instanceof Jugador) {
            sql = "INSERT INTO jugadores (id, nombre, edad, cantidad, nacionalidad, posicion) VALUES (?, ?, ?, ?, ?, ?)";
        } else if (persona instanceof Entrenador) {
            sql = "INSERT INTO entrenadores (id, nombre, edad, cantidad, nacionalidad, estrategia, experiencia_anios, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        } else if (persona instanceof Partido) {
            sql = "INSERT INTO partidos (id, nombre, edad, cantidad, nacionalidad, estadio, resultado, torneo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        }

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getNombre());
            ps.setDouble(3, persona.getPrecio());
            ps.setInt(4, persona.getCantidad());
            ps.setString(5, persona.getCategoria());
            
            if (persona instanceof Jugador) {
                ps.setString(6, ((Jugador) persona).getPosicion());
            } else if (persona instanceof Entrenador) {
                Entrenador e = (Entrenador) persona;
                ps.setString(6, e.getEstrategia());
                ps.setInt(7, e.getExperienciaAnios());
                ps.setDouble(8, e.getSueldo());
            } else if (persona instanceof Partido) {
                Partido part = (Partido) persona;
                ps.setString(6, part.getTalla());
                ps.setString(7, part.getColor());
                ps.setString(8, part.getMaterial());
            }
            
            ps.executeUpdate();
        }
    }

    public void actualizar(Persona persona) throws SQLException, Exception {
        String sql = "";
        if (persona instanceof Jugador) {
            sql = "UPDATE jugadores SET nombre=?, edad=?, cantidad=?, nacionalidad=?, posicion=? WHERE id=?";
        } else if (persona instanceof Entrenador) {
            sql = "UPDATE entrenadores SET nombre=?, edad=?, cantidad=?, nacionalidad=?, estrategia=?, experiencia_anios=?, sueldo=? WHERE id=?";
        } else if (persona instanceof Partido) {
            sql = "UPDATE partidos SET nombre=?, edad=?, cantidad=?, nacionalidad=?, estadio=?, resultado=?, torneo=? WHERE id=?";
        }

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, persona.getNombre());
            ps.setDouble(2, persona.getPrecio());
            ps.setInt(3, persona.getCantidad());
            ps.setString(4, persona.getCategoria());
            
            if (persona instanceof Jugador) {
                ps.setString(5, ((Jugador) persona).getPosicion());
                ps.setInt(6, persona.getId());
            } else if (persona instanceof Entrenador) {
                Entrenador e = (Entrenador) persona;
                ps.setString(5, e.getEstrategia());
                ps.setInt(6, e.getExperienciaAnios());
                ps.setDouble(7, e.getSueldo());
                ps.setInt(8, persona.getId());
            } else if (persona instanceof Partido) {
                Partido part = (Partido) persona;
                ps.setString(5, part.getTalla());
                ps.setString(6, part.getColor());
                ps.setString(7, part.getMaterial());
                ps.setInt(8, persona.getId());
            }
            
            ps.executeUpdate();
        }
    }

    public void eliminar(int id, String tipo) throws SQLException, Exception {
        String tabla = obtenerNombreTabla(tipo);
        String sql = "DELETE FROM " + tabla + " WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Persona buscarPorId(int id, String tipo) throws SQLException, Exception {
        String tabla = obtenerNombreTabla(tipo);
        String sql = "SELECT * FROM " + tabla + " WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return construirObjetoDesdeResultSet(rs, tipo);
                }
            }
        }
        return null;
    }

    public List<Persona> listarTodosPorTipo(String tipo) throws SQLException, Exception {
        List<Persona> lista = new ArrayList<>();
        String tabla = obtenerNombreTabla(tipo);
        String sql = "SELECT * FROM " + tabla;
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(construirObjetoDesdeResultSet(rs, tipo));
            }
        }
        return lista;
    }

    private String obtenerNombreTabla(String tipo) {
        return switch (tipo) {
            case "JUGADOR" -> "jugadores";
            case "ENTRENADOR" -> "entrenadores";
            case "PARTIDO" -> "partidos";
            default -> "jugadores";
        };
    }

    private Persona construirObjetoDesdeResultSet(ResultSet rs, String tipo) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        double edad = rs.getDouble("edad");
        int cantidad = rs.getInt("cantidad");
        String nacionalidad = rs.getString("nacionalidad");

        return switch (tipo) {
            case "JUGADOR" -> new Jugador(id, nombre, edad, cantidad, nacionalidad, rs.getString("posicion"));
            case "ENTRENADOR" -> new Entrenador(id, nombre, edad, cantidad, nacionalidad,
                    rs.getString("estrategia"),
                    rs.getInt("experiencia_anios"),
                    rs.getDouble("sueldo"));
            case "PARTIDO" -> new Partido(id, nombre, edad, cantidad, nacionalidad,
                    rs.getString("estadio"),
                    rs.getString("resultado"),
                    rs.getString("torneo"));
            default -> new Persona(id, nombre, edad, cantidad, nacionalidad);
        };
    }
}