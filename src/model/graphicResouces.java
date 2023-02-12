package model;

import java.io.File;

import libreria.generica;

public class graphicResouces {

	private generica<File,File> Resouces;
	
	public graphicResouces() {
		super();
		Resouces = new generica<File,File>();
	}

	public String logo() {
		Resouces.setAtributoT1(new File("RecursosGraficos/Icon/logo.png"));
		return Resouces.getAtributoT1().getAbsolutePath();
	}
}
