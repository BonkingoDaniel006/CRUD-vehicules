import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestionStock gestionStock = new GestionStock();
        Scanner scanner = new Scanner(System.in);
        boolean enExecution = true;

        System.out.println(" BIENVENUE DANS LA GESTION DE STOCK de véhicule pour BOKINGO ");

        while (enExecution) {
            afficherMenu();
            System.out.print("Faites votre choix : ");

            if (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.nextLine(); // Nettoie la saisie incorrecte
                continue;
            }

            int choix = scanner.nextInt();
            scanner.nextLine(); // Nettoie le retour à la ligne dans le buffer

            switch (choix) {
                case 1 -> ajouterVehiculeUI(scanner, gestionStock);
                case 2 -> afficherTousLesVehiculesUI(gestionStock);
                case 3 -> chercherVehiculeUI(scanner, gestionStock);
                case 4 -> modifierVehiculeUI(scanner, gestionStock);
                
            }
        }

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Ajouter un véhicule");
        System.out.println("2. Afficher tous les vehicules");
        System.out.println("3. Rechercher un véhicule");
        System.out.println("4. Modifier un vehicule (nom, prix, matricule)");
        System.out.println("5. Supprimer un véhicule");
        System.out.println("6. Quitter");
    }

    private static void ajouterVehiculeUI(Scanner scanner, GestionStock gestionStock) {
        System.out.print("Entrez le matricule : ");
        String immatriculation = scanner.nextLine();
        System.out.print("Entrez la marque : ");
        String marque = scanner.nextLine();
        Boolean enRevision = true;

        System.out.print("Entrez le prix du produit (€) : ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Prix invalide. Entrez un nombre valide : ");
            scanner.next();
        }
        double prix = scanner.nextDouble();
        scanner.nextLine(); 
        

        boolean succes = gestionStock.ajouterVehicule( immatriculation, marque, prix, enRevision);
        if (succes) {
            System.out.println("Produit ajouté avec succès !");
        } else {
            System.out.println("Erreur : Un produit avec ce nom existe déjà.");
        }
    }

    private static void afficherTousLesVehiculesUI(GestionStock gestionStock) {
        if (gestionStock.estVide()) {
            System.out.println("Le stock est actuellement vide.");
            return;
        }

        List<Vehicule> vehicules = gestionStock.getTousLesVehicules();
        System.out.println("\n--- LISTE DU STOCK ---");
        for (Vehicule p : vehicules) {
            System.out.println("- " + p);
        }
    }


    private static void chercherVehiculeUI(Scanner scanner, GestionStock gestionStock) {
        System.out.print("Entrez le matricule du produit à chercher : ");
        String matricule = scanner.nextLine();

        Vehicule vehicule = gestionStock.chercherVehicule(matricule);
        if (vehicule != null) {
            System.out.println("Produit trouvé. marque: " + vehicule);
        } else {
            System.out.println("Aucun produit trouvé sous ce nom.");
        }
    }

    private static void modifierVehiculeUI (Scanner scanner, GestionStock gestionStock) {
        System.out.print("Entrez l'immatriculation du vehicule à modifier : ");
        String immatriculation = scanner.nextLine();

        Vehicule vehicule = gestionStock.chercherVehicule(immatriculation);
        if (vehicule == null) {
            System.out.println("Produit introuvable.");
            return;
        }

        System.out.println("Produit sélectionné : " + vehicule);
        System.out.println("1. Modifier la marque");
        System.out.println("2. Modifier le prix");
        System.out.println("3. Modifier le matricule");
        System.out.print("Votre choix : ");

        if (!scanner.hasNextInt()) {
            System.out.println("Saisie invalide.");
            scanner.nextLine();
            return;
        }

        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            System.out.print("Entrez la nouvelle marque : ");
            String nouvelleMarque = scanner.nextLine();
            boolean succes = gestionStock.modifierMarque(immatriculation, nouvelleMarque);
            if (succes) {
                System.out.println("Marque modifié avec succès !");
            } else {
                System.out.println("Erreur : Le nouveau nom existe déjà ou est invalide.");
            }
        } else if (choix == 2) {
            System.out.print("Entrez le nouveau prix (€) : ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Prix invalide. Entrez un nombre valide : ");
                scanner.next();
            }
            double nouveauPrix = scanner.nextDouble();
            scanner.nextLine();

            boolean succes = gestionStock.modifierPrix(immatriculation, nouveauPrix);
            if (succes) {
                System.out.println("Prix mis à jour avec succès !");
            }
        } else if (choix == 3){
            System.out.println("Entrez le nouveau matricule: ");
            String nouveauMatricule = scanner.nextLine();

            boolean succes = gestionStock.modifierImmatriculationVehicule(immatriculation, nouveauMatricule);

            if (succes){
                System.out.println("matricule mit à jour");
                
            }
        }else {
            System.out.println("Choix invalide.");
        }
    }

   
}