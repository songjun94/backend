package step03;

import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class AppTest {

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	
	@Test
	public void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();		
		
		/*
		 * 1. �а� ������ ���� , ����
		 * 
		 * 2. �л� ������ ���� (�л� 1 YOO �л� 2 Kang) �� ���� �� ��ǻ�� ���а��� �������踦 ���� �� ����
		 * 
		 */

		tx.begin();
		
			Major major1 = new Major("��ǻ�Ͱ���");
			em.persist(major1);
		
			Student student1 = new Student("YOO");
			student1.setMajor(major1); // �������� ����(�ܷ�Ű ����)
			em.persist(student1);// entitymanager major1 ��ƼƼ�� ����ȭ ������

			Student student2 = new Student("Kang");
			student2.setMajor(major1);
			em.persist(student2);
				
		tx.commit();
		// SELECT * FROM student; major_id �� �����Ѱ� Ȯ��
	}
	@Test
	public void readStudent() { // JPA�� �л� ����Ʈ ��ȸ
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		
		Major major = em.find(Major.class, 1L);
//		System.out.println(major);//persistence�� update�� �ٲٰ� �ؾߵ�
//		System.out.println(major.getStudents());
		
		List<Student> students = major.getStudents();
		for (Student student : students) {
			System.out.println(student.getStudentName());
		}
		
	}
	
	@Test
	public void testSaveNonOwnerWithJPA() {//JPA�� ������ �� ���� �������迡�� ���������� ������ �ƴ� ������ ���� �Է��� ���
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		//persistence : create
		
		tx.begin();

		//�а� ������ ����
		Major major1 = new Major("��ǻ�� ����");
		em.persist(major1);
		
		//�л� 1 ����
		Student student1 = new Student("Yoo");
//		student1.setMajor(major1); ���������� ������ ���� �������� ����

//		���� ���������� ������ �ƴ� ������ �������踦  ������ ���,
		List<Student> students = major1.getStudents();
		students.add(student1);
		em.persist(student1);
		
//		�л�2 ����
		Student student2 = new Student("Kang");
//		student2.setMajor(major1); ���������� ������ ���� �������� ����

		students.add(student2);
		em.persist(student2);
		
		tx.commit();
	}
	
	@Test
	public void testSaveOwnerwithOOP() { // ������ ��ü���� �ڵ忡�� ���������� ����
		Major major1 = new Major("��ǻ�Ͱ���");
		
		Student student1 = new Student("YOO");
		student1.setMajor(major1);
		
		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		
		List<Student> students = major1.getStudents();
		System.out.println("students.size : " + students.size());
		
	}
	
	@Test
	public void biwithPureOOP() { // ������ ��ü���� �ڵ忡�� ���������� ����
		Major major1 = new Major("��ǻ�Ͱ���");
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("YOO");
		student1.setMajor(major1); // ���������� ���� ���⿡�� �������� ����
		students.add(student1);// �ݴ��������� �������� ����
		
		Student student2 = new Student("Kang");
		student2.setMajor(major1); // ���������� ���� ���⿡�� �������� ����
		students.add(student2); // �ݴ��������� �������� ����
		
		System.out.println("students.size : " + students.size());
	}
	
	@Test
	public void biwithJPA() { // JPA Ȱ��
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		tx.begin();
		Major major1 = new Major("������");
		em.persist(major1);
		
		Student student1 = new Student("Park");
		
		//����� �������� ����
		student1.setMajor(major1); // ���������� ���� ���⿡�� ����
		List<Student> students = major1.getStudents();
		students.add(student1); // �ݴ��������� ����
		
		// �л�2�� ���� �� �������� ����, ����ȭ
		Student student2 = new Student("Kim");
		student2.setMajor(major1);
		students.add(student2);
		em.persist(student2);
		
		tx.commit();
		//  SELECT s.*, m.major_name FROM student s JOIN major m ON s.major_id = m.major_id WHERE s.major_id = 1;
		
	}
	
}
