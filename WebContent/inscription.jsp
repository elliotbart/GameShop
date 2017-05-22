<%@ page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="utf-8" />

        <title>Inscription</title>

        <!--  <link type="text/css" rel="stylesheet" href="form.css" />-->

    </head>

    <body>

       <form method="post" action="Inscription">
		<label for="Username">E-mail :</label>
		<input type="text" name="username" id="username1" />
		<span class="erreur">${form.erreurs['username']}</span>
		<br />
		<label for="Password">Mot de passe :</label>
		<input type="password" name="password" id="password1" />
		<span class="erreur">${form.erreurs['password']}</span>
		<br />
		<label for="CheckPassword">Re-taper le mot de passe :</label>
		<input type="password" name="check" id="check"/>
		<span class="erreur">${form.erreurs['check']}</span>
		<br />
		<label for="Nom">Nom :</label>
		<input type="text" name="nom" id="nom1"/>
		<br />
		<label for="Prenom">Prénom :</label>
		<input type="text" name="prenom" id="prenom1" />
		<br />
		<label for="Date naissance">Date naissance:</label>
		<input type="date" name="date_naissance" id="date_naissance1" />
		<br />
		<%-- <input type="hidden" name="id_client" value="${uModif.id_client}"/> --%>
		<input type="reset" value=" Reset " />
		<input type="submit" value="Valider" />
	</form>
	
	 <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	 
	 
     <c:if test="${empty form.erreurs}">

        <!-- <p >Sucess de l'inscription. </p> -->

    </c:if>

    </body>

</html>