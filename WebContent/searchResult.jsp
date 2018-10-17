<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/nav.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <c:forEach items="${alist}" var="item">
      <c:set value="${item.spotName}" var="spotName"></c:set>
      <c:set value="${item.address}" var="address"></c:set>
      <c:set value="${item.location}" var="location"></c:set>
      <c:set value="${item.city}" var="city"></c:set>
      <c:set value="${item.info}" var="info"></c:set>
      <c:set value="${item.mainImage}" var="mainImage"></c:set>
   </c:forEach>
<script type="text/javascript">
   $(function(){
      $('#btn').click(function(){
         $.ajax({
               type : "get",
               url : "JsonServlet",
               dataType:"json",
                data : {
                 "spotName" : "${spotName}",
                  "img" : "${mainImage}",
                  "flag" : "add",
                  "address" : "${address}" 
               },

               success : function(data) {
                  $('#mySidebar').append("<img src="+data.img+" width='200' height='200'><br>");
                  $('#mySidebar').append("<div><span style='color:red'>"+data.spotName+"</span><span align='right'><a id='"+data.spotName+"'>삭제</a></span></div>");
               }//callback
               ,
               error : function(data){
                  alert("중복 불가");
               }
            });//ajax
      });
      $('#mySidebar a').click(function(){
         alert($(this).attr('id'));
         $.ajax({
               type : "get",
               url : "JsonServlet",
               dataType:"json",
               data : {
                 "spotName" : $(this).attr('id'),
                  "flag" : "cons"
               },

               success : function(data) {
                 $('#mySidebar').html(data.str);
                  
               }//callback
               ,
               error : function(data){
                  alert("삭제 실패");
               }
            });//ajax
      });
   });
   
</script>
<style>
      
      #mainImage {
         margin-right: 30px;
         padding : 10px;
         border: 1px solid lightgray;
         width: 400px;
         height: 200px
      }
      
      #info {
         margin-left: 30px;
         border: 1px solid lightgray;
         width: 400px;
         height: 200px
      }
      .sidebar {
      margin-top:190px;
    position: absolute;
    right: -200px;
    transition: 0.3s;
    width: 300px;
    text-decoration: none;
    font-size: 20px;
    color: white;
    border-radius: 0 5px 5px 0;
    height:1200px;
    background-color: white;
    z-index: 100;
    top: -100px;
   }
      .sidebar:hover {
    right: 0;
}
   
      
</style>

<script type="text/javascript" src="js/nav.js"></script>

</head>
<body>
      <nav class="navbar navbar-defalt navbar-fixed-top" style="background-color: #fff">
         <div id="header">
            <div class="container">
               <div class="navbar-header" style="margin-top: 15px">
                  <button type="button" class="navbar-toggle" id="menuSpan" data-toggle="collapse" data-target="#myNavbar">
                       <span class="icon-bar"></span>
                        <span class="icon-bar" style="margin-top: 2px"></span>
                        <span class="icon-bar"></span>
                  </button>
                  <a href="index.jsp"><img src="img/main_logo2.png" width="150" height="47" style="background-color: #FFFAE5/* #0F6A8B  #F5EED2*/"></a>
               </div> <!-- navbar-header -->
               
               <div class="collapse navbar-collapse navbar-right" id="myNavbar" style="margin-top: 15px">
                  <form class="navbar-form navbar-left" action="getdata.do">
                        <div class="input-group">
                           <input type="text" class="form-control" placeholder="Search" name="search" id="myInput">
                           <div class="input-group-btn">
                              <button class="btn btn-default" type="submit">
                                 <i class="glyphicon glyphicon-search"></i>
                              </button>
                           </div>
                        </div>
                  </form>
                  
                  <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                           <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="userMenu">
                              <span class="glyphicon glyphicon-user white">
                                 <span class="caret" style="margin-left: 10px"></span>
                              </span>
                           </a>
                           <ul class="dropdown-menu">
                              <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;로그아웃</a></li>
                              <li><a href="myreviews.do?id=${sessionScope.vo.id}"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;내가 쓴 글</a></li>
                              <li><a href="scrap.do?id=${sessionScope.vo.id}"><span class="glyphicon glyphicon-bookmark"></span>&nbsp;&nbsp;스크랩</a></li>
                              <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;글 작성</a></li>
                              <li><a href="#"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;정보 수정</a></li>
                           </ul>
                        </li>
               </ul>
            </div> <!-- myNavbar -->
            </div> <!-- container -->
      </div> <!-- header -->
       <div id="line"></div>
   </nav>
   
    <div style="height: 120px"></div>
    
    <div>
       <c:choose>
          <c:when test="${emptyFlag == true || flag == true}">
             <div class="col-sm-12">
                <div align="right" class="col-sm-6">
                   <h3>${spotName}</h3><br>
                </div>
                
               <div align="left" class="col-sm-6" style="margin-top: 21px">
                   <a href="#" id="btn"><img src="img/courseAdd.png" width="75"></a>
                </div>
             </div>
         
            <div align="right" class="col-sm-12" style="margin-bottom: 10pxl"> 
               <div align="right" class="col-sm-6">  
                  <img alt="${spotName}" src="${mainImage}" id="mainImage"> 
               </div>
               <div align="left" class="col-sm-6" id="info"> 
                  ${address}<br><br>
                  ${info}
               </div>
            </div>
            <div align="center" class="col-sm-12" style="margin-top: 35px"><hr></div>
          </c:when>
          <c:otherwise></c:otherwise>
       </c:choose>
      
      <div align="center" class="col-sm-12" style="margin-top: 15px"> 
         <h3 align="center" style="margin-top: 10">관련 리뷰</h3><br><br>
         <h1>그만 그만 그만 그만!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1</h1>
         
         <c:forEach items="${lvo.list}" var="rList">
            <a href="#">
               <div align="center" class="col-sm-4">
                  <hr>
                  ${rList.date}<br>
                  <img src="${rList.mainImage}" width="350" height="200"><br>
                  ${rList.title}
                  <hr><br><br>
               </div>
            </a>
         </c:forEach>
         
         <br><br>
         
         <div align="center" class="col-sm-12">  
            <c:set var="pb" value="${lvo.pb}"></c:set>
            <c:if test="${pb.previousPageGroup}">
               <ul class="pagination pagination-sm">
                   <li><a href="getdata.do?search=${spotName}&&pageNo=${pb.startPageOfPageGroup-1}">&#60;</a></li>
                 </ul>
            </c:if>
            
            <c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
               <c:choose>
                  <c:when test="${pb.nowPage!=i}">
                     <ul class="pagination">
                         <li><a href="getdata.do?search=${spotName}&&pageNo=${i}">${i}</a></li>
                      </ul>
                  </c:when>
                  <c:otherwise>
                     <ul class="pagination">
                         <li><a href="#">${i}</a></li>
                      </ul>
                  </c:otherwise>
               </c:choose>
               &nbsp;
            </c:forEach>
            
            <c:if test="${pb.nextPageGroup}">
               <ul class="pagination pagination-sm">
                   <li><a href="getdata.do?pageNo=${pb.endPageOfPageGroup+1}">&#62;</a></li>
                 </ul>
            </c:if>   
         </div>         
      </div>
    </div>
               <div id="mySidebar" class="sidebar">
                  <h3 align="center" style="color: black">코스만들기</h3>
                  <c:choose>
                     <c:when test="${sessionScope.cvo!=null}">
                        ${sessionScope.cvo.allCourse}
                     </c:when>
                  </c:choose>
               </div>
      
</body>

</html>