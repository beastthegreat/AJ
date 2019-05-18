package dao;
import pojos.Voters;
public interface votersdao {

	Voters validateVoter(String email, String passwd) throws Exception;
	
}
