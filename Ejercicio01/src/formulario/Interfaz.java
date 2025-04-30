package formulario;

import java.awt.*;
import javax.swing.*;

public class Interfaz extends JFrame{
	
	private JPanel jpnAgregar;
	private JPanel jpnModificar;
	private JPanel jpnBorrar;
	private JPanel jpnFormulario;
	private JPanel jpnResultados;
	private CardLayout cardLayout;
	
	private Operaciones operaciones;
	
	public static DefaultListModel<Alumno> modeloLista;
	private JList<Alumno> jlModificar;
	private JList<Alumno> jlBorrar;
	private JScrollPane jspModificar;
	private JScrollPane jspBorrar;
	
	private Color verde = new Color(108, 161, 68);
	private Color rojo = new Color(183, 24, 21);
	
	public Interfaz() {
		operaciones = new Operaciones();
		inicializarFrame();
		inicializarPaneles();
		inicializarComponentes();
		setVisible(true);
	}
	
	public void inicializarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}
	
	public void inicializarPaneles() {
		cardLayout = new CardLayout();
		jpnFormulario = new JPanel(cardLayout);
		add(jpnFormulario, BorderLayout.WEST);
		jpnFormulario.setPreferredSize(new Dimension(500, 0));
			
		jpnAgregar = new JPanel();
		jpnModificar = new JPanel();
		jpnBorrar = new JPanel();
		
		jpnFormulario.add(jpnAgregar, "Agregar");
		jpnAgregar.setBackground(rojo);
		jpnFormulario.add(jpnModificar, "Modificar");
		jpnFormulario.add(jpnBorrar, "Borrar");
		
		jpnResultados = new JPanel();
		jpnResultados.setLayout(null);
		add(jpnResultados, BorderLayout.EAST);
		jpnResultados.setBackground(verde);
		jpnResultados.setPreferredSize(new Dimension(300, 0));
		
		jpnAgregar.setLayout(null);
		jpnModificar.setLayout(null);
		jpnBorrar.setLayout(null);
	}
	
	public void inicializarComponentes() {
		inicializarBotonesMenu();
		inicializarCamposTexto();
		inicializarResultados();
	}
	
	public void inicializarBotonesMenu() {
		JButton jbtAgregar = new JButton("Agregar");
		JButton jbtModificar = new JButton("Modificar");
		JButton jbtBorrar = new JButton("Borrar");
		
		JPanel panelBotones = new JPanel(new FlowLayout());
		
		panelBotones.add(jbtAgregar);
		panelBotones.add(jbtModificar);
		panelBotones.add(jbtBorrar);
		add(panelBotones, BorderLayout.NORTH);

		jbtAgregar.addActionListener(e -> cardLayout.show(jpnFormulario, "Agregar"));
		jbtModificar.addActionListener(e -> cardLayout.show(jpnFormulario, "Modificar"));
		jbtBorrar.addActionListener(e -> cardLayout.show(jpnFormulario, "Borrar"));
	}
	
	
	public void inicializarCamposTexto() {
		JLabel jlbAgregarNombre = new JLabel("Agregar alumno: ");
		JLabel jlbAgregarNota = new JLabel("Agregar nota: ");
		JLabel jlbModificar = new JLabel("Modificar alumno: ");
		
		JLabel jlbNuevoNombre = new JLabel("Nuevo nombre: ");
		JLabel jlbNuevaNota = new JLabel("Nueva nota: ");
		
		JLabel jlbBorrar = new JLabel("Borrar alumno: ");
		
		JTextField jtfAgregarNombre = new JTextField();
		JTextField jtfAgregarNota = new JTextField();
		
		JTextField jtfNuevoNombre = new JTextField();
		JTextField jtfNuevaNota = new JTextField();
		
		modeloLista = new DefaultListModel<Alumno>();
		jlModificar = new JList<Alumno>(modeloLista);
		jlBorrar = new JList<Alumno>(modeloLista);
		jspModificar = new JScrollPane(jlModificar);
		jspBorrar = new JScrollPane(jlBorrar);
		
		jlbAgregarNombre.setBounds(40, 120, 200, 40);
		jlbAgregarNota.setBounds(40, 170, 200, 40);
		
		jlbModificar.setBounds(40, 120, 240, 40);
		jlbNuevoNombre.setBounds(40, 170, 200, 40);
		jlbNuevaNota.setBounds(40, 220, 200, 40);
		
		jlbBorrar.setBounds(40, 120, 200, 40);
		
		jtfAgregarNombre.setBounds(240, 130, 200, 30);
		jtfAgregarNota.setBounds(240, 175, 200, 30);
		
		jtfNuevoNombre.setBounds(240, 170, 200, 30);
		jtfNuevaNota.setBounds(240, 220, 200, 30);
		jspModificar.setBounds(250, 130, 200, 30);
		jspBorrar.setBounds(250, 130, 200, 30);
		
		Font fuente = new Font("Arial", Font.BOLD, 18);
		jlbAgregarNombre.setFont(fuente);
		jlbAgregarNota.setFont(fuente);
		jlbModificar.setFont(fuente);
		jlbNuevoNombre.setFont(fuente);
		jlbNuevaNota.setFont(fuente);
		jlbBorrar.setFont(fuente);
		
		jpnAgregar.add(jlbAgregarNombre);
		jpnAgregar.add(jlbAgregarNota);
		
		jpnAgregar.add(jtfAgregarNombre);
		jpnAgregar.add(jtfAgregarNota);
		
		jpnModificar.add(jlbModificar);
		jpnModificar.add(jlbNuevoNombre);
		jpnModificar.add(jlbNuevaNota);
		jpnModificar.add(jspModificar);
		jpnModificar.add(jtfNuevoNombre);
		jpnModificar.add(jtfNuevaNota);
		
		jpnBorrar.add(jlbBorrar);
		jpnBorrar.add(jspBorrar);
		
		inicializarBotonesEventos(jtfAgregarNombre, jtfAgregarNota, jtfNuevoNombre, jtfNuevaNota);
	}

	private void inicializarBotonesEventos(JTextField jtfAgregarNombre,  JTextField jtfAgregarNota, JTextField jtfNuevoNombre, JTextField jtfNuevaNota) {
		JButton evAgregar = new JButton("Agregar");
		JButton evModificar = new JButton("Modificar");
		JButton evBorrar = new JButton("Borrar");
		
		evAgregar.setBounds(200, 260, 100, 30);
		evModificar.setBounds(200, 260, 100, 30);
		evBorrar.setBounds(200, 260, 100, 30);
		
		jpnAgregar.add(evAgregar);
		jpnModificar.add(evModificar);
		jpnBorrar.add(evBorrar);
		
		agregar(jtfAgregarNombre, jtfAgregarNota, evAgregar);
		modificar(jtfNuevoNombre, jtfNuevaNota, evModificar);
		borrar(evBorrar);
	}
	
	private void agregar (JTextField jtfAgregarNombre,  JTextField jtfAgregarNota, JButton evAgregar) {
		evAgregar.addActionListener(e -> {
			String nombre = jtfAgregarNombre.getText();
			int nota = Integer.parseInt(jtfAgregarNota.getText());
			operaciones.añadir(nombre, nota);
		});
	}
	private void modificar(JTextField jtfNuevoNombre, JTextField jtfNuevaNota, JButton evModificar) {
		evModificar.addActionListener(e -> {
			Alumno alumno = jlModificar.getSelectedValue();
			String nombre = jtfNuevoNombre.getText();
			int nota = Integer.parseInt(jtfNuevaNota.getText());
			operaciones.modificar(alumno, nombre, nota);
		});
	}
	private void borrar(JButton evBorrar) {
		evBorrar.addActionListener(e -> {
			Alumno alumno = jlBorrar.getSelectedValue();
			operaciones.eliminar(alumno);
		});
	}
	
	private static JLabel notaMaxima;
	private static JLabel notaMinima;
	
	private void inicializarResultados() {
		notaMaxima = new JLabel("Nota max: " + Operaciones.obtenerMayor());
		notaMinima = new JLabel("Nota min: " + Operaciones.obtenerMenor());
		
		notaMaxima.setBounds(40, 80, 100, 30);
		notaMinima.setBounds(40, 120, 100, 30);
		
		jpnResultados.add(notaMaxima);
		jpnResultados.add(notaMinima);
	}
	
	public static void actualizarResultados() {
	    notaMaxima.setText("Nota max: " + Operaciones.obtenerMayor());
	    notaMinima.setText("Nota min: " + Operaciones.obtenerMenor());
	}
}   
