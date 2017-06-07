<%@ page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Inscription</title>

        <!--  <link type="text/css" rel="stylesheet" href="form.css" />-->

    </head>

    <body>

       <form method="post" action="inscription">
		<label for="Email">E-mail :</label>
		<input type="email" name="email" id="email1" value = "<c:out value="${client.email}"/>"/>
		<span class="erreur">${inscription.erreurs['email']}</span>
		<br />
		<label for="Password">Mot de passe :</label>
		<input type="password" name="password" id="password1" />
		<span class="erreur">${inscription.erreurs['password']}</span>
		<br />
		<label for="CheckPassword">Re-taper le mot de passe :</label>
		<input type="password" name="check" id="check"/>
		<span class="erreur">${inscription.erreurs['check']}</span>
		<br />
		<label for="Nom">Nom :</label>
		<input type="text" name="nom" id="nom1" value = "<c:out value="${client.lastName}"/>"/>
		<span class="erreur">${inscription.erreurs['nom']}</span>
		
		<br />
		<label for="Prenom">Prénom :</label>
		<input type="text" name="prenom" id="prenom1" value = "<c:out value="${client.firstName}"/>" />
		<span class="erreur">${inscription.erreurs['prenom']}</span>
		
		<br />
		<label for="Date naissance">Date naissance (yyyy-mm-dd):</label>
		<input type="date"  min="1900-01-01" name="date_naissance" id="date_naissance1" value = "<c:out value="${client.birthDate}"/>" />
				<span class="erreur">${inscription.erreurs['date_naissance']}</span>
		
		<br />
		<%-- <input type="hidden" name="id_client" value="${uModif.id_client}"/> --%>
		<input type="reset" value=" Reset " />
		<input type="submit" value="Valider" />
	</form>
	
<<<<<<< HEAD
	 <p class="${empty inscription.erreurs ? 'succes' : 'erreur'}">${inscription.resultat}</p>
	 
	 
     
=======
	 <p class="${empty form.hasErrorOccured() ? 'succes' : 'erreur'}">${form.resultat}</p>
	 
	 
     <c:if test="${empty form.hasErrorOccured()}">

        <!-- <p >Sucess de l'inscription. </p> -->

    </c:if>

>>>>>>> 1a74711ed48ee7c21d6adf5cf7fb3c56f1493853
    </body>

</html>