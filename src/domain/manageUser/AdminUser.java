package domain.manageUser;


public class AdminUser
{

	private int id;
	private int status;
	private String account;
	private String name;
	private String password;

	public AdminUser(){}
	public AdminUser(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public AdminUser(int id, int status, String account, String name, String password) {
		this.id = id;
		this.status = status;
		this.account = account;
		this.name = name;
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

