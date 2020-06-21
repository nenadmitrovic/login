<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <section id="main">
    
    <div class="container">
    
    <div class="row">
    
        <%@include file="sidebar_company.jsp" %>
        
    <div class="col-md-7">
        
        
        <form action="update_user/${user.userId}" method="post" id="login" class="well">
            
  	<div class="form-group">
    		<label>Username:</label>
                <input name="username" type="text" class="form-control" value="${user.username}" placeholder="Enter Username">
  	</div>
    <div class="form-group">
    		<label>Password:</label>
                <input name="password" type="text" class="form-control" value="${user.password}" placeholder="Password">
  	</div>
    <div class="form-group">
    		<label>Name:</label>
                <input name="name" type="text" class="form-control" value="${user.name}" placeholder="Name">
  	</div>
    <div class="form-group">
    		<label>Surname:</label>
                <input name="surname" type="text" class="form-control" value="${user.surname}" placeholder="Surname">
  	</div>
    <div class="form-group">
    		<label>Email:</label>
                <input name="email" type="text" class="form-control" value="${user.email}" placeholder="Email">
  	</div>
            <div class="form-group">
    		<label>Company:</label>
                <input  name="companyName" type="text" class="form-control" value="${company.name}">
                <input type="hidden" name="companyId" value="${company.companyId}">
            </div>
        
        
            <select name="roleId">
                <option value="-1">Select role:</option>
                <c:forEach items="${roles}" var="role">
                    <option value="${role.roleId}">${role.name}</option>
                </c:forEach>
            </select><br/>
            <br/>
            <input type="submit" value="Save"  class="btn btn-default btn-block main-color-bg"/>
    </form>
    
    
    
    
    
    </div>
    
    
    </div>
    </div>
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
