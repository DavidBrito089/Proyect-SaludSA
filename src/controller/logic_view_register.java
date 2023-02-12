package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.query;
import view.view_register_user;

public class logic_view_register implements MouseListener,ActionListener{

	private view_register_user vru;
	private String genero="";
	private query senSQL;
	private validarER val;
	
	public logic_view_register(view_register_user vru) {
		this.vru=vru;
		vru.btn_registrarse.addMouseListener(this);
		vru.rbtn_masc.addActionListener(this);
		vru.rbtn_fem.addActionListener(this);
		val = new validarER();
		senSQL = new query();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		/**
		 * Registra al usuario en la base de datos usando expresiones regulares
		 */
		if(e.getSource()==vru.btn_registrarse) {
			
			if(!val.ValidarNombre(vru.txt_nombres.getText())) {
				JOptionPane.showMessageDialog(vru, "Error en el nombre");
			}else if(!val.ValidarApellido(vru.txt_Apellidos.getText())) {
				JOptionPane.showMessageDialog(vru, "Error en el Apellido");
			}else if(!val.ValidarAnio(vru.txt_año.getText())) {
				JOptionPane.showMessageDialog(vru, "Error en el Año");
			}else if(!val.ValidarNumeroCedula(vru.txt_cedula.getText())) {
				JOptionPane.showMessageDialog(vru, "Error en numero de cedula");
			}else if(!val.ValidarMes(vru.txt_mes.getText())) {
				JOptionPane.showMessageDialog(vru, "Error en el mes");
			}else if(!val.ValidarDia(vru.txt_dia.getText())) {
				JOptionPane.showMessageDialog(vru, "Error en el dia");
			}else if(!val.ValidarDireccion(vru.txt_Direccion.getText())) {
				JOptionPane.showMessageDialog(vru, "Error en la Direccion");
			}else if(!val.ValidarContraseña(String.valueOf(vru.txt_Password.getPassword()))) {
				JOptionPane.showMessageDialog(vru, "Error en la Contraseña");
			}else if(!vru.txt_nombres.getText().equals("")&&!vru.txt_Apellidos.getText().equals("")&&!vru.txt_año.getText().equals("")
			   &&!vru.txt_dia.getText().equals("")&&!vru.txt_mes.getText().equals("")&&!vru.txt_Direccion.getText().equals("")&&!String.valueOf(vru.txt_Password.getPassword()).equals("")
			   &&!genero.equals("")) {
				String sentence = "INSERT INTO `pacientes`(`id`, `nombre`, `apellido`,`cedula`, `correo`, `fecha_nacimiento`, `genero`, `numero_telefono`, `direccion`, `password_pac`) "
						+ "VALUES (null,'"+vru.txt_nombres.getText()+"','"+vru.txt_Apellidos.getText()+"','"+vru.txt_cedula.getText()+"','"+vru.txt_Correo.getText()+"','"+vru.txt_año.getText()+"-"+vru.txt_mes.getText()+"-"+vru.txt_dia.getText()
						+"','"+genero+"','"+vru.txt_Telf.getText()+"','"+vru.txt_Direccion.getText()+"','"+String.valueOf(vru.txt_Password.getPassword())+"')";
				if(senSQL.operIUD(sentence)) {
					JOptionPane.showMessageDialog(vru, "Usuario Registrado");
					vru.dispose();
				}
				senSQL.closeConn();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vru.rbtn_masc) {
			genero="Masculino";
		}
		
		if(e.getSource()==vru.rbtn_fem) {
			genero="Femenino";
		}
	}

}
