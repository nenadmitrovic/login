<%@include file="top_default.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
    <section id="main">

    <div class="container">
      
    <div class="row">
        <%@include file="sidebar_default.jsp" %>
        <div id="table" class="col-md-9">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Company</h3> 
            </div>
            <div class="panel-body">
                <table class="table table-striped table-hover">
                    <tr> 
                        <th>#</th>
                        <th>Company Name</th>
                        <th>Company Adress</th>
                        <th>ID Number</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        
                    </tr>
                     <tr>
                        <td>${company.companyId}</td>
                        <td>${company.name}</td>
                        <td>${company.adress}</td>
                        <td>${company.idNumber}</td>
                        
                    </tr>
                </table>
            </div>
       </div>
    </div>
        
        <div id="table" class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Users</h3>
            </div>
            <div class="panel-body">
                <table  class="table table-striped table-hover">
                    <tr>
                        <th style="text-align: center">Username</th>
                        <th style="text-align: center">Password</th>
                        <th style="text-align: center">Name</th>
                        <th style="text-align: center">Surname</th>
                        <th style="text-align: center">Email</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                   
                    <c:forEach items="${users}" var="user">
                        
                    <tr style="text-align: center">
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.email}</td>
                        <td><a  class="btn btn-danger main-color-bg" hidden="" href="update_default_user/${user.userId}/${user.companyId}">Edit User</a></td>
                        <td><a  class="btn btn-danger" hidden="" href="delete_default_user/${user.userId}">Delete User</a></td>
                        
                    </tr>
                   
                    </c:forEach>
                    
                </table>
                
                
            </div>
       </div>
    </div>
    
    
    </div>
    </div>
        
          
    </div>
    </div>
    
    
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
