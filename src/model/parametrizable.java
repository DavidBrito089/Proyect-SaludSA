package model;

public interface parametrizable {

	public final String ip = "localhost", 
			port="3306",
			bbdd="consultorio",
			user= "root",
			psw="",
			driver="com.mysql.cj.jdbc.Driver";
	public default String getURL() {
		return "jdbc:mysql://"+ip+":"+port+"/"+bbdd+"?user="+user+"&password="+psw+"&useSSL=false&serverTimeZone=UTC";
	}
}
