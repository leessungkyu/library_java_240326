package Books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class showMain {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Book> bookList = new ArrayList<>();
	public static void main(String[] args) {
    	while(true) {	   
		   System.out.println("---도서관프로그램---");
		   System.out.println("필요한 기능을 선택하십시오");
		   System.out.println("[1:도서등록, 2:전체조회, 3:개별죄회, 4:책정보수정, 5: 삭제, 6: 반납 및 대출, 7: 정렬변경]");
		   
		   int in = sc.nextInt();
		   System.out.println(in + "번 선택");
		   System.out.println("------------------------------------");
		   
		   switch(in){
			   case 1:
				   insertBook();
				   break;
			   case 2:
				    selectAll();
				    break;
			   case 3:
				    System.out.print("조회할 책번호 입력 : " );
				    int index = sc.nextInt();
				    selectOne(index);
				    break;
			   case 4:
				    updateBook();
				    break;
			   case 5:
				    deleteBook();
				    break;
			   case 6:
				    checkBook();
				    break;
			   case 7:
				    bookSort();
				    break;
				    
		   }
		   System.out.println(bookList.toString());
		   if (in == 0) {
			   System.out.println("프로그램 종료");
		   }
	    }	   
	}
	
	static void insertBook() {

		System.out.println("---도서등록---");
		System.out.print("책번호 입력 -> ");
		String no = sc.next();
		System.out.print("제목 입력 -> ");
		String title = sc.next();
		System.out.print("지은이 입력 -> ");
		String author = sc.next();
		System.out.print("장르 입력 -> ");
		String genre = sc.next();
		
		Book book = new Book(no, title, author, genre, true);
		
		int cnt = 0;
		for(int i=0;i<bookList.size();i++) {
			if (bookList.get(i).getbNo().equals(no)) {
				System.out.println("존재하는 책번호입니다.");
				cnt++;
			}
		}
		if (cnt == 0) {
			bookList.add(book);
			System.out.println("--등록완료--");
		}	
	}
	
	static void selectAll() {
		bookList.forEach(e->{
			System.out.println("도서번호 -> " + e.getbNo());
			System.out.println("제목 -> " + e.getbTitle());
			System.out.println("지은이 -> " + e.getbAuthor());
			System.out.println("장르 -> " + e.getbGenre());
			System.out.println("대출가능여부 -> " + e.isbAvailable());
			System.out.println("------------------------------------");
		});
	}
	
	static void selectOne(int index) {
		Book b = bookList.get(index -1); 
		System.out.println("도서번호 -> " + b.getbNo());
		System.out.println("제목 -> " + b.getbTitle());
		System.out.println("지은이 -> " + b.getbAuthor());
		System.out.println("장르 -> " + b.getbGenre());
		System.out.println("대출가능여부 -> " + b.isbAvailable());
		System.out.println("------------------------------------");
	}
	
	static void updateBook() {
		System.out.print("변경하고자 하는 책번호를 입력 ");
		int in = sc.nextInt();
		Book b = bookList.get(in - 1);
		
		System.out.print("제목 -> ");
		String title = sc.next();
		System.out.print("지은이 -> ");
		String author = sc.next();
		System.out.print("장르 -> ");
		String genre = sc.next();
		System.out.print("대출가능여부 -> ");
		boolean available = sc.nextBoolean();		

		b.setbTitle(title);
		b.setbAuthor(author);
		b.setbGenre(genre);
		b.setbAvailable(available);	
	}
	
	static void deleteBook() {
		System.out.println("삭제하고자 하는 책번호를 입력 ");
		int in = sc.nextInt();
		bookList.remove(in-1);
	}
	
	static void checkBook() {
		System.out.print("반납 or 대출할 책번호를 입력 ");
		int in = sc.nextInt();
		Book b = bookList.get(in -1);
		if (b.isbAvailable()) {
			System.out.println("대출진행 하겠습니다.");
			b.setbAvailable(false);
		} else {
			System.out.println("반납진행 하겠습니다.");
			b.setbAvailable(true);
		}
	}
	
	static void bookSort() {
		System.out.print("번호정렬: 1/ 제목정렬 2  => ");
		int in = sc.nextInt();
		
		if (in == 1) {
		   Collections.sort(bookList, new BookTitleComparator());
		}  else if (in == 2) {
			Collections.sort(bookList, new BookNoComparator());
		} 
		System.out.println(bookList.toString());
	}
}

class BookTitleComparator implements Comparator<Book>{
	@Override
	public int compare(Book b1, Book b2) {
		return b1.getbTitle().compareTo(b2.getbTitle());
	}
}
  
class BookNoComparator implements Comparator<Book>{
	@Override
	public int compare(Book b1, Book b2) {
		if (Integer.getInteger(b1.getbNo()) > Integer.getInteger(b2.getbNo())) {
			return 1;
		} else if (Integer.getInteger(b1.getbNo()) < Integer.getInteger(b2.getbNo())) {
			return -1;
		}
		return 0;
	}
}


