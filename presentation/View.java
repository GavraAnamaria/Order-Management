package presentation;

import dataAccess.ClientDA;
import dataAccess.ProdusDA;
import model.Client;
import model.Produs;

import java.util.List;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

    public class View  extends JFrame {
        private final JTextField IDc = new JTextField(33);
        private final JTextField nume = new JTextField(33);
        private final JTextField adresa = new JTextField(33);
        private final JTextField IDp = new JTextField(30);
        private final JTextField denumire = new JTextField(30);
        private final JTextField cantitate = new JTextField(30);
        private final JTextField pret = new JTextField(30);
        private final JComboBox<Integer> client = new JComboBox<>();
        private final JComboBox<Integer> produs = new JComboBox<>();
        private final JTextField cantitateComanda = new JTextField(10);
        private final JButton adC = new JButton("Adaugare");
        private final JButton adP = new JButton("Adaugare");
        private final JButton editC = new JButton("Editare");
        private final JButton editP = new JButton("Editare");
        private final JButton delC = new JButton("Stergere");
        private final JButton delP = new JButton("Stergere");
        private final JButton vizC = new JButton("Vizualizare");
        private final JButton vizP = new JButton("Vizualizare");
        private final JButton comanda = new JButton("Plasare");
        JTextArea textArea1 = new JTextArea();
        JTextArea textArea2 = new JTextArea();

        public View() {
            JScrollPane scrollPane1 = new JScrollPane(textArea1);
            scrollPane1.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane1.setPreferredSize(new Dimension(400, 200));

            JScrollPane scrollPane2 = new JScrollPane(textArea2);
            scrollPane2.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane2.setPreferredSize(new Dimension(400, 200));

            JTabbedPane tabbedPane = new JTabbedPane();
            ClientDA c = new ClientDA();
            ProdusDA prod = new ProdusDA();
            JPanel card1 = new JPanel();
            JPanel label = new JPanel();
            JPanel tf = new JPanel();
            JPanel button = new JPanel();
            JPanel p = new JPanel();
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();

            card1.setLayout(new GridLayout(0,1));
            card1.setBorder(BorderFactory.createEmptyBorder(50,15,0,0));
            label.setLayout(new GridLayout(0,1, 9, 9));
            tf.setLayout(new GridLayout(0,1, 7, 7));

            label.add(new JLabel("ID:"));
            tf.add(IDc);
            label.add(new JLabel("NUME:"));
            tf.add(nume);
            label.add(new JLabel("ADRESA:"));
            tf.add(adresa);
            p.add(label);
            p.add(tf);

            button.add(adC);
            button.add(editC);
            button.add(delC);
            button.add(vizC);

            card1.add(p);
            card1.add(button);
            panel1.add(card1);
            panel1.add(scrollPane1);

            JPanel card2 = new JPanel();
            JPanel label1 = new JPanel();
            JPanel tf1 = new JPanel();
            JPanel button1 = new JPanel();
            JPanel p1 = new JPanel();

            card2.setLayout(new GridLayout(0,1));
            card2.setBorder(BorderFactory.createEmptyBorder(20,11,0,15));
            label1.setLayout(new GridLayout(0,1, 4, 4));
            tf1.setLayout(new GridLayout(0,1, 3, 3));

            label1.add(new JLabel("ID PRODUS:"));
            tf1.add(IDp);
            label1.add(new JLabel("DENUMIRE:"));
            tf1.add(denumire);
            label1.add(new JLabel("CANTITATE:"));
            tf1.add(cantitate);
            label1.add(new JLabel("PRET:"));
            tf1.add(pret);
            p1.add(label1);
            p1.add(tf1);

            button1.add(adP);
            button1.add(editP);
            button1.add(delP);
            button1.add(vizP);

            card2.add(p1);
            card2.add(button1);
            panel2.add(card2);
            panel2.add(scrollPane2);

            JPanel card3 = new JPanel();
            JPanel label2 = new JPanel();
            JPanel tf2 = new JPanel();
            JPanel p2 = new JPanel();
            JPanel button2 = new JPanel();

            card3.setLayout(new GridLayout(0,1));
            card3.setBorder(BorderFactory.createEmptyBorder(40,20,0,20));
            label2.setLayout(new GridLayout(0,1, 17, 17));
            tf2.setLayout(new GridLayout(0,1, 10, 10));

            List<Client> clienti = c.findAll();
            List<Produs> produse = prod.findAll();
            label2.add(new JLabel("ID Client: "));
            if(produse.size() != 0){
                for(Produs pr:produse)
                   produs.addItem(pr.getId());}
            if(clienti.size() != 0)
                for(Client cl:clienti)
                    client.addItem(cl.getId());

            tf2.add(client);
            label2.add(new JLabel("Produs: "));
            tf2.add(produs);
            label2.add(new JLabel("Cantitate: "));
            tf2.add(cantitateComanda);
            button2.add(comanda);

            p2.add(label2);
            p2.add(tf2);

            card3.add(p2);
            card3.add(button2);

            tabbedPane.addTab("CLIENTI", panel1);
            tabbedPane.addTab("PRODUSE", panel2);
            tabbedPane.addTab("COMENZI", card3);

            this.setContentPane(tabbedPane);
            this.pack();
            this.setTitle("DB");
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


        //----------------------------------[ INTRODUCERE POLINOAME ]---------------------------------------------------



        int getIDc() {
            return Integer.parseInt(IDc.getText());
        }

        int getIDp() {
            return Integer.parseInt(IDp.getText());
        }

        String getNume() {
            return nume.getText();
        }

        String getDenumire() {
            return denumire.getText();
        }

        String getAdresa() {
            return adresa.getText();
        }

        int getPret() {
            return Integer.parseInt(pret.getText());
        }

        int getCantitate() {
            return Integer.parseInt(cantitate.getText());
        }

        int getClient() {
            return (Integer) client.getSelectedItem();
        }

        int getProdus() {
            return (Integer) produs.getSelectedItem();
        }

        int getCantitateComanda() {
            return Integer.parseInt(cantitateComanda.getText());
        }

        void setText1(String text){
            textArea1.setText(text);
        }
        void setText2(String text){
            textArea2.setText(text);
        }
        //----------------------------------[ ASCULTATORI ]------------------------------------------

        void adCListener(ActionListener act) {
            adC.addActionListener(act);
        }

        void adPListener(ActionListener act) {
            adP.addActionListener(act);
        }

        void editCListener(ActionListener act) {
            editC.addActionListener(act);
        }

        void editPListener(ActionListener act) {
            editP.addActionListener(act);
        }

        void delCListener(ActionListener act) {
            delC.addActionListener(act);
        }

        void delPListener(ActionListener act) {
            delP.addActionListener(act);
        }

        void vizCListener(ActionListener act) {
            vizC.addActionListener(act);
        }

        void vizPListener(ActionListener act) {
            vizP.addActionListener(act);
        }

        void comandListener(ActionListener act) {
            comanda.addActionListener(act);
        }

        }
