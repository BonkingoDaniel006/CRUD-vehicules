import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GestionStock
 */
public class GestionStock {

    private final Map<String, Vehicule> stock = new HashMap<>();

    public boolean ajouterVehicule(String immatriculation, String marque, Double prix, boolean enRevision) {
        if (stock.containsKey(immatriculation)) {
            return false; // retourne false si un vehicule a cette immatriculation
        }
        Vehicule vehicule = new Vehicule(immatriculation, marque, prix, null);
        stock.put(immatriculation, vehicule);
        return true;
    }

    public Vehicule chercherVehicule(String immatriculation) {
        Vehicule vehicule = stock.get(immatriculation);
        return vehicule;
    }

    public boolean modifierImmatriculationVehicule(String ancienMatricule, String nouveauMatricule) {
        // Si l'ancien n'existe pas, ou si le nouveau existe déjà, on refuse
        if (!stock.containsKey(ancienMatricule) || stock.containsKey(nouveauMatricule)) {
            return false;
        }
        
        // On retire l'ancienne entrée
        Vehicule vehicule = stock.remove(ancienMatricule);
        
        // On met à jour l'immatriculation dans l'objet
        vehicule.setImmatriculation(nouveauMatricule);
        
        // On remet le véhicule dans la map avec sa nouvelle clé
        stock.put(nouveauMatricule, vehicule);
        return true;
    }

    public boolean modifierMarque(String immatriculation, String nouvelleMarque) {
        // On cherche le véhicule par son immatriculation
        Vehicule vehicule = stock.get(immatriculation);
        if (vehicule == null) {
            return false; // Le véhicule n'existe pas
        }
        
        // Pas besoin de modifier la clé de la Map, juste l'attribut du véhicule
        vehicule.setMarque(nouvelleMarque);
        return true;
    }

    public boolean modifierPrix(String immatriculation, Double nouveauPrix) {
        // On cherche le véhicule par son immatriculation
        Vehicule vehicule = stock.get(immatriculation);
        if (vehicule == null) {
            return false; // Le véhicule n'existe pas
        }
        
        // On met à jour le prix
        vehicule.setPrix(nouveauPrix);
        return true;
    }
    public boolean modifierEnrevision (Boolean Enrevision, String immatriculation) {
        // on recupère le vehicule grace à l'immatriculation
        Vehicule vehicule = stock.get(immatriculation);
        if (vehicule == null){
            return false;
        } // le vehicule n'existe pas
        vehicule.setEnRevision(Enrevision);// on modifier Enrevision
        return true;
    }

    public boolean supprimerVehicule (String immatriculation) {

        if (!stock.containsKey(immatriculation)) {
            return false; // Le véhicule n'existe pas dans le stock
        }
    
        // Supprime l'entrée de la Map grâce à sa clé (l'immatriculation)
        stock.remove(immatriculation);
        return true; // Suppression réussie

        }

    // Indique si le stock est vide.
    public boolean estVide() {
        return stock.isEmpty();
    }

    //renvoie la liste de tout les produits

    public List<Vehicule> getTousLesVehicules() {
        return new ArrayList<>(stock.values());
    }
}