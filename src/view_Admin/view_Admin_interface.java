package view_Admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;
import controller.view_Admin_logic;
import view.login_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class view_Admin_interface extends JFrame {

	private JPanel contentPane;
	public JLabel lblLogo;
	public JPanel btnCerrar;
	public JLabel lblCerrar;
	public JPanel btnGestionPacientes;
	public JPanel btnGestionDeHorarios;
	public JPanel btnRegistroDoctores;
	private view_Admin_logic val;
	private JLabel lblNewLabel;
	public JPanel panelPrincipal;
	private login_interface li;

	public view_Admin_interface() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("RecursosGraficos\\Icon\\Recurso 3@2x.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				li = new login_interface();
				li.toFront();
				li.setVisible(true);
			}
		});
		
		AbstractBorder bords = new TextBubbleBorder(2,10);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1355, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		RoundRectangle2D.Float roundedRectangle = 
		new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 30, 30);
		setShape(roundedRectangle);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 255, 255));
		panelPrincipal.setBounds(0, 0, 1360, 720);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(287, 0, 1110, 26);
		panelPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		btnCerrar = new JPanel();
		btnCerrar.setLayout(null);
		btnCerrar.setBackground(new Color(255, 0, 0));
		btnCerrar.setBorder(bords);
		btnCerrar.setBounds(1000, -4, 67, 29);
		panel_1.add(btnCerrar);
		
		lblCerrar = new JLabel("X");
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setForeground(new Color(255, 255, 255));
		lblCerrar.setFont(new Font("Product Sans", Font.BOLD, 13));
		lblCerrar.setBounds(0, 11, 57, 20);
		btnCerrar.add(lblCerrar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 230));
		panel_2.setBounds(0, 0, 289, 728);
		panelPrincipal.add(panel_2);
		panel_2.setLayout(null);
		
		btnGestionPacientes = new JPanel();
		btnGestionPacientes.setBackground(new Color(0, 0, 0));
		btnGestionPacientes.setBounds(0, 119, 288, 40);
		panel_2.add(btnGestionPacientes);
		btnGestionPacientes.setLayout(null);
		btnGestionPacientes.setBorder(bords);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion  de  Pacientes");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 4, 288, 40);
		btnGestionPacientes.add(lblNewLabel_1);
		
		btnGestionDeHorarios = new JPanel();
		btnGestionDeHorarios.setLayout(null);
		btnGestionDeHorarios.setBackground(Color.BLACK);
		btnGestionDeHorarios.setBounds(0, 157, 288, 40);
		btnGestionDeHorarios.setBorder(bords);
		panel_2.add(btnGestionDeHorarios);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gestion de Horarios");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(0, 4, 288, 40);
		btnGestionDeHorarios.add(lblNewLabel_1_1);
		
		btnRegistroDoctores = new JPanel();
		btnRegistroDoctores.setLayout(null);
		btnRegistroDoctores.setBackground(Color.BLACK);
		btnRegistroDoctores.setBounds(0, 196, 288, 40);
		btnRegistroDoctores.setBorder(bords);
		panel_2.add(btnRegistroDoctores);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Registro de Doctores");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(0, 4, 288, 40);
		btnRegistroDoctores.add(lblNewLabel_1_1_1);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(38, 617, 206, 71);
		panel_2.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel = new JLabel("ADMINISTRADOR");
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 25, 269, 83);
		panel_2.add(lblNewLabel);
		
		Timer timer = new Timer(10, new MyTimerActionListener(this));
		timer.start();
		
		val =new view_Admin_logic(this);
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
