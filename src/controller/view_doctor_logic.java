package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.query;
import view_doctor.PanelListaPacientes;
import view_doctor.historial_clinico;
import view_doctor.view_doctor_interface;

public class view_doctor_logic implements ActionListener,MouseListener {

	private view_doctor_interface vdi;
	private PanelListaPacientes doc;
	private historial_clinico hc;
	private query senSQL;
	
	public view_doctor_logic(view_doctor_interface vdi) {
		this.vdi = vdi;
		vdi.lblCerrar.addMouseListener(this);
		vdi.btnGestionCitas.addMouseListener(this);
		vdi.btnHistoriaClinica.addMouseListener(this);
		this.doc = new PanelListaPacientes();
		this.vdi.panelPrincipal.add(doc);
		this.hc = new historial_clinico();
		this.vdi.panelPrincipal.add(hc);
		hc.btn_guardar.addMouseListener(this);
		hc.btn_buscar.addActionListener(this);
		hc.setVisible(false);
		senSQL = new query();
		vdi.lbl_nomdoctor.setText(vdi.lbl_nomdoctor.getText()+": "+vdi.doc.getNombres()+" "+vdi.doc.getApellidos());
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vdi.lblCerrar) {
			vdi.dispose();
		}
		

		if(e.getSource()==hc.btn_guardar) {

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vdi.btnHistoriaClinica ) {
			doc.setVisible(false);
			hc.setVisible(true);
		}
		if(e.getSource()==vdi.btnGestionCitas) {
			doc.setVisible(true);
			hc.setVisible(false);
		}
		if(e.getSource()==hc.btn_guardar) {
			String sentence = "UPDATE `historiaclinica`"
					+ " SET `alergias`='"+hc.txt_alergias.getText()+"',`Enfermedades_pre_existentes`='"+hc.txt_enfermedadesP.getText()+"',"
					+ "`medicamentos ingeridos`='"+hc.txt_medicamentosIn .getText()+"',`operaciones_realizadas`='"+hc.txt_operacionesR .getText()+"',"
					+ "`tratamiento`='"+hc.text_tratamiento.getText()+"' WHERE cedula = "+hc.txt_CedulaP.getText();
			if(senSQL.operIUD(sentence)) {
				JOptionPane.showMessageDialog(vdi, "Datos Actualizados");
			}
			senSQL.closeConn();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vdi.lblCerrar) {
			vdi.lblCerrar.setForeground(Color.red);
		}
		if(e.getSource()==vdi.btnGestionCitas) {
			vdi.btnGestionCitas.setBackground(Color.blue);
		}
		
		if(e.getSource()==vdi.btnHistoriaClinica ) {
			vdi.btnHistoriaClinica.setBackground(Color.blue);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vdi.lblCerrar) {
			vdi.lblCerrar.setForeground(Color.black);
		}
		if(e.getSource()==vdi.btnGestionCitas) {
			vdi.btnGestionCitas.setBackground(new Color(0, 64, 128));
		}
		
		if(e.getSource()==vdi.btnHistoriaClinica ) {
			vdi.btnHistoriaClinica.setBackground(new Color(0, 64, 128));
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		hc.txt_sexo.setText("");
		if(e.getSource()==hc.btn_buscar) {
			ResultSet buscar = null;
			String sentence = "SELECT `cedula`,`genero`"
					+ "FROM `pacientes` WHERE cedula LIKE '%"+hc.txt_CedulaP.getText()+ "%'";
			buscar = senSQL.consultas(sentence);		
			
			try {
				while(buscar.next()) {
					hc.txt_CedulaP.setText(buscar.getString(1));
					hc.txt_sexo.setText(buscar.getString(2));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(hc.txt_sexo.getText().equals("")) {
				JOptionPane.showMessageDialog(doc, "No se ha encontrado el usuario");
			}else {
				hc.txt_alergias.setText("Ninguno");
				hc.txt_enfermedadesP.setText("Ninguno");
				hc.txt_medicamentosIn.setText("Ninguno");
				hc.txt_operacionesR.setText("Ninguno");
				cargarPacienteBasedeDatos();
				if(hc.txt_alergias.getText().equals("Ninguno")){
					String sentence3 = "INSERT INTO `historiaclinica`(`cedula`, `alergias`, `Enfermedades_pre_existentes`, `medicamentos ingeridos`, `operaciones_realizadas`, `tratamiento`)"
							+ "VALUES ('"+hc.txt_CedulaP.getText()+"','s/d','s/d','s/d','s/d','s/d')";
					if(senSQL.operIUD(sentence3)) {
						JOptionPane.showMessageDialog(vdi, "Registrado");
					}
					senSQL.closeConn();
				}
				cargarPacienteBasedeDatos();
			}

			
			senSQL.closeConn();
		}
	}
	
	public void cargarPacienteBasedeDatos() {
		ResultSet buscar2 = null;
		String sentence2 = "SELECT `cedula`, `alergias`, `Enfermedades_pre_existentes`, `medicamentos ingeridos`, `operaciones_realizadas`, `tratamiento` "
				+ "FROM `historiaclinica` WHERE  cedula ='"+hc.txt_CedulaP.getText()+ "'";
		buscar2 = senSQL.consultas(sentence2);		
		
		try {
			while(buscar2.next()) {
				hc.txt_CedulaP.setText(buscar2.getString(1));
				hc.txt_alergias.setText(buscar2.getString(2));
				hc.txt_enfermedadesP.setText(buscar2.getString(3));
				hc.txt_medicamentosIn.setText(buscar2.getString(4));
				hc.txt_operacionesR.setText(buscar2.getString(5));
				hc.text_tratamiento.setText(buscar2.getString(6));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
