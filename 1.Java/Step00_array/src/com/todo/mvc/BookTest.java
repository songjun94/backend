package com.todo.mvc;

public class BookTest {

	public static void main(String[] args) {
		// ���̰� 3�� ������ �迭
		int[] numbers = new int[3];
		// ���̰� 3�� ���ڿ� �迭
		String[] names = new String[3];

		//���̰� 3�� BookŸ���� ��ü�迭
		Book[] books = new Book[3];
	
		Book book1 = new Book("���ΰ� �ٴ�", "��ֿ���");
		System.out.println(book1);
		System.out.println(book1.getBookname());
	
		books[0] = book1;
		System.out.println(books[0]);
		
		books[1] = new Book("�ڹ��� ����", "���ü�");
		books[2] = new Book("��ū ����", "�������丮");
		
		for (Book book : books) {
			System.out.println(book.getBookname()+""+book.getAuthor());
	
		}
	}

}
