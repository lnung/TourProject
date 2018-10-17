package model.vo;

import java.util.ArrayList;

public class MemberVO {
   private String userName;
   private int ssn;
   private String id;
   private String password;
   private String tel;
   private String mail;
   private ArrayList<CourseVO> courses;
   
   ArrayList<Integer> scraps = new ArrayList<Integer>();
   
   public MemberVO(){}
   
   public MemberVO(String id) {
      this.id = id;
   }
   
   
   public MemberVO(String userName, int ssn, String id, String password, String tel, String mail) {
      this.userName = userName;
      this.ssn = ssn;
      this.id = id;
      this.password = password;
      this.tel = tel;
      this.mail = mail;
   }
   public MemberVO(String password, String tel, String mail) {
      super();
      this.password = password;
      this.tel = tel;
      this.mail = mail;
   }
   
   public MemberVO(String id, String userName) {
      this.id=id;
      this.userName = userName;
   }

   public ArrayList<Integer> getScraps() {
      return scraps;
   }


   public void setScraps(int reviewNum) {
      scraps.add(reviewNum);
   }


   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   public int getSsn() {
      return ssn;
   }
   public void setSsn(int ssn) {
      this.ssn = ssn;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   public String getMail() {
      return mail;
   }
   public void setMail(String mail) {
      this.mail = mail;
   }
   
   public ArrayList<CourseVO> getCourses() {
      return courses;
   }

   public void setCourses(ArrayList<CourseVO> courses) {
      this.courses = courses;
   }

   public void setScraps(ArrayList<Integer> scraps) {
      this.scraps = scraps;
   }

   @Override
   public String toString() {
      return "MemberVO [userName=" + userName + ", ssn=" + ssn + ", id=" + id + ", password=" + password + ", tel="
            + tel + ", mail=" + mail + ", courses=" + courses + ", scraps=" + scraps + "]";
   }
   
}