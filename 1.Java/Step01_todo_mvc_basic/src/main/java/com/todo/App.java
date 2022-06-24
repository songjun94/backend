package com.todo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {

	private static final String RESOURCES = "src/main/resources/";
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	
	public static void main(String[] args) throws Exception{
		//App.java에서 todo-data-simple.txt파일을 읽기 위해서는
		// 해당 파일이 위치한 경로를 알아야함.
		
		// package import 단축기 ctrl + shift + o
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		System.out.println(filePath);
	
		// todo-data-simple.txt의 데이터 수 조회
		Long numberOfLines = Files.lines(filePath).count();
		System.out.println(numberOfLines);
	
		//Long 타입을 int 타입으로 변환
		int rows = numberOfLines.intValue();
	
		//할일의 번호들을 저장할 Long 타입의 배열 생성 todoNumbers
		Long[] todoNumbers = new Long[rows];
		//할일 제목들을 저장할 String 타입의 배열 todoTitles
		String[] todoTitles = new String[rows];
		//할일 내용들을 저장할 String 타입의 배열 todoDescriptions
		String[] todoDescriptions = new String[rows];
		//할일 날짜들을 저장할 LocalDate 타입의 배열 todoDueDate
		LocalDate[] todoDueDate = new LocalDate[rows];
		
		// 파일 읽기 
		List<String> lines = Files.readAllLines(filePath);
//		System.out.println(lines);

		int index = 0;
		for (String line : lines) {
			final String[] columns =line.split("\t");
			System.out.println(columns[0]+ "  "+ columns[1]);
			
			//위에서 생성한 배열에 각각 읽어들인 데이터들을 저장
			
			// 할 일 번호를 저장할 변수 id
			final Long id = Long.parseLong(columns[0]);
			todoNumbers[index] = id;
			
			// 할일 제목을 저장할 변수 title
			final String title = columns[1];
			todoTitles[index] = title;
			
			// 할일 날짜를 저장할 변수
			final LocalDate dueDate = LocalDate.parse(columns[2], DATE_PATTERN);
			todoDueDate[index] = dueDate;
			
			// 할일 날짜를 저장할 변수 description
			final String description = columns[3];
			//배열에 저장할 코드 작성
			todoDescriptions[index] = description;
			
			index ++;
		}//foreach 끝
		
		//전체 Todos 조회 (일반적인 반복문 활용)
		//00번째로 해야 할 일은 : 00이고, 할 일 내용은 00입니다. 기한은 00까지 입니다.
		for (int i = 0; i < todoNumbers.length; i++) {
			System.out.print(todoNumbers[i] + "번 째로 해야할 일은 : ");
			System.out.print(todoTitles[i] + "이고, 할 일 내용은 ");
			System.out.print(todoDescriptions[i] + " 입니다. 기한은 ");
			System.out.print(todoDueDate[i] + " 까지 입니다.\n");
		}
	}//main끝

}//App.java끝
