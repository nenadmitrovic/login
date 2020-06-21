
<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<section id="main">
  <div class="container">
    <div class="row">
        <%@include file="sidebar_others.jsp" %>
       <div id="table" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Current document</h3>
            </div>
            <div class="panel-body">
                <table style="text-align: center;" id="tabela" class="table table-striped table-hover">
                    <tr style="text-align: center;">
                        <th style="text-align: center;">Mark</th>
                        <th style="text-align: center;">Name</th>
                        <th style="text-align: center;" >Description</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                        <tr style="text-align: center">
                        <td>${document.mark}</td>
                        <td>${document.name}</td>
                        <td>${document.description}</td>
                    </tr>
                </table>
           </div>
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
                        <tr style="text-align: center">
                        <c:forEach items="${descriptors}" var="desc">
                        </tr>
                        <tr style="text-align: center">
                        <td>${desc.mark}</td>
                        <td>${desc.name}</td>
                        <td>${desc.type}</td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="delete_descriptor/${desc.id}/${document.documentId}">Delete Document</a></td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="edit_descriptor/${desc.id}/${document.documentId}">Edit Descriptor</a></td>
                        </tr>
                        
                        
                        </c:forEach>
                        
                    </tr>
                </table>
           </div>
       </div>
    </div>
                    
    
        
     <div id="table" style="margin-left: 290px;" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Add new descriptor for current document</h3>
            </div>
            <div class="panel-body">
                
                <form action="add_new_descriptor/${document.documentId}" method="post">
                    
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
                
                <input type="submit" value="Save"  class="btn btn-default btn-block main-color-bg"/>
                
                </div>
                </div>
                </form>
            </div>
       </div>
    
        
        
       
</div>
    </div>
     
    </section>
      
        <%@include file="bottom.jsp" %>
