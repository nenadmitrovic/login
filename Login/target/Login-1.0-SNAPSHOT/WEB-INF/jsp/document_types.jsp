<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="top.jsp" %>
    
   
    
    <section id="main">
    
    <div class="container">
    
    <div class="row">
    
        <%@include file="sidebar_others.jsp" %>
    
        <div id="add_company" class="col-md-7">
     <form action="add_new_document" method="post" id="login" class="well" >
  	<div class="form-group">
    <label for="sel1">Select list:</label>
    <select name="documentId" class="form-control" id="sel1">
           <c:forEach items="${documentTypes}" var="types">
               <option value="${types.documentId}">${types.name}</option>
          </c:forEach>
        </select>
      </div>
    
    <button   type="submit" class="btn btn-default btn-block main-color-bg">Add new document</button>
    </form>
    
    
    
    
    
    </div>
    
    
    </div>
    </div>
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
