package xyz.nahidwin.lot5.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private String numero;
    private Date date;
    private Date dateEnvoiConf = null;

    private AnnulationClient annulation = null;
    private final ArrayList<Billet> billets = new ArrayList<Billet>();
    private Client client;
    private Representation representation;
    private Facture facture;

    public Reservation(String numero, Client c, Billet b, Representation r) {
        this.numero = numero;
        this.client=c;

        this.billets.add(b);
        this.representation = r;
        this.facture=null;

        this.date = Calendar.getInstance().getTime();
    }

    public Reservation(String numero, Client c, Billet b, Representation r, Facture f) {
        this.numero = numero;
        this.client=c;

        this.billets.add(b);
        this.representation = r;
        this.facture=f;

        this.date = Calendar.getInstance().getTime();
    }

    // -- Confirmation de la Reservation --

    public void confirmerReservation(){
        dateEnvoiConf = Calendar.getInstance().getTime();
    }

    public boolean estConfirmee(){
        return this.dateEnvoiConf != null;
    }

    // -- Annulation --

    public void annulerReservation(){
        this.annulation = new AnnulationClient(Calendar.getInstance().getTime());
    }

    // -- Billets

    // THINKER ajouterBillet
    public void ajouterBillet(Billet b){
        if (b==null){
            System.out.println("Le billet mis en parametre est vide");
        } else if (this.billets.contains(b)){
            System.out.println("La reservation contient deja ce billet");
        } else {
            addBillet(b);
        }
    }

    // DOER ajouterBillet
    protected void addBillet(Billet b){
        billets.add(b);
    }

    // THINKER supprimerBillet
    public void supprimerBillet(Billet b){
        if (b==null){
            System.out.println("Le billet mis en parametre est vide");
        } else if (!this.billets.contains(b)){
            System.out.println("La reservation ne contient pas ce billet");
        } else if (billets.size()<=1){
            System.out.println("La reservation doit contenir au moins 1 billet");
        } else {
            addBillet(b);
        }
    }

    // DOER supprimerBillet
    protected void removeBillet(Billet b){
        billets.remove(b);
    }

    // -- GETTERs et SETTERs --

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateEnvoiConf() {
        return dateEnvoiConf;
    }

    public Annulation getAnnulation() {
        return annulation;
    }

    public ArrayList<Billet> getBillets(){
        return this.billets;
    }

    public Facture getFacture(){
        return this.facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Client getClient(){
        return this.client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Representation getRepresentation(){
        return this.representation;
    }

    // -- Affichage --

    public void afficherConfirmation(){
        if (estConfirmee()) {
            System.out.println("La reservation n'a pas été confirmee");
        } else{
            System.out.println(this.dateEnvoiConf);
        }
    }

    public void afficherAnnulation(){
        if (this.annulation==null){
            System.out.println("La reservation n'a pas ete annulee");
        } else {
            System.out.println(this.annulation);
        }
    }

    public void afficheBillets(){
        for (Billet b : billets){
            System.out.println(b);
            System.out.println("\n----------------\n");
        }
    }

    public void afficherFacture(){
        if (this.facture==null){
            System.out.println("La reservation n'a pas de facture");
        } else {
            System.out.println(this.facture);
        }
    }

    public void afficherClient(){
        System.out.println(this.client);
    }

    public String toString(){
        String messageConfirmation;
        if (estConfirmee()){
            messageConfirmation = "Date de la confirmation : " + this.dateEnvoiConf;
        } else {
            messageConfirmation = "La reservation n'a pas ete confirmee";
        }
        return "Representation : " + this.representation +"Numero de la reservation : " + this.numero + "\n\nClient : " + this.client.toString()+"\n\nDate de creation : " + this.date.toString() + "\n\n" + messageConfirmation;
    }

    public void afficher(){
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;
        return Objects.equals(getNumero(), that.getNumero()) && getBillets().equals(that.getBillets()) && Objects.equals(getClient(), that.getClient()) && Objects.equals(getRepresentation(), that.getRepresentation());
    }
}
