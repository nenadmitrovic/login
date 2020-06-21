<%@include file="top.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<section id="main">
  <div class="container">
    <div class="row">
        <%@include file="sidebar_others.jsp" %>
       <div id="table" class="col-md-8">
        <div class="panel panel-default">
            <div class="panel-heading main-color-bg">
                <h3 class="panel-title">Documents</h3>
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
                    <c:forEach items="${documents}" var="doc">
                        <tr style="text-align: center">
                        <td>${doc.mark}</td>
                        <td>${doc.name}</td>
                        <td>${doc.description}</td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="edit_document/${doc.documentId}">Edit Document</a></td>
                        <td><a class="btn btn-danger main-color-bg" hidden="" href="delete_document/${doc.documentId}">Delete Document</a></td>
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
