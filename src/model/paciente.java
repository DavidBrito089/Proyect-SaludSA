package model;

import java.util.Date;

import libreria.generica;

public class paciente{

	private generica <Integer,String> datosPaciente;
	private generica <String,String> datosPacienteinter;
	private generica <String,String> direcandPass;
	
	
	public paciente (int id,int ced,String nombre,String Apellido,String correo
					,String fecha,String genero,String numeroTelf,String dire,String password) {
		datosPaciente = new generica <Integer,String>(id,ced,nombre,Apellido);
		datosPacienteinter = new generica<String,String>(correo,fecha,genero,numeroTelf);
		direcandPass = new generica<String,String>(dire,password);
	}
	
	public int getID() {
		return datosPaciente.getAtributoT1();
	}
	
	public int getCed() {
		return datosPaciente.getAtributoT2();
	}
	
	public String getNombre() {
		return datosPaciente.getAtributoS1();
	}
	
	public String getApellido() {
		return datosPaciente.getAtributoS2();
	}
	
	public String getCorreo() {
		return datosPacienteinter.getAtributoT1();
	}
	
	public String getFecha() {
		return datosPacienteinter.getAtributoT2();
	}
	
	public String getGenero() {
		return datosPacienteinter.getAtributoS1();
	}
	
	public String getNulTelf() {
		return datosPacienteinter.getAtributoS2();
	}
	
	public String getDireccion() {
		return direcandPass.getAtributoT1();
	}
	
	public String getPassword() {
		return direcandPass.getAtributoS1();
	}
	
	public String [] getDatosArray() {
		String [] dat = {String.valueOf(getID()),getNombre(),getApellido(),String.valueOf(getCed()),
						getCorreo(),getFecha(),getGenero(),getNulTelf(),getDireccion(),getPassword()};
		
		return dat;
	}
	
	public String citaMedica() {
		Date date = new Date();
		
		return "---------------------------------------------------------------------------\n"+
			   "---------------------------      SALUD-SA     -----------------------------\n"+
			   "Fecha de generacion:"+date.toString()+"\n"+
			   "PACIENTE:"+getNombre() +"\n"+
			   "DIRECCION: "+ getDireccion()+"\n\n\n"+			   
			   "---------------------------------------------------------------------------\n";
	}
}

