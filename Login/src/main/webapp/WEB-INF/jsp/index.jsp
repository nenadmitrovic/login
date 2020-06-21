<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
    <section id="main">
    
    <div class="container">
    
    <div class="row">
    
        <%@include file="sidebar_company.jsp" %>
    
        <div id="table" class="col-md-7">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Companies</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-hover">
                    <tr>
                        <th>Name</th>
                        <th>Adress</th>
                        <th>ID Number</th>
                        <th></th>
                         <th></th>
                    </tr>
                   
                    <c:forEach items="${companies}" var="company">
                        
                    <tr>
                        <td>${company.name}</td>
                        <td>${company.adress}</td>
                        <td>${company.idNumber}</td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="add/${company.companyId}">Create User</a></td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="showByCompany/${company.companyId}">Show Users</a></td>
                    </tr>
                   
                    </c:forEach>
                    
                </table>
                
                
            </div>
       </div>
    </div>
    
    
    </div>
    </div>
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
