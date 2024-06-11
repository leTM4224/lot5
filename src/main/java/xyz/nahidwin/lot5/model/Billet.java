package xyz.nahidwin.lot5.model;

public class Billet {
    private String numero;

    private Reservation reservation;
    // private Fauteuil fauteuil;
    // private Tarification tarif;

    public Billet(String numero){
        this.numero=numero;
    }

    // Reservation

    // THINKER ajouterReservation
    public void ajouterReservation(Reservation reservation){
        if (reservation==null){
            System.out.println("La reservation en parametre est vide");
        } else {
            addReservation(reservation);
        }
    }

    // DOER ajouterReservation
    protected void addReservation(Reservation reservation){
        this.reservation=reservation;
    }

    // THINKER supprimerReservation
    public void supprimerReservation(){
        if (this.reservation == null){
            System.out.println("Il n'y a pas de reservation");
        } else {
            removeReservation();
        }
    }

    // DOER supprimerReservation
    protected void removeReservation(){
        this.reservation=null;
    }

    // -- GETTERs et SETTERs --

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Reservation getReservation(){
        return this.reservation;
    }

    // -- Affichage --

    public String toString(){
        return this.numero;
    }

    public void affichage(){
        System.out.println(this.toString());
    }
}
