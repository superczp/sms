package domain;

import java.io.Serializable;

public class Teacher implements Serializable {
	private static final long serivalVersionUID=12345;

	private int id;
	private String accout;
	private String password;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher(int id, String accout, String password, String name) {
		super();
		this.id = id;
		this.accout = accout;
		this.password = password;
		this.name = name;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"\t"+this. accout+"\t"+this. password+"\t"+this. name;
	}
	public String show() {
		// TODO Auto-generated method stub
		return this.id+"#"+this. accout+"#"+this. password+"#"+this. name;
	}
}
