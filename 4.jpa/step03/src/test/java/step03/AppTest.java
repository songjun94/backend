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
		 * 1. 학과 데이터 생성 , 저장
		 * 
		 * 2. 학생 데이터 생성 (학생 1 YOO 학생 2 Kang) 및 저장 및 컴퓨터 공학과의 연관관계를 설정 후 저장
		 * 
		 */

		tx.begin();
		
			Major major1 = new Major("컴퓨터공학");
			em.persist(major1);
		
			Student student1 = new Student("YOO");
			student1.setMajor(major1); // 연관관계 설정(외래키 설정)
			em.persist(student1);// entitymanager major1 엔티티를 영속화 시켜줘

			Student student2 = new Student("Kang");
			student2.setMajor(major1);
			em.persist(student2);
				
		tx.commit();
		// SELECT * FROM student; major_id 값 적용한거 확인
	}
	@Test
	public void readStudent() { // JPA로 학생 리스트 조회
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		
		Major major = em.find(Major.class, 1L);
//		System.out.println(major);//persistence에 update로 바꾸고 해야됨
//		System.out.println(major.getStudents());
		
		List<Student> students = major.getStudents();
		for (Student student : students) {
			System.out.println(student.getStudentName());
		}
		
	}
	
	@Test
	public void testSaveNonOwnerWithJPA() {//JPA를 저굥한 양 방향 연관관계에서 연관관계의 주인이 아닌 곳에만 값을 입력한 경우
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		//persistence : create
		
		tx.begin();

		//학과 데이터 저장
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1);
		
		//학생 1 저장
		Student student1 = new Student("Yoo");
//		student1.setMajor(major1); 연관관계의 주인인 곳에 연관관계 설정

//		만약 연관관계의 주인이 아닌 곳에만 연관관계를  설정할 경우,
		List<Student> students = major1.getStudents();
		students.add(student1);
		em.persist(student1);
		
//		학생2 저장
		Student student2 = new Student("Kang");
//		student2.setMajor(major1); 연관관계의 주인인 곳에 연관관계 설정

		students.add(student2);
		em.persist(student2);
		
		tx.commit();
	}
	
	@Test
	public void testSaveOwnerwithOOP() { // 순수한 객체지향 코드에서 연관관계의 설정
		Major major1 = new Major("컴퓨터공학");
		
		Student student1 = new Student("YOO");
		student1.setMajor(major1);
		
		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		
		List<Student> students = major1.getStudents();
		System.out.println("students.size : " + students.size());
		
	}
	
	@Test
	public void biwithPureOOP() { // 순수한 객체지향 코드에서 연관관계의 설정
		Major major1 = new Major("컴퓨터공학");
		List<Student> students = major1.getStudents();
		
		Student student1 = new Student("YOO");
		student1.setMajor(major1); // 연관관계의 주인 방향에서 연관관계 설정
		students.add(student1);// 반대편에서도 연관관계 설정
		
		Student student2 = new Student("Kang");
		student2.setMajor(major1); // 연관관계의 주인 방향에서 연관관계 설정
		students.add(student2); // 반대편에서도 연관관계 설정
		
		System.out.println("students.size : " + students.size());
	}
	
	@Test
	public void biwithJPA() { // JPA 활용
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		tx.begin();
		Major major1 = new Major("국문학");
		em.persist(major1);
		
		Student student1 = new Student("Park");
		
		//양방향 연관관계 설정
		student1.setMajor(major1); // 연관관계의 주인 방향에서 설정
		List<Student> students = major1.getStudents();
		students.add(student1); // 반대편에서도 설정
		
		// 학생2도 생성 및 연관관계 설정, 영속화
		Student student2 = new Student("Kim");
		student2.setMajor(major1);
		students.add(student2);
		em.persist(student2);
		
		tx.commit();
		//  SELECT s.*, m.major_name FROM student s JOIN major m ON s.major_id = m.major_id WHERE s.major_id = 1;
		
	}
	
}

