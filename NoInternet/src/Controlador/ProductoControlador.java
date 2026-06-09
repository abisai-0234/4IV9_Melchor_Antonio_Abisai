package Controlador;

import Vista.ProductoVista;
import Modelo.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ProductoControlador {

    private ProductoDAO dao;     
    private ProductoVista vista; 

    public ProductoControlador(ProductoDAO dao, ProductoVista vista) {
        this.dao = dao;
        this.vista = vista;
        inicializarEventos();
        cargarTabla();
    }

    private void inicializarEventos() {
        vista.getBtnAgregar().addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnBuscar().addActionListener(e -> buscar());
        vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());
        vista.getCmbTipoProducto().addActionListener(e -> cambiarCamposEspecificos());
        vista.getTablaProductos().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cargarProductoSeleccionado();
            }
        });
    }

    private void agregar() {
        try {
            Persona persona = construirProductoDesdeFormulario();
            if (persona == null) return;
            dao.agregar(persona);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Registro agregado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numéricos sean válidos.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al agregar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error inesperado: " + ex.getMessage());
        }
    }

    private void actualizar() {
        try {
            Persona persona = construirProductoDesdeFormulario();
            if (persona == null) return;
            dao.actualizar(persona);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Registro actualizado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numéricos sean válidos.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al actualizar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error inesperado: " + ex.getMessage());
        }
    }

    private void eliminar() {
        String idStr = vista.getTxtId().getText().trim();
        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del registro a eliminar.");
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            String tipo = (String) vista.getCmbTipoProducto().getSelectedItem();
            if (vista.confirmar("¿Está seguro de eliminar el registro con ID " + id + "?")) {
                dao.eliminar(id, tipo);
                cargarTabla();
                vista.limpiarFormulario();
                vista.mostrarMensaje("Registro eliminado.");
            }
        } catch (NumberFormatException ex) {
            vista.mostrarError("El ID debe ser un número válido.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al eliminar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error inesperado: " + ex.getMessage());
        }
    }

    private void buscar() {
        String idStr = vista.getTxtId().getText().trim();
        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del registro a buscar.");
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            String tipo = (String) vista.getCmbTipoProducto().getSelectedItem();
            Persona persona = dao.buscarPorId(id, tipo);
            if (persona != null) {
                cargarProductoEnFormulario(persona);
                vista.mostrarMensaje("Registro encontrado:\n" + persona.mostrarDetalle());
            } else {
                vista.mostrarError("No se encontró un registro con ID " + id + " en " + tipo);
            }
        } catch (NumberFormatException ex) {
            vista.mostrarError("El ID debe ser un número válido.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al buscar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error inesperado: " + ex.getMessage());
        }
    }

    private void cambiarCamposEspecificos() {
        String tipo = (String) vista.getCmbTipoProducto().getSelectedItem();
        vista.getCardLayout().show(vista.getPanelCamposEspecificos(), tipo);
        cargarTabla();
    }

    private Persona construirProductoDesdeFormulario() {
        if (vista.getTxtId().getText().trim().isEmpty() || vista.getTxtNombre().getText().trim().isEmpty()) {
            vista.mostrarError("ID y Nombre son obligatorios.");
            return null;
        }

        int id = Integer.parseInt(vista.getTxtId().getText().trim());
        String nombre = vista.getTxtNombre().getText().trim();
        double edad = Double.parseDouble(vista.getTxtPrecio().getText().trim());
        int cantidad = Integer.parseInt(vista.getTxtCantidad().getText().trim());
        String nacionalidad = vista.getTxtCategoria().getText().trim();
        String tipo = (String) vista.getCmbTipoProducto().getSelectedItem();

        return switch (tipo) {
            case "JUGADOR" -> new Jugador(id, nombre, edad, cantidad, nacionalidad, 
                    vista.getTxtFechaCaducidad().getText().trim());
            case "ENTRENADOR" -> new Entrenador(id, nombre, edad, cantidad, nacionalidad, 
                    vista.getTxtTalla().getText().trim(), 
                    parseIntSeguro(vista.getTxtColor().getText()), 
                    parseDoubleSeguro(vista.getTxtMaterial().getText()));
            case "PARTIDO" -> new Partido(id, nombre, edad, cantidad, nacionalidad, 
                    vista.getTxtFechaCaducidad().getText().trim(), 
                    vista.getTxtPeso().getText().trim(), 
                    vista.getTxtMarca().getText().trim());
            default -> new Persona(id, nombre, edad, cantidad, nacionalidad);
        };
    }

    private void cargarTabla() {
        DefaultTableModel modelo = vista.getModeloTabla();
        modelo.setRowCount(0);
        try {
            String tipo = (String) vista.getCmbTipoProducto().getSelectedItem();
            List<Persona> personas = dao.listarTodosPorTipo(tipo);
            for (Persona p : personas) {
                modelo.addRow(new Object[]{
                    p.getId(), p.getNombre(), String.format("%.0f", p.getPrecio()), p.getCantidad(), p.getCategoria(), tipo
                });
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar la tabla: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error inesperado al cargar la tabla: " + ex.getMessage());
        }
    }

    private void cargarProductoSeleccionado() {
        int fila = vista.getTablaProductos().getSelectedRow();
        if (fila < 0) return;
        int id = (int) vista.getModeloTabla().getValueAt(fila, 0);
        String tipo = (String) vista.getCmbTipoProducto().getSelectedItem();
        try {
            Persona persona = dao.buscarPorId(id, tipo);
            if (persona != null) {
                cargarProductoEnFormulario(persona);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar registro: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error inesperado al seleccionar registro: " + ex.getMessage());
        }
    }

    private void cargarProductoEnFormulario(Persona persona) {
        vista.getTxtId().setText(String.valueOf(persona.getId()));
        vista.getTxtNombre().setText(persona.getNombre());
        vista.getTxtPrecio().setText(String.valueOf(persona.getPrecio()));
        vista.getTxtCantidad().setText(String.valueOf(persona.getCantidad()));
        vista.getTxtCategoria().setText(persona.getCategoria());

        if (persona instanceof Entrenador) {
            Entrenador e = (Entrenador) persona;
            vista.getCmbTipoProducto().setSelectedItem("ENTRENADOR");
            vista.getTxtTalla().setText(e.getEstrategia());
            vista.getTxtColor().setText(String.valueOf(e.getExperienciaAnios()));
            vista.getTxtMaterial().setText(String.valueOf(e.getSueldo()));
        } else if (persona instanceof Partido) {
            Partido part = (Partido) persona;
            vista.getCmbTipoProducto().setSelectedItem("PARTIDO");
            vista.getTxtFechaCaducidad().setText(part.getTalla());
            vista.getTxtPeso().setText(part.getColor());
            vista.getTxtMarca().setText(part.getMaterial());
        } else if (persona instanceof Jugador) {
            Jugador j = (Jugador) persona;
            vista.getCmbTipoProducto().setSelectedItem("JUGADOR");
            vista.getTxtFechaCaducidad().setText(j.getPosicion());
        }
    }

    private double parseDoubleSeguro(String texto) {
        if (texto == null) return 0.0;
        texto = texto.trim().replace(",", ".");
        try {
            return texto.isEmpty() ? 0.0 : Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private int parseIntSeguro(String texto) {
        if (texto == null) return 0;
        texto = texto.trim();
        try {
            if (texto.contains(".")) {
                return (int) Double.parseDouble(texto);
            }
            return texto.isEmpty() ? 0 : Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}