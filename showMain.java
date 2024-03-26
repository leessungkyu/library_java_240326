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
		   System.out.println("---���������α׷�---");
		   System.out.println("�ʿ��� ����� �����Ͻʽÿ�");
		   System.out.println("[1:�������, 2:��ü��ȸ, 3:������ȸ, 4:å��������, 5: ����, 6: �ݳ� �� ����, 7: ���ĺ���]");
		   
		   int in = sc.nextInt();
		   System.out.println(in + "�� ����");
		   System.out.println("------------------------------------");
		   
		   switch(in){
			   case 1:
				   insertBook();
				   break;
			   case 2:
				    selectAll();
				    break;
			   case 3:
				    System.out.print("��ȸ�� å��ȣ �Է� : " );
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
			   System.out.println("���α׷� ����");
		   }
	    }	   
	}
	
	static void insertBook() {

		System.out.println("---�������---");
		System.out.print("å��ȣ �Է� -> ");
		String no = sc.next();
		System.out.print("���� �Է� -> ");
		String title = sc.next();
		System.out.print("������ �Է� -> ");
		String author = sc.next();
		System.out.print("�帣 �Է� -> ");
		String genre = sc.next();
		
		Book book = new Book(no, title, author, genre, true);
		
		int cnt = 0;
		for(int i=0;i<bookList.size();i++) {
			if (bookList.get(i).getbNo().equals(no)) {
				System.out.println("�����ϴ� å��ȣ�Դϴ�.");
				cnt++;
			}
		}
		if (cnt == 0) {
			bookList.add(book);
			System.out.println("--��ϿϷ�--");
		}	
	}
	
	static void selectAll() {
		bookList.forEach(e->{
			System.out.println("������ȣ -> " + e.getbNo());
			System.out.println("���� -> " + e.getbTitle());
			System.out.println("������ -> " + e.getbAuthor());
			System.out.println("�帣 -> " + e.getbGenre());
			System.out.println("���Ⱑ�ɿ��� -> " + e.isbAvailable());
			System.out.println("------------------------------------");
		});
	}
	
	static void selectOne(int index) {
		Book b = bookList.get(index -1); 
		System.out.println("������ȣ -> " + b.getbNo());
		System.out.println("���� -> " + b.getbTitle());
		System.out.println("������ -> " + b.getbAuthor());
		System.out.println("�帣 -> " + b.getbGenre());
		System.out.println("���Ⱑ�ɿ��� -> " + b.isbAvailable());
		System.out.println("------------------------------------");
	}
	
	static void updateBook() {
		System.out.print("�����ϰ��� �ϴ� å��ȣ�� �Է� ");
		int in = sc.nextInt();
		Book b = bookList.get(in - 1);
		
		System.out.print("���� -> ");
		String title = sc.next();
		System.out.print("������ -> ");
		String author = sc.next();
		System.out.print("�帣 -> ");
		String genre = sc.next();
		System.out.print("���Ⱑ�ɿ��� -> ");
		boolean available = sc.nextBoolean();		

		b.setbTitle(title);
		b.setbAuthor(author);
		b.setbGenre(genre);
		b.setbAvailable(available);	
	}
	
	static void deleteBook() {
		System.out.println("�����ϰ��� �ϴ� å��ȣ�� �Է� ");
		int in = sc.nextInt();
		bookList.remove(in-1);
	}
	
	static void checkBook() {
		System.out.print("�ݳ� or ������ å��ȣ�� �Է� ");
		int in = sc.nextInt();
		Book b = bookList.get(in -1);
		if (b.isbAvailable()) {
			System.out.println("�������� �ϰڽ��ϴ�.");
			b.setbAvailable(false);
		} else {
			System.out.println("�ݳ����� �ϰڽ��ϴ�.");
			b.setbAvailable(true);
		}
	}
	
	static void bookSort() {
		System.out.print("��ȣ����: 1/ �������� 2  => ");
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


