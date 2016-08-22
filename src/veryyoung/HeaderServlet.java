package veryyoung;

//引入所需要的包  
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HeaderServlet extends HttpServlet {
		// 重写doGet方法
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			response.setContentType("text/plain; charset=UTF-8");// 设置编码格式
			String name = request.getParameter("name");
			name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println(name);
			String sex = request.getParameter("sex");
			sex = new String(sex.getBytes("ISO-8859-1"),"UTF-8");
			String strHeader = request.getHeader("user-agent");
//			System.out.println(strHeader);
			
//			response.getWriter().write(name);
            PrintWriter pw = response.getWriter();  
            pw.write("user-agent:"+strHeader+"\n姓名:"+name+"\n性别:"+sex); 
		}
		// 重写doPost方法
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}
}
