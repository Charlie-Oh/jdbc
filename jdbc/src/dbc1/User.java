package dbc1;

public class User {
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="test";
	private String pwd="1111";
	
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPwd() {
		return pwd;
	}
}