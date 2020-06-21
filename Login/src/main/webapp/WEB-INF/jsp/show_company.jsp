<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
    <section id="main">
    <div class="container">
    
    <div class="row">
    
        <%@include file="sidebar_company.jsp" %>
    
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
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="add_user/${company.companyId}">Create User</a></td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="edit_company/${company.companyId}">Edit Company</a></td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="delete_company/${company.companyId}">Delete Company</a></td>
                    </tr>
                </table>
            </div>
       </div>
    </div>
        
        <div id="table" class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Company Users</h3>
            </div>
            <div  class="panel-body">
                <table  class="table table-striped table-hover">
                    <tr style="text-align: center">
                        <th >Username</th>
                        <th>Password</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
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
                        <td><a  class="btn btn-danger main-color-bg" hidden="" href="update_user/${user.userId}/${user.companyId}">Edit User</a></td>
                        <td><a  class="btn btn-danger" hidden="" href="delete_user_from_company/${user.userId}">Delete User</a></td>
                        
                    </c:forEach>
                        
                        </tr>
                </table>
            </div>
       </div>
    </div>
</div>
</div>
</section>
 <%@include file="bottom.jsp" %>
