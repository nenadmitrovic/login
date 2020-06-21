<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

    

<section id="main">
  <div class="container">
    <div class="row">
        <%@include file="sidebar_others.jsp" %>
        
        <br><br>
        
        <label>Type:${document.name}</label>
<form action="save_document" method="post">
    <label>Date:</label><br>
    <input type="text" name="datum" placeholder="Enter datum" value="${datum}"/><br><br>
    <label>Descriptors:&nbsp;</label><br><br>
    <c:forEach items="${descriptors}" var="desc">
                    
              <label>${desc.name}:&nbsp;&nbsp;</label><input type="text" name="${desc.name}" placeholder="Enter ${desc.name}"/><br><br>
                    
                    
    </c:forEach>
              <input type="hidden" name="documentId" value="${document.documentId}"/>
              <input  type="submit"/>
</form>

        
  <!--      
        
       <div id="table" class="col-md-8">
           
           
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Documents</h3>
            </div>
            <div class="panel-body">
                
              <table style="text-align: center;" id="tabela" class="table table-striped table-hover">
                  <form></form>  
                  <form action="save_document" method="post" enctype="multipart/form-data">
              <tr><label>Type:&nbsp;</label><label>${document.name}</label></tr><br><br>
            <tr><label>Date:&nbsp;&nbsp;</label><input type="text" name="datum" placeholder="Enter date" value="${datum}" id="txtDatum"/></tr><br><br>
<br><br>
              <tr><label>Descriptors:&nbsp;</label></tr><br><br>
              <c:forEach items="${descriptors}" var="desc">
                    
              <tr><label>${desc.name}:&nbsp;&nbsp;</label><input type="text" name="${desc.name}" placeholder="Enter ${desc.name}"/></tr><br><br>
                    
                    
              </c:forEach>
        
        
                    
              <input type="submit" hidden="${document.documentId}"  value="Save"  class="btn btn-default btn-block main-color-bg" id="btn1"/>
                    
             </form>
               </table>
                    
           </div>
       </div>
    </div>
    
  -->
        
        
       
</div>
    </div>
     
    </section>
      
        <%@include file="bottom.jsp" %>
