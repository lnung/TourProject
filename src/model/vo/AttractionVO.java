package model.vo;
import java.util.ArrayList;

public class AttractionVO {
   private String spotName;
   private String address; // ÃÑ ÁÖ¼Ò
   private String location; //½Ã µµ
   private String city; // ½Ã ±º ±¸
   private String info;
   private String mainImage;
   private ArrayList<String> images;
   
   
   public AttractionVO() {}

   public AttractionVO(String spotName, String address, String mainImage) {
      this.spotName = spotName;
      this.address = address;
      this.mainImage = mainImage;
   }
   public AttractionVO(String spotName, String address, String location, String city, String info) {
      super();
      this.spotName = spotName;
      this.address = address;
      this.location = location;
      this.city = city;
      this.info = info;
   }

   public AttractionVO(String spotName, String address, String location, String city, String info, String mainImage) {
      super();
      this.spotName = spotName;
      this.address = address;
      this.location = location;
      this.city = city;
      this.info = info;
      this.mainImage = mainImage;
   }


   public String getMainImage() {
      return mainImage;
   }

   public void setMainImage(String mainImage) {
      this.mainImage = mainImage;
   }

   public String getSpotName() {
      return spotName;
   }
   public void setSpotName(String spotName) {
      this.spotName = spotName;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getLocation() {
      return location;
   }
   public void setLocation(String location) {
      this.location = location;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public String getInfo() {
      return info;
   }
   public void setInfo(String info) {
      this.info = info;
   }


   public ArrayList<String> getImages() {
      return images;
   }


   public void setImages(ArrayList<String> images) {
      this.images = images;
   }

   @Override
   public String toString() {
      return "AttractionVO [spotName=" + spotName + ", address=" + address + ", location=" + location + ", city="
            + city + ", info=" + info + ", mainImage=" + mainImage + ", images=" + images + "]";
   }
   
}