package xyz.nahidwin.lot5.model;

public abstract class Paiement {
    protected boolean realise;

    public Paiement(boolean realise) {
        this.realise = realise;
    }

    public Paiement(){
        this.realise = false;
    }

    public void validerPaiement() {
        this.realise = true;
    }

    public boolean isRealise() {
        return realise;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "realise=" + realise +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paiement paiement = (Paiement) o;
        return isRealise() == paiement.isRealise();
    }

    public void afficher() {
        System.out.println(this.toString());
    }
}
