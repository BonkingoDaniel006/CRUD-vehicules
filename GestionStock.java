import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * GestionStock
 */
public class GestionStock {

    private  final Map<String, Vehicule> stock = new HashMap<>();

    public boolean ajouterVehicule (String immatriculation, String marque, Double prix, boolean enRevision){
        String cle = immatriculation;

        if (stock.containsKey(cle)){
            return false;
        }
        Vehicule vehicule = new Vehicule(immatriculation, marque, prix, null);
        stock.put(cle, vehicule);


        return true;
    }

    public Vehicule chercherVehicule(String immatriculation) {
        return stock.get(immatriculation);

    }

    public boolean modifierImmatriculationVehicule (String ancienMatricule, String NouveauMatricule) {
        String ancienneCle = ancienMatricule;
        String nouvellecle = NouveauMatricule;

        if (!stock.containsKey(nouvellecle) || stock.containsKey(nouvellecle)) {
            return false;
        }
        Vehicule vehicule = stock.remove(ancienneCle);
        vehicule.setImmatriculation(NouveauMatricule);
        stock.put(nouvellecle, vehicule);
        return true;
    }
}