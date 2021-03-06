package dev.info.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.info.model.Info;

// index.jsp에서 보낸 요청을 처음으로 받는 컨트롤러(Servlet)

//@Controller // @Component의 직관적인 네이밍
// @Controller가 유효한 범위는 ex1 ~ ex3
@RestController
public class InfoController {

	// insert
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("gender") String gender, @RequestParam("city") String city) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Info info = new Info();

			info.setName(name);
			info.setAge(age);
			info.setGender(gender);
			info.setCity(city);

			em.persist(info);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
	@RequestMapping(value = "/read", method=RequestMethod.GET)
	public Info read(@RequestParam("id") int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		
		Info info = em.find(Info.class, id);
		return info;
	}
	
//	@RequestMapping(value = "/read", method = RequestMethod.GET)
//	public void Read(@RequestParam("id") int id) {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		try {
//			tx.begin();
//
//			Info findinfo = em.find(Info.class, id); 
//			System.out.println("이름 :" + findinfo.getName()  + "\n나이 :" + findinfo.getAge() + "\n성별 :" + findinfo.getGender()
//			+ "\n지역 :" + findinfo.getCity());
//
//
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close();
//			emf.close();
//		}
//	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam("id") int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Info findinfo = em.find(Info.class, id);
			em.remove(findinfo);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("gender") String gender, @RequestParam("city") String city) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Info findinfo = em.find(Info.class,id);
			findinfo.setName(name);
			findinfo.setAge(age);
			findinfo.setCity(city);
			findinfo.setGender(gender);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

}

