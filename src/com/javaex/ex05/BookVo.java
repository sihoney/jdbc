package com.javaex.ex05;

public class BookVo {

	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	/*
	private String authorId;
	private String authorName;
	private String authorDesc;
	*/
	
	public BookVo() {
		
	}
	
	public BookVo(int bookId, String title, String pubs, String pubDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate + "]";
	}
	
	
}
