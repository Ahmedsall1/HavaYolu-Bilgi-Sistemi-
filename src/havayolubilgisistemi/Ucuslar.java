package havayolubilgisistemi;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AsusTuf
 */
public class Ucuslar extends javax.swing.JFrame {

    private static String tip;
    private int id;

    public Ucuslar(Ucus ucus1, Yolcu yol) {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        id = 1;
        Color backgroundColor = new Color(197, 255, 248);
        getContentPane().setBackground(backgroundColor);

        GeriButton.setBackground(new Color(150, 239, 255));
        this.TipLbl.setText("Ucuslar  Tarih: " + ucus1.formattedDate); // Seçildi Sefer Tarihi 
        this.tip = tip;
        DefaultTableModel tableModel = new DefaultTableModel(); // Tablu uluştur

        if (tip.equals("Sefer") && !ucus1.nerden.isEmpty()) {  
            tableModel.addColumn("Sirket Adi");
            tableModel.addColumn("Sefer no");
            tableModel.addColumn("Ucus no");
            tableModel.addColumn("KM");
            tableModel.addColumn("saat");
            tableModel.addColumn("nerden");
            tableModel.addColumn("nereye");
            tableModel.addColumn("Sure");
            tableModel.addColumn("ucak Adi");
            tableModel.addColumn("Ucret");

            for (Ucus ucus : HavaYolu.UcusList) {  // Seçilen Seferin Bilgilerine göre uçuşları Gösterir
                if (ucus.formattedDate.equals(ucus.formattedDate) && ucus.nerden.equals(ucus1.nerden) && ucus.nereye.equals(ucus1.nereye)) {
                    tableModel.addRow(new Object[]{ucus.ucak.sirketadi, ucus.no, ucus.i, ucus.KM, ucus.saat, ucus.nerden, ucus.nereye, ucus.sure, ucus.ucak.name, ucus.ucak.koltukUcreti});
                }
            }
        }
        UcuslarTable.setModel(tableModel);
        UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = UcuslarTable.getSelectedRow();
                    if (selectedRow != -1) {
                        for (Ucus usus : HavaYolu.UcusList) {  // Seçilen Uçuşun Uçağı Koltuk Seçsin
                            if (usus.i == Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 2).toString())) {
                                KoltukSec ucus = new KoltukSec(usus, yol);
                                ucus.setVisible(true);
                                setVisible(false);
                            }
                        }
                    }
                }
            }
        });
    }

    public Ucuslar(Personel person) {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        id = 2;
        Color backgroundColor = new Color(197, 255, 248);
        getContentPane().setBackground(backgroundColor);
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Personel Adi");
        tableModel.addColumn("Sirket Adi");
        tableModel.addColumn("no");
        tableModel.addColumn("KM");
        tableModel.addColumn("Tarih");
        tableModel.addColumn("saat");
        tableModel.addColumn("nerden");
        tableModel.addColumn("nereye");
        tableModel.addColumn("Sure");
        tableModel.addColumn("ucak Adi");

        for (Ucus ucus : person.Ucuslar) {
            //if(ucus.formattedDate.equals("18-12-2023") || ucus.formattedDate.equals("19-12-2023"))
            tableModel.addRow(new Object[]{person.getName(),ucus.ucak.sirketadi, ucus.no, ucus.KM, ucus.formattedDate, ucus.saat, ucus.nerden, ucus.nereye, ucus.sure, ucus.ucak.name});
        }
        UcuslarTable.setModel(tableModel);

    }

    public Ucuslar(String tip, String nerden, String nereye, String tarih, Yolcu yol) {
        id = 1;
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Color backgroundColor = new Color(197, 255, 248);
        getContentPane().setBackground(backgroundColor);
        this.TipLbl.setText("Ucuslar  Tarih: " + tarih);
        Ucuslar.tip = tip;
        DefaultTableModel tableModel = new DefaultTableModel();

        if (tip.equals("Sefer") && !nerden.isEmpty()) {
            tableModel.addColumn("Sirket Adi");
            tableModel.addColumn("Sefer no");
            tableModel.addColumn("Ucus no");
            tableModel.addColumn("KM");
            tableModel.addColumn("saat");
            tableModel.addColumn("nerden");
            tableModel.addColumn("nereye");
            tableModel.addColumn("Sure");
            tableModel.addColumn("ucak Adi");
            tableModel.addColumn("Ucret");

            for (Ucus ucus : HavaYolu.UcusList) {
                if (ucus.formattedDate.equals(tarih) && ucus.nerden.equals(nerden) && ucus.nereye.equals(nereye)) {
                    tableModel.addRow(new Object[]{ucus.ucak.sirketadi, ucus.no, ucus.i, ucus.KM, ucus.saat, ucus.nerden, ucus.nereye, ucus.sure, ucus.ucak.name, ucus.ucak.koltukUcreti});
                }
            }
        }
        UcuslarTable.setModel(tableModel);
        UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = UcuslarTable.getSelectedRow();
                    if (selectedRow != -1) {
                        for (Ucus usus : HavaYolu.UcusList) {
                            if (usus.i == Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 2).toString())) {
                                KoltukSec ucus = new KoltukSec(usus, yol);
                                ucus.setVisible(true);
                                setVisible(false);
                            }
                        }
                        System.out.println("Selected Row: " + selectedRow);
                        System.out.println("Sirket Adi " + UcuslarTable.getValueAt(selectedRow, 0));
                        System.out.println("no " + UcuslarTable.getValueAt(selectedRow, 1));
                        System.out.println("Ucus no " + UcuslarTable.getValueAt(selectedRow, 2));
                        System.out.println("KM: " + UcuslarTable.getValueAt(selectedRow, 3));
                        System.out.println("saat: " + UcuslarTable.getValueAt(selectedRow, 4));
                        System.out.println("nerden: " + UcuslarTable.getValueAt(selectedRow, 5));
                        System.out.println("nereye: " + UcuslarTable.getValueAt(selectedRow, 6));
                        System.out.println("Sure: " + UcuslarTable.getValueAt(selectedRow, 7));
                        System.out.println("ucak Adi: " + UcuslarTable.getValueAt(selectedRow, 8));
                        System.out.println("Ucret: " + UcuslarTable.getValueAt(selectedRow, 9));
                    }
                }
            }
        });

    }
    public Ucuslar(String tip) {
        id = 3;
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        GeriButton.setBackground(new Color(150, 239, 255));
        Color backgroundColor = new Color(197, 255, 248);
        getContentPane().setBackground(backgroundColor);
        this.TipLbl.setText(tip + "ler");
        Ucuslar.tip = tip;
        DefaultTableModel tableModel = new DefaultTableModel();

        if (tip.equals("Ucus")) {
            tableModel.addColumn("Sirket Adi");
            tableModel.addColumn("no");
            tableModel.addColumn("KM");
            tableModel.addColumn("Tarih");
            tableModel.addColumn("saat");
            tableModel.addColumn("nerden");
            tableModel.addColumn("nereye");
            tableModel.addColumn("Sure");
            tableModel.addColumn("ucak Adi");
            tableModel.addColumn("Ucret");

            for (Ucus ucus : HavaYolu.UcusList) {
                tableModel.addRow(new Object[]{ucus.ucak.sirketadi, ucus.no, ucus.KM, ucus.formattedDate, ucus.saat, ucus.nerden, ucus.nereye, ucus.sure, ucus.ucak.name, ucus.ucak.koltukUcreti});
            }
            UcuslarTable.setModel(tableModel);
            UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = UcuslarTable.getSelectedRow();
                        if (selectedRow != -1) {
                            for (Ucus usus : HavaYolu.UcusList) {
                                if (usus.i == Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 1).toString())) {
                                    Duzelt ucus = new Duzelt(usus);
                                    ucus.setVisible(true);
                                    setVisible(false);
                                }
                            }
                        }
                    }
                }
            });
        } else if (tip.equals("Sefer")) {
            tableModel.addColumn("no");
            tableModel.addColumn("KM");
            tableModel.addColumn("Tarih");
            tableModel.addColumn("nerden");
            tableModel.addColumn("nereye");
            tableModel.addColumn("Sure");

            for (Sefer sefer : HavaYolu.UcusList) {
                tableModel.addRow(new Object[]{sefer.no, sefer.KM, sefer.formattedDate, sefer.nerden, sefer.nereye, sefer.sure});
            }
            UcuslarTable.setModel(tableModel);
            UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = UcuslarTable.getSelectedRow();
                        if (selectedRow != -1) {
                            Sefer sefer = HavaYolu.SeferList.get(Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 0).toString()) - 101);
                            Duzelt ucus = new Duzelt(sefer);
                            ucus.setVisible(true);
                            setVisible(false);
                        }
                    }
                }
            });
        } else if (tip.equals("Personel")) {
            tableModel.addColumn("ID");
            tableModel.addColumn("Adi");
            tableModel.addColumn("Gorev");
            for (User user : HavaYolu.PersonelList) {
                tableModel.addRow(new Object[]{user.getId(), user.getName(), user.gettip()});
            }
            UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = UcuslarTable.getSelectedRow();
                        if (selectedRow != -1) {
                            for (User per : HavaYolu.PersonelList) {
                                if (per.getId() == Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 0).toString())) {
                                    if (per.gettip().equals("Yonetici")) {
                                        continue;
                                    } else {
                                        Ucuslar ucus = new Ucuslar((Personel) per);
                                        ucus.setVisible(true);
                                        setVisible(false);
                                    }
                                }
                            }
                        }
                    }
                }
            });
            UcuslarTable.setModel(tableModel);
        }
        else if (tip.equals("User")) {
            tableModel.addColumn("ID");
            tableModel.addColumn("Adi");
            tableModel.addColumn("Gorev");
            for (User user : HavaYolu.PersonelList) {
                tableModel.addRow(new Object[]{user.getId(), user.getName(), user.gettip()});
            }
            UcuslarTable.setModel(tableModel);
            UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = UcuslarTable.getSelectedRow();
                        if (selectedRow != -1) {
                            for (User per : HavaYolu.PersonelList) {
                                if (per.getId() == Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 0).toString())) {
                                    Duzelt ucus = new Duzelt(per);
                                    ucus.setVisible(true);
                                    setVisible(false);
                                }
                            }
                        }
                    }
                }
            });
        } else if (tip.equals("Sirket")) {
            tableModel.addColumn("ID");
            tableModel.addColumn("Adi");
            for (Sirket sirket : HavaYolu.SirketiList) {
                tableModel.addRow(new Object[]{sirket.id, sirket.name});
            }
            UcuslarTable.setModel(tableModel);
            UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = UcuslarTable.getSelectedRow();
                        if (selectedRow != -1) {
                            for (Sirket per : HavaYolu.SirketiList) {
                                if (per.id == Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 0).toString())) {
                                    Duzelt ucus = new Duzelt(per);
                                    ucus.setVisible(true);
                                    setVisible(false);
                                }
                            }
                        }
                    }
                }
            });
        } else if (tip.equals("Yolcu")) {
            tableModel.addColumn("ID");
            tableModel.addColumn("Adi");
            tableModel.addColumn("Ozelik");
            tableModel.addColumn("Koltuk");

            for (Yolcu yolcu : HavaYolu.YolcuList) {
                tableModel.addRow(new Object[]{yolcu.getId(), yolcu.getName(), yolcu.Ytip, yolcu.Koltuk});
            }
            UcuslarTable.setModel(tableModel);
        } else if (tip.equals("Ucak")) {
            tableModel.addColumn("ID");
            tableModel.addColumn("Sirket Adi");
            tableModel.addColumn("Adi");
            tableModel.addColumn("tipi");
            tableModel.addColumn("Koltuk sayisi");
            tableModel.addColumn("dolu");
            tableModel.addColumn("Pilot adi");
            tableModel.addColumn("Koltuk Ucreti");
            for (Ucak ucak : HavaYolu.UcakList) {
                tableModel.addRow(new Object[]{ucak.id, ucak.sirketadi, ucak.name, ucak.tip, ucak.harfSayisi * ucak.siraSayisi, ucak.koltukSayisi, ucak.pilot.getName(), ucak.koltukUcreti});
            }
            UcuslarTable.setModel(tableModel);
            UcuslarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = UcuslarTable.getSelectedRow();
                        if (selectedRow != -1) {
                            for (Ucak per : HavaYolu.UcakList) {
                                if (per.id == Integer.parseInt(UcuslarTable.getValueAt(selectedRow, 0).toString())) {
                                    UcakPage ucus = new UcakPage(per);
                                    ucus.setVisible(true);
                                    setVisible(false);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        UcuslarTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        TipLbl = new javax.swing.JLabel();
        GeriButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        UcuslarTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UcuslarTable.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        UcuslarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şirket", "Uçak", "Saat", "Nereden             >                Nereye", "Mesafe", "Süre", "Uçak Tipi", "Ücret"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(UcuslarTable);
        if (UcuslarTable.getColumnModel().getColumnCount() > 0) {
            UcuslarTable.getColumnModel().getColumn(0).setResizable(false);
            UcuslarTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            UcuslarTable.getColumnModel().getColumn(1).setResizable(false);
            UcuslarTable.getColumnModel().getColumn(2).setResizable(false);
            UcuslarTable.getColumnModel().getColumn(3).setResizable(false);
            UcuslarTable.getColumnModel().getColumn(3).setPreferredWidth(300);
            UcuslarTable.getColumnModel().getColumn(4).setResizable(false);
            UcuslarTable.getColumnModel().getColumn(5).setResizable(false);
            UcuslarTable.getColumnModel().getColumn(6).setResizable(false);
            UcuslarTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(150, 239, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        TipLbl.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        TipLbl.setText("Uçuşlar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(TipLbl)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TipLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GeriButton.setBackground(new java.awt.Color(102, 204, 255));
        GeriButton.setFont(new java.awt.Font("Cascadia Code", 1, 36)); // NOI18N
        GeriButton.setText("Geri");
        GeriButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        GeriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeriButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(GeriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 577, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GeriButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeriButtonActionPerformed
        if (id == 1) {
            Home ucus = new Home();
            ucus.setVisible(true);
            setVisible(false);
        } else {
            YoneticiPage ucus = new YoneticiPage(Yonetici.getYonet());
            ucus.setVisible(true);
            setVisible(false);
        }


    }//GEN-LAST:event_GeriButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ucuslar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ucuslar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ucuslar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ucuslar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ucuslar(tip).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GeriButton;
    private javax.swing.JLabel TipLbl;
    private javax.swing.JTable UcuslarTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
