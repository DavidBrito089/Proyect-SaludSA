package model;

import libreria.generica;

public class doctor {
	
	private generica <String,String> datosDoctor;
	private generica <String,String> datosDoctorS;
	private generica <Long,Long> numerosDoctor;
	


	public doctor(String nombres, String Apellidos,String Correo,String fechaNacimineto,String especialidad,Long numeroCelular,String Direccion,Long cedula) {
		datosDoctor = new generica<String,String> (nombres,Apellidos,Correo,Direccion);
		datosDoctorS = new generica<String,String>(fechaNacimineto,especialidad);
		numerosDoctor = new generica <Long,Long>(numeroCelular,cedula);
	}
	
	public void setNombres(String noms) {
		datosDoctor.setAtributoT1(noms);
	}
	
	public String getNombres() {
		return datosDoctor.getAtributoT1();
	}
	
	public void setApellidos(String apellidos) {
		datosDoctor.setAtributoT2(apellidos);
	}
	
	public String getApellidos() {
		return datosDoctor.getAtributoT2();
	}
	
	public void setFechaNacimiento(int dia, int mes,int anio) {
		datosDoctorS.setAtributoT1(String.valueOf(anio)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia));
	}
	public String getFechaNacimiento() {
		return datosDoctorS.getAtributoT1();
	}
	
	public void setEspecialidad(String especialidad) {
		datosDoctorS.setAtributoS1(especialidad);
	}
	
	public String getEspecialidad() {
		return datosDoctorS.getAtributoS1();
	}
	public void setCorreo(String cor) {
		datosDoctor.setAtributoS1(cor);
	}
	
	public String getCorreo() {
		return datosDoctor.getAtributoS1();
	}
	
	public void setDireccion(String dir) {
		datosDoctor.setAtributoS2(dir);
	}
	
	public String getDireccion() {
		return datosDoctor.getAtributoS2();
	}
	
	public void setNumCel(Long num) {
		numerosDoctor.setAtributoT1(num);
	}
	
	public Long getNumCel() {
		return numerosDoctor.getAtributoT1();
	}
	
	public void setNumCed(Long num) {
		numerosDoctor.setAtributoS1(num);
	}
	
	public Long getNumCed() {
		return numerosDoctor.getAtributoS1();
	}
	
	public String [] getArray() {
		String [] aux = {getNombres(),getApellidos(),getCorreo(),getFechaNacimiento(),getEspecialidad(),
				String.valueOf(getNumCel()),getDireccion(),String.valueOf(getNumCed())};
		return aux;
	}
}
