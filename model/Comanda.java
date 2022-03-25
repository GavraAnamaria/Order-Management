package model;

import java.sql.Timestamp;

public class Comanda {
    private int id;
    private int idClient;
    private int idProdus;
    private int cantitate;
    private int pret;

    public Comanda() {
    }

    public Comanda(int id, int idClient, int idProdus, int cantitate, int pret) {
        this.id = id;
        this.idClient = idClient;
        this.idProdus = idProdus;
        this.cantitate = cantitate;
        this.pret = pret;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int produs) {
        this.idProdus = produs;
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "_______________________________________________________________\n| Comanda cu numarul " + id + " a fost plasata cu succes!               |\n| data: "+ timestamp + "                                |\n| id client: " + idClient + "                                                 |\n| id produs = " + idProdus + "                                                |\n| cantitate = " + cantitate + "                                                |\n| pret = " + pret + "                                                    |\n|______________________________________________________________|\n\n\n";

    }
}
