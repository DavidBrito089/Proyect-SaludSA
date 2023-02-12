package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import controller.logic_view_register;
import controller.view_login_logic;
import model.graphicResouces;
import view.login_interface.MyTimerActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;

public class view_register_user extends JFrame {

	private JPanel contentPane;
	public JTextField txt_nombres;
	public JTextField txt_Apellidos;
	public JPasswordField txt_Password;
	public JPanel btn_registrarse;
	private graphicResouces gR = new graphicResouces();
	int xM,yM;
	private view_login_logic vli;
	public JLabel lblIngresar;
	private JPanel btnCerrar;
	public JTextField txt_dia;
	public JTextField txt_mes;
	public JTextField txt_año;
	private ButtonGroup bt;
	public JTextField txt_Telf;
	private logic_view_register lvr;
	public JRadioButton rbtn_masc;
	public JRadioButton rbtn_fem;
	public JTextField txt_Direccion;
	public JTextField txt_Correo;
	public JTextField txt_cedula;
	
	public view_register_user() {

		AbstractBorder redondear = new TextBubbleBorder(1,10);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 500, 492);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
	
		Timer timer = new Timer(10, new MyTimerActionListener(this));
		timer.start();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 234, 234));
		panel.setBounds(0, 0, 500, 700);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		RoundRectangle2D.Float roundedRectangle = 
		new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 20, 20);
		setShape(roundedRectangle);
		
		txt_nombres = new JTextField();
		txt_nombres.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nombres.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_nombres.setBackground(new Color(234, 234, 234));
		txt_nombres.setForeground(new Color(0, 0, 0));
		txt_nombres.setBounds(45, 106, 185, 30);
		txt_nombres.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_nombres);
		txt_nombres.setColumns(10);
		
		txt_Apellidos = new JTextField();
		txt_Apellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Apellidos.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_Apellidos.setBackground(new Color(234, 234, 234));
		txt_Apellidos.setForeground(new Color(0, 0, 0));
		txt_Apellidos.setBounds(45, 158, 185, 30);
		txt_Apellidos.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_Apellidos);
		txt_Apellidos.setColumns(10);
		
		txt_cedula = new JTextField();
		txt_cedula.setHorizontalAlignment(SwingConstants.CENTER);
		txt_cedula.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_cedula.setBackground(new Color(234, 234, 234));
		txt_cedula.setForeground(new Color(0, 0, 0));
		txt_cedula.setBounds(45, 205, 185, 30);
		txt_cedula.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_cedula);
		txt_cedula.setColumns(10);
		
		txt_dia = new JTextField();
		txt_dia.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_dia.setBackground(new Color(234, 234, 234));
		txt_dia.setForeground(new Color(0, 0, 0));
		txt_dia.setBounds(45, 296, 46, 30);
		txt_dia.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_dia);
		txt_dia.setColumns(10);
		
		JSeparator sep_dia = new JSeparator();
		sep_dia.setForeground(new Color(0, 0, 0));
		sep_dia.setBounds(43, 327, 52, 13);
		sep_dia.setAlignmentY(SwingConstants.CENTER);
		panel.add(sep_dia);
		
		txt_mes = new JTextField();
		txt_mes.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mes.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_mes.setBackground(new Color(234, 234, 234));
		txt_mes.setForeground(new Color(0, 0, 0));
		txt_mes.setBounds(111, 296, 46, 30);
		txt_mes.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_mes);
		txt_mes.setColumns(10);
		
		JSeparator sep_mes = new JSeparator();
		sep_mes.setForeground(new Color(0, 0, 0));
		sep_mes.setBounds(111, 327, 52, 13);
		sep_mes.setAlignmentY(SwingConstants.CENTER);
		panel.add(sep_mes);
		
		txt_año = new JTextField();
		txt_año.setHorizontalAlignment(SwingConstants.CENTER);
		txt_año.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_año.setBackground(new Color(234, 234, 234));
		txt_año.setForeground(new Color(0, 0, 0));
		txt_año.setBounds(184, 296, 46, 30);
		txt_año.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_año);
		txt_año.setColumns(10);
		
		JSeparator sep_año = new JSeparator();
		sep_año.setForeground(new Color(0, 0, 0));
		sep_año.setBounds(184, 327, 52, 13);
		sep_año.setAlignmentY(SwingConstants.CENTER);
		panel.add(sep_año);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(45, 136, 185, 13);
		separator.setAlignmentY(SwingConstants.CENTER);
		panel.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBounds(45, 189, 185, 13);
		separator_2.setAlignmentY(SwingConstants.CENTER);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBounds(45, 237, 185, 13);
		separator_3.setAlignmentY(SwingConstants.CENTER);
		panel.add(separator_3);
		
		JLabel lblNewLabel = new JLabel("NOMBRES");
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblNewLabel.setBounds(111, 140, 58, 14);
		panel.add(lblNewLabel);
		
		btn_registrarse = new JPanel();
		btn_registrarse.setForeground(new Color(255, 255, 255));
		btn_registrarse.setBackground(new Color(0, 0, 0));
		btn_registrarse.setBounds(194, 443, 111, 30);
		panel.add(btn_registrarse);
		btn_registrarse.setLayout(null);
		
		lblIngresar = new JLabel("REGISTRARSE");
		lblIngresar.setBackground(new Color(240, 240, 240));
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setBounds(0, 5, 111, 25);
		lblIngresar.setCursor(new Cursor(HAND_CURSOR));
		btn_registrarse.add(lblIngresar);
		btn_registrarse.setBorder(redondear);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-xM,y-yM);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xM = e.getX();
				yM= e.getY();
			}
		});
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 500, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnCerrar = new JPanel();
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setBounds(454, 4, 43, 25);
		panel_1.add(btnCerrar);
		btnCerrar.setLayout(null);
		btnCerrar.setBorder(redondear);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setBounds(-2, -5, 45, 30);
		btnCerrar.add(lblNewLabel_1);
		lblNewLabel_1.setCursor(new Cursor(HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {

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
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Registro");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 11, 359, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel iconlbl = new JLabel("");
		iconlbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconlbl.setBounds(154, 41, 185, 54);
		File nw = new File(gR.logo());
		ImageIcon icon = new ImageIcon(nw.getAbsolutePath());
		iconlbl.setIcon(icon);
		panel.add(iconlbl);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblApellidos.setBounds(111, 190, 58, 14);
		panel.add(lblApellidos);
		
		JLabel lblDia = new JLabel("DIA");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblDia.setBounds(40, 327, 58, 22);
		panel.add(lblDia);
		
		JLabel lblMes = new JLabel("MES");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblMes.setBounds(104, 327, 58, 22);
		panel.add(lblMes);
		
		JLabel lblAo = new JLabel("AÑO");
		lblAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAo.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblAo.setBounds(178, 327, 58, 22);
		panel.add(lblAo);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeNacimiento.setFont(new Font("Product Sans", Font.BOLD, 11));
		lblFechaDeNacimiento.setBounds(33, 276, 129, 22);
		panel.add(lblFechaDeNacimiento);
		
		JLabel lblGenero = new JLabel("GENERO:");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Product Sans", Font.BOLD, 11));
		lblGenero.setBounds(40, 379, 58, 14);
		panel.add(lblGenero);
		
		bt = new ButtonGroup();
		rbtn_masc = new JRadioButton("Masculino");
		rbtn_masc.setBackground(new Color(234, 234, 234));
		rbtn_masc.setBounds(45, 393, 94, 23);
		panel.add(rbtn_masc);
		bt.add(rbtn_masc);
		
		rbtn_fem = new JRadioButton("Femino");
		rbtn_fem.setBackground(new Color(234, 234, 234));
		rbtn_fem.setBounds(154, 393, 109, 23);
		panel.add(rbtn_fem);
		bt.add(rbtn_fem);
		
		JLabel lblNumeroTel = new JLabel("NUMERO TELF.");
		lblNumeroTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroTel.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblNumeroTel.setBounds(320, 140, 87, 14);
		panel.add(lblNumeroTel);
		
		txt_Telf = new JTextField();
		txt_Telf.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Telf.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_Telf.setBackground(new Color(234, 234, 234));
		txt_Telf.setForeground(new Color(0, 0, 0));
		txt_Telf.setBounds(269, 106, 185, 30);
		txt_Telf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_Telf);
		txt_Telf.setColumns(10);
		
		JSeparator separators = new JSeparator();
		separators.setForeground(Color.BLACK);
		separators.setBounds(269, 136, 185, 13);
		panel.add(separators);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblDireccion.setBounds(318, 190, 89, 14);
		panel.add(lblDireccion);
		
		txt_Direccion = new JTextField();
		txt_Direccion.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Direccion.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_Direccion.setBackground(new Color(234, 234, 234));
		txt_Direccion.setForeground(new Color(0, 0, 0));
		txt_Direccion.setBounds(269, 158, 185, 30);
		txt_Direccion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txt_Direccion);
		txt_Direccion.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(269, 189, 185, 13);
		panel.add(separator_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(269, 224, 204, 174);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(redondear);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 144, 185, 13);
		panel_2.add(separator_1);
		separator_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBounds(58, 149, 87, 14);
		panel_2.add(lblContrasea);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Product Sans", Font.PLAIN, 11));
		
		txt_Password = new JPasswordField();
		txt_Password.setBounds(10, 113, 185, 30);
		panel_2.add(txt_Password);
		txt_Password.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Password.setBackground(new Color(128, 128, 128));
		txt_Password.setForeground(new Color(0, 0, 0));
		txt_Password.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JSeparator separatorCorreo = new JSeparator();
		separatorCorreo.setBounds(10, 83, 185, 13);
		panel_2.add(separatorCorreo);
		separatorCorreo.setForeground(new Color(255, 255, 255));
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setBounds(58, 88, 87, 14);
		panel_2.add(lblCorreo);
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Product Sans", Font.PLAIN, 11));
		
		txt_Correo = new JTextField();
		txt_Correo.setBounds(10, 52, 185, 30);
		panel_2.add(txt_Correo);
		txt_Correo.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Correo.setBackground(new Color(128, 128, 128));
		txt_Correo.setForeground(new Color(0, 0, 0));
		txt_Correo.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JLabel lblCuenta = new JLabel("CUENTA");
		lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuenta.setForeground(Color.WHITE);
		lblCuenta.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblCuenta.setBounds(46, 11, 114, 30);
		panel_2.add(lblCuenta);
		
		JLabel lblCedula = new JLabel("CEDULA");
		lblCedula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedula.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblCedula.setBounds(111, 242, 58, 14);
		panel.add(lblCedula);
		
		lvr =new logic_view_register(this);
	}
	class MyTimerActionListener implements ActionListener {
	    float opacity = 0f;
	    JFrame miVentana;
	    public MyTimerActionListener(JFrame miVentana) {
	        this.miVentana = miVentana;
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	 if (opacity < 1f) {
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
