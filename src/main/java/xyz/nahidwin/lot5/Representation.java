package xyz.nahidwin.lot5;

import java.util.ArrayList;
import java.util.Objects;

public class Representation {
    private String jour;
    private String heure;
    private boolean annulee;
    private final ArrayList<Reservation> reservations = new ArrayList<>();

    public Representation(String jour, String heure){
        this.jour = jour;
        this.heure = heure;
        this.annulee = false;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return "Representation{" +
                "jour='" + jour + '\'' +
                ", heure='" + heure + '\'' +
                ", annulee=" + annulee + '\'' +
                ", reservations=" + reservations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Representation that = (Representation) o;
        return isAnnulee() == that.isAnnulee() && Objects.equals(getJour(), that.getJour()) && Objects.equals(getHeure(), that.getHeure());
    }

    public void ajoutReversation(Reservation reservation){
        if (this.reservations.contains(reservation)){
            System.out.println("La réservation est déjà présente");
        }
        else if(reservation == null){
            System.out.println("La réservation est vide");
        }
        else{
            ajouterReservation(reservation);
        }
    }

    public void ajouterReservation(Reservation reservation){
        this.reservations.add(reservation);
    }
}
