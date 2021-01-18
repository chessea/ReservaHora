<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Mascota</title>



    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200&display=swap" rel="stylesheet">
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">


    <script src="https://kit.fontawesome.com/9da6b49243.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="views/styles.css">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/ReservaHora/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="mascotas?opcion=crear">Ingresar Mascotas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="mascotas?opcion=listar">Listar Mascotas</a>
        </li>
     
      </ul>
    </div>
  </div>
</nav>




<div class="container p-4">
    <div class="row">
        <div class="col-md-4 mx-auto">

            <div class="card">
                <span class="border border-light">
                    <div class="card-body">
                        <h5 class="card-title text-center text-white bg-secondary p-2">Agregar Mascota</h5>
                   
                        <br>
                        <form action="mascotas" method="post">
                             <input type="hidden" name="opcion" value="guardar">
                            <div class="form-group">
                                <input type="text" class="form-control" name="nombreMascota"
                                    placeholder="Nombre de la mascota" autofocus>
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="text" name="rutDueno" class="form-control"
                                    placeholder="Rut del Dueno">
                            </div>
                           
                            <br>
                            <div class="form-group d-grid gap-2">
                                <button type="submit" class="btn btn-success btn-block">Guardar</button>
                            </div>
                        </form>


                </span>
            </div>

        </div>
    </div>
</div>



	
	
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

</body>
</html>