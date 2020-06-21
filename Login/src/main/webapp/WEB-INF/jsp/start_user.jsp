<%@include file="top_user.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
<section  id="main">
    
    <div class="container col-lg-offset-3">
    
        <div class="row">
        
        <div id="table" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Document Type</h3>
            </div>
            <div class="panel-body">
                
                <form action="save_document_type" method="post">
                    
                <div class="form-group">
    		<label>Mark:</label>
                <input name="mark" type="text" class="form-control" placeholder="Enter Mark">
                </div>
                <div class="form-group">
    		<label>Name:</label>
                <input name="name" type="text" class="form-control" placeholder="Enter Name">
                </div>
                <div class="form-group">
                <label>Description:</label><br>
                <textarea name="description"></textarea>
                </div>
                    
                <input type="submit" value="Save"  class="btn btn-default btn-block main-color-bg"/>
                
                
                    
                    
                </div>
                
                </form>
                
               
                
                
                
            </div>
       </div>
      
            
                
        <div id="table" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Descriptors</h3>
            </div>
            <div class="panel-body">
                <table style="text-align: center;" id="tabela" class="table table-striped table-hover">
                    <tr style="text-align: center;">
                        <th style="text-align: center;">Mark</th>
                        <th style="text-align: center;">Name</th>
                        <th style="text-align: center;" >Type</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                   
                    <c:forEach items="${descriptors}" var="desc">
                        
                        <tr style="text-align: center">
                        <td>${desc.mark}</td>
                        <td>${desc.name}</td>
                        <td>${desc.type}</td>
                        
                       
                        
                    </c:forEach>
                        
                        
                        </tr>
                        
                </table>
                
               
                
            
                
            </div>
       </div>
    </div>
        
        <div id="table" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Add new descriptor</h3>
            </div>
            <div class="panel-body">
                
                <form action="save_descriptor" method="post">
                    
                <div class="form-group">
    		<label>Mark:</label>
                <input name="mark" type="text" class="form-control" placeholder="Enter Mark">
                </div>
                <div class="form-group">
    		<label>Name:</label>
                <input name="name" type="text" class="form-control" placeholder="Enter Name">
                </div>
                    
                <div class="form-group">
    		<label>Type:</label>
                <select name="type">
                    <c:forEach items="${types}" var="type">
                        
                        <option value="${type}">${type}</option>
                        
                    </c:forEach>
                   
                </select><br><br>
                
                <input type="submit" value="Save" />
                
                </div>
                </div>
                </form>
            </div>
       </div>
        
        
        
    </div>
    
    
    </div>
        
    </div>
        
       
        
      
        
        
    </div>
        
          
    </div>
    </div>
    
    </section>
      
        <%@include file="bottom.jsp" %>
