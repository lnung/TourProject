package courseBiz;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.vo.AttractionVO;
import model.vo.CourseVO;
import model.vo.MemberVO;

public class CourseBiz {
	int count = 0;
	
	public ArrayList<CourseVO> getCourseList(HttpServletRequest request) {
		/*
		 * ���ǿ� ���ε��� member�� courseList ����Ʈ ������ �� �޾ƿ´�.
		 */
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		ArrayList<CourseVO> course = member.getCourses();
	
		return course;
	}

	public void removeAllCourse(HttpServletRequest request, int courseNum) {
		/*
		 * ���ǿ� ���ε��� ArrayList�� �޾ƿͼ�
		 * �� �߿� courseNum�� ��ġ�ϴ� ��ǰ�� �����ϴ� ������ �ۼ� 
		 */
		ArrayList<CourseVO> cartList = (ArrayList<CourseVO>)request.getSession().getAttribute("courseList");
		
		for(int i = 0; i < cartList.size(); i++) {
			if(courseNum == cartList.get(i).getCourseNum())
				cartList.remove(cartList.get(i));
		}
	}
	
	public void removeOneCourse(HttpServletRequest request, int attrNum) {
		CourseVO course = new CourseVO();
		HashMap<Integer, AttractionVO> map = course.getMap();
		
		if(!map.isEmpty()) {
			for(int i = 0; i < map.size(); i++) {
				if(map.get(attrNum) != null) {
					map.remove(attrNum);
				}
			}
		}
		
	}
	
	public HashMap<Integer, AttractionVO> addCourse(HttpServletRequest request, AttractionVO attr) {
		// searchResult ������ �ʿ��� ����
		CourseVO course = new CourseVO();
		HashMap<Integer, AttractionVO> map = new HashMap<Integer, AttractionVO>();
		map.put(count + 1, attr);
		course.setMap(map);
		
		return map;
	}
	
	public void makeCourse(HttpServletRequest request,String name) {
		CourseVO vo = new CourseVO(name);
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		member.getCourses().add(vo);
	}
	
	public void addCourse(HttpServletRequest request, CourseVO course) {
		
	}
}
