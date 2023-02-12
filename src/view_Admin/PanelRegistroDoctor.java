package view_Admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelRegistroDoctor extends JPanel {
	
	public JPanel panel;
	public JTable tbl_doctores;
	public JPanel btnAgregar;
	public JTextField txtNombres;
	public JTextField txtApellidos;
	public JTextField txtCorreoElectronico;
	public Choice txtEspecialidad;
	public JTextField txtNumeroCelular;
	public JTextField txtDireccion;
	public DefaultTableModel model;
	public JSpinner sp_dia;
	public JSpinner sp_año;
	public JSpinner sp_mes;
	public Choice direcCorreo;
	public JTextField txtCedula;
	
	public PanelRegistroDoctor() {
		
		AbstractBorder bords = new TextBubbleBorder(2,10);
		setLayout(null);
		setBounds(288,42,1360,720);
		panel = new JPanel();
		panel.setBounds(285,21,1089,697);
		panel.setBackground(Color.white);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelDoctoresAgregados = new JPanel();
		panelDoctoresAgregados.setBounds(358, 11, 710, 675);
		panelDoctoresAgregados.setBorder(bords);
		panel.add(panelDoctoresAgregados);
		panelDoctoresAgregados.setLayout(null);
		
		JLabel lblDoctoresAgregados = new JLabel("Doctores Agregados");
		lblDoctoresAgregados.setFont(new Font("Product Sans", Font.BOLD, 16));
		lblDoctoresAgregados.setBounds(277, 11, 165, 59);
		panelDoctoresAgregados.add(lblDoctoresAgregados);
		
		tbl_doctores = new JTable();
		tbl_doctores.setFont(new Font( "Product Sans",Font.CENTER_BASELINE  ,12 ));
		JScrollPane sc = new JScrollPane(tbl_doctores);
		sc.setBounds(42, 69, 636, 524);
		sc.setBorder(bords);
		panelDoctoresAgregados.add(sc);
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nombres");		
		model.addColumn("Apellidos");
		model.addColumn("Correo Electrónico");
		model.addColumn("fecha de nacimiento");
		model.addColumn("especialidad");
		model.addColumn("Número de telefono");
		model.addColumn("Direccion");
		tbl_doctores.setModel(model);
		tbl_doctores.getColumnModel().getColumn(0).setMinWidth(70);
		tbl_doctores.getColumnModel().getColumn(1).setMinWidth(40);
		tbl_doctores.getColumnModel().getColumn(2).setMinWidth(50);
		tbl_doctores.setFont(new Font( "Product Sans",Font.ITALIC  ,10 ));
		JTableHeader th = new JTableHeader();
		th = tbl_doctores.getTableHeader();
		th.setResizingAllowed(false);
		th.setReorderingAllowed(false);
		tbl_doctores.setEnabled(false);
		tbl_doctores.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel panelRegistroDoctores = new JPanel();
		panelRegistroDoctores.setBounds(10, 11, 344, 675);
		panel.add(panelRegistroDoctores);
		panelRegistroDoctores.setBorder(bords);
		panelRegistroDoctores.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de doctores");
		lblNewLabel.setBounds(87, 11, 165, 59);
		panelRegistroDoctores.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 102, 134, 9);
		panelRegistroDoctores.add(separator);
		separator.setForeground(new Color(0, 0, 0));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 165, 134, 9);
		panelRegistroDoctores.add(separator_1);
		separator_1.setForeground(Color.BLACK);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 260, 286, 9);
		panelRegistroDoctores.add(separator_2);
		separator_2.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRES");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(49, 102, 85, 22);
		panelRegistroDoctores.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Product Sans", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1 = new JLabel("APELLIDOS");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(46, 166, 88, 22);
		panelRegistroDoctores.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Product Sans", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CORREO ELECTRONICO");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(49, 260, 238, 22);
		panelRegistroDoctores.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Product Sans", Font.PLAIN, 12));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(36, 325, 280, 9);
		panelRegistroDoctores.add(separator_3);
		separator_3.setForeground(Color.BLACK);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(36, 387, 280, 9);
		panelRegistroDoctores.add(separator_1_1);
		separator_1_1.setForeground(Color.BLACK);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(36, 451, 280, 9);
		panelRegistroDoctores.add(separator_2_1);
		separator_2_1.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("NUMERO CELULAR");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(92, 386, 160, 22);
		panelRegistroDoctores.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setFont(new Font("Product Sans", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("DIRECCION");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setBounds(87, 451, 165, 22);
		panelRegistroDoctores.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Product Sans", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("ESPECIALIDAD");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2.setBounds(69, 325, 196, 22);
		panelRegistroDoctores.add(lblNewLabel_1_1_1_2);
		lblNewLabel_1_1_1_2.setFont(new Font("Product Sans", Font.PLAIN, 12));
		
		btnAgregar = new JPanel();
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregar.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAgregar.setBackground(Color.black);
			}
		});
		btnAgregar.setBackground(new Color(0, 0, 0));
		btnAgregar.setBounds(116, 594, 109, 33);
		btnAgregar.setBorder(bords);
		panelRegistroDoctores.add(btnAgregar);
		btnAgregar.setLayout(null);
		
		JLabel btn_Add = new JLabel("AGREGAR");
		btn_Add.setForeground(new Color(255, 255, 255));
		btn_Add.setFont(new Font("Product Sans", Font.BOLD, 13));
		btn_Add.setHorizontalAlignment(SwingConstants.CENTER);
		btn_Add.setBounds(0, 0, 109, 38);
		btnAgregar.add(btn_Add);

		txtNombres = new JTextField();
		txtNombres.setBounds(20, 67, 134, 30);		
		txtNombres.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombres.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtNombres.setBackground(new Color(240, 240, 240));
		txtNombres.setForeground(new Color(0, 0, 0));
		txtNombres.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelRegistroDoctores.add(txtNombres);
		
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(20, 130, 134, 30);		
		txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidos.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtApellidos.setBackground(new Color(240, 240, 240));
		txtApellidos.setForeground(new Color(0, 0, 0));
		txtApellidos.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelRegistroDoctores.add(txtApellidos);
		
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setBounds(20, 229, 150, 30);		
		txtCorreoElectronico.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreoElectronico.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtCorreoElectronico.setBackground(new Color(240, 240, 240));
		txtCorreoElectronico.setForeground(new Color(0, 0, 0));
		txtCorreoElectronico.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelRegistroDoctores.add(txtCorreoElectronico);
		
		txtEspecialidad = new Choice();
		txtEspecialidad.setBounds(36, 293, 280, 30);
		txtEspecialidad.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtEspecialidad.setBackground(new Color(240, 240, 240));
		txtEspecialidad.setForeground(new Color(0, 0, 0));
		panelRegistroDoctores.add(txtEspecialidad);
		
		txtNumeroCelular = new JTextField();
		txtNumeroCelular.setBounds(36, 357, 280, 30);		
		txtNumeroCelular.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroCelular.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtNumeroCelular.setBackground(new Color(240, 240, 240));
		txtNumeroCelular.setForeground(new Color(0, 0, 0));
		txtNumeroCelular.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelRegistroDoctores.add(txtNumeroCelular);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(36, 421, 280, 30);		
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtDireccion.setBackground(new Color(240, 240, 240));
		txtDireccion.setForeground(new Color(0, 0, 0));
		txtDireccion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelRegistroDoctores.add(txtDireccion);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(36, 490, 280, 30);		
		txtCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedula.setFont(new Font("Product Sans", Font.PLAIN, 15));
		txtCedula.setBackground(new Color(240, 240, 240));
		txtCedula.setForeground(new Color(0, 0, 0));
		txtCedula.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelRegistroDoctores.add(txtCedula);
		
		JLabel arroba = new JLabel("@");
		arroba.setHorizontalAlignment(SwingConstants.CENTER);
		arroba.setFont(new Font("Product Sans", Font.PLAIN, 15));
		arroba.setBounds(180, 232, 23, 22);
		panelRegistroDoctores.add(arroba);
		
		direcCorreo = new Choice();
		direcCorreo.setBounds(211, 234,105,20);
		panelRegistroDoctores.add(direcCorreo);
		
		sp_dia = new JSpinner();
		sp_dia.setBounds(237, 102, 65, 20);
		panelRegistroDoctores.add(sp_dia);
		
		sp_mes = new JSpinner();
		sp_mes.setBounds(237, 133, 65, 20);
		panelRegistroDoctores.add(sp_mes);
		
		sp_año = new JSpinner();
		sp_año.setBounds(237, 165, 65, 20);
		panelRegistroDoctores.add(sp_año);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Fecha de nacimineto");
		lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_3.setFont(new Font("Product Sans", Font.PLAIN, 12));
		lblNewLabel_1_1_1_3.setBounds(180, 81, 136, 22);
		panelRegistroDoctores.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("DIA");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Product Sans", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(167, 102, 85, 22);
		panelRegistroDoctores.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("MES");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Product Sans", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(167, 136, 85, 22);
		panelRegistroDoctores.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("AÑO");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Product Sans", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1.setBounds(167, 168, 85, 22);
		panelRegistroDoctores.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("CEDULA");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Product Sans", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(87, 520, 165, 22);
		panelRegistroDoctores.add(lblNewLabel_1_1_1_1_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setForeground(Color.BLACK);
		separator_2_1_1.setBounds(36, 520, 280, 9);
		panelRegistroDoctores.add(separator_2_1_1);
		
		direcCorreo.add("salud.sa.com");
		direcCorreo.add("hotmail.com");
		direcCorreo.add("outlook.com");
	}
}
	
   