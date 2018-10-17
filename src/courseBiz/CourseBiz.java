package courseBiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.vo.AttractionVO;
import model.vo.CourseVO;
import model.vo.MemberVO;

public class CourseBiz {

   private static CourseBiz biz = new CourseBiz();

   private CourseBiz() {
   }

   public static CourseBiz getInstance() {
      return biz;
   }

   public ArrayList<CourseVO> getCourseList(HttpServletRequest request) {
      /*
       * ���ǿ� ���ε��� member�� courseList ����Ʈ ������ �� �޾ƿ´�.
       */
      HttpSession session = request.getSession();
      MemberVO member = (MemberVO) session.getAttribute("member");
      ArrayList<CourseVO> course = member.getCourses();

      return course;
   }

   public void removeAllCourse(HttpServletRequest request, int courseNum) {
      /*
       * ���ǿ� ���ε��� ArrayList�� �޾ƿͼ� �� �߿� courseNum�� ��ġ�ϴ� ��ǰ�� �����ϴ� ������ �ۼ�
       */
      ArrayList<CourseVO> cartList = (ArrayList<CourseVO>) request.getSession().getAttribute("courseList");

      for (int i = 0; i < cartList.size(); i++) {
         if (courseNum == cartList.get(i).getCourseNum())
            cartList.remove(cartList.get(i));
      }
   }

   public void removeOneCourse(String spotName, CourseVO cvo) {// ??????????????

      HashMap<Integer, AttractionVO> map = cvo.getMap();
      int x = 0;
      int y=0;
      if (!map.isEmpty()) {
         Iterator<Integer> iter = map.keySet().iterator();
         while (iter.hasNext()) {
            x = iter.next();
            if (map.get(x).getSpotName().equals(spotName)) {
               y = x;
               iter.remove();
            }
         }
         if(y>1) ddaengigi(map, y);
      }

   }

   private void ddaengigi(HashMap<Integer, AttractionVO> map, int x) {
      AttractionVO vo = null;
      if (map.keySet().contains(x+1)) {
         while (map.keySet().contains(x+1)) {
            vo = map.get(x+1);
            map.remove(x+1); // map �����..
            map.put(x, vo); // map��.. ������ �ڸ�..�״ϱ� 1...��.. vo...put..
            x += 1;// x=x+1;..
         }
      }
   }

   public void addCourse(AttractionVO attr, CourseVO cvo) throws Exception {/// �ٲ�
      // searchResult ������ �ʿ��� ����
      HashMap<Integer, AttractionVO> map;
      if (cvo.getMap() != null) {
         map = cvo.getMap();
         Iterator<Integer> iter = map.keySet().iterator();
         boolean flag = false;
         while (iter.hasNext()) {
            if (map.get(iter.next()).getSpotName().equals(attr.getSpotName()))
               flag = true;
         }
         if (!flag)
            map.put(cvo.getMap().size() + 1, attr);
         else
            throw new Exception("�ߺ��Ұ�");
      } else {
         map = new HashMap<Integer, AttractionVO>();
         map.put(1, attr);
      }
      cvo.setMap(map);
      // return map;
   }

   public void makeCourse(HttpServletRequest request, String name) {
      CourseVO vo = new CourseVO(name);
      HttpSession session = request.getSession();
      MemberVO member = (MemberVO) session.getAttribute("vo");
      member.getCourses().add(vo);
   }

   public void addCourse(HttpServletRequest request, CourseVO course) {

   }
}