package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws Exception {

		System.out.println("Quel est le code du département recherché ? ");

		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");

		try {
			String saisieMin = scanner.nextLine();
			System.out.println("Choississez une population maximum (en milliers d'habitants): ");
			String saisieMax = scanner.nextLine();

			if (!Character.isDigit(saisieMin.charAt(0))) {
				throw new Exception("Probleme sur la saisie min");
			} else if (!Character.isDigit(saisieMax.charAt(0))) {
				throw new Exception("Probleme sur la saisie max");
			}

			int min = Integer.parseInt(saisieMin) * 1000;
			int max = Integer.parseInt(saisieMax) * 1000;

			List<Ville> villes = rec.getVilles();
			for (Ville ville : villes) {
				if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
					if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
						System.out.println(ville);
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage() + "\nCe n'est pas un chiffre");
		}

	}

}
