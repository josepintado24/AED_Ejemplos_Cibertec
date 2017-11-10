package gui;

import clases.Persona;
import arreglos.ArregloPersonas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EjemploProyectoAED extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblMensaje;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPeso;
	private JLabel lblEstatura;
	private JLabel lblEstadoCivil;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPeso;
	private JTextField txtEstatura;
	private JComboBox <String> cboEstadoCivil;
	private JScrollPane scpScroll;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	//  Tipo de operación a procesar: Adicionar, Modificar, Eliminar o Consultar
	private int tipoOperacion;
	//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR  = 2;
	public final static int CONSULTAR = 3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploProyectoAED frame = new EjemploProyectoAED();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public EjemploProyectoAED() {
		setResizable(false);
		setTitle("Ejemplo Proyecto AED");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		lblMensaje = new JLabel("Seleccione una acción");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBackground(Color.LIGHT_GRAY);
		lblMensaje.setOpaque(true);
		lblMensaje.setBounds(10, 11, 775, 33);
		getContentPane().add(lblMensaje);

		lblCodigo = new JLabel("C\u00F3digo              PER");
		lblCodigo.setBounds(10, 55, 110, 23);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(116, 55, 86, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 80, 70, 23);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(90, 80, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 105, 70, 23);
		getContentPane().add(lblPeso);
	
		txtPeso = new JTextField();
		txtPeso.setBounds(90, 105, 50, 23);
		getContentPane().add(txtPeso);
		txtPeso.setEditable(false);
		txtPeso.setColumns(10);
		
		lblEstatura = new JLabel("Estatura");
		lblEstatura.setBounds(10, 130, 70, 23);
		getContentPane().add(lblEstatura);

		txtEstatura = new JTextField();
		txtEstatura.setBounds(90, 130, 50, 23);
		getContentPane().add(txtEstatura);
		txtEstatura.setEditable(false);
		txtEstatura.setColumns(10);
		
		lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(10, 156, 86, 19);
		getContentPane().add(lblEstadoCivil);
		
		cboEstadoCivil = new JComboBox <String> ();
		cboEstadoCivil.setModel(new DefaultComboBoxModel <String> 
		                       (new String[] {"Soltero", "Casado", "Viudo", "Divorciado"}));
		cboEstadoCivil.setBounds(90, 155, 86, 22);
		getContentPane().add(cboEstadoCivil);
		cboEstadoCivil.setEnabled(false);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 190, 775, 340);
		getContentPane().add(scpScroll);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scpScroll.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PESO (kg)");
		modelo.addColumn("ESTATURA (mts)");
		modelo.addColumn("ESTADO CIVIL");
		modelo.addColumn("IMC = peso/estatura²");
		tblTabla.setModel(modelo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(240, 55, 101, 23);
		getContentPane().add(btnBuscar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 540, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(135, 540, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(260, 540, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(385, 540, 120, 23);
		getContentPane().add(btnEliminar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(510, 540, 120, 23);
		getContentPane().add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setEnabled(false);
		btnVolver.setBounds(664, 540, 120, 23);
		getContentPane().add(btnVolver);

		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	
	//  Declaración global
	ArregloPersonas ap = new ArregloPersonas();
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando persona");
		txtCodigo.setText(ap.codigoCorrelativo());
		txtNombre.setText("");
		txtPeso.setText("");
		txtEstatura.setText("");
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando persona");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando persona");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando persona");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPeso.setText("");
		txtEstatura.setText("");
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		lblMensaje.setText("Seleccione una acción");
	}	
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarPersona();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarPersona();
				break;
			case CONSULTAR:
				consultarPersona();
				break;
			case MODIFICAR:
				modificarPersona();
				break;
			case ELIMINAR:
				eliminarPersona();
		}
	}
	//  Métodos tipo void sin parámetros
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamaño(); i++) {
			Object[] fila = { "PER" + ap.obtener(i).getCodigo(),
					          ap.obtener(i).getNombre(),
					          ap.obtener(i).getPeso(),
					          ap.obtener(i).getEstatura(),
					          ap.obtener(i).detalleEstado(), 
					          ap.obtener(i).imc() };
			modelo.addRow(fila);
		}
	}
	void adicionarPersona() {
		String codigo = leerCodigo(),
		       nombre = leerNombre();
		if (nombre.length() > 0)
			try {
				double peso = leerPeso();
				try {
					double estatura = leerEstatura();
					int estado = leerPosEstado();
					Persona nueva = new Persona(codigo, nombre, peso, estatura, estado);
			  		ap.adicionar(nueva);
					listar();
					txtCodigo.setText(ap.codigoCorrelativo());
					txtNombre.setText("");
					txtPeso.setText("");
					txtEstatura.setText("");
					txtNombre.requestFocus();
				}
				catch (Exception e) {
					mensaje("Ingrese ESTATURA correcta");
					txtEstatura.setText("");
					txtEstatura.requestFocus();	
				}
			}
			catch (Exception e) {
				mensaje("Ingrese PESO correcto");
				txtPeso.setText("");
				txtPeso.requestFocus();
			}
		else {
			mensaje("Ingrese NOMBRE correcto");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
	}
	void consultarPersona() {
		Persona x = ap.buscar(leerCodigo());
		if (x != null) {
			txtNombre.setText(x.getNombre());
			txtPeso.setText("" + x.getPeso());
			txtEstatura.setText("" + x.getEstatura());
			cboEstadoCivil.setSelectedIndex(x.getEstado());
		}
		else {
			mensaje("El código PER" + leerCodigo() + " no existe");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	void modificarPersona() {
		Persona x = ap.buscar(leerCodigo());
		if (x != null) {
			String nombre = leerNombre();
			if (nombre.length() > 0)
				try {
					double peso = leerPeso();
					try {
						double estatura = leerEstatura();
						int estado = leerPosEstado();
						x.setNombre(nombre);
						x.setPeso(peso);
						x.setEstatura(estatura);
						x.setEstado(estado);
						listar();
						txtCodigo.requestFocus();
					}
					catch (Exception e) {
						mensaje("Ingrese ESTATURA correcta");
						txtEstatura.setText("");
						txtEstatura.requestFocus();
					}	
				}
				catch (Exception e) {
					mensaje("Ingrese PESO correcto");
					txtPeso.setText("");
					txtPeso.requestFocus();
				}
			else {
				mensaje("Ingrese NOMBRE correcto");
				txtNombre.setText("");
				txtNombre.requestFocus();
			}
		}
		else {
			mensaje("Ingrese CÓDIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	void eliminarPersona() {
		try {
			Persona x = ap.buscar(leerCodigo());
			if (x != null) {
				ap.eliminar(x);
				listar();
				txtCodigo.setText("");
				txtNombre.setText("");
				txtPeso.setText("");
				txtEstatura.setText("");
				txtCodigo.requestFocus();
			}
			else {
				mensaje("El código PER" + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
		catch (Exception e) {
			mensaje("Ingrese CÓDIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}	
	}
	//  Métodos tipo void con parámetros
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		txtPeso.setEditable(sino);
		txtEstatura.setEditable(sino);
		cboEstadoCivil.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		if (tipoOperacion != ADICIONAR)
			btnBuscar.setEnabled(!sino);
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		if (tipoOperacion == CONSULTAR)
			btnAceptar.setEnabled(false);
		else
			btnAceptar.setEnabled(!sino);
		btnVolver.setEnabled(!sino);		
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//  Métodos que retornan valor sin parámetros
	String leerCodigo() {
		return txtCodigo.getText();
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	double leerPeso() {
		return Double.parseDouble(txtPeso.getText().trim());
	}
	double leerEstatura() {
		return Double.parseDouble(txtEstatura.getText().trim());
	}
	int leerPosEstado() {
		return cboEstadoCivil.getSelectedIndex();
	}
	
}
