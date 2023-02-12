package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.query;
import view_user.view_user_interface;

public class view_user_logic implements ActionListener,MouseListener,ItemListener{
	
	private view_user_interface vr;
	private query senSQL;
	private int actualid;

	public view_user_logic(view_user_interface vr) {
		this.vr=vr;
		senSQL = new query();
		vr.lblAgendar.addMouseListener(this);
		vr.cbo_especialidad.addItemListener(this);
		vr.cbo_doctor.addItemListener(this);
		vr.cbo_horario.addItemListener(this);
		cargarEspecialidades();		
		vr.lbl_bienvenida.setText(vr.lbl_bienvenida.getText()+vr.pas.getNombre()+" "+vr.pas.getApellido());
	}
	
	public void cargarHorarioDoctor() {
		ResultSet res = null;		
		String Sentencia = "SELECT `Horario` FROM `horarios` WHERE `medicos_id` = " + actualid;
		res=senSQL.consultas(Sentencia);
		try {
			while ( res.next() ) {
				String [] horario = res.getString(1).split("-") ;				
				vr.cbo_horario.add(horario[2]+" "+horario[3]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		senSQL.closeConn();
	}
	
	public void cargarDoctores() {
		ResultSet res = null;
		String Sentencia = "SELECT nombre,apellido,id FROM `medicos` WHERE especialidad = '"+vr.cbo_especialidad.getSelectedItem()+"'" ;
		res=senSQL.consultas(Sentencia);
		try {
			while ( res.next() ) {
				vr.cbo_doctor.add(res.getString(1)+" "+res.getString(2));
				actualid=Integer.valueOf(res.getString(3));
				System.out.println(actualid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		senSQL.closeConn();
	}

	private void cargarEspecialidades() {
		vr.cbo_especialidad.add("Anestesiología");
		vr.cbo_especialidad.add("Anatomía Patológica");
		vr.cbo_especialidad.add("Cardiología Clínica");
		vr.cbo_especialidad.add("Cardiología Intervencionista");
		vr.cbo_especialidad.add("Cirugía Pediátrica");
		vr.cbo_especialidad.add("Cirugía General");
		vr.cbo_especialidad.add("Cirugía Plástica y Reconstructiva");
		vr.cbo_especialidad.add("Angiología y Cirugía Vascular y Endovascular");
		vr.cbo_especialidad.add("Dermatología");
		vr.cbo_especialidad.add("Endoscopia");
		vr.cbo_especialidad.add("Gastroenterología");
		vr.cbo_especialidad.add("Ginegología");
		vr.cbo_especialidad.add("Hematología");
		vr.cbo_especialidad.add("Infectología");
		vr.cbo_especialidad.add("Rehabilitación");
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
		if(e.getSource()==vr.lblAgendar) {
			if(vr.cbo_especialidad.getSelectedItem()!=null&&vr.cbo_doctor.getSelectedItem()!=null&&vr.cbo_horario.getSelectedItem()!=null) {
				Date date = new Date();
				try {
		            String str = "					---------------------------------------------------------------------------\n"+
		            			 "					----------------------------     SALUD-SA    ------------------------------\n"+
		            			 "					Fecha de generacion:  "+date.toString()+"\n"+			   
		            			 "					Fecha Atencion:  "+vr.cbo_horario.getSelectedItem() +"\n"+			   
		            			 "					Especialidad:  "+ vr.cbo_especialidad.getSelectedItem() +"\n"+
		            			 "					Doctor: "+ vr.cbo_doctor.getSelectedItem() +"\n"+	
		            			 "					---------------------------------------------------------------------------\n"+
		            			 "					Paciente: "+ vr.pas.getNombre()+" "+ vr.pas.getApellido() +"\n"+	
		            			 "					Documento: "+ vr.pas.getCed() +"\n"	+
		            			 "					Correo: "+ vr.pas.getCorreo() +"\n"	
		            			 					+"\n\n\n"+	
		            			 "					---------------------------------------------------------------------------\n";;
		    			  
		    		vr.IMPRESION.setText(str);
		            // Crear un objeto Document
		            Document document = new Document();

		            // Crear un objeto PdfWriter
		            PdfWriter.getInstance(document, new FileOutputStream("citaMedica.pdf"));

		            // Abrir el documento
		            document.open();

		            // Agregar el string como un párrafo al documento
		            document.add(new Paragraph(str));

		            // Cerrar el documento
		            document.close();
            
		            
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
				labelAnimation timer = new labelAnimation(vr.lblAgendar);
				timer.start();
				

		            int result = JOptionPane.showConfirmDialog(null, "¿Desea abrir el pdf?", "Confirmación", JOptionPane.YES_NO_OPTION);
		            if (result == JOptionPane.YES_OPTION) {
		            	try {
							Desktop.getDesktop().open(new File("citaMedica.pdf"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            }
				

			}else {
				JOptionPane.showMessageDialog(vr, "ERROR NO HA SELECCIONADO TODOS LOS CAMPOS");
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
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vr.cbo_especialidad) {
			vr.cbo_doctor .removeAll();
			vr.cbo_horario.removeAll();
			cargarDoctores();
			cargarHorarioDoctor();
		}
	}
class labelAnimation extends Thread{
		
		private JLabel l;
		private ImageIcon icon;
		private File nw;
		
		public labelAnimation(JLabel l) {
			this.l = l;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for ( int i = 0; i<198 ;i++) {
				if(i<10) {
					 nw = new File("RecursosGraficos/videos/Comp 100"+i+".jpg");
					 icon = new ImageIcon(nw.getAbsolutePath());
					 l.setIcon(icon);
				}else if(i<100) {
					 nw = new File("RecursosGraficos/videos/Comp 10"+i+".jpg");
					 icon = new ImageIcon(nw.getAbsolutePath());
				}else if(i<200) {
					 nw = new File("RecursosGraficos/videos/Comp 1"+i+".jpg");
					 icon = new ImageIcon(nw.getAbsolutePath());
				}
				l.setIcon(icon);
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
