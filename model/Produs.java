package model;

public class Produs {
    private int id;
    private String denumire;
    private int cantitate;
    private int pret;

    public Produs() {
    }

    public Produs(int id, String denumire, int cantitate, int pret) {
        this.id = id;
        this.denumire = denumire;
        this.cantitate = cantitate;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }


    @Override
    public String toString() {
        return "Produs id=" + id + ", denumire = " + denumire + ", cantitate = " + cantitate + ", pret = " + pret + "\n";
    }
}
