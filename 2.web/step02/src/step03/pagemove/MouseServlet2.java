package step03.pagemove;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mouseResult")
public class MouseServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		request.getCharacterEncoding();
		
		Mouse mouse = (Mouse)request.getAttribute("mouse");
	
		
		out.printf("<h4>이름 : %s </h4>", mouse.getName());
		out.printf("<h4>국적 : %s </h4>", mouse.getCountry());
		out.printf("<h4>주소 : %s </h4>", mouse.getAddress());
		
	}

}
