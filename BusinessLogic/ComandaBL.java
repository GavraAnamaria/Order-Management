package BusinessLogic;

import dataAccess.ComandaDA;
import model.Comanda;
import model.Produs;

import java.util.List;
import java.util.NoSuchElementException;

public class ComandaBL {
    private ComandaDA comandaDA = new ComandaDA();


    public List<Comanda> findAll() {
        List<Comanda> c = comandaDA.findAll();
        return c;
    }
    public void insert(Comanda c) {
        Comanda cl = comandaDA.insert(c);
        if (cl == null) {
            throw new NoSuchElementException("Nu s-a putut realiza inserarea!\n");
        }
    }


    public void plasareComanda( Comanda c){
        ProdusBL p = new ProdusBL();
        p.setCantitate1(c.getIdProdus(), c.getCantitate());
        Comanda cl = comandaDA.insert(c);
        if (cl == null) {
            throw new NoSuchElementException("Nu s-a putut realiza comanda!\n");
        }
    }
}
