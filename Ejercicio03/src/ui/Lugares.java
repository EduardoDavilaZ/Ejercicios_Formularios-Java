package ui;

import java.awt.*;
import javax.swing.*;

import bdd.ConsultasBDD;

public class Lugares extends JPanel implements Estilos {
	private static final long serialVersionUID = 1L;

	private JPanel jpnNorte;
	private JPanel jpnCentro;
	private JPanel jpnSur;
	
	private JTextField jtfIp;
	private JTextField jtfNombre;
	private JTextField jtfLugar;
	
	public Lugares() {
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
		JLabel jlbTitulo = new JLabel("Lugares");
		Estilos.configurarTitulo(jlbTitulo);
		jpnNorte.add(jlbTitulo);
	}
	
	private void componentesCentro() {
	    JLabel jlbIp = new JLabel("IP: ");
	    JLabel jlbNombre = new JLabel("Equipo: ");
	    JLabel jlbLugar = new JLabel("Lugar: ");
	    
	    jtfNombre = new JTextField();
	    jtfLugar = new JTextField();
	    jtfIp = new JTextField();
	    
	    jlbIp.setBounds(40, 30, 160, 30);
	    jlbNombre.setBounds(40, 70, 160, 30);
	    jlbLugar.setBounds(40, 110, 160, 30);
	    
	    jtfIp.setBounds(130, 30, 200, 30);
	    jtfNombre.setBounds(130, 70, 200, 30);
	    jtfLugar.setBounds(130, 110, 200, 30);
	    
	    jlbIp.setFont(fuente1);
	    jlbNombre.setFont(fuente1);
	    jlbLugar.setFont(fuente1);
	    
	    jpnCentro.add(jlbIp);
	    jpnCentro.add(jlbNombre);
	    jpnCentro.add(jlbLugar);
	    
	    jpnCentro.add(jtfIp);
	    jpnCentro.add(jtfNombre);
	    jpnCentro.add(jtfLugar);
	}
	
	private void componentesSur() {
		JButton jbtEnviar = new JButton("Enviar");
		Estilos.configurarBotonEnviar(jbtEnviar);
		jbtEnviar.addActionListener(e -> {
			ConsultasBDD consulta = new ConsultasBDD();
			consulta.introducirLugar(jtfIp.getText(), jtfNombre.getText(), jtfLugar.getText());
		});
		jpnSur.add(jbtEnviar);
	}
}
