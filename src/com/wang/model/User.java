package com.wang.model;
/**
 * �û�ʵ����
 * @author yefeng
 *
 */
public class User {
	private int id;//���
	private String usernamee;//�û���
	private String  password;//����
    private String status;//����֤״̬
    private String sex;//�Ա�
    private String readertype;//�������
	public User(String usernamee, String password) {
		super();
		this.usernamee = usernamee;
		this.password = password;
	}
	public User() {
		super();
	}
	
	public User(int id, String usernamee, String status, String sex,String readertype) {
		super();
		this.id = id;
		this.usernamee = usernamee;
		this.status = status;
		this.sex = sex;
		this.readertype = readertype;
	}
	public User(String usernamee, String password,String sex, String readertype) {
		super();
		this.usernamee = usernamee;
		this.password = password;
		//this.status = status;
		this.sex = sex;
		this.readertype = readertype;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usernamee=" + usernamee + ", password=" + password + ", status=" + status + ", sex="
				+ sex + ", readertypeid=" + readertype + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getReadertype() {
		return readertype;
	}
	public void setReadertype(String readertype) {
		this.readertype = readertype;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsernamee() {
		return usernamee;
	}
	public void setUsernamee(String usernamee) {
		this.usernamee = usernamee;
	}
	public String getPwd() {
		return password;
	}
	public void setPwd(String password) {
		this.password = password;
	}
	
	
}
