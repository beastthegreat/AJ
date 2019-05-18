
package dao;

import pojos.Voters;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VotersDaoImpl implements votersdao {

	private Connection cn;
	private PreparedStatement pst1;

	public VotersDaoImpl() throws Exception {
		// get cn from DBUtils
		cn =fetchConnection();
		// pst1
		pst1 = cn.prepareStatement("select * from voters where emailid=? and passwd=?");
		System.out.println("dao created...");
	}
	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("dao cleaned up...");
	}
	
	@Override
	public Voters validateVoter(String emailid, String passwd) throws Exception {
		// set IN params
		pst1.setString(1, emailid);
		pst1.setString(2, passwd);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voters(rst.getInt(1),emailid, passwd, rst.getBoolean(4));
		}
		return null;
	}
	
	
	
	
	
	
	
}
