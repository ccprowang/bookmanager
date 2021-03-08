package com.wang.model;

public class Book {
	int id;//ͼ��id
	String BookName;//ͼ����
	String author;//����
	String isbn;//�Ա�
	float price;//�۸�
	String bookTypeId;//ͼ�������
	String bookDesc;//ͼ���������
	int number;//����
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Book(int id, String bookName, String author, String isbn, float price, String bookTypeId, String bookDesc,int number) {
		super();
		this.id = id;
		BookName = bookName;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.number=number;
	}
	public Book(String bookName, String author, String isbn, float price, String bookTypeId, String bookDesc, int number) {
		super();
		BookName = bookName;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.number = number;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", BookName=" + BookName + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", bookTypeId=" + bookTypeId + ", bookDesc=" + bookDesc + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public Book() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getisbn() {
		return isbn;
	}
	public void setisbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(String bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
}
