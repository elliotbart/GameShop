package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Client;

public class GestionInscription {

	private static final String CHAMP_EMAIL = "username";
	private static final String CHAMP_PASS = "password";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_DATE_NAISSANCE = "date_naissance";
	private static final String CHAMP_PASS_CHECK = "check";
	
	Map<String, String> erreurs = new HashMap<String, String>();

	private String resultat = "";

	public Client getClient(HttpServletRequest request) {
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String birthDate = getValeurChamp(request, CHAMP_DATE_NAISSANCE);
		String checkmotDePasse = getValeurChamp(request, CHAMP_PASS_CHECK);

		Client client = new Client();

		/* Validation du champ email. */
		try {
			validationEmail(email);
		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		client.setEmail(email);

		/* Validation du champ mot de passe. */
		try {
			validationPassword(motDePasse);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
		client.setPassword(motDePasse);

		try {
			checkReTypePassword(motDePasse, checkmotDePasse);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS_CHECK, e.getMessage());
		}
		
		try {
			checkNames(nom);
		}
		catch (Exception e) {
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
		client.setLastName(nom);
		try {
			checkNames(prenom);
		}
		catch (Exception e) {
			erreurs.put(CHAMP_PRENOM, e.getMessage());
		}
		client.setFirstName(prenom);
		
		try {
			Date birth = getStringToDate(birthDate);
			System.out.println(birth.toString());
			checkBirthDate(birth);
		} 
		catch (Exception e) {
			erreurs.put(CHAMP_DATE_NAISSANCE, e.getMessage());
			
		}
		client.setBirthDate(birthDate);

		if (erreurs.isEmpty()){
			resultat = "Succès de l'inscription.";
		}
		else {
			resultat = "Echec de l'inscription";
		}
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
	
	private void checkBirthDate(Date date) throws Exception {
		//Date currentDate = Calendar.getInstance().getTime();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -18);
		Date majorityDate = cal.getTime();

		if (majorityDate != null) {
			if(date.after(majorityDate)) {
				throw new Exception("Vous devez être majeur(e) pour vous inscrire... Vous pouvez quand même consulter le catalgue sans authentification :) ");
			} 
		}
		else 
			throw new Exception("Merci d'entrer une date de naissance"); // Impossible d'arriver ici avec JS google
	}

	private static Date getStringToDate(String date) throws ParseException {
		System.out.println(date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date returnDate = formatter.parse(date);
		
		System.out.println(returnDate);
		return returnDate;
		
	}

	private void validationPassword(String motDePasse) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.length() < 5) {
				throw new Exception("Le mot de passe doit contenir au moins 5 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}

	private void checkReTypePassword(String motDePasse, String checkmotDePasse) throws Exception {
		if (checkmotDePasse != null) {
			if (checkmotDePasse.length() < 5) {
				throw new Exception("Le mot de passe doit contenir au moins 5 caractères.");
			} else if (!checkmotDePasse.equals(motDePasse)) {
				throw new Exception("Les mots de passe doivent être identiques !");
			}
		} else {
			throw new Exception("Merci de saisir votre verification du mot de passe.");
		}
	}
	
	private void checkNames(String name) throws Exception {
		if (name == null) {
			throw new Exception("Nom ou prénom vide");
		}
		else if (!name.matches("^[a-zA-Z]+$")){
			throw new Exception("Les noms doivent contenir uniquement des caractères alphabétiques");
		}
	}
	
	private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

	
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	public Map<String,String> getErreurs() {
		return erreurs;
	}

}
