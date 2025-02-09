package it.polito.tdp.lab05.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammiDAO {

	public boolean isCorrect(String anagramma) {
		
		String sql="SELECT nome"
					+ "FROM parola"
					+ "WHERE nome=?";
		
		boolean result;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				result=true;
			}
			else {
				result=false;
			}

			conn.close();

			return result;
			

		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException("Errore Db", e);
			return false;
		}
	
	}
}
