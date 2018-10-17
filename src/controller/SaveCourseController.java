package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseBiz.CourseBiz;
import model.dao.TourDao;
import model.vo.CourseVO;
import service.CListVO;
import service.ReviewService;

public class SaveCourseController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String courseName = request.getParameter("courseName");
		String pageNo = request.getParameter("pageNo");
		
		CourseVO cvo = TourDao.getInstance().makeCourse(id, courseName);
		CourseVO cvo2 = (CourseVO)request.getSession().getAttribute("cvo");
		cvo.setMap(cvo2.getMap());
		
		TourDao.getInstance().insertCourse(cvo);
		
		CListVO mcourse= ReviewService.getInstance().getCourses(id,pageNo);
		
		request.setAttribute("mcourse", mcourse);
		
		return new ModelAndView("courseRegisterResult.jsp");
	}

}
