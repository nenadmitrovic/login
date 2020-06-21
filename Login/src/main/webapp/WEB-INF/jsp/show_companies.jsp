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
                
                <form action="search_company" method="post">
                <table class="table table-striped table-hover">
                    
                    <tr>
                        <th></th>
                        
                    
                        <th><input type="text" name="name" placeholder="Enter company name" ></th>
                        <th><input type="submit" value="Search" ></th>
                        
                    
                    
                    
                    </tr>
                    <tr> 
                        <th></th>
                        <th></th>
                    </tr
                    
                   
                    
                   
                    <c:forEach items="${companies}" var="company">
                        
                    <tr>
                        <td>${company.companyId}</td>
                        <td>${company.name}</td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="show_company/${company.companyId}">Show Company</a></td>
                        
                    </tr>
                   
                    </c:forEach>
                    
                </table>
                </form>
                
                <nav aria-label="Page navigation example" class="text-center">
                            <ul class="pagination">
                              <c:forEach begin="1" end="${totalCompanies}" varStatus="counter">
                              <li class="page-item"><a class="page-link" href="show_companies?page=${counter.count}">${counter.count}</a></li>
                              </c:forEach>
                            </ul>
                </nav
                
                
                
            </div>
       </div>
    </div>
    
    
    </div>
    </div>
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
