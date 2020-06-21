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
                    </tr>
                    <tr> 
                        <th></th>
                        <th></th>
                    </tr>
                   <tr>
                        <td>${c.companyId}</td>
                        <td>${c.name}</td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="show_company/${c.companyId}">Show Company</a></td> 
                        
                    </tr>
                   
                   
                    
                </table>
                
                
                
            </div>
       </div>
    </div>
    
    
    </div>
    </div>
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
