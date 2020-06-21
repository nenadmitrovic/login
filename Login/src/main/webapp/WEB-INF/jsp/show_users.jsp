<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
   
    
    <section id="main">
    <div class="container">
    
    <div class="row">
    
        <%@include file="sidebar_company.jsp" %>
    
        <div id="table" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Search Users</h3> 
            </div>
            <div class="panel-body">
                <form action="search_users" method="post">
                <table class="table table-striped table-hover">
                  
                    <tr> 
                        <th>Search Users</th>
                        <th><input type="text" name="username" placeholder="Enter Username"></th>
                        <th><input type="submit" value="Search Users"></th>
                   </tr>
                   
                </table>
                </form>
                
            </div>
       </div>
    </div>
        
        
   
   
    
</body>

</html>


        
        
        
        
        <div id="table" class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Company Users</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-hover">
                    <tr>
                        <th>Username</th>
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
                        <td><a  class="btn btn-danger" hidden="" href="delete_user/${user.userId}/page=1">Delete User</a></td>
                        
                    </c:forEach>
                        
                        
                        </tr>
                        
                </table>
                
                <nav aria-label="Page navigation example" class="text-center">
                            <ul class="pagination">
                              <c:forEach begin="1" end="${totalPages}" varStatus="counter">
                              <li class="page-item"><a class="page-link" href="show_users?page=${counter.count}">${counter.count}</a></li>
                              </c:forEach>
                            </ul>
                </nav>
                
            
                
            </div>
       </div>
    </div>
</div>
</div>
</section>
        
        
      
        <%@include file="bottom.jsp" %>
