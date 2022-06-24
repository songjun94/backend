package step04.query.string;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServletEng
 */
@WebServlet("/queryTestEng")
public class QueryServletEng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버에서 클라이언트로 응답할 때 참고로 안내할 응답한 문서(hml)타입, 문자셋(charset) 지정 
		response.setContentType("text/html;charset=UTF-8");
		
		// 출력을 위한 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		//출력문으로 <h1>Get 방식으로 요청되었음</h1>
		out.print("<h1>Get 방식으로 요청되었음</h1>");
		
		// 클라이언트(브라우저)에서 입력한 값 추출(꺼내기)
//		String id = request.getParameter("id");
//		String password = request.getParameter("pwd");
//		String name = request.getParameter("name");
//		
//		out.print("ID:" + id + "<br>");
//		out.print("비밀번호:" + password + "<br>");
//		out.print("이름:" + name + "<br>");
		
		//checkbox의 값 받기, 중복으로 선택이 가능하기 때문에 배열로 받게 됨
		String[] hobbies = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String introduction = request.getParameter("introduction");
	
		for (String hobby : hobbies) {
			out.println(hobby);
		}
		
		out.print(gender + "<br>");
		out.print(country + "<br>");
		out.print(introduction + "<br>");
		
//		System.out.println(id);
		
		
		//자원해제
		out.close();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 요청에 따른 encoding 타입 지정
		//서버가 클라이언트로부터 받을 때 참고할 인코딩 타입
		//클라이언트가 서버에게 전달할 정보
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		// 출력을 위한 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
//		//출력문으로 <h1>Get 방식으로 요청되었음</h1>
		
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		out.print("ID:" + id + "<br>");
		out.print("비밀번호:" + password + "<br>");
		out.print("이름:" + name + "<br>");
		
		
		out.print("<h1>POST 방식으로 요청되었음</h1>");
		//자원해제
		out.close();
	}

}
