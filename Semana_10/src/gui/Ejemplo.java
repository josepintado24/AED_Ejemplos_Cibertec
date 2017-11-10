package gui;
import clase.Alumno;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import arreglo.ArregloAlumno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ejemplo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblNota;
	private JTextField txtNota1;
	private JLabel lblNota_1;
	private JTextField txtNota2;
	private JButton btnAdicionar;
	private JButton btnEliminarFinal;
	private JButton btnEliminarTodo;
	private JButton btnEliminarCodigo;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(29, 27, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(85, 24, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(194, 27, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(250, 24, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNota = new JLabel("nota1");
		lblNota.setBounds(371, 27, 46, 14);
		contentPane.add(lblNota);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(410, 24, 86, 20);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		lblNota_1 = new JLabel("nota2");
		lblNota_1.setBounds(519, 27, 46, 14);
		contentPane.add(lblNota_1);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(569, 24, 86, 20);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(533, 83, 148, 23);
		contentPane.add(btnAdicionar);
		
		btnEliminarFinal = new JButton("Eliminar Final");
		btnEliminarFinal.addActionListener(this);
		btnEliminarFinal.setBounds(533, 128, 148, 23);
		contentPane.add(btnEliminarFinal);
		
		btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.addActionListener(this);
		btnEliminarTodo.setBounds(533, 174, 148, 23);
		contentPane.add(btnEliminarTodo);
		
		btnEliminarCodigo = new JButton("Eliminar por codigo");
		btnEliminarCodigo.addActionListener(this);
		btnEliminarCodigo.setBounds(533, 227, 148, 23);
		contentPane.add(btnEliminarCodigo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 62, 455, 172);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("NOTA 1");
		modelo.addColumn("NOTA 2");
		modelo.addColumn("PROMEDIO");
		tblTabla.setModel(modelo);
		
		listar();
		
	}
	ArregloAlumno objeto=new ArregloAlumno();
	
	void listar(){
		modelo.setRowCount(0);
		
		for(int i=0;i<objeto.tamano();i++){
			Object[]fila={
					objeto.obtener(i).getCodigo(),
					objeto.obtener(i).getNombre(),
					objeto.obtener(i).getNota1(),
					objeto.obtener(i).getNota2(),
					objeto.obtener(i).promedio()
			};
			modelo.addRow(fila);
		}
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminarCodigo) {
			actionPerformedBtnEliminarCodigo(arg0);
		}
		if (arg0.getSource() == btnEliminarTodo) {
			actionPerformedBtnEliminarTodo(arg0);
		}
		if (arg0.getSource() == btnEliminarFinal) {
			actionPerformedBtnEliminarFinal(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try{
			int codigo=leerCodigo();
			if(objeto.buscar(codigo)==null){
				String nombre=leerNombre();
				if(nombre.length()>0){
					
					try{
						double nota1=leerNota1();
						double nota2=leerNota2();
						Alumno nuevo=new Alumno(codigo,nombre,nota1,nota2);
						objeto.adicionar(nuevo);
						listar();
					}catch(Exception ar){
						mensaje("La notas estan ma ingresadas");
					}

				}else{
					mensaje("La caja esta vacia");
				}
				

			}else{
				mensaje("El codigo ya existe");
			}
			

		}catch(Exception ar){
			mensaje("Error de ingreso de datos");
		}
		

		
	}
	void mensaje(String cadena){
		JOptionPane.showMessageDialog(this, cadena);
	}
	
	
	int leerCodigo(){
		return Integer.parseInt(txtCodigo.getText());
	}
	String leerNombre(){
		return txtNombre.getText();
	}
	double leerNota1(){
		return Double.parseDouble(txtNota1.getText());
	}
	
	double leerNota2(){
		return Double.parseDouble(txtNota2.getText());
	}
	protected void actionPerformedBtnEliminarFinal(ActionEvent arg0) {
	
		if(objeto.tamano()==0){
			mensaje("no hay nada");
		}else{
			objeto.eliminarAlFinal();
			listar();
		}

	
	}
	protected void actionPerformedBtnEliminarTodo(ActionEvent arg0) {
		
		if(objeto.tamano()>0){
			objeto.eliminarTodo();
			listar();
		}else{
			mensaje("El arreglo esta vacio");
		}

	
	}
	protected void actionPerformedBtnEliminarCodigo(ActionEvent arg0) {
		try{
			Alumno codigoBuscado=objeto.buscar(leerCodigo());
			
			if(codigoBuscado!=null){
				objeto.eliminar(codigoBuscado);
				listar();
			}else{
				mensaje("El codigo no existe");
			}
		}catch(Exception a){
			mensaje("Dato mal ingresado");
		}

		

	
	}
}
