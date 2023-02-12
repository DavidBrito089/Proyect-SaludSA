package view_Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAsignacionHorarios extends JPanel {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public JPanel panel;
	public Choice sel_horasal;
	public DefaultTableModel model;
	public Choice select_doctor;
	public Choice sel_dia;
	public Choice sel_hora;
	public JTable tbl_horarios;
	public JButton cargarHorario;
	public JButton btn_refresh;
	
	public PanelAsignacionHorarios() {
		AbstractBorder bords = new TextBubbleBorder(2,10);
		setLayout(null);
		setBounds(288,42,screenSize.width,screenSize.height);
		panel = new JPanel();
		panel.setBounds(285,21,1089,697);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 296, 675);
		panel_1.setBorder(bords);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDoctor = new JLabel("DOCTOR:");
		lblDoctor.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblDoctor.setBounds(10, 65, 99, 16);
		panel_1.add(lblDoctor);
		
		select_doctor = new Choice();
		select_doctor.setBounds(10, 87, 276, 20);
		panel_1.add(select_doctor);
		
		JLabel lblDiamesao = new JLabel("DIA");
		lblDiamesao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiamesao.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblDiamesao.setBounds(10, 143, 50, 16);
		panel_1.add(lblDiamesao);
		
		JLabel lblHoraI = new JLabel("HORA DE INICIO");
		lblHoraI.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraI.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblHoraI.setBounds(70, 143, 99, 16);
		panel_1.add(lblHoraI);
		
		JLabel lblHoraF = new JLabel("HORA DE SALIDA");
		lblHoraF.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraF.setFont(new Font("Product Sans", Font.BOLD, 12));
		lblHoraF.setBounds(179, 143, 107, 16);
		panel_1.add(lblHoraF);
		
		sel_dia = new Choice();
		sel_dia.setBounds(10, 165, 54, 20);
		panel_1.add(sel_dia);
		
		sel_hora = new Choice();
		sel_hora.setBounds(70, 165, 99, 20);
		panel_1.add(sel_hora);
		
		sel_horasal = new Choice();
		sel_horasal.setBounds(179, 165, 107, 20);
		panel_1.add(sel_horasal);
		
		JLabel lblAsignacionHorarios = new JLabel("Asignacion horarios");
		lblAsignacionHorarios.setFont(new Font("Product Sans", Font.BOLD, 16));
		lblAsignacionHorarios.setBounds(70, 12, 165, 42);
		panel_1.add(lblAsignacionHorarios);
		
		cargarHorario = new JButton("cargarHorario");
		cargarHorario.setBounds(45, 212, 175, 42);
		panel_1.add(cargarHorario);
			
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(bords);
		panel_2.setBounds(308, 11, 760, 675);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		tbl_horarios = new JTable();
		tbl_horarios.setFont(new Font( "Product Sans",Font.BOLD ,12 ));
		JScrollPane sc = new JScrollPane(tbl_horarios);
		sc.setBounds(24, 69, 706, 595);
		sc.setBorder(bords);
		panel_2.add(sc);
		model = new DefaultTableModel();
		model.addColumn("HORA");
		model.addColumn("LUNES");		
		model.addColumn("MARTES");
		model.addColumn("MIERCOLES");
		model.addColumn("JUEVES");
		model.addColumn("VIERNES");
		model.addColumn("SABADO");
		model.addColumn("DOMINGO");
		tbl_horarios.setModel(model);
		tbl_horarios.setFont(new Font( "Product Sans",Font.CENTER_BASELINE  ,12 ));
		JTableHeader th = new JTableHeader();
		th = tbl_horarios.getTableHeader();
		th.setResizingAllowed(false);
		th.setReorderingAllowed(false);
		tbl_horarios.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel lblHorarios = new JLabel("Horarios");
		lblHorarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorarios.setFont(new Font("Product Sans", Font.BOLD, 16));
		lblHorarios.setBounds(285, 11, 165, 59);
		panel_2.add(lblHorarios);
		
		btn_refresh = new JButton("Refresh");
		btn_refresh.setBounds(23, 35, 89, 23);
		panel_2.add(btn_refresh);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tbl_horarios.setDefaultRenderer(Object.class, centerRenderer);
	}
}
