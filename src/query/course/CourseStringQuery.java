package query.course;

public interface CourseStringQuery {
	   String MAKE_COURSE = "INSERT INTO course(id,course_num,course_name) VALUES(?,course_seq.nextVal,?)";
	   // course 생성
	   String INSERT_COURSE = "INSERT INTO course_info(course_num,spot_name,course_order) VALUES(?,?,?)";
	   // course에 attraction 추가
	   
	   String GET_COURSE = "SELECT course_num,course_info.spot_name spot_name,course_order,address,spot_image FROM course_info,"
				+ "(SELECT tourspot.spot_name spot_name,address,spot_image FROM tourspot,spot_image WHERE tourspot.spot_name=spot_image.spot_name) tour"
				+ " WHERE course_num = ? AND (course_info.spot_name = tour.spot_name) ORDER BY course_order";
	   
	   String GET_COURSE_BY_ID = "SELECT * FROM (SELECT course_num,course_name,CEIL(rownum/6) page FROM course WHERE id=? ORDER BY course_num desc) WHERE page=?";
}
