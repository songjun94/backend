package step02;

import static org.junit.Assert.fail;

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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();		
		
		tx.begin();
		
		//학과 데이터 저장(INSERT)
		Major major1 = new Major("컴퓨터공학");
		em.persist(major1);// entitymanager major1 엔티티를 영속화 시켜줘
		
		//학생 데이터 저장(INSERT)
		Student student1 = new Student("YOO");
		student1.setMajor(major1); // 연관관계 설정(외래키 설정)
		em.persist(student1);// entitymanager major1 엔티티를 영속화 시켜줘

		// 학생 2(Kang) 생성, 컴공과로 맵핑, 저장(INSERT)
		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		em.persist(student2);
		
		tx.commit();
	}
	
	@Test
	public void testRead() { //전공 이름 조회
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();

		Student student = em.find(Student.class, 1L);
		System.out.println(student);
		Major major = student.getMajor();
		System.out.println("전공이름 : " + major.getMajorName());
//		System.out.println("전공이름 : " + student.getMajor().getMajorName());
	}
	@Test
	public void updateRelation() {
		/*
		 * 1. 새로운 major 국문학과 생성, 영속화(persist)
		 * 2. 학생1(1L) 조회후 (find) 새로운 학과로 생성
		 * 
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();		

		tx.begin();
		//1.
		Major major2 = new Major("국문학과");
		em.persist(major2);
		//2.
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(major2);// em.update()같은 별도의 메서드는 없고, set() 활용하여 엔티티 변경
		tx.commit(); //commit()이 호출되면 flush()가 내부적으로 호출, 변경 감지 동작, 변경사항을 DB에 자동으로 반영시킴
	}
	@Test
	public void deleteRelation() {
		
		/*
		 * 1. 학생 1의 전공을 제거
		 */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();		

		tx.begin();
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(null); // 제적
		tx.commit();
	}
	@Test
	public void deleteEntity() {
		/*
		 * 1. 컴공 DB에서 제거 할 때는 연관 관계 부수고 해야됨 위의 null 한 것 처럼
		 */
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();		
	
		tx.begin();
		//학과 폐지전에 학생에게 미리 통보
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(null);
		
		Student student2 = em.find(Student.class, 2L);
		student2.setMajor(null);
		
		//학과 폐지
		Major major = em.find(Major.class, 1L);
		em.remove(major);
		tx.commit();
	}	
}
