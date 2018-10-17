package model.vo;

import java.util.HashMap;

public class CourseVO {
	private int courseNum;
	private String courseName;
	private HashMap<Integer, AttractionVO> map;

	public CourseVO(String courseName) {
		super();
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public HashMap<Integer, AttractionVO> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, AttractionVO> map) {
		this.map = map;
	}

	public CourseVO() {
		super();
	}

	public CourseVO(int courseNum) {
		super();
		this.courseNum = courseNum;
	}

	public CourseVO(int courseNum, String courseName) {
		super();
		this.courseNum = courseNum;
		this.courseName = courseName;
	}

	public String getAllCourse() {
		if (map != null) {
			System.out.println("map size!!!!!!!!!!!!!!!!!!111" + map.size());
			String str = "<h3 align=\"center\" style=\"color: black\">�ڽ������</h3>";
			for (int i = 1; i <= map.size(); i++) {
				str += "<img src=" + map.get(i).getMainImage()
						+ " width='200' height='200'><br><div><span style='color:red'>" + map.get(i).getSpotName()
						+ "</span><span align='right'><a id='" + map.get(i).getSpotName() + "'>����</a></span></div><br>";
			}
			str += "<script src='js/soRj.js'></script>";
			return str;
		}
		return null;
	}
}