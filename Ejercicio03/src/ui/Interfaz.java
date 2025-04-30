package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Interfaz extends JFrame implements Estilos{
	private static final long serialVersionUID = 1L;
	
	private JPanel jpnMenu;
	private JPanel jpnFormulario;
	
	Jesuitas jesuitas = new Jesuitas();
	Lugares lugares = new Lugares();
	Visitas visitas = new Visitas();
	
	JPanel jpnBotones;
	CardLayout cardLayout;
	
	public Interfaz() {
		inicializarFrame();
		inicializarPaneles();
	}
	
	public void inicializarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	public void inicializarPaneles() {
		cardLayout = new CardLayout();
		jpnMenu = new JPanel();
		jpnFormulario = new JPanel(cardLayout);
		
		jpnMenu.setPreferredSize(new Dimension(200, 0));
		jpnFormulario.setPreferredSize(new Dimension(500, 0));
	
		jpnMenu.setBackground(fondo1);
		inicializarMenu();
		inicializarFormularios();
		
		add(jpnMenu, BorderLayout.WEST);
		add(jpnFormulario, BorderLayout.CENTER);
	}
	
	public void inicializarMenu() {
		inicializarImagen();
		inicializarBotones();
	}
	
	public void inicializarFormularios() {
		jpnFormulario.add(jesuitas, "Jesuitas");
		jpnFormulario.add(lugares, "Lugares");
		jpnFormulario.add(visitas, "Visitas");
	}
	
	public void inicializarImagen() {
		JLabel jlbLogo = new JLabel();
		ImageIcon icono = new ImageIcon("src/img/fundacionLoyola.jpg");
		icono.setImage(icono.getImage().getScaledInstance(164, 93, Image.SCALE_SMOOTH)); // 804, 469
		jlbLogo.setIcon(icono);
		jpnMenu.add(jlbLogo);
	}
	
	public void inicializarBotones() {
		jpnBotones = new JPanel();
		jpnBotones.setLayout(new BoxLayout(jpnBotones, BoxLayout.Y_AXIS));
		
		JButton jbtJesuitas = new JButton("Jesuitas");
		JButton jbtLugares = new JButton("Lugares");
		JButton jbtVisitas = new JButton("Visitas");
		
		ImageIcon iiJesuitas = new ImageIcon("src/img/jesuitas.png");
		ImageIcon iiLugares= new ImageIcon("src/img/lugares.png");
		ImageIcon iiVisitas = new ImageIcon("src/img/visitas.png");
		
		iiJesuitas.setImage(iiJesuitas.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iiLugares.setImage(iiLugares.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		iiVisitas.setImage(iiVisitas.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		
		jbtJesuitas.setIcon(iiJesuitas);
		jbtLugares.setIcon(iiLugares);
		jbtVisitas.setIcon(iiVisitas);
		
		configurarBotones(jbtJesuitas);
		configurarBotones(jbtLugares);
		configurarBotones(jbtVisitas);
		
	    jbtJesuitas.addActionListener(e -> cardLayout.show(jpnFormulario, "Jesuitas"));
	    jbtLugares.addActionListener(e -> cardLayout.show(jpnFormulario, "Lugares"));
	    jbtVisitas.addActionListener(e -> cardLayout.show(jpnFormulario, "Visitas"));
	    
		jpnBotones.add(jbtJesuitas);
		jpnBotones.add(jbtLugares);
		jpnBotones.add(jbtVisitas);
		
		jpnMenu.add(jpnBotones);
	}
	
	public void configurarBotones(JButton boton) {
	    boton.setMaximumSize(new Dimension(200, 40));
	    boton.setPreferredSize(new Dimension(200, 40));
	    boton.setBackground(fondo2);
	    boton.setForeground(fondo4);
	    boton.setFont(fuente3);
	    boton.setBorder(borde);

	    boton.setHorizontalAlignment(SwingConstants.LEFT);
	    boton.setHorizontalTextPosition(SwingConstants.RIGHT);
	    boton.setVerticalTextPosition(SwingConstants.CENTER);
	    boton.setBorder(new EmptyBorder(0, 30, 0, 0));
	    
	    boton.addMouseListener(new MouseAdapter() {
	        public void mouseEntered(MouseEvent e) {
	            boton.setBackground(fondo1);
	        }
	        public void mouseExited(MouseEvent e) {
	            boton.setBackground(fondo2);
	        }
	    });
	}
}