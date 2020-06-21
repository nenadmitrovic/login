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
                
                <form action="save_doc_after_edit/${document.documentId}" method="post">
                    
                <div class="form-group">
    		<label>Mark:</label>
                <input name="mark" type="text" value="${document.mark}" class="form-control" placeholder="Enter Mark">
                </div>
                <div class="form-group">
    		<label>Name:</label>
                <input name="name" type="text" value="${document.name}" class="form-control" placeholder="Enter Name">
                </div>
                <div class="form-group">
                <label>Description:</label><br>
                <input type="text" name="description" value="${document.description}"></textarea>
                </div>
                    
                <input type="submit" hidden="${document.documentId}"  value="Save"  class="btn btn-default btn-block main-color-bg"/>
                
                
                    
                    
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
