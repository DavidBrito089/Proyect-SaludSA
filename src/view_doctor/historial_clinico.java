package view_doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.TitledBorder;

public class historial_clinico extends JPanel {
	public JTextField txt_edad;
	public JTextField txt_sexo;
	public JTextField txt_alergias;
	public JTextField txt_enfermedadesP;
	public JTextField txt_medicamentosIn;
	public JTextField txt_CedulaP;
	public JPanel btn_guardar;
	public JButton btn_buscar;
	public JTextPane text_tratamiento;
	public JTextField txt_operacionesR;

	
	public historial_clinico() {
		setBackground(new Color(255, 255, 255));
		this.setBounds(10, 153, 1335, 557);
		setLayout(null);
		
		AbstractBorder bords = new TextBubbleBorder(2,10); 
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(49, 107, 1224, 428);
		add(panel_1);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setFont(new Font("Product Sans", Font.PLAIN, 18));
		lblEdad.setBounds(22, 34, 69, 20);
		panel_1.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSexo.setBounds(127, 33, 69, 14);
		panel_1.add(lblSexo);
		
		JLabel lblAlergias = new JLabel("Alergias");
		lblAlergias.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlergias.setFont(new Font("Product Sans", Font.PLAIN, 18));
		lblAlergias.setBounds(992, 34, 95, 20);
		panel_1.add(lblAlergias);
		
		JLabel lblEnfermedadesPreexistentes = new JLabel("Enfermedades preexistentes");
		lblEnfermedadesPreexistentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnfermedadesPreexistentes.setFont(new Font("Product Sans", Font.PLAIN, 18));
		lblEnfermedadesPreexistentes.setBounds(894, 117, 285, 20);
		panel_1.add(lblEnfermedadesPreexistentes);
		
		JLabel lblMedicamentos = new JLabel("Medicamentos ingeridos");
		lblMedicamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicamentos.setFont(new Font("Product Sans", Font.PLAIN, 18));
		lblMedicamentos.setBounds(905, 202, 263, 19);
		panel_1.add(lblMedicamentos);
		
		txt_edad = new JTextField();
		txt_edad.setFont(new Font("Product Sans", Font.BOLD, 15));
		txt_edad.setEditable(false);
		txt_edad.setColumns(10);
		txt_edad.setBounds(84, 22, 44, 38);
		panel_1.add(txt_edad);
		
		txt_sexo = new JTextField();
		txt_sexo.setFont(new Font("Product Sans", Font.BOLD, 15));
		txt_sexo.setEditable(false);
		txt_sexo.setColumns(10);
		txt_sexo.setBounds(192, 22, 154, 38);
		panel_1.add(txt_sexo);
		
		txt_alergias = new JTextField();
		txt_alergias.setFont(new Font("Product Sans", Font.PLAIN, 11));
		txt_alergias.setColumns(10);
		txt_alergias.setBounds(859, 65, 348, 20);
		panel_1.add(txt_alergias);
		
		txt_enfermedadesP = new JTextField();
		txt_enfermedadesP.setFont(new Font("Product Sans", Font.PLAIN, 11));
		txt_enfermedadesP.setColumns(10);
		txt_enfermedadesP.setBounds(859, 148, 348, 20);
		panel_1.add(txt_enfermedadesP);
		
		txt_medicamentosIn = new JTextField();
		txt_medicamentosIn.setFont(new Font("Product Sans", Font.PLAIN, 11));
		txt_medicamentosIn.setColumns(10);
		txt_medicamentosIn.setBounds(859, 230, 348, 20);
		panel_1.add(txt_medicamentosIn);
		
		btn_guardar = new JPanel();
		btn_guardar.setBounds(975, 361, 141, 43);
		panel_1.add(btn_guardar);
		btn_guardar.setLayout(null);
		btn_guardar.setBackground(new Color(0, 128, 192));
		btn_guardar.setBorder(bords);
		
		JLabel lblGuarda = new JLabel("GUARDAR");
		lblGuarda.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuarda.setForeground(Color.WHITE);
		lblGuarda.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblGuarda.setBackground(Color.WHITE);
		lblGuarda.setBounds(0, 0, 141, 43);
		btn_guardar.add(lblGuarda);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Rerecetario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 75, 839, 342);
		panel_1.add(panel);
		panel.setLayout(null);
		
		text_tratamiento = new JTextPane();
		text_tratamiento.setBounds(10, 60, 404, 271);
		panel.add(text_tratamiento);
		text_tratamiento.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblMedicamento = new JLabel("Medicamento");
		lblMedicamento.setBounds(425, 28, 131, 30);
		panel.add(lblMedicamento);
		lblMedicamento.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedicamento.setFont(new Font("Product Sans", Font.PLAIN, 18));
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setBounds(10, 25, 141, 36);
		panel.add(lblTratamiento);
		lblTratamiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblTratamiento.setFont(new Font("Product Sans", Font.PLAIN, 18));
		
		JTextPane text_tratamiento_1 = new JTextPane();
		text_tratamiento_1.setBackground(Color.LIGHT_GRAY);
		text_tratamiento_1.setBounds(424, 60, 404, 271);
		panel.add(text_tratamiento_1);
		
		txt_operacionesR = new JTextField();
		txt_operacionesR.setFont(new Font("Product Sans", Font.PLAIN, 11));
		txt_operacionesR.setColumns(10);
		txt_operacionesR.setBounds(859, 317, 348, 20);
		panel_1.add(txt_operacionesR);
		
		JLabel lblOperacionesRealidas = new JLabel("Operaciones realidas");
		lblOperacionesRealidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacionesRealidas.setFont(new Font("Product Sans", Font.PLAIN, 18));
		lblOperacionesRealidas.setBounds(905, 289, 263, 19);
		panel_1.add(lblOperacionesRealidas);
		
		JLabel lblHistorial = new JLabel("Historial clinica ");
		lblHistorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorial.setFont(new Font("Product Sans", Font.BOLD, 20));
		lblHistorial.setBounds(587, 21, 174, 25);
		add(lblHistorial);
		
		JLabel lblNumeroDeCedula = new JLabel("Numero de cedula del paciente");
		lblNumeroDeCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroDeCedula.setBounds(1019, 37, 254, 25);
		add(lblNumeroDeCedula);
		
		JLabel lblInformacion = new JLabel("Informacion");
		lblInformacion.setFont(new Font("Product Sans", Font.BOLD, 18));
		lblInformacion.setBounds(49, 71, 119, 25);
		add(lblInformacion);
		
		txt_CedulaP = new JTextField();
		txt_CedulaP.setColumns(10);
		txt_CedulaP.setBounds(1076, 73, 197, 20);
		add(txt_CedulaP);
		
		File nw = new File("RecursosGraficos/Icon/lupa.png");
		ImageIcon icon = new ImageIcon(nw.getAbsolutePath());
		btn_buscar = new JButton();
		btn_buscar.setBounds(1031, 71, 35, 25);
		btn_buscar.setIcon(icon);
		add(btn_buscar);
	}
}