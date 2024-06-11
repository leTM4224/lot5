package xyz.nahidwin.lot5.model;

import java.util.Date;

public abstract class Annulation {
    private Date date;
    private boolean remboursementEffectue;

    public Annulation(Date date) {
        this.date = date;
        this.remboursementEffectue = false;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRemboursementEffectue() {
        return remboursementEffectue;
    }

    public void setRemboursementEffectue(boolean remboursementEffectue) {
        this.remboursementEffectue = remboursementEffectue;
    }

    public void remboursement(){
        if (!remboursementEffectue) {
            rembourser();
        }
        else{
            System.out.println("Le remboursement à déjà été effectué.");
        }
    }

    public void rembourser(){
        this.remboursementEffectue = true;
    }

    @Override
    public String toString() {
        return "Annulation{" +
                "date=" + date +
                ", remboursementEffectue=" + remboursementEffectue +
                '}';
    }

    public void afficher(){
        System.out.println(this.toString());
    }
}