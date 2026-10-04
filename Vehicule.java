public class Vehicule {
    protected  String immatriculation;
    protected  String marque; 
    protected Double prix;
    protected Boolean enRevision;

    public Vehicule (String immatriculation, String marque, Double prix, Boolean enRevision) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.prix = prix;
        this.enRevision = false;
    }

    //getters

    public String getImmatriculation () {
        return immatriculation;
    }
    public String getMarque () {
        return marque;
    }
    public Double getPrix () {
        return prix;
    }

    //setter

    public void setImmatriculation (String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public void setMarque (String marque) {
        this.marque = marque;
    }
    public  void setprix(Double prix) {
        this.prix = prix;

    }
    public  void setEnRevision (Boolean enRevision) {
        this.enRevision = true;
    }

    //affichage
    @Override 
    public String toString() {
        return "Immatriculation: " +immatriculation+ " marque: " + marque + " prix: " + prix + " €";
    }

}
