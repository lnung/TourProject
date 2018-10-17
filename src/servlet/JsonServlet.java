package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import courseBiz.CourseBiz;
import model.vo.AttractionVO;
import model.vo.CourseVO;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JsonServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String spotName = request.getParameter("spotName");
		String img = request.getParameter("img");
		String address = request.getParameter("address");
		CourseVO cvo = (CourseVO) request.getSession().getAttribute("cvo");
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();

		if (request.getSession().getAttribute("cvo") == null)
			cvo = new CourseVO();
		try {
			if (request.getParameter("flag").equals("add")) {
				// ��ٱ��Ͽ� ��� ����
				CourseBiz.getInstance().addCourse(new AttractionVO(spotName, address, img), cvo);

				json.put("spotName", spotName);
				json.put("img", img);
			} else if (request.getParameter("flag").equals("cons") && cvo.getMap() != null) {
				// �ڹٽ�ũ��Ʈ�� jsp���� ��Ͽ��� �����ϰ� ��ٱ��Ͽ��� ���� ����
				System.out.println("111111111111111" + cvo.getMap());
				CourseBiz.getInstance().removeOneCourse(spotName, cvo);
				System.out.println("222222222222222" + cvo.getMap());
				json.put("str", cvo.getAllCourse());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("cvo", cvo);
		out.print(json);

	}
}