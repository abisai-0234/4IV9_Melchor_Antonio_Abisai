package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductoVista extends JFrame {

    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    private JTextField txtId, txtNombre, txtPrecio, txtCantidad, txtCategoria;
    private JComboBox<String> cmbTipoProducto;

    private JTextField txtFechaCaducidad, txtPeso;
    private JCheckBox chkPerecedero;

    private JTextField txtMarca, txtGarantia, txtVoltaje;

    private JTextField txtTalla, txtColor, txtMaterial;

    private JButton btnAgregar, btnActualizar, btnEliminar, btnBuscar, btnLimpiar;

    private JPanel panelCamposEspecificos;
    private CardLayout cardLayout;

    public ProductoVista() {
        setTitle("Práctica 3: CRUD de Fútbol — Patrón MVC");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(39, 174, 96));
        JLabel lblTitulo = new JLabel("Sistema de futbol — Práctica 3 (MVC)");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Edad", "Posición", "Nacionalidad"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.setRowHeight(25);

        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        scrollTabla.setPreferredSize(new Dimension(900, 250));
        add(scrollTabla, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout(5, 5));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelInferior.add(crearPanelFormulario(), BorderLayout.CENTER);
        panelInferior.add(crearPanelBotones(), BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Jugador"));

        JPanel panelComun = new JPanel(new GridLayout(2, 6, 5, 5));

        panelComun.add(new JLabel("Tipo:"));
        cmbTipoProducto = new JComboBox<>(new String[]{"JUGADOR"});
        panelComun.add(cmbTipoProducto);

        panelComun.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelComun.add(txtId);

        panelComun.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelComun.add(txtNombre);

        panelComun.add(new JLabel("Edad:"));
        txtPrecio = new JTextField();
        panelComun.add(txtPrecio);

        panelComun.add(new JLabel("Posición:"));
        txtCantidad = new JTextField();
        panelComun.add(txtCantidad);

        panelComun.add(new JLabel("Nacionalidad:"));
        txtCategoria = new JTextField();
        panelComun.add(txtCategoria);

        panel.add(panelComun, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        panelCamposEspecificos = new JPanel(cardLayout);
        panelCamposEspecificos.setBorder(BorderFactory.createTitledBorder("Datos Específicos"));

        JPanel panelAlimento = new JPanel(new GridLayout(1, 6, 5, 5));
        panelAlimento.add(new JLabel("Fecha Registro:"));
        txtFechaCaducidad = new JTextField();
        panelAlimento.add(txtFechaCaducidad);
        panelAlimento.add(new JLabel("Estatura (m):"));
        txtPeso = new JTextField();
        panelAlimento.add(txtPeso);
        panelAlimento.add(new JLabel("Lesionado:"));
        chkPerecedero = new JCheckBox();
        panelAlimento.add(chkPerecedero);
        panelCamposEspecificos.add(panelAlimento, "JUGADOR");

        panel.add(panelCamposEspecificos, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar por ID");
        btnLimpiar = new JButton("Limpiar");

        Color colorBtn = new Color(0, 100, 60);
        Color colorBtnEliminar = new Color(140, 20, 20);
        for (JButton btn : new JButton[]{btnAgregar, btnActualizar, btnBuscar, btnLimpiar}) {
            btn.setBackground(colorBtn);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
        }
        btnEliminar.setBackground(colorBtnEliminar);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setOpaque(true);
        btnEliminar.setBorderPainted(false);

        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);
        panel.add(btnLimpiar);

        return panel;
    }

    public JTable getTablaProductos() { return tablaProductos; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtPrecio() { return txtPrecio; }
    public JTextField getTxtCantidad() { return txtCantidad; }
    public JTextField getTxtCategoria() { return txtCategoria; }
    public JComboBox<String> getCmbTipoProducto() { return cmbTipoProducto; }

    public JTextField getTxtFechaCaducidad() { return txtFechaCaducidad; }
    public JTextField getTxtPeso() { return txtPeso; }
    public JCheckBox getChkPerecedero() { return chkPerecedero; }

    public JTextField getTxtMarca() { return txtMarca; }
    public JTextField getTxtGarantia() { return txtGarantia; }
    public JTextField getTxtVoltaje() { return txtVoltaje; }

    public JTextField getTxtTalla() { return txtTalla; }
    public JTextField getTxtColor() { return txtColor; }
    public JTextField getTxtMaterial() { return txtMaterial; }

    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }

    public CardLayout getCardLayout() { return cardLayout; }
    public JPanel getPanelCamposEspecificos() { return panelCamposEspecificos; }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje,
            "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtCategoria.setText("");
        txtFechaCaducidad.setText("");
        txtPeso.setText("");
        chkPerecedero.setSelected(false);
        txtMarca.setText("");
        txtGarantia.setText("");
        txtVoltaje.setText("");
        txtTalla.setText("");
        txtColor.setText("");
        txtMaterial.setText("");
        tablaProductos.clearSelection();
    }
}
