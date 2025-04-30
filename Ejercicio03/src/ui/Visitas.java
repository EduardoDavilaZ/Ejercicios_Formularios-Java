package ui;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import bdd.ConsultasBDD;

public class Visitas extends JPanel implements Estilos{
	private static final long serialVersionUID = 1L;

	private JPanel jpnNorte;
	private JPanel jpnCentro;
	private JPanel jpnSur;
	
	private DefaultListModel<String> modeloLista;
	private JList<String> jlLugares;
	private JTextField jtfCodigo;
	private JScrollPane jcpLugares;
	
	public Visitas() {
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
		JLabel jlbTitulo = new JLabel("Visitas");
		Estilos.configurarTitulo(jlbTitulo);
		jpnNorte.add(jlbTitulo);
	}
	
	private void componentesCentro() {
		JLabel jlbCodigo = new JLabel("Código: ");
	    JLabel jlbLugar = new JLabel("Equipo: ");
	    jtfCodigo = new JTextField();
	    
		ArrayList<String> alLugares = new ArrayList<String>();
		ConsultasBDD consultas = new ConsultasBDD();
		consultas.visualizarLugares(consultas.conexion, alLugares);
		modeloLista = new DefaultListModel<String>();
		
		for (String lugar : alLugares) {
		    modeloLista.addElement(lugar);
		}
		
		jlLugares = new JList<String>(modeloLista);
		jcpLugares = new JScrollPane(jlLugares);
		Estilos.configurarBarra(jcpLugares);
		
	    jlbCodigo.setBounds(40, 30, 160, 30);
	    jlbLugar.setBounds(40, 70, 160, 30);
	    jtfCodigo.setBounds(130, 30, 120, 30);
	    jcpLugares.setBounds(130, 70, 200, 210);
	    
	    jlbCodigo.setFont(fuente1);
	    jlbLugar.setFont(fuente1);
	    
	    jpnCentro.add(jlbCodigo);
	    jpnCentro.add(jlbLugar);
	    jpnCentro.add(jtfCodigo);
	    jpnCentro.add(jcpLugares);
	}
	
	private void componentesSur() {
		JButton jbtEnviar = new JButton("Enviar");
		Estilos.configurarBotonEnviar(jbtEnviar);
		
		jbtEnviar.addActionListener(e -> {
			ConsultasBDD consulta = new ConsultasBDD();
			String lugar = jlLugares.getSelectedValue();
			System.out.println(lugar);
			consulta.introducirVisita(jtfCodigo.getText(), lugar);
		});
		
		jpnSur.add(jbtEnviar);
	}
}
