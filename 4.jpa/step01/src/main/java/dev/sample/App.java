package dev.sample;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");

		// EntityManagerFactory�� ���� EntityManager ��ü ����
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Book book = new Book(); // 26 28 29 31 �ּ� �ϸ� update
			book.setBookName("���ΰ� �ٴ�");
//			book.setAuthor("��ֿ���");
			
			// ���, em.persist(����� entity); list.add(entity);
			em.persist(book); // INSERT INTO BOOK~
			
			//����, em.update()������ ���� �޼���� �������� ����
			book.setBookName("�ٴٿ� ����");
			
			//�� ����ȸ : em.find(��ȸ�� ��ƼƼ�� Ÿ�� Id�� ������ �ʵ尪)
			// SELECT * FROM book WHERE id = 1;
			Book findBook = em.find(Book.class, 1L);
			System.out.println(findBook.getBookName());
			
			// em.remove(������ entity)
		    em.remove(findBook); // DELETE FROM BOOK WHERE id = 1L;
			
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
