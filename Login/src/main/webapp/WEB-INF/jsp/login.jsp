<!DOCTYPE html>
<html lang="en">
  <head>
      <base href="/Login/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Amin Area Account Login</title>
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">

    
  </head>

  <body>

    <nav class="navbar navbar-default ">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <header id="header">
    	<div class="container">
        	<div class="row">
            	<div class="col-md-12">
               	
                <h1 class="text-center">Admin Area<small>Account Login</small></h1>
                
            	</div>
            </div>
        </div>
    </header>

    <section id="main">
    <div class="container">
    <div class="row">
   	<div class="col-md-4 col-md-offset-4">
    
            <form action="login" method="post" id="login" class="well">
  	<div class="form-group">
    		<label>Enter Username</label>
                <input type="text" name="username" class="form-control" placeholder="Enter Username">
  	</div>
    <div class="form-group">
    		<label>Enter Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter Password">
  	</div>
                <input  type="submit" value="Login" class="btn btn-default btn-block" />
    </form>
  
    
    
    
    
    
    </div>
    </div>
    </div>
    </section>
    
    <footer id="footer">
    
    	<p>Copyright Nenad Mitrovic &copy; 2017</p>
    
    </footer>

    


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
    <script src="resources/js/bootstrap.min.js"></script>
   
  </body>
</html>
