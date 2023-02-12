package view_doctor;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;

import model.graphicResouces;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class PanelListaPacientes extends JPanel {


	public PanelListaPacientes() {
		setBackground(new Color(255, 255, 255));
		setBounds(10, 153, 1335, 557);
		setLayout(null);
		
		AbstractBorder redondear = new TextBubbleBorder(1,10);
		
		this.setBorder(redondear);
		
		File nw = new File("RecursosGraficos/videos/Comp 1000.jpg");
		ImageIcon icon = new ImageIcon(nw.getAbsolutePath());
		
		JLabel lblNewLabel_1 = new JLabel("Citas de hoy:");
		lblNewLabel_1.setFont(new Font("Product Sans", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 29, 187, 22);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(698, 62, 627, 384);
		add(scrollPane_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Citas Atendidas");
		lblNewLabel_1_1.setFont(new Font("Product Sans", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(698, 29, 187, 22);
		add(lblNewLabel_1_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane((Component) null);
		scrollPane_1_1.setBounds(33, 62, 627, 384);
		add(scrollPane_1_1);

	}
}
