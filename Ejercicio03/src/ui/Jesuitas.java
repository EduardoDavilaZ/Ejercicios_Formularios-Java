package ui;

import java.awt.*;
import javax.swing.*;

import bdd.ConsultasBDD;

public class Jesuitas extends JPanel implements Estilos {
	private static final long serialVersionUID = 1L;
	
	private JPanel jpnNorte;
	private JPanel jpnCentro;
	private JPanel jpnSur;
	
	private JTextField jtfCodigo;
	private JTextField jtfNombre;
	private JTextField jtfNombreAl;
	private JTextArea jtaFirmaES;
	private JTextArea jtaFirmaENG;
	
    public Jesuitas() {
        inicializarPanel();
        inicializarComponentes();
    }

    public void inicializarPanel() {
        setPreferredSize(new Dimension(getWidth(), 500));
        setBackground(Color.white);
        inicializarPaneles();
    }
    
    private void inicializarPaneles() {
    	jpnNorte = new JPanel();
    	jpnCentro = new JPanel();
    	jpnSur = new JPanel();
    	
    	jpnNorte.setPreferredSize(new Dimension(500, 50));
    	jpnCentro.setPreferredSize(new Dimension(500, 350));
    	jpnSur.setPreferredSize(new Dimension(500, 50));
    	
    	jpnCentro.setLayout(null);
    	
    	jpnNorte.setBackground(fondo1);
    	jpnCentro.setBackground(fondo4);
    	jpnSur.setBackground(fondo3);
    	
    	add(jpnNorte);
    	add(jpnCentro);
    	add(jpnSur);
	}

	public void inicializarComponentes() {
    	componentesNorte();
    	componentesCentro();
    	componentesSur();
    }
    
	private void componentesNorte() {
		JLabel jlbTitulo = new JLabel("Jesuitas");
		Estilos.configurarTitulo(jlbTitulo);
		jpnNorte.add(jlbTitulo);
	}

	private void componentesCentro() {
		JLabel jlbCodigo = new JLabel("Código: ");
		JLabel jlbNombre = new JLabel("Jesuita: ");
		JLabel jlbNombreAl = new JLabel("Alumno: ");
		JLabel jlbFirmaES = new JLabel("Firma:");
		JLabel jlbFirmaENG = new JLabel("Firma:");
		
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
		
		Estilos.configurarBarra(jspFirmaES);
		Estilos.configurarBarra(jspFirmaENG);
		
		jlbFirmaES.setHorizontalTextPosition(SwingConstants.LEFT);
		jlbFirmaENG.setHorizontalTextPosition(SwingConstants.LEFT);
		
		jlbCodigo.setBounds(40, 30, 160, 30);
		jlbNombre.setBounds(40, 70, 160, 30);
		jlbNombreAl.setBounds(40, 110, 160, 30);
		jlbFirmaES.setBounds(40, 150, 160, 30);
		jlbFirmaENG.setBounds(40, 230, 160, 30);
		
		jtfCodigo.setBounds(130, 30, 120, 30);
		jtfNombre.setBounds(130, 70, 200, 30);
		jtfNombreAl.setBounds(130, 110, 200, 30);
		jspFirmaES.setBounds(130, 150, 200, 60);
		jspFirmaENG.setBounds(130, 230, 200, 60);
		
		jlbCodigo.setFont(fuente1);
		jlbNombre.setFont(fuente1);
		jlbNombreAl.setFont(fuente1);
		jlbFirmaES.setFont(fuente1);
		jlbFirmaENG.setFont(fuente1);
		
		ImageIcon iiFirmaES= new ImageIcon("src/img/ES.png");
		ImageIcon iiFirmaENG = new ImageIcon("src/img/ENG.png");
		
		iiFirmaES.setImage(iiFirmaES.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		iiFirmaENG.setImage(iiFirmaENG.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		
		jlbFirmaES.setIcon(iiFirmaES);
		jlbFirmaENG.setIcon(iiFirmaENG);
		
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
	
	private void componentesSur() {
		JButton jbtEnviar = new JButton("Enviar");
		Estilos.configurarBotonEnviar(jbtEnviar);
		
		jbtEnviar.addActionListener(e -> {
			ConsultasBDD consulta = new ConsultasBDD();
			consulta.introducirAlumno(jtfCodigo.getText(), jtfNombre.getText(), jtfNombreAl.getText(), jtaFirmaES.getText(), jtaFirmaENG.getText());
		});
		
		jpnSur.add(jbtEnviar);
	}
}