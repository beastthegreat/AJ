package pojos;

public class Voters {
	private int id;
	private String emailid;
	private String passwd;
	private Boolean voted;
	public Voters(int id, String emailid, String passwd, Boolean voted) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.passwd = passwd;
		this.voted = voted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Boolean getVoted() {
		return voted;
	}
	public void setVoted(Boolean voted) {
		this.voted = voted;
	}
	
	 @Override
	 public String toString() {
		 return "Voter [id= " + id + "emailid= "+ emailid + "Voted=  "+ voted +" ]";
		 
		 
	 }
	
	
	
	
}
