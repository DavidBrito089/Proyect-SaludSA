package model;

import libreria.generica;

public class enfermedadesPaciente extends paciente{

	private generica<String,String> enfermedades;
	
	public enfermedadesPaciente(int id, int ced, String nombre, String Apellido, String correo, String fecha,
			String genero, String numeroTelf, String dire, String password) {
		super(id, ced, nombre, Apellido, correo, fecha, genero, numeroTelf, dire, password);
		// TODO Auto-generated constructor stub
	}

}
