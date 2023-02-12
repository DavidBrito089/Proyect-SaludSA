package view_doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import controller.view_doctor_logic;
import model.doctor;
import view.login_interface;


public class view_doctor_interface extends JFrame {

	private JPanel contentPane;
	public JLabel lblLogo;
	public JPanel btnCerrar;
	public JLabel lblCerrar;
	public JPanel btnGestionCitas;
	public JPanel btnHistoriaClinica;
	public JLabel lbl_nomdoctor;
	public JPanel panelPrincipal;
	private login_interface li;
	private view_doctor_logic vdl;
	public doctor doc;

	
	public view_doctor_interface(doctor doc) {
		this.doc=doc;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1355, 720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Timer timer = new Timer(10, new MyTimerActionListener(this));
		timer.start();
		
		RoundRectangle2D.Float roundedRectangle = 
		new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 30, 30);
		setShape(roundedRectangle);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(192, 192, 192));
		panelPrincipal.setBounds(0, 0, 1366, 720);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(0, 0, 1648, 26);
		panelPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		btnCerrar = new JPanel();
		btnCerrar.setLayout(null);
		btnCerrar.setBackground(new Color(255, 128, 128));
		btnCerrar.setBorder(bords);
		btnCerrar.setBounds(1285, -2, 67, 29);
		panel_1.add(btnCerrar);
		
		lblCerrar = new JLabel("X");
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setForeground(new Color(0, 0, 0));
		lblCerrar.setFont(new Font("Product Sans", Font.BOLD, 13));
		lblCerrar.setBounds(0, -2, 67, 42);
		btnCerrar.add(lblCerrar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(0, 26, 1366, 117);
		panelPrincipal.add(panel_2);
		panel_2.setLayout(null);
		
		btnGestionCitas = new JPanel();
		btnGestionCitas.setBackground(new Color(0, 64, 128));
		btnGestionCitas.setBounds(370, 77, 288, 40);
		panel_2.add(btnGestionCitas);
		btnGestionCitas.setLayout(null);
		btnGestionCitas.setBorder(bords);
		
		JLabel lblNewLabel_1 = new JLabel("Gestión de citas");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 4, 288, 40);
		btnGestionCitas.add(lblNewLabel_1);
		
		btnHistoriaClinica = new JPanel();
		btnHistoriaClinica.setLayout(null);
		btnHistoriaClinica.setBackground(new Color(0, 64, 128));
		btnHistoriaClinica.setBounds(657, 77, 288, 40);
		btnHistoriaClinica.setBorder(bords);
		panel_2.add(btnHistoriaClinica);
		
		JLabel lblNewLabel_1_1 = new JLabel("Historia Clínica");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Product Sans", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(0, 4, 288, 40);
		btnHistoriaClinica.add(lblNewLabel_1_1);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(38, 617, 206, 71);
		panel_2.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_nomdoctor = new JLabel("DOCTOR");
		lbl_nomdoctor.setForeground(new Color(255, 255, 255));
		lbl_nomdoctor.setFont(new Font("Product Sans", Font.BOLD, 17));
		lbl_nomdoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nomdoctor.setBounds(0, 0, 1356, 66);
		panel_2.add(lbl_nomdoctor);
		
		vdl = new view_doctor_logic(this);
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
	    	        }
	    	        miVentana.setOpacity(opacity);
	    	    } else {
	    	        ((Timer)e.getSource()).stop();
	    	    }	    	 
	    }
	    
	}
}
