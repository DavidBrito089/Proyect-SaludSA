package controller;

import java.awt.Color;import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import model.doctor;
import model.graphicResouces;
import model.query;
import view_Admin.PanelAsignacionHorarios;
import view_Admin.PanelDatosPaciente;
import view_Admin.PanelRegistroDoctor;
import view_Admin.view_Admin_interface;

public class view_Admin_logic implements ActionListener,MouseListener,AncestorListener,FocusListener,ItemListener{

	private view_Admin_interface vai;
	private graphicResouces gr;
	private PanelRegistroDoctor rd;
	private PanelAsignacionHorarios ah;
	private PanelDatosPaciente dp;
	private String doctorActual;
	private query senSQL;
	private ArrayList <String> Horario;
	private int finalNum=0;
	private validarER val;
	
	public view_Admin_logic(view_Admin_interface vai) {
		this.vai=vai;
		this.vai.btnGestionPacientes.addMouseListener(this);
		this.vai.btnGestionDeHorarios.addMouseListener(this);
		this.vai.btnRegistroDoctores.addMouseListener(this);		
		vai.btnCerrar.addMouseListener(this);
		this.rd = new PanelRegistroDoctor();
		this.ah = new PanelAsignacionHorarios();
		this.dp = new PanelDatosPaciente();
		this.dp.btn_editar.addMouseListener(this);
		this.dp.btn_buscar.addMouseListener(this);
		this.rd.tbl_doctores.addAncestorListener(this);
		this.rd.btnAgregar.addMouseListener(this);
		ah.tbl_horarios.addMouseListener(this);
		ah.select_doctor.addMouseListener(this);
		ah.btn_refresh.addActionListener(this);
		ah.select_doctor.addItemListener(this);
		senSQL = new query();
		ah.cargarHorario.addActionListener(this);
		cargarElementosGraficos();
		ImplementosAsignacionHorarios();
		cargarEspecialidades();
		Horario=new ArrayList<String>();
		val = new validarER();
	}
	
	public void cargarElementosGraficos() {
		cargarLogo();
		cargarPanel();
		implementosDeDiseño();
		cargarRegistroDoctores();
	}
	public void cargarLogo() {
		gr = new graphicResouces();
		File nw = new File(gr.logo());
		ImageIcon icon = new ImageIcon(nw.getAbsolutePath());
		vai.lblLogo.setIcon(icon);
	}
	public void implementosDeDiseño() {
		vai.btnGestionDeHorarios.setCursor(new Cursor(vai.HAND_CURSOR));
		vai.btnGestionPacientes.setCursor(new Cursor(vai.HAND_CURSOR));
		vai.btnRegistroDoctores.setCursor(new Cursor(vai.HAND_CURSOR));
		vai.btnCerrar.setCursor(new Cursor(vai.HAND_CURSOR));
	}
	public void cargarPanel() {
		rd.panel.setVisible(false);
		ah.panel.setVisible(false);
		dp.panel.setVisible(true);
		vai.panelPrincipal.add(rd.panel);
		vai.panelPrincipal.add(ah.panel);
		vai.panelPrincipal.add(dp.panel);
		cargarPacientes();
	}
	
	private void cargarRegistroDoctores() {
		ResultSet buscar = null;
		String sentencia = "SELECT * FROM `medicos` WHERE 1";
		buscar = senSQL.consultas(sentencia);
		try {
			while(buscar.next()) {
					String [] data = {
							buscar.getString(1),
							buscar.getString(2),
							buscar.getString(3),
							buscar.getString(4),
							buscar.getString(5),
							buscar.getString(6),
							buscar.getString(7),
							buscar.getString(8)
					};
					ah.select_doctor.add(data[1]+" "+data[2]);
					finalNum=Integer.valueOf(buscar.getString(1));
					rd.model.addRow(data);
					doctorActual=data[1]+" "+data[2];
			}			
		} catch (SQLException e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		senSQL.closeConn();
		
		ah.sel_dia.add("Lunes");
		ah.sel_dia.add("Martes");
		ah.sel_dia.add("Miercoles");
		ah.sel_dia.add("Jueves");
		ah.sel_dia.add("Viernes");
		ah.sel_dia.add("Sabado");
		ah.sel_dia.add("Domingo");
	}
	
	 void cargarEspecialidades() {
		 rd.txtEspecialidad.add("Anestesiología");
		 rd.txtEspecialidad.add("Anatomía Patológica");
			rd.txtEspecialidad.add("Cardiología Clínica");
			rd.txtEspecialidad.add("Cardiología Intervencionista");
			rd.txtEspecialidad.add("Cirugía Pediátrica");
			rd.txtEspecialidad.add("Cirugía General");
			rd.txtEspecialidad.add("Cirugía Plástica y Reconstructiva");
			rd.txtEspecialidad.add("Angiología y Cirugía Vascular y Endovascular");
			rd.txtEspecialidad.add("Dermatología");
			rd.txtEspecialidad.add("Endoscopia");
			rd.txtEspecialidad.add("Gastroenterología");
			rd.txtEspecialidad.add("Ginegología");
			rd.txtEspecialidad.add("Hematología");
			rd.txtEspecialidad.add("Infectología");
			rd.txtEspecialidad.add("Rehabilitación");

	 }
	private void cargarPacientes() {
		ResultSet buscar = null;
		String sentencia = "SELECT * FROM `pacientes` WHERE 1";
		buscar = senSQL.consultas(sentencia);
		try {
			while(buscar.next()) {
					String [] data = {
							buscar.getString(2),
							buscar.getString(3),
							buscar.getString(4),
							buscar.getString(5),
							buscar.getString(6),
							buscar.getString(7)
					};
					dp.model.addRow(data);
			}
		} catch (SQLException e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		senSQL.closeConn();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ah.cargarHorario) {
			
			
			for(int i=0;i<Horario.size();i++) {
				String [] datos= Horario.get(i).split("-");
				String sentence = "INSERT INTO `horarios`(`id`, `medicos_id`, `Horario`) VALUES (null,"+idMedicos()+",'"+Horario.get(i)+"')";			
				senSQL.operIUD(sentence);
				senSQL.closeConn();
				ah.tbl_horarios.setValueAt(ah.select_doctor.getSelectedItem(),Integer.valueOf(datos[0]) , Integer.valueOf(datos[1]));
				
			}
		}
		
		if(e.getSource()==ah.btn_refresh ) {
			ah.model = new DefaultTableModel();
			ah.model.addColumn("HORA");
			ah.model.addColumn("LUNES");		
			ah.model.addColumn("MARTES");
			ah.model.addColumn("MIERCOLES");
			ah.model.addColumn("JUEVES");
			ah.model.addColumn("VIERNES");
			ah.model.addColumn("SABADO");
			ah.model.addColumn("DOMINGO");
			setHoras();
			ah.tbl_horarios.setModel(ah.model);
			cargarHorario();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vai.btnCerrar) {
			vai.dispose();
		}
		if(e.getSource()==vai.btnRegistroDoctores) {			
			rd.panel.setVisible(true);
			ah.panel.setVisible(false);
			dp.panel.setVisible(false);
		}
		if(e.getSource()==vai.btnGestionPacientes) {
			rd.panel.setVisible(false);
			ah.panel.setVisible(false);
			dp.panel.setVisible(true);
		}
		if(e.getSource()==vai.btnGestionDeHorarios ) {
			rd.panel.setVisible(false);
			ah.panel.setVisible(true);
			dp.panel.setVisible(false);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		
		if(e.getSource()==rd.btnAgregar) {
			if(!val.ValidarNombre(rd.txtNombres.getText())) {
				JOptionPane.showMessageDialog(rd, "Error en el nombre");
			}else if(!val.ValidarApellido(rd.txtApellidos.getText())) {
				JOptionPane.showMessageDialog(rd, "Error en el Apellido");
			}else if(!val.ValidarCorreo(rd.txtCorreoElectronico.getText())) {
				JOptionPane.showMessageDialog(rd, "Error en el Correo Electronico");
			}else if(!val.validarFecha(rd.sp_dia.getValue().toString(), rd.sp_mes.getValue().toString(), rd.sp_año.getValue().toString())) {
				JOptionPane.showMessageDialog(rd, "Error en la Fecha");
			}else if(!val.ValidarTeleConvencional(rd.txtNumeroCelular.getText())) {
				JOptionPane.showMessageDialog(rd, "Error en el Numero De Celular");
			}else if(!val.ValidarDireccion(rd.txtDireccion.getText())) {
				JOptionPane.showMessageDialog(rd, "Error en la Direccion");
			}else if(!val.ValidarNumeroCedula(rd.txtCedula.getText())) {
				JOptionPane.showMessageDialog(rd, "Error en el Numero de Cedula");
			}else if(!rd.txtNombres.getText().equals("")&&!rd.txtApellidos.getText().equals("")&&!rd.txtCorreoElectronico.getText().equals("")&&!rd.sp_año.getValue().toString().equals("")
					&&!rd.sp_mes.getValue().toString().equals("")&&!rd.sp_dia.getValue().toString().equals("")&&!rd.txtNumeroCelular.getText().equals("")&&!rd.txtDireccion.getText().equals("")
					&&!rd.txtCedula.getText().equals("")) {
				String sentencia = "INSERT INTO medicos (`id`, `nombre`, `apellido`, `Correo`, `fecha_nacimiento`, `especialidad`, `numero_telefono`, `direccion`, `Cedula`) "
						+ "VALUES (null,'"+
						rd.txtNombres.getText()+"','"+
						rd.txtApellidos.getText()+ "', '"+
						rd.txtCorreoElectronico.getText()+"@"+rd.direcCorreo.getSelectedItem()+ "', '"+
						rd.sp_año.getValue()+"-"+rd.sp_mes.getValue()+"-"+rd.sp_dia.getValue()+ "', '"+
						rd.txtEspecialidad.getSelectedItem()+ "', '"+
						rd.txtNumeroCelular.getText()+"', '"+
						rd.txtDireccion.getText()+ "', '"+
						Long.valueOf(rd.txtCedula.getText())+"'); ";
				if(senSQL.operIUD(sentencia)) {
					JOptionPane.showMessageDialog(null, "Registro Exitoso");
				}
				senSQL.closeConn();
				finalNum++;
				ah.select_doctor.add(rd.txtNombres.getText() + " " + rd.txtApellidos.getText());
				String [] data = {String.valueOf(finalNum), rd.txtNombres.getText(),rd.txtApellidos.getText(),rd.txtCorreoElectronico.getText()+"@"+rd.direcCorreo.getSelectedItem(),
						rd.sp_año.getValue()+"-"+rd.sp_mes.getValue()+"-"+rd.sp_dia.getValue(),rd.txtEspecialidad.getSelectedItem(),rd.txtNumeroCelular.getText()
						,rd.txtDireccion.getText()};
				rd.model.addRow(data);
			}else {
				JOptionPane.showMessageDialog(null,"ERROR CAMPOS SIN LLENAR");
			}
		}
		
		if(e.getSource()==dp.btn_buscar) {
			ResultSet buscar = null;
			String sentence = "SELECT `id`, `nombre`, `apellido`, `cedula`, `correo`, `fecha_nacimiento`, `genero`, `numero_telefono`, `direccion`, `password_pac` "
					+ "FROM `pacientes` WHERE cedula LIKE '%"+dp.txt_cedula.getText()+ "%'";
			buscar = senSQL.consultas(sentence);
			try {
				while(buscar.next()) {
					dp.txt_nombres.setText(buscar.getString(2));
					dp.txt_Apellidos.setText(buscar.getString(3));
					dp.txt_cedula.setText(buscar.getString(4));
					dp.txt_Correo.setText(buscar.getString(5));
					if(buscar.getString(7).equals("Masculino")) {
						dp.rbtn_masc.setSelected(true);
					}else if(buscar.getString(7).equals("Femenino")) {
						dp.rbtn_fem.setSelected(true);
					}
					dp.txt_Telf.setText(buscar.getString(8));
					dp.txt_Direccion.setText(buscar.getString(9));
					dp.txt_Password.setText(buscar.getString(10));
				}
			} catch (SQLException e1){
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			senSQL.closeConn();
		}
		
		if (e.getSource()==dp.btn_editar) {
			
			String sentencia = "UPDATE pacientes SET password_pac = '"+
					String.valueOf(dp.txt_Password.getPassword())+"' WHERE cedula = '"+dp.txt_cedula.getText()+"'";
			
			if(senSQL.operIUD(sentencia)) {
				JOptionPane.showMessageDialog(vai, "Contraseña cambiada");
			}
			senSQL.closeConn();
		}
		
		if(e.getSource()==ah.tbl_horarios) {
			int fila = ah.tbl_horarios.getSelectedRow();
			int columna = ah.tbl_horarios.getSelectedColumn();
			
			String horaSeleccionada=String.valueOf(ah.tbl_horarios.getModel().getValueAt(fila, 0));
			String DiaSeleccionada=String.valueOf(ah.tbl_horarios.getModel().getColumnName(columna));

			
			Horario.add(String.valueOf(fila)+"-"+String.valueOf(columna)+"-"+horaSeleccionada+"-"+DiaSeleccionada+"-"+ah.select_doctor.getSelectedItem());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vai.btnGestionPacientes ) {
			vai.btnGestionPacientes.setBackground(Color.gray);
		}
		if(e.getSource()==dp.btn_buscar) {
			dp.btn_buscar.setBackground(Color.gray);
		}
		if(e.getSource()==vai.btnGestionDeHorarios) {
			vai.btnGestionDeHorarios.setBackground(Color.gray);
		}
		if(e.getSource()==vai.btnRegistroDoctores ) {
			vai.btnRegistroDoctores.setBackground(Color.gray);
		}
		if(e.getSource()==vai.btnCerrar) {
			vai.btnCerrar.setBackground(Color.white);
			vai.lblCerrar.setForeground(Color.black);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==dp.btn_buscar) {
			dp.btn_buscar.setBackground(Color.black);
		}
		if(e.getSource()==vai.btnGestionPacientes ) {
			vai.btnGestionPacientes.setBackground(Color.black);
		}
		if(e.getSource()==vai.btnGestionDeHorarios) {
			vai.btnGestionDeHorarios.setBackground(Color.black);
		}
		if(e.getSource()==vai.btnRegistroDoctores ) {
			vai.btnRegistroDoctores.setBackground(Color.black);
		}
		if(e.getSource()==vai.btnCerrar) {
			vai.btnCerrar.setBackground(Color.red);
			vai.lblCerrar.setForeground(Color.white);
		}
	}

	public void ImplementosAsignacionHorarios() {
		setHoras();
	}
	
	public void setHoras() {
		
		for(int i = 0 ; i <=24; i++) {
			if(i>=0 && i<10) {
				ah.sel_hora.add("0"+i+":00");
				ah.sel_horasal .add("0"+i+":00");
				String [] st = {"0"+i+":00"};
				ah.model.addRow(st);
			}else {
				ah.sel_hora.add(i+":00");
				ah.sel_horasal.add(i+":00");
				String [] st = {i+":00"};
				ah.model.addRow(st);
			}			
		}
	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ancestorMoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	}
	public void cargarHorario() {
		ResultSet res= null;
		String  sentence = "SELECT `Horario` FROM `horarios` WHERE `medicos_id`="+idMedicos();
		res=senSQL.consultas(sentence);
		try {
			while(res.next()){
				String [] data = res.getString(1).split("-");
				ah.tbl_horarios.setValueAt(ah.select_doctor.getSelectedItem(), Integer.valueOf(data[0]), Integer.valueOf(data[1]));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		senSQL.closeConn();
	}
	
	private int idMedicos() {
		ResultSet buscar = null;
		int aux=0;
		String [] nombres= ah.select_doctor.getSelectedItem().split(" ");
		
		String sentencia = "SELECT id FROM `medicos` WHERE nombre='"+nombres[0]+"' AND apellido='"+nombres[1]+"'";
		buscar = senSQL.consultas(sentencia);
		try {
			while(buscar.next()) {
						aux=Integer.valueOf(buscar.getString(1));
			}			
		} catch (SQLException e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		senSQL.closeConn();
		return aux;
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ah.select_doctor) {
			ah.model = new DefaultTableModel();
			ah.model.addColumn("HORA");
			ah.model.addColumn("LUNES");		
			ah.model.addColumn("MARTES");
			ah.model.addColumn("MIERCOLES");
			ah.model.addColumn("JUEVES");
			ah.model.addColumn("VIERNES");
			ah.model.addColumn("SABADO");
			ah.model.addColumn("DOMINGO");
			setHoras();
			ah.tbl_horarios.setModel(ah.model);
			cargarHorario();
		}
	}
}
