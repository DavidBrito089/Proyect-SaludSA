package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class validarER {
	public  boolean ValidarNombre(String Nombre) {
		return Nombre.matches("^([A-Z]{1}([a-z]|[áéíóú]|ñ){2,}[ ]?){2}$");		
	}

	public boolean ValidarNumeroCedula(String cedula) {
		boolean cedulaCorrecta = false;
		if (cedula.length() == 10)
		{
			int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
			if (tercerDigito < 6) {
				int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
				int verificador = Integer.parseInt(cedula.substring(9,10));
				int suma = 0;
				int digito = 0;
				for (int i = 0; i < (cedula.length() - 1); i++) {
					digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
					suma += ((digito % 10) + (digito / 10));
				}
				if ((suma % 10 == 0) && (suma % 10 == verificador)) {
					cedulaCorrecta = true;
				}
				else if ((10 - (suma % 10)) == verificador) {
					cedulaCorrecta = true;
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} else {
			cedulaCorrecta = false;
		}
		return cedulaCorrecta;
	}

	public  boolean ValidarApellido(String Apellido) {
		return Apellido.matches("^([A-Z]{1}([a-z]|[áéíóú]|ñ){2,}[ ]?){2}$");
	}

	public  boolean ValidarDia (String Dia){
		return Dia.matches("^((0)([1-9])|(1|2)([0-9]))|((3)[0-1])$"); 
	}

	public  boolean ValidarMes (String Mes){
		return Mes.matches("^([1-9])|(1)([0-2])$"); 
	}

	public  boolean ValidarAnio (String Anio){
		return Anio.matches("^(1|2)([0-9]{3})$"); 
	}
	
	public boolean validarFecha(String dia, String mes, String anio) {
        String fecha=dia+"/"+mes+"/"+anio;
		try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	
	public  boolean ValidarDireccion (String Direccion) {
		return Direccion.matches("^([A-Z]{1}([a-z]|[áéíóú]|ñ){2,}[,]?[-]?){1,}$");
	}

	public  boolean ValidarContraseña (String Contraseña) {
		return Contraseña.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
	}

	/*
	 * La contraseña debe tener al entre 8 y 16 caracteres,
	 *  al menos un dígito, al menos una minúscula y
	 *   al menos una mayúscula.
	 */


	public boolean ValidarTeleConvencional (String Tele_Convencional){
		return Tele_Convencional.matches("^(((02|03|06|04|07)?(2|3|6|4|7)[0-9]{6})|((09)([0-9]{8})))$"); 
	}

	public boolean ValidarCorreo(String Correo) {
		return Correo.matches("^[a-zA-Z0-9]{8,}$");
	}

}
