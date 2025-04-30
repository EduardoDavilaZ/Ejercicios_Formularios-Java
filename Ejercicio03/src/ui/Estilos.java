package ui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;

public interface Estilos {
	Font fuente1 = new Font("Comic Sans MS", Font.BOLD, 18);
	Font fuente2 = new Font("Comic Sans MS", Font.BOLD, 26);
	Font fuente3 = new Font("Comic Sans MS", Font.ITALIC, 16);
	
	Color fondo1 = new Color(2, 104, 157);
	Color fondo2 = new Color(18, 125, 190);
	Color fondo3 = new Color(40, 40, 40);
	Color fondo4 = new Color(255, 255, 255);
	
	Border borde = new LineBorder(fondo1, 2);
	
	public static void configurarTitulo(JLabel label) {
		label.setFont(fuente2);
		label.setForeground(Color.white);
		label.setPreferredSize(new Dimension(110, 40));
	}
	
	public static void configurarBotonEnviar(JButton boton) {
	    boton.setPreferredSize(new Dimension(120, 40));
	    boton.setBackground(fondo1);
	    boton.setFont(fuente1);
	    boton.setForeground(Color.black);
	    boton.setFocusPainted(false);
	    boton.setContentAreaFilled(false);
	    boton.setBorderPainted(false);

	    boton.addMouseListener(new MouseAdapter() {
	        public void mouseEntered(MouseEvent e) {
	            boton.setBackground(fondo2);
	            boton.setForeground(fondo4);
	        }
	        public void mouseExited(MouseEvent e) {
	            boton.setBackground(fondo1);
	            boton.setForeground(Color.black);
	        }
	    });

	    boton.setUI(new BasicButtonUI() {
	        @Override
	        public void paint(Graphics g, JComponent c) {
	            Graphics2D g2 = (Graphics2D) g;
	            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	            g2.setColor(boton.getBackground());
	            g2.fillRoundRect(0, 0, boton.getWidth(), boton.getHeight(), 30, 30);
	            super.paint(g2, c);
	        }
	    });
	}
	
	public static void configurarBarra(JScrollPane scrollPane) {
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		        g.setColor(fondo2); 
		        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
		    }
		    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		        g.setColor(fondo4);
		        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
		    }
		});
	}
}