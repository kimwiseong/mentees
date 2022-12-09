package mentees.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mentees.service.MemberService;

/**
 * Servlet implementation class MemberImageController
 */
@WebServlet("/memberImage")
public class MemberImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MemberService memberService = new MemberService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		
		String saveDir = request.getSession().getServletContext().getRealPath("img");		
			
		MultipartRequest multi = new MultipartRequest(request, saveDir, 1024*1024*15, "UTF-8", new DefaultFileRenamePolicy());
		String uri = request.getRequestURI();
		String con = request.getContextPath();

		String image = multi.getFilesystemName("image");
		if (image == null || "".equals(image)) 
			out.print("<script>alert('사진을 선택해주세요.'); history.back(); </script>");
		
		boolean isUpdate = memberService.updateImage(email, image);
		if (isUpdate) {
			out.print("<script>alert('수정했습니다'); location.href='mypage'; </script>");
		}
		else {
			out.print("<script>alert('수정 실패했습니다.'); history.back(); </script>");
		}
	}

}
