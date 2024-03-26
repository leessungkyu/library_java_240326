package Books;


import java.util.ArrayList;
import java.util.Scanner;

public class Book {
	  public  Scanner sc = new Scanner(System.in);
      private String bNo;
      private String bTitle;
      private String bAuthor;
      private String bGenre;
      private boolean bAvailable;
	  private ArrayList<Book> BookList = new ArrayList<>();	
      
    public Book(String no, String title, String Author, String Genre, boolean Available) {
    	bNo = no;
    	bTitle = title;
    	bAuthor = Author;
    	bGenre = Genre;
    	bAvailable = Available;
    }
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	} 
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public String getbGenre() {
		return bGenre;
	}
	public void setbGenre(String bGenre) {
		this.bGenre = bGenre;
	}
	public boolean isbAvailable() {
		return bAvailable;
	}
	public void setbAvailable(boolean bAvailable) {
		this.bAvailable = bAvailable;
	}
	
	public int sizeArray() {
		return BookList.size();
	}
	
    @Override
    public String toString() {
        return "도서번호: " + bNo + ", 제목: " + bTitle + ", 지은이: " + bAuthor + ", 장르: " + bGenre + ", 대출 가능 여부: " + (bAvailable ? "가능" : "불가능");
    } 
      
}
