<%@include file="top.jsp" %>
    
   
    
    <section id="main">
    
    <div class="container">
    
    <div class="row">
    
        <%@include file="sidebar_company.jsp" %>
    
        <div id="add_company" class="col-md-7">
     <form action="add_companyy" method="post" id="login" class="well" >
  	<div class="form-group">
    		<label>Company name:</label>
                <input name="name" type="text" class="form-control" placeholder="Company name">
  	</div>
    <div class="form-group">
    		<label>Company adress:</label>
                <input name="adress" type="text" class="form-control" placeholder="Company adress">
  	</div>
    <div class="form-group">
    		<label>Company ID:</label>
                <input name="id_number" type="text" class="form-control" placeholder="Company ID">
  	</div>
    
    <button   type="submit" class="btn btn-default btn-block main-color-bg">Add Company</button>
    </form>
    
    
    
    
    
    </div>
    
    
    </div>
    </div>
   
    
    
    
    
    </section>
      
        <%@include file="bottom.jsp" %>
