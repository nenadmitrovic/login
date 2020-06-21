<%@include file="top_user.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
<section  id="main">
    
    <div class="container col-lg-offset-3">
    
        <div class="row">
        
        <div id="table" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Descriptor</h3>
            </div>
            <div class="panel-body">
                
                <form action="save_desc_after_edit/${descriptor.id}/${document.documentId}" method="post">
                    
                <div class="form-group">
    		<label>Mark:</label>
                <input name="mark" type="text" value="${descriptor.mark}" class="form-control" placeholder="Enter Mark">
                </div>
                <div class="form-group">
    		<label>Name:</label>
                <input name="name" type="text" value="${descriptor.name}" class="form-control" placeholder="Enter Name">
                </div>
                <div class="form-group">
                <label>Type:</label><br>
                <input type="text" name="type" value="${descriptor.type}"></textarea>
                </div>
                    
                <input type="submit" value="Save"  class="btn btn-default btn-block main-color-bg"/>
                
                
                    
                    
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

