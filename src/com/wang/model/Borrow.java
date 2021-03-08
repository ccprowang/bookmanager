package com.wang.model;

import java.sql.Date;

public class Borrow {
    int userid;
    int bookid;
    Date borrowdate;
    Date returnDate;
    
    public Borrow(Date borrowdate, Date returnDate) {
		super();
		this.borrowdate = borrowdate;
		this.returnDate = returnDate;
	}
	public Borrow() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public int getUserid() {
		return userid;
	}
	public Borrow(int userid, int bookid, Date borrowdate, Date returnDate) {
		super();
		this.userid = userid;
		this.bookid = bookid;
		this.borrowdate = borrowdate;
		this.returnDate = returnDate;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
}
