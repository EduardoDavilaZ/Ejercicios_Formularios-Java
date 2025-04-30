package formulario;

import java.awt.*;
import javax.swing.*;

import bdd.ConsultasBDD;

public class Interfaz extends JFrame implements Estilos{

	private static final long serialVersionUID = 1L;
	private JPanel jpnNorte;
	private JPanel jpnSur;
	private JPanel jpnCentro;
	
	JTextField jtfCodigo;
	JTextField jtfNombre;
	JTextField jtfNombreAl;
	JTextArea jtaFirmaES;
	JTextArea jtaFirmaENG;
	
	public Interfaz() {
		inicializarFrame();
		inicializarPaneles();
		inicializarComponentes();
	}
	
	public void inicializarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	public void inicializarPaneles() {
		jpnNorte = new JPanel();
		jpnCentro = new JPanel();
		jpnSur = new JPanel();
		
		jpnNorte.setBackground(azul);
		jpnCentro.setBackground(celeste);
		jpnSur.setBackground(gris);
		
		jpnNorte.setPreferredSize(new Dimension(WIDTH, 50));
		jpnCentro.setPreferredSize(new Dimension(WIDTH, 500));
		jpnSur.setPreferredSize(new Dimension(WIDTH, 50));
		
		jpnCentro.setLayout(null);
		
		add(jpnNorte, BorderLayout.NORTH);
		add(jpnCentro, BorderLayout.CENTER);
		add(jpnSur, BorderLayout.SOUTH);
	}
	
	public void inicializarComponentes() {
		componentesNorte();
		componentesCentro();
		componentesSur();
	}
	
	public void componentesNorte() {
		JLabel jlbTitulo = new JLabel("Jesuitas");
		jlbTitulo.setFont(fuente2);
		jlbTitulo.setForeground(Color.white);
		jlbTitulo.setPreferredSize(new Dimension(110, 40));
		jpnNorte.add(jlbTitulo);
	}
	
	public void componentesCentro() {
		JLabel jlbCodigo = new JLabel("Código: ");
		JLabel jlbNombre = new JLabel("Jesuita: ");
		JLabel jlbNombreAl = new JLabel("Alumno: ");
		JLabel jlbFirmaES = new JLabel("Firma: ");
		JLabel jlbFirmaENG = new JLabel("Firma: ");
		
		jtfCodigo = new JTextField();
		jtfNombre = new JTextField();
		jtfNombreAl = new JTextField();
		jtaFirmaES = new JTextArea();
		jtaFirmaENG = new JTextArea();
		
		jtaFirmaES.setLineWrap(true);
		jtaFirmaENG.setLineWrap(true);
		jtaFirmaES.setWrapStyleWord(true);
		jtaFirmaENG.setWrapStyleWord(true);
		
		JScrollPane jspFirmaES = new JScrollPane(jtaFirmaES);
		JScrollPane jspFirmaENG = new JScrollPane(jtaFirmaENG);
		
		jlbCodigo.setBounds(30, 30, 160, 30);
		jlbNombre.setBounds(30, 70, 160, 30);
		jlbNombreAl.setBounds(30, 110, 160, 30);
		jlbFirmaES.setBounds(30, 150, 160, 30);
		jlbFirmaENG.setBounds(30, 230, 160, 30);
		
		
		jtfCodigo.setBounds(120, 30, 120, 30);
		jtfNombre.setBounds(120, 70, 200, 30);
		jtfNombreAl.setBounds(120, 110, 200, 30);
		jspFirmaES.setBounds(120, 150, 200, 60);
		jspFirmaENG.setBounds(120, 230, 200, 60);
		
		jlbCodigo.setFont(fuente1);
		jlbNombre.setFont(fuente1);
		jlbNombreAl.setFont(fuente1);
		jlbFirmaES.setFont(fuente1);
		jlbFirmaENG.setFont(fuente1);
		
		jpnCentro.add(jlbCodigo);
		jpnCentro.add(jlbNombre);
		jpnCentro.add(jlbNombreAl);
		jpnCentro.add(jlbFirmaES);
		jpnCentro.add(jlbFirmaENG);
		
		jpnCentro.add(jtfCodigo);
		jpnCentro.add(jtfNombre);
		jpnCentro.add(jtfNombreAl);
		jpnCentro.add(jspFirmaES);
		jpnCentro.add(jspFirmaENG);
	}
	
	public void componentesSur() {
		JButton jbtEnviar = new JButton("Enviar");
		jbtEnviar.setPreferredSize(new Dimension(120, 40));
		jbtEnviar.setBackground(Color.white);
		jbtEnviar.addActionListener(e -> {
			ConsultasBDD consulta = new ConsultasBDD();
			consulta.introducirAlumno(jtfCodigo.getText(), jtfNombre.getText(), jtfNombreAl.getText(), jtaFirmaES.getText(), jtaFirmaENG.getText());
		});
		
		jpnSur.add(jbtEnviar);
	}
}
