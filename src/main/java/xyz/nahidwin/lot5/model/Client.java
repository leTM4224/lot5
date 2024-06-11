package xyz.nahidwin.lot5.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Client {
    // RFC 5322 compliant regex with correction for the 00 bug in the IP pattern
    private static final Pattern EMAIL_VALIDATION_REGEX = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"
            , Pattern.CASE_INSENSITIVE);

    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mail;
    private String numero;
    private final ArrayList<Reservation> mesReservation;

    public Client(String nom, String prenom, String adresse, String tel, String mail, String numero, Reservation reservation) throws InvalidFormatException{
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

        try {
            int temp = Integer.parseInt(tel);
            if (tel.length() == 10) this.tel = tel;
            else throw new InvalidPhoneFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Numero de telephone invalide");
        }

        Matcher matcher = EMAIL_VALIDATION_REGEX.matcher(mail);
        if (matcher.find()) this.mail = mail;
        else throw new InvalidMailFormatException();

        this.numero = numero;

        if (reservation == null) throw new IllegalArgumentException();
        else {
            this.mesReservation = new ArrayList<>();
            this.mesReservation.add(reservation);
        }
    }

    public Client(String nom, String prenom, String adresse, String tel, String mail, String numero, ArrayList<Reservation> mesReservation) throws InvalidFormatException, MinimalSizeException {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

        try {
            int temp = Integer.parseInt(tel);
            if (tel.length() == 10) this.tel = tel;
            else throw new InvalidPhoneFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Numero de telephone invalide");
        }

        Matcher matcher = EMAIL_VALIDATION_REGEX.matcher(mail);
        if (matcher.find()) this.mail = mail;
        else throw new InvalidMailFormatException();

        this.numero = numero;

        if (mesReservation.isEmpty()) throw new MinimalSizeException("Un client a au moins une reservation");
        else this.mesReservation = mesReservation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Reservation> getMesReservation() {
        return mesReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;
        return Objects.equals(getNom(), client.getNom()) && Objects.equals(getPrenom(), client.getPrenom()) && Objects.equals(getAdresse(), client.getAdresse()) && Objects.equals(getTel(), client.getTel()) && Objects.equals(getMail(), client.getMail()) && Objects.equals(getNumero(), client.getNumero());
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

    public void afficher() {
        System.out.println(this.toString());
    }

    //doers
    public void addReservation(Reservation reservation) {
        this.mesReservation.add(reservation);
    }

    public void removeReservatoin(Reservation reservation) {
        this.mesReservation.remove(reservation);
    }

    //thinkers
    public void ajouterReservation(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Cette reservation n'existe pas");
        else if (this.contient(reservation)) throw new IllegalArgumentException("Le client a deja fait cette reservation");
        else addReservation(reservation);
    }

    //utilitary
    protected boolean contient(Object o) {
        return this.mesReservation.contains(o);
    }

    protected int nbReservation() {
        return this.mesReservation.size();
    }
}
