package BusinessLogic;

import java.util.List;
import java.util.NoSuchElementException;

import dataAccess.ClientDA;
import model.Client;

public class ClientBL {
    private final ClientDA clientDA ;

    public ClientBL() {
           clientDA = new ClientDA();
    }

    public List<Client> findAll() {
        List<Client> c = clientDA.findAll();
        if (c == null) {
            throw new NoSuchElementException("Nu exista clienti in baza de date!\n");
        }
        return c;
    }
    public void insert(Client c) {
        Client cl = clientDA.insert(c);
        if (cl == null) {
            throw new NoSuchElementException("Nu s-a putut realiza inserarea!\n");
        }
    }
    public void delete(int id) {
        int i = clientDA.delete(id);
        if (i == 0) {
            throw new NoSuchElementException("Nu s-a putut realiza stergerea!\n");
        }
    }

    public void update(Client c) {
        Client i = clientDA.update(c);
        if (i == null) {
            throw new NoSuchElementException("Nu s-a putut realiza actualizarea!\n");
        }
    }
}
