package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import beans.Client;

public class GestionInscription {

	private static final String CHAMP_EMAIL = "username";
	private static final String CHAMP_PASS = "password";
	
	private boolean errorOccured = false;
	private String resultat = "";

	public Client getClient(HttpServletRequest request) {
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String nom = getValeurChamp(request, "nom");
		String prenom = getValeurChamp(request, "prenom");
		String birthDate = getValeurChamp(request, "date_naissance");
		String checkmotDePasse = getValeurChamp(request, "check");

		Client client = new Client();

		/* Validation du champ email. */
		try {
			validationEmail(email);
		} catch (Exception e) {
			errorOccured = true;
		}
		client.setEmail(email);

		/* Validation du champ mot de passe. */
		try {
			validationPassword(motDePasse);
		} catch (Exception e) {
			errorOccured = true;
		}
		client.setPassword(motDePasse);

		try {
			checkReTypePassword(motDePasse, checkmotDePasse);
		} catch (Exception e) {
			errorOccured = true;
		}

		client.setLastName(nom);
		client.setFirstName(prenom);
		client.setBirthDate(birthDate);

		// /* Initialisation du r茅sultat global de la validation. */
		// if ( !erreurs.isEmpty() ) {
		// resultat = "echec de l'inscription.";
		// }/* else {
		// resultat = "echec de l'inscription.";
		// }*/

		return client;
	}

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
	
	private boolean checkDate(Date date) {
		Date currentDate = Calendar.getInstance().getTime();
		if(date.after(currentDate)) {
			return true;
		} else {
			return false;
		}
	}

	private static Date getValeurDate(HttpServletRequest request, String nomChamp) throws ParseException {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			Date valeur_date = new SimpleDateFormat("yyyy-MM-dd").parse(valeur);
			return valeur_date;
		}
	}

	private void validationPassword(String motDePasse) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caract猫res.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}

	private void checkReTypePassword(String motDePasse, String checkmotDePasse) throws Exception {
		if (checkmotDePasse != null) {
			if (checkmotDePasse.length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caract猫res.");
			} else if (!checkmotDePasse.equals(motDePasse)) {
				throw new Exception("veuillez taper les memes mot de passe .");
			}
		} else {
			throw new Exception("Merci de saisir votre verifivation de mot de passe.");
		}
	}
	
	private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

	public boolean hasErrorOccured() {
		return errorOccured;
	}

	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}
