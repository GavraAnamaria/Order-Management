package BusinessLogic;

import dataAccess.ProdusDA;
import model.Produs;

import java.util.List;
import java.util.NoSuchElementException;

public class ProdusBL {

        private ProdusDA produsDA ;

        public ProdusBL() {
            produsDA = new ProdusDA();
        }

        public List<Produs> findAll() {
            List<Produs> c = produsDA.findAll();
            if (c == null) {
                throw new NoSuchElementException("Nu exista clienti in baza de date!\n");
            }
            return c;
        }
        public void insert(Produs c) {
            Produs cl = produsDA.insert(c);
            if (cl == null) {
                throw new NoSuchElementException("Nu s-a putut realiza inserarea!\n");
            }
        }
        public void delete(int id) {
            int i = produsDA.delete(id);
            if (i == 0) {
                throw new NoSuchElementException("Nu s-a putut realiza stergerea!\n");
            }
        }

        public void update(Produs c) {
            Produs i = produsDA.update(c);
            if (i == null) {
                throw new NoSuchElementException("Nu s-a putut realiza actualizarea!\n");
            }
        }



    public void setCantitate1(int id, int cantitate) {
        Produs i = produsDA.findById(id);
        if (i == null || i.getCantitate() < cantitate) {
            throw new NoSuchElementException("EROARE!\n");
        }else
        produsDA.setCantitate(id,i.getCantitate() - cantitate);
    }
    }

