<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
    <section id="main">
    <div class="container">
    
    <div class="row">
    
        <%@include file="sidebar_company.jsp" %>
    
        <div class="col-md-7">
        
        
        <form action="update_company/${company.companyId}" method="post" id="login" class="well">
            
  	<div class="form-group">
    		<label>Company name:</label>
                <input name="name" type="text" class="form-control" value="${company.name}" placeholder="Enter company name">
  	</div>
    <div class="form-group">
    		<label>Adress:</label>
                <input name="adress" type="text" class="form-control" value="${company.adress}" placeholder="Adress">
  	</div>
    <div class="form-group">
    		<label>ID Number:</label>
                <input name="idNumber" type="text" class="form-control" value="${company.idNumber}" placeholder="idNumber">
  	</div>
    <br/>
            <input type="submit" value="Save"  class="btn btn-default btn-block main-color-bg"/>
    </form>
    
    
    
    
    
    </div>
        
        
        
        
    
    
    </div>
        
        
        
    </div>
        
        
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
