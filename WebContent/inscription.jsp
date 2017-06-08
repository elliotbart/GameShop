<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="beans.Game"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>


<!-- Bootstrap core CSS -->
<link href="bootstrap_projet/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap_projet/css/shop-homepage.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap_projet/css/shop-inscription.css" rel="stylesheet">


</head>

<body>
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-toggleable-md navbar-inverse bg-inverse">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarExample"
		aria-controls="navbarExample" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="container">
		<a class="navbar-brand" href="#">Vente en ligne de jeux vidéos</a>
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="homeservlet">Accueil<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="inscription">Inscription</a>
				</li>
				<c:if test="${empty sessionScope.sessionClient}">
					<li class="nav-item"><a class="nav-link" href="connexion">Connexion</a>
					</li>
				</c:if>
				<c:if test="${!empty sessionScope.sessionClient}">
					<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		    <div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">EPV Games</h1>

			</div>
			</div>
			<!-- /.col-lg-3 -->

			
			
			
			<div class="row">
			<div class="col-lg-9">

					<form method="post" action="inscription">
					<fieldset>
						<label for="Email">E-mail :</label> <input type="email"
							name="email" id="email1" value="<c:out value="${client.email}"/>" />
						<span class="erreur">${inscription.erreurs['email']}</span> <br />
						<label for="Password">Mot de passe :</label> <input
							type="password" name="password" id="password1" /> <span
							class="erreur">${inscription.erreurs['password']}</span> <br />
						<label for="CheckPassword">Re-taper le mot de passe :</label> <input
							type="password" name="check" id="check" /> <span class="erreur">${inscription.erreurs['check']}</span>
						<br /> <label for="Nom">Nom :</label> <input type="text"
							name="nom" id="nom1" value="<c:out value="${client.lastName}"/>" />
						<span class="erreur">${inscription.erreurs['nom']}</span> <br />
						<label for="Prenom">Prénom :</label> <input type="text"
							name="prenom" id="prenom1"
							value="<c:out value="${client.firstName}"/>" /> <span
							class="erreur">${inscription.erreurs['prenom']}</span> <br /> <label
							for="Date naissance">Date naissance (yyyy-mm-dd):</label> <input
							type="date" min="1900-01-01" max="2017-12-12"
							name="date_naissance" id="date_naissance1"
							value="<c:out value="${client.birthDate}"/>" /> <span
							class="erreur">${inscription.erreurs['date_naissance']}</span> <br />
						<%-- <input type="hidden" name="id_client" value="${uModif.id_client}"/> --%>
						<input type="reset" value=" Reset " /> <input type="submit"
							value="Valider" />
						</fieldset>
					</form>
					<p class="${empty inscription.erreurs ? 'succes' : 'erreur'}">${inscription.resultat}</p>


				</div>

				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->


	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-inverse">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2017</p>
	</div>
	<!-- /.container -->
	 </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="bootstrap_projet/vendor/jquery/jquery.min.js"></script>
	<script src="bootstrap_projet/vendor/tether/tether.min.js"></script>
	<script src="bootstrap_projet/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
