<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <c:if test="${!empty sessionScope.sessionClient}">  
				Bonjour ${sessionScope.sessionClient.firstName} ${sessionScope.sessionClient.lastName} ! <br>
				Votre inscription a été effectuée avec succès, bienvenue sur notre site !
                </c:if>
                <p>Vous pouvez vous connecter à votre espace client via ce formulaire.</p>

                <label for="nom">Adresse email </label>
                <input type="email" id="email" name="email" value="<c:out value="${client.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${connexion.erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe</label>
                <input type="password" name="password" id="password1" value="" size="20" maxlength="20" />
                <span class="erreur">${connexion.erreurs['password']}</span>
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p class="${empty connexion.erreurs ? 'succes' : 'erreur'}">${connexion.resultat}</p>
                                
            </fieldset>
        </form>
    </body>
</html>