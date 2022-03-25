package presentation;

import BusinessLogic.ClientBL;
import BusinessLogic.ComandaBL;
import BusinessLogic.ProdusBL;
import connection.DBConnection;
import dataAccess.ProdusDA;
import model.Client;
import model.Comanda;
import model.Produs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class Controller {
    private ClientBL c;
    private ProdusBL p;
    private ComandaBL com;
    private View v;

    Controller() {
        c = new ClientBL();
        p = new ProdusBL();
        com = new ComandaBL();
        v = new View();
        v.adCListener(new acListener());
        v.adPListener(new apListener());
        v.editCListener(new ecListener());
        v.editPListener(new epListener());
        v.delCListener(new dcListener());
        v.delPListener(new dpListener());
        v.vizCListener(new vcListener());
        v.vizPListener(new vpListener());
        v.comandListener(new cListener());
    }

    class acListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Client cl = new Client(v.getIDc(), v.getNume(), v.getAdresa());
            c.insert(cl);
        }
    }

    class apListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Produs prod = new Produs(v.getIDp(), v.getDenumire(), v.getCantitate(), v.getPret());
            p.insert(prod);
        }
    }

    class dcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            c.delete(v.getIDc());
        }
    }


    class dpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            p.delete(v.getIDp());
        }
    }

    class ecListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Client cl = new Client(v.getIDc(), v.getNume(), v.getAdresa());
            c.update(cl);
        }
    }
    class epListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Produs prod = new Produs(v.getIDp(), v.getDenumire(), v.getCantitate(), v.getPret());
            p.update(prod);
        }
    }

    class vpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Produs> produse = p.findAll();
            String s = "";
            for(Produs prod:produse)
                s = s + prod.toString();
            v.setText2(s);
        }
    }

    class vcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Client> clienti = c.findAll();
            String s = "";
            for(Client prod:clienti)
                s = s + prod.toString();
            v.setText1(s);
        }
        }


    class cListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Comanda> comenzi = com.findAll();
            ProdusDA p = new ProdusDA();
            int id = 0;
            if(comenzi.size() != 0)
               id = comenzi.get(comenzi.size() - 1).getId() + 1;
            System.out.println(id);
            int pret = (p.findById(v.getProdus()) ).getPret() * v.getCantitateComanda();
            Comanda comand = new Comanda(id, v.getClient(), v.getProdus(), v.getCantitateComanda(), pret);
            com.plasareComanda(comand);
            String s="";
            try {
                FileWriter fileWriter = new FileWriter("C:\\Users\\Anamaria\\Desktop\\a.txt");
                for(Comanda i:comenzi){
                    s=s+i.toString();
                }
                fileWriter.write(s+comand+"\n");
                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Controller c = new Controller();
    }
}
