package service;

import java.util.ArrayList;

import model.PagingBean;
import model.vo.CourseVO;

/*
 * 특정한 페이지의 게시물들을 저장하는 VO
 * 특정한 페이지 정보와 책 리스트 정보가 동시에 저장
 */
public class CListVO {
	private ArrayList<CourseVO> list;
	private PagingBean pb;

	public CListVO(ArrayList<CourseVO> list, PagingBean pb) {
		this.list = list;
		this.pb = pb;
	}
	public CListVO() {}
	public ArrayList<CourseVO> getList() {
		return list;
	}
	public void setList(ArrayList<CourseVO> list) {
		this.list = list;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}
	@Override
	public String toString() {
		return "CListVO [list=" + list + ", pb=" + pb + "]";
	}

}
