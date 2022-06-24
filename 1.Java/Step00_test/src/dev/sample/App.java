package dev.sample;

public class App {

	public static void main(String[] args) {
//		System.out.println("Hello World!");
		
		// 사람 객체 1개 생성
		// 타입 변수명 = new 클래스명();
//		int yoo = new Person("유재석", 48); // 정수형 타입의 변수 yoo에 Person 객체 초기화 불가.
		Person yoo = new Person("유재석", 48); // Person 타입의 변수 yoo에 Person 객체 초기화 가능.
		
		System.out.println(yoo.getName()); // 유재석
		
		// 8. 길이가 2인 Person 타입의 객체 배열 생성
		Person[] people = new Person[2];
		
		// 9. 사람 객체 생성
		Person jo = new Person("조세호", 40);
		
		// 10. 생성한 객체를 객체 배열에 저장
		people[0] = yoo;
//		people[1] = jo;
		people[1] = new Person("조세호", 40);
		
		// 11. forEach()를 통해 name과 age 출력
		for (Person person : people) {
			System.out.println(person.getName() + person.getAge());
		}
	}

}
