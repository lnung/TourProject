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
}