package view_Admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.graphicResouces;
import java.awt.SystemColor;

public class PanelDatosPaciente extends JPanel {

	public JPanel panel;
	public JTable tbl_doctores;
	public JTextField txt_nombres;
	public JTextField txt_Apellidos;
	public JPasswordField txt_Password;
	public JPanel btn_editar;
	public JLabel lblIngresar;
	private JPanel btnCerrar;
	public JTextField txt_dia;
	private JTextField txt_mes;
	private JTextField txt_año;
	public DefaultTableModel model;
	private graphicResouces gR = new graphicResouces();
	public JTextField txt_cedula;
	public JPanel btn_buscar;
	public JTextField txt_Correo;
	public JRadioButton rbtn_masc;
	public JRadioButton rbtn_fem;
	public JTextField txt_Telf;
	public JTextField txt_Direccion;
	
	public PanelDatosPaciente() {
		
		AbstractBorder bords = new TextBubbleBorder(2,10);
		AbstractBorder redondear = new TextBubbleBorder(1,10);
		setLayout(null);
		setBounds(288,42,1360,720);
		panel = new JPanel();
		panel.setBounds(285,21,1089,697);
		panel.setBackground(Color.white);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelDoctoresAgregados = new JPanel();
		panelDoctoresAgregados.setBounds(291, 11, 777, 675);
		panelDoctoresAgregados.setBorder(bords);
		panel.add(panelDoctoresAgregados);
		panelDoctoresAgregados.setLayout(null);
		
		JLabel lblDoctoresAgregados = new JLabel("Lista de Pacientes");
		lblDoctoresAgregados.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctoresAgregados.setFont(new Font("Product Sans", Font.BOLD, 16));
		lblDoctoresAgregados.setBounds(277, 11, 165, 59);
		panelDoctoresAgregados.add(lblDoctoresAgregados);
		
		tbl_doctores = new JTable();
		tbl_doctores.setFont(new Font( "Product Sans",Font.BOLD ,12 ));
		JScrollPane sc = new JScrollPane(tbl_doctores);
		sc.setBounds(24, 69, 706, 524);
		sc.setBorder(bords);
		panelDoctoresAgregados.add(sc);
		model = new DefaultTableModel();
		model.addColumn("Nombres");		
		model.addColumn("Apellidos");
		model.addColumn("Correo Electrónico");
		model.addColumn("Número Con.");
		model.addColumn("Número Celular");
		model.addColumn("Número Direccion");
		tbl_doctores.setModel(model);
		tbl_doctores.getColumnModel().getColumn(0).setMinWidth(50);
		tbl_doctores.getColumnModel().getColumn(1).setMinWidth(50);
		tbl_doctores.getColumnModel().getColumn(2).setMinWidth(150);
		tbl_doctores.setFont(new Font( "Product Sans",Font.ITALIC  ,10 ));
		JTableHeader th = new JTableHeader();
		th = tbl_doctores.getTableHeader();
		th.setResizingAllowed(false);
		th.setReorderingAllowed(false);
		tbl_doctores.setEnabled(false);
		
		JPanel panelEditarPacientes = new JPanel();
		panelEditarPacientes.setBounds(10, 11, 282, 675);
		panel.add(panelEditarPacientes);
		panelEditarPacientes.setBorder(bords);
		panelEditarPacientes.setLayout(null);
		File nw = new File(gR.logo());
		ImageIcon icon = new ImageIcon(nw.getAbsolutePath());
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblApellidos.setBounds(104, 140, 58, 14);
		panelEditarPacientes.add(lblApellidos);
		
		JLabel lblDia = new JLabel("DIA");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblDia.setBounds(46, 165, 58, 22);
		panelEditarPacientes.add(lblDia);
		
		JLabel lblMes = new JLabel("MES");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblMes.setBounds(106, 165, 58, 22);
		panelEditarPacientes.add(lblMes);
		
		JLabel lblAo = new JLabel("AÑO");
		lblAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAo.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblAo.setBounds(179, 165, 58, 22);
		panelEditarPacientes.add(lblAo);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeNacimiento.setFont(new Font("Product Sans", Font.BOLD, 11));
		lblFechaDeNacimiento.setBounds(33, 220, 129, 22);
		panelEditarPacientes.add(lblFechaDeNacimiento);
		
		JLabel lblGenero = new JLabel("GENERO:");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Product Sans", Font.BOLD, 11));
		lblGenero.setBounds(44, 249, 58, 14);
		panelEditarPacientes.add(lblGenero);
		
		ButtonGroup bt = new ButtonGroup();
		rbtn_masc = new JRadioButton("Masculino");
		rbtn_masc.setBackground(new Color(234, 234, 234));
		rbtn_masc.setBounds(49, 263, 94, 23);
		panelEditarPacientes.add(rbtn_masc);
		bt.add(rbtn_masc);
		
		rbtn_fem = new JRadioButton("Femino");
		rbtn_fem.setBackground(new Color(234, 234, 234));
		rbtn_fem.setBounds(158, 263, 109, 23);
		panelEditarPacientes.add(rbtn_fem);
		bt.add(rbtn_fem);
		
		JLabel lblNumeroTel = new JLabel("NUMERO TELF.");
		lblNumeroTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroTel.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblNumeroTel.setBounds(95, 327, 87, 14);
		panelEditarPacientes.add(lblNumeroTel);
		
		txt_Telf = new JTextField();
		txt_Telf.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Telf.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_Telf.setBackground(new Color(234, 234, 234));
		txt_Telf.setForeground(new Color(0, 0, 0));
		txt_Telf.setBounds(44, 293, 185, 30);
		txt_Telf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_Telf);
		txt_Telf.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(44, 323, 185, 13);
		panelEditarPacientes.add(separator_3);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblDireccion.setBounds(93, 377, 89, 14);
		panelEditarPacientes.add(lblDireccion);
		
		txt_Direccion = new JTextField();
		txt_Direccion.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Direccion.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_Direccion.setBackground(new Color(234, 234, 234));
		txt_Direccion.setForeground(new Color(0, 0, 0));
		txt_Direccion.setBounds(44, 345, 185, 30);
		txt_Direccion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_Direccion);
		txt_Direccion.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(44, 376, 185, 13);
		panelEditarPacientes.add(separator_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(33, 428, 204, 174);
		panelEditarPacientes.add(panel_2);
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
		
		txt_nombres = new JTextField();
		txt_nombres.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nombres.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_nombres.setBackground(new Color(240, 240, 240));
		txt_nombres.setForeground(new Color(192, 192, 192));
		txt_nombres.setBounds(46, 59, 185, 30);
		txt_nombres.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_nombres);
		txt_nombres.setColumns(10);
		
		txt_Apellidos = new JTextField();
		txt_Apellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Apellidos.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_Apellidos.setBackground(new Color(240, 240, 240));
		txt_Apellidos.setForeground(new Color(192, 192, 192));
		txt_Apellidos.setBounds(46, 108, 185, 30);
		txt_Apellidos.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_Apellidos);
		txt_Apellidos.setColumns(10);
		
		txt_cedula = new JTextField();
		txt_cedula.setHorizontalAlignment(SwingConstants.CENTER);
		txt_cedula.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_cedula.setBackground(new Color(240, 240, 240));
		txt_cedula.setForeground(new Color(0, 0, 0));
		txt_cedula.setBounds(26, 11, 185, 30);
		txt_cedula.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_cedula);
		txt_cedula.setColumns(10);
		
		txt_dia = new JTextField();
		txt_dia.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_dia.setBackground(new Color(240, 240, 240));
		txt_dia.setForeground(new Color(192, 192, 192));
		txt_dia.setBounds(46, 179, 46, 30);
		txt_dia.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_dia);
		txt_dia.setColumns(10);
		
		JSeparator sep_dia = new JSeparator();
		sep_dia.setForeground(new Color(0, 0, 0));
		sep_dia.setBounds(44, 210, 52, 13);
		sep_dia.setAlignmentY(SwingConstants.CENTER);
		panelEditarPacientes.add(sep_dia);
		
		txt_mes = new JTextField();
		txt_mes.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mes.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_mes.setBackground(new Color(240, 240, 240));
		txt_mes.setForeground(new Color(192, 192, 192));
		txt_mes.setBounds(112, 179, 46, 30);
		txt_mes.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_mes);
		txt_mes.setColumns(10);
		
		JSeparator sep_mes = new JSeparator();
		sep_mes.setForeground(new Color(0, 0, 0));
		sep_mes.setBounds(112, 210, 52, 13);
		sep_mes.setAlignmentY(SwingConstants.CENTER);
		panelEditarPacientes.add(sep_mes);
		
		txt_año = new JTextField();
		txt_año.setHorizontalAlignment(SwingConstants.CENTER);
		txt_año.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txt_año.setBackground(new Color(240, 240, 240));
		txt_año.setForeground(new Color(192, 192, 192));
		txt_año.setBounds(185, 179, 46, 30);
		txt_año.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelEditarPacientes.add(txt_año);
		txt_año.setColumns(10);
		
		JSeparator sep_año = new JSeparator();
		sep_año.setForeground(new Color(0, 0, 0));
		sep_año.setBounds(185, 210, 52, 13);
		sep_año.setAlignmentY(SwingConstants.CENTER);
		panelEditarPacientes.add(sep_año);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(46, 140, 185, 13);
		separator.setAlignmentY(SwingConstants.CENTER);
		panelEditarPacientes.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBounds(48, 89, 185, 13);
		separator_2.setAlignmentY(SwingConstants.CENTER);
		panelEditarPacientes.add(separator_2);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setForeground(new Color(0, 0, 0));
		separator_2_3.setBounds(26, 42, 185, 13);
		separator_2_3.setAlignmentY(SwingConstants.CENTER);
		panelEditarPacientes.add(separator_2_3);
		
		btn_editar = new JPanel();
		btn_editar.setForeground(new Color(255, 255, 255));
		btn_editar.setBackground(new Color(0, 0, 0));
		btn_editar.setBounds(71, 634, 111, 30);
		panelEditarPacientes.add(btn_editar);
		btn_editar.setLayout(null);
		
		lblIngresar = new JLabel("EDITAR");
		lblIngresar.setBackground(new Color(240, 240, 240));
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setBounds(0, 5, 111, 25);
		btn_editar.add(lblIngresar);
		btn_editar.setBorder(redondear);
		
		JLabel lblNombres = new JLabel("NOMBRES");
		lblNombres.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblNombres.setBounds(106, 90, 58, 14);
		panelEditarPacientes.add(lblNombres);
		
		JLabel lblCedla = new JLabel("CEDULA");
		lblCedla.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedla.setFont(new Font("Product Sans", Font.PLAIN, 11));
		lblCedla.setBounds(84, 45, 58, 14);
		panelEditarPacientes.add(lblCedla);
		
		btn_buscar = new JPanel();
		btn_buscar.setLayout(null);
		btn_buscar.setForeground(Color.WHITE);
		btn_buscar.setBackground(Color.BLACK);
		btn_buscar.setBounds(221, 25, 46, 30);
		panelEditarPacientes.add(btn_buscar);
		btn_buscar.setBorder(bords);
		
		JLabel lblIngresar_1 = new JLabel("...");
		lblIngresar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar_1.setForeground(Color.WHITE);
		lblIngresar_1.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblIngresar_1.setBackground(SystemColor.menu);
		lblIngresar_1.setBounds(0, 5, 46, 25);
		btn_buscar.add(lblIngresar_1);
	}
}
