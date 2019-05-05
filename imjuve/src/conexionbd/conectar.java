package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Santh
 */
public class conectar {
	private String NombreBD = "imjuve.accdb";
	private String ConexionBD = "jbdc:odbc:Driver={Microsoft Access "
			+ "Driver (*mdb)};DBQ=" + this.NombreBD;
	private String SentenciaSQL;
	private Connection CanalBD;
	private Statement Instruccion;
	private ResultSet Resultado;
	
	public conectar(){
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		this.CanalBD = DriverManager.getConnection(this.ConexionBD);
		this.Instruccion = this.CanalBD.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(SQLException SQLE){
			JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
		}
		catch(ClassNotFoundException CNFE){
			JOptionPane.showMessageDialog(null, "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
		}
	}
}


