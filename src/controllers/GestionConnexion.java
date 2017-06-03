package controllers;

import javax.servlet.http.HttpServletRequest;

import beans.Client;

public class GestionConnexion extends AbstractGestion{


	public Client connectClient( HttpServletRequest request ) {
		/* Récupération des champs du formulaire */
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);

		Client client = new Client();

		/* Validation email. */
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		client.setEmail(email);

		/* Validation mot de passe. */
		try {
			validationPassword(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		client.setPassword(motDePasse);

		/* Initialisation du résultat. */
		if ( erreurs.isEmpty() ) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}

		return client;
	}


}



