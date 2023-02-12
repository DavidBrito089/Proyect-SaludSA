package view_user;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import controller.view_user_logic;
import model.paciente;
import view.login_interface;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class view_user_interface extends JFrame{
	public JTextPane IMPRESION;
	public JLabel lblAgendar;
	public JPanel btn_guardar;
	private view_user_logic vul;
	private JPanel contentPane;
	public Choice cbo_especialidad;
	public Choice cbo_doctor;
	public Choice cbo_horario;
	private login_interface li;
	public paciente pas;
	public JLabel lbl_bienvenida;

	
	
	public view_user_interface(paciente pas) {
		this.pas=pas;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		

		setBackground(new Color(255, 255, 255));
		setBounds(0,0, 1366,720);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				li = new login_interface();
				li.toFront();
				li.setVisible(true);
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBounds(0, 0, 1350, 681);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		File nw = new File("RecursosGraficos/videos/Comp 1000.jpg");
		ImageIcon icon = new ImageIcon(nw.getAbsolutePath());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Impresion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 205, 1330, 465);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		IMPRESION = new JTextPane();
		IMPRESION.setFont(new Font("Product Sans", Font.PLAIN, 16));
		IMPRESION.setBounds(24, 60, 1280, 407);
		panel_1.add(IMPRESION);
		IMPRESION.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel lbl_horarioDisponible_1 = new JLabel("Cita medica");
		lbl_horarioDisponible_1.setFont(new Font("Product Sans", Font.PLAIN, 16));
		lbl_horarioDisponible_1.setBounds(24, 27, 145, 26);
		panel_1.add(lbl_horarioDisponible_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Seleccion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 1330, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		btn_guardar = new JPanel();
		btn_guardar.setBounds(996, 73, 154, 88);
		panel.add(btn_guardar);
		btn_guardar.setBackground(new Color(0, 0, 0));
		btn_guardar.setLayout(null);
		lblAgendar = new JLabel(icon);
		lblAgendar.setBounds(0, -1, 158, 89);
		btn_guardar.add(lblAgendar);
		btn_guardar.add(lblAgendar);
		
		JLabel lbl_horarioDisponible = new JLabel("Horario disponible:");
		lbl_horarioDisponible.setBounds(660, 110, 137, 20);
		panel.add(lbl_horarioDisponible);
		lbl_horarioDisponible.setFont(new Font("Product Sans", Font.PLAIN, 16));
		
		cbo_especialidad = new Choice();
		cbo_especialidad.setBounds(238, 110, 159, 20);
		panel.add(cbo_especialidad);
		
		JLabel lbl_horarioDisponible_2 = new JLabel("Doctor:");
		lbl_horarioDisponible_2.setBounds(420, 110, 60, 25);
		panel.add(lbl_horarioDisponible_2);
		lbl_horarioDisponible_2.setFont(new Font("Product Sans", Font.PLAIN, 16));
		
		JLabel lbl_horarioDisponible_2_1 = new JLabel("Especialidad:");
		lbl_horarioDisponible_2_1.setBounds(141, 110, 133, 25);
		panel.add(lbl_horarioDisponible_2_1);
		lbl_horarioDisponible_2_1.setFont(new Font("Product Sans", Font.PLAIN, 16));
		
		cbo_doctor = new Choice();
		cbo_doctor.setBounds(486, 110, 159, 20);
		panel.add(cbo_doctor);
		
		cbo_horario = new Choice();
		cbo_horario.setBounds(803, 110, 159, 20);
		panel.add(cbo_horario);
		
		lbl_bienvenida = new JLabel("Bienvenido ");
		lbl_bienvenida.setFont(new Font("Product Sans", Font.BOLD, 29));
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_bienvenida.setBounds(10, 36, 1310, 36);
		panel.add(lbl_bienvenida);
		
		vul = new view_user_logic(this);
	}
}

