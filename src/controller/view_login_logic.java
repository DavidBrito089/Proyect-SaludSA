package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.doctor;
import model.paciente;
import model.query;
import view.login_interface;
import view.view_register_user;
import view_Admin.view_Admin_interface;
import view_doctor.view_doctor_interface;
import view_user.view_user_interface;

public class view_login_logic implements ActionListener,MouseListener,KeyListener,FocusListener{

	private login_interface li;
	private view_Admin_interface vai;
	private view_doctor_interface vdi;
	private view_user_interface vui;
	private query exeSQL;
	private view_register_user vr;
	private doctor doc;
	private paciente pas;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public view_login_logic(login_interface li) {
		this.li=li;
		this.li.txtNombreDeUsuario.addMouseListener(this);
		this.li.txtPassword.addMouseListener(this);
		li.txtNombreDeUsuario.addFocusListener(this);
		li.txtPassword.addFocusListener(this);
		li.txtPassword.addActionListener(this);
		this.li.btnIngresar.addMouseListener(this);
		this.li.btnCrear.addMouseListener(this);
		exeSQL = new query();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==li.btnIngresar) {
			li.lblIngresar.setSize(li.lblIngresar.getWidth(), li.lblIngresar.getHeight());
		}
	}
	
	public boolean loginAdm(boolean flag) {
		String sentencia=String.format("SELECT * FROM admins WHERE nom_user_admin='%s' AND password='%s';",li.txtNombreDeUsuario.getText(),String.valueOf(li.txtPassword.getPassword()));
		ResultSet res=exeSQL.consultas(sentencia);
		try {
			if(res.next()) {
				flag=true;
			}else {
				flag=false;
			}
			exeSQL.closeConn();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;
	}

	public boolean loginDoc(boolean flag) {
		String sentencia=String.format("SELECT * FROM medicos WHERE Correo='%s' AND Cedula='%s';",li.txtNombreDeUsuario.getText(),String.valueOf(li.txtPassword.getPassword()));
		ResultSet res=exeSQL.consultas(sentencia);
		try {
			if(res.next()) {
				flag=true;
				//String nombres, String Apellidos,String Correo,String fechaNacimineto,String especialidad,Long numeroCelular,String Direccion,Long cedula
				doc = new doctor(res.getString(2),
								res.getString(3),
								res.getString(4),
								res.getString(5),
								res.getString(6),
								Long.valueOf(res.getString(7)),
								res.getString(8),
								Long.valueOf(res.getString(9)));
			}else {
				flag=false;
			}
			exeSQL.closeConn();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;
	}
	
	public boolean loginCli(boolean flag) {
		String sentencia=String.format("SELECT * FROM pacientes WHERE correo='%s' AND password_pac='%s';",li.txtNombreDeUsuario.getText(),String.valueOf(li.txtPassword.getPassword()));
		ResultSet res=exeSQL.consultas(sentencia);
		try {
			if(res.next()) {
				flag=true;
				//int id,int ced,String nombre,String Apellido,String correo
				//,String fecha,String genero,String numeroTelf,String dire,String password
				pas = new paciente(Integer.valueOf(res.getString(1)),
									Integer.valueOf(res.getString(4)),
									res.getString(2),res.getString(3),
									res.getString(5),res.getString(6),
									res.getString(7),res.getString(8),
									res.getString(9),res.getString(10));
				System.out.println(pas.getApellido());
			}else {
				flag=false;
			}
			exeSQL.closeConn();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		if(e.getSource()==li.btnIngresar) {

			if(loginAdm(flag)){
				vai = new view_Admin_interface();
				vai.setVisible(true);
				li.dispose();
			}else if(loginDoc(flag)){
				vdi = new view_doctor_interface(doc);
				vdi.setVisible(true);
				li.dispose();
			}else if(loginCli(flag)) {
				vui = new view_user_interface(pas);
				vui.setVisible(true);
				li.dispose();
			}else {
				JOptionPane.showMessageDialog(li, "Credenciales Incorrectas");
			}
			

		}
		
		if(e.getSource()==li.btnCrear) {
		
			vr = new view_register_user();
			vr.setVisible(true);
			vr.toFront();
			vr.setAlwaysOnTop(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==li.btnIngresar) {
			li.btnIngresar.setBackground(new Color(192,192,192));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==li.btnIngresar) {
			li.btnIngresar.setBackground(Color.BLACK);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==li.txtPassword) {
			if(String.valueOf(li.txtPassword.getPassword()).equals("Contraseña")) {
				li.txtPassword.setForeground(Color.black);
				li.txtPassword.setText("");
			}
			if(li.txtNombreDeUsuario.getText().equals("")){
				li.txtNombreDeUsuario.setText("Nombre de usuario");
				li.txtNombreDeUsuario.setForeground(new Color(192, 192, 192));
			}
		}
		
		if(e.getSource()==li.txtNombreDeUsuario) {
			if(li.txtNombreDeUsuario.getText().equals("Nombre de usuario")) {
				li.txtNombreDeUsuario.setText("");
				li.txtNombreDeUsuario.setForeground(Color.black);
			}
			if(String.valueOf(li.txtPassword.getPassword()).equals("")) {
				li.txtPassword.setText("Contraseña");
				li.txtPassword.setForeground(new Color(192, 192, 192));
			}	
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
