package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controller.view_login_logic;
import model.graphicResouces;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ColorModel;
import java.io.File;

import java.awt.SystemColor;
import java.awt.Toolkit;

public class login_interface extends JFrame {
	public JTextField txtNombreDeUsuario;
	public JPasswordField txtPassword;
	public JPanel btnIngresar;
	private graphicResouces gR = new graphicResouces();
	int xM,yM;
	private view_login_logic vli;
	public JPanel btnCrear;
	public JLabel lblIngresar;
	public JPanel panelContenedor;
	public JPanel panelColor;
	public JLabel iconlbl;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_interface frame = new login_interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public login_interface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("RecursosGraficos\\Icon\\Recurso 3@2x.png"));

		AbstractBorder redondear = new TextBubbleBorder(1,10);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 463);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		Timer timer = new Timer(10, new MyTimerActionListener(this));
		timer.start();
		
		panelColor = new JPanel();
		panelColor.setBounds(0, 30, 692, 436);
		panelColor.setBackground(new Color(192, 192, 192));
		getContentPane().add(panelColor);
		panelColor.setLayout(null);
		
		panelContenedor = new JPanel();
		panelContenedor.setBackground(new Color(255,255,255));
		panelContenedor.setBounds(0, 30, 682, 436);
		getContentPane().add(panelContenedor);
		panelContenedor.setLayout(null);
		
		RoundRectangle2D.Float roundedRectangle = 
		new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 20, 20);
		setShape(roundedRectangle);
		
		txtNombreDeUsuario = new JTextField();
		txtNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreDeUsuario.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtNombreDeUsuario.setBackground(new Color(255, 255, 255));
		txtNombreDeUsuario.setForeground(Color.black);
		txtNombreDeUsuario.setBounds(244, 169, 185, 30);
		txtNombreDeUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelContenedor.add(txtNombreDeUsuario);
		txtNombreDeUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("Contraseña");
		txtPassword.setBackground(new Color(255, 255, 255));
		txtPassword.setForeground(new Color(192, 192, 192));
		txtPassword.setBounds(244, 223, 185, 30);
		txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelContenedor.add(txtPassword);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(244, 199, 185, 13);
		separator.setAlignmentY(SwingConstants.CENTER);
		panelContenedor.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(244, 254, 185, 13);
		panelContenedor.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblNewLabel.setBounds(310, 203, 58, 14);
		panelContenedor.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblContrasea.setBounds(295, 258, 87, 14);
		panelContenedor.add(lblContrasea);
		
		btnIngresar = new JPanel();
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(0, 0, 0));
		btnIngresar.setBounds(244, 327, 185, 30);
		panelContenedor.add(btnIngresar);
		btnIngresar.setLayout(null);
		
		lblIngresar = new JLabel("INGRESAR");
		lblIngresar.setBackground(new Color(240, 240, 240));
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setBounds(0, 5, 185, 25);
		lblIngresar.setCursor(new Cursor(HAND_CURSOR));
		btnIngresar.add(lblIngresar);
		btnIngresar.setBorder(redondear);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-xM,y-yM);
			}
		});
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xM = e.getX();
				yM= e.getY();
			}
		});
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 689, 29);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel btnCerrar = new JPanel();
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setBounds(633, 2, 42, 25);
		panel_2.add(btnCerrar);
		btnCerrar.setLayout(null);
		btnCerrar.setBorder(redondear);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setCursor(new Cursor(HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {				
				btnCerrar.setBackground(new Color(0, 0, 0));
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setBackground(new Color(255, 255, 255));
				lblNewLabel_1.setForeground(new Color(0, 0, 0));
			}
		});
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1.setBounds(-3, -7, 45, 30);
		btnCerrar.add(lblNewLabel_1);
		
		iconlbl = new JLabel("");
		iconlbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconlbl.setBounds(244, 71, 185, 54);
		File nw = new File(gR.logo());
		ImageIcon icon = new ImageIcon(nw.getAbsolutePath());
		iconlbl.setIcon(icon);
		panelContenedor.add(iconlbl);
		
		btnCrear = new JPanel();
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrear.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCrear.setBackground(Color.black);
			}
		});
		btnCrear.setLayout(null);
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setBackground(Color.BLACK);
		btnCrear.setBounds(244, 358, 184, 30);
		panelContenedor.add(btnCrear);
		
		JLabel lblCrear = new JLabel("CREAR");
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblCrear.setBackground(SystemColor.menu);
		lblCrear.setBounds(0, 5, 184, 25);
		btnCrear.add(lblCrear);
		btnCrear.setBorder(redondear);
		
		Timer timer2 = new Timer(10, new AnimationInit(this));
		timer2.start();
		
		vli = new view_login_logic(this);
	}
	
	class AnimationInit implements ActionListener{

		private login_interface li;
		private int opacity = 255;
		private int dur = 50;
		private JLabel logoDeSalud;
		private ImageIcon icons;
		private Image image;
		private int y=131;
		
		
		public AnimationInit(login_interface li) {
			this.li=li;
			li.iconlbl.setVisible(false);
			li.txtNombreDeUsuario.setVisible(false);
			li.panelContenedor.setVisible(false);
			icons = new ImageIcon(gR.logo());
			image = icons.getImage();
			icons = new ImageIcon(image.getScaledInstance(89, 53, java.awt.Image.SCALE_SMOOTH));
			logoDeSalud = new JLabel(icons);
			logoDeSalud.setBounds(187, 133, 299, 154);
			li.panelColor.add(logoDeSalud);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(dur!=0) {
				dur--;
				if(dur<1) {
					dur=0;
					li.panelContenedor.setVisible(true);
				}
			}
			if (opacity!=0 && dur==0) {    	        
    	        opacity-=5;
    	        if(y>50) {
    	        	y-=4;
    	        }else if(y>21 && y<50){
    	        	y-=2;
    	        }
    	        
    	        logoDeSalud.setBounds(187, y, 299, 154);
    	        
    	        li.panelColor.setBackground(new Color(li.panelColor.getBackground().getRed(), 
    	        									  li.panelColor.getBackground().getGreen(),
    	        									  li.panelColor.getBackground().getBlue(),opacity));
    	        li.repaint();
    	        if (opacity == 0) {
    	        	li.iconlbl.setVisible(true);
    	        	li.txtNombreDeUsuario.setVisible(true);
    	        	li.panelColor.setVisible(false);
    	        	li.txtNombreDeUsuario.requestFocus();
    	            opacity= 1;
    	            ((Timer)e.getSource()).stop();
    	        }
    	    }
		}
	}
	
	
	class MyTimerActionListener implements ActionListener {
	    float opacity = 0f;
	    JFrame miVentana;
	    public MyTimerActionListener(JFrame miVentana) {
	        this.miVentana = miVentana;
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	 if (opacity <= 1f) {
	    	        opacity += 0.1f;
	    	        if (opacity > 1f) {
	    	            opacity = 1f;
	    	            ((Timer)e.getSource()).stop();
	    	        }
	    	        miVentana.setOpacity(opacity);
	    	    }
	    }
	}
}

