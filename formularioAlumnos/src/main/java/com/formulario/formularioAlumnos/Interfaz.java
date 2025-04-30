package com.formulario.formularioAlumnos;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Interfaz extends JFrame implements Estilos {
	
	private static final long serialVersionUID = 1L;
	private JPanel jpnNorte;
	private JPanel jpnSur;
	private JPanel jpnOeste;
	private JPanel jpnEste;
	
	JTextField jtfNombre;
	JTextField jtfApodo;
	JTextArea jtaSobreMi;
	JRadioButton jrbEstudiar;
	JRadioButton jrbTrabajar;
	JComboBox<String> jcbEstudios;
	
	public Interfaz() {
		inicializarFrame();
		inicializarPaneles();
		inicializarSecciones();
		setVisible(true);
	}
	
	public void inicializarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}
	
	public void inicializarPaneles() {
		jpnNorte = new JPanel();
		jpnSur = new JPanel();
		jpnOeste = new JPanel();
		jpnEste = new JPanel();
		
		jpnNorte.setBackground(color2);
		jpnSur.setBackground(color3);
		jpnOeste.setBackground(color1);
		jpnEste.setBackground(color1);
		
		jpnNorte.setPreferredSize(new Dimension(WIDTH, 100));
		jpnSur.setPreferredSize(new Dimension(WIDTH, 60));
		jpnOeste.setPreferredSize(new Dimension(460, HEIGHT));
		jpnEste.setPreferredSize(new Dimension(300, HEIGHT));
		
		//jpnNorte.setLayout(null);
		//jpnSur.setLayout(null);
		jpnOeste.setLayout(null);
		jpnEste.setLayout(null);
		
		add(jpnNorte, BorderLayout.NORTH);
		add(jpnSur, BorderLayout.SOUTH);
		add(jpnOeste, BorderLayout.WEST);
		add(jpnEste, BorderLayout.CENTER);
	}
	
	private void inicializarSecciones() {
		seccionNorte();
		seccionSur();
		seccion1();
		seccion2();
		seccion3();
		seccion4();
	}
	
	private void seccionNorte() {
		JLabel jlbTitulo = new JLabel("¡Bienvenido!");
		jlbTitulo.setFont(fuente3);
		jlbTitulo.setPreferredSize(new Dimension(200, 80));
		jpnNorte.add(jlbTitulo);
	}
	
	private void seccionSur() {
		JButton jbtEnviar = new JButton("Enviar");
		jbtEnviar.setPreferredSize(new Dimension(100, 40));
		jbtEnviar.setBackground(color1);
		jbtEnviar.setFont(fuente);
		
		jbtEnviar.addActionListener(e -> {
			ConsultasBDD consulta = new ConsultasBDD();
			
			String nombre = jtfNombre.getText();
			String apodo = jtfApodo.getText();
			String sobreMi = jtaSobreMi.getText();
			char aspiracion = jrbEstudiar.isSelected() ? 'e' : 't';
			int idEstudio = jcbEstudios.getSelectedIndex() + 1;
			
			int idAlumno = consulta.insertarAlumno(nombre, apodo, sobreMi, aspiracion, idEstudio);
			
			if (idAlumno != -1) {
				ArrayList<Integer> alAficiones = new ArrayList<Integer>();
				for (Component componente : jpnEste.getComponents()) {
					if (componente instanceof JCheckBox && ( (JCheckBox) componente/*cast*/		).isSelected()) { // Si el componente es un checkbox y está seleccionado
						alAficiones.add(consulta.obtenerAficion(	(	(JCheckBox)componente/*cast*/	).getText()	 	)	); // Guarda en el arrayList el id de la aficion
					}
				}
				consulta.insertarAficiones(idAlumno, alAficiones);
			}
		});
		
		jpnSur.add(jbtEnviar);
	}
	
	private void seccion1 () {
		JLabel jlbTitulo = new JLabel("Datos personales");
		JLabel jlbNombre = new JLabel("Nombre: ");
		JLabel jlbApodo = new JLabel("Me gusta que me llamen: ");
		JLabel jlbEstudios = new JLabel("Últimos estudios: ");
		
		jtfNombre = new JTextField();
		jtfApodo = new JTextField();
		
		DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>();
		jcbEstudios = new JComboBox<String>();
		jcbEstudios.setModel(modeloComboBox);
		
		ConsultasBDD consultas = new ConsultasBDD();
		consultas.generarItems(jcbEstudios);
		
		jlbTitulo.setFont(fuente2);
		jlbNombre.setFont(fuente);
		jlbApodo.setFont(fuente);
		jlbEstudios.setFont(fuente);
		
		jlbTitulo.setBounds(70, 15, 260, 30);
		jlbNombre.setBounds(30, 60, 100, 30);
		jlbApodo.setBounds(30, 90, 260, 30);
		jlbEstudios.setBounds(30, 120, 200, 30);
		
		jtfNombre.setBounds(120, 65, 280, 20);
		jtfApodo.setBounds(260, 95, 140, 20);
		jcbEstudios.setBounds(200, 125, 200, 20);
		
		jpnOeste.add(jlbTitulo);
		jpnOeste.add(jlbNombre);
		jpnOeste.add(jlbApodo);
		jpnOeste.add(jlbEstudios);
		
		jpnOeste.add(jtfNombre);
		jpnOeste.add(jtfApodo);
		
		jpnOeste.add(jcbEstudios);
	}
	
	private void seccion2() {
		JLabel jlbTitulo = new JLabel("Más sobre mí...");
		jtaSobreMi = new JTextArea(" Me gusta...");
		
		jlbTitulo.setBounds(70, 220, 260, 30);
		jlbTitulo.setFont(fuente2);
		
		jtaSobreMi.setLineWrap(true);
		jtaSobreMi.setWrapStyleWord(true);
		
		JScrollPane jspSobreMi = new JScrollPane(jtaSobreMi);
		
		jspSobreMi.setBounds(30, 270, 370, 90);
		
		jpnOeste.add(jlbTitulo);
		jpnOeste.add(jspSobreMi);
		
	}
	
	private void seccion3() {
		JLabel jlbTitulo = new JLabel("Aficiones");
		jlbTitulo.setBounds(70, 15, 260, 30);
		jlbTitulo.setFont(fuente2);
		
		ConsultasBDD consultas = new ConsultasBDD();
		consultas.generarCheckBoxes(jpnEste);
		
		jpnEste.add(jlbTitulo);
	}
	
	private void seccion4() {
		JLabel jlbTitulo = new JLabel("<html>Cuando acabe,<br>quiero ...</html>");
		ButtonGroup bgAspiraciones = new ButtonGroup();
		
		jrbEstudiar = new JRadioButton("Estudiar", false);
		jrbTrabajar = new JRadioButton("Trabajar", false);
		
		bgAspiraciones.add(jrbEstudiar);
		bgAspiraciones.add(jrbTrabajar);
		
		jlbTitulo.setBounds(70, 220, 370, 90);
		jrbEstudiar.setBounds(90, 320, 100, 30);
		jrbTrabajar.setBounds(90, 350, 100, 30);
		
		jlbTitulo.setFont(fuente2);
		jrbEstudiar.setBackground(color1);
		jrbTrabajar.setBackground(color1);
		
		
		jpnEste.add(jlbTitulo);
		jpnEste.add(jrbEstudiar);
		jpnEste.add(jrbTrabajar);
	}
}