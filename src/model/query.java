package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class query extends connection{

	public ResultSet consultas(String sentenciaSelect) {
		try {
			stmt =(Statement)openConn().createStatement();
			res=stmt.executeQuery(sentenciaSelect);
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Consultas"+e);
		}
		return res;
	}
	
	public boolean operIUD(String senIUD) {
		try {
			stmt = (Statement) openConn().createStatement();
			stmt.executeUpdate(senIUD);
			this.closeConn();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Operaciones IUD:"+e);
			return false;
		}
		
	}
	
}