/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package havayolubilgisistemi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author AsusTuf
 */
public class UcakPage extends javax.swing.JFrame {

    /**
     * Creates new form UcakPage
     */
    private String tip, name, pilot, hostes, sirket;
    private boolean ucakvar = false;
    private Ucak ucak;

    public UcakPage() {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Color backgroundColor = new Color(197, 255, 248);
        getContentPane().setBackground(backgroundColor);
        GitBtn.setEnabled(false);

    }

    public UcakPage(Ucak ucak) {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        ucakvar = true;
        this.ucak = ucak;
        Color backgroundColor = new Color(197, 255, 248);
        getContentPane().setBackground(backgroundColor);

        GitBtn.setEnabled(false);
        AdiTxt.setText(ucak.name);
        SirketTxt.setText(ucak.sirketadi);
        SirkettBox.setActionCommand(ucak.sirketadi);
        PilotBox.setActionCommand(ucak.pilot.getName());
        HosteseBox.setActionCommand(ucak.hosteseList.get(0).getName());
        UcakTipiBox.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PilotBox = new javax.swing.JComboBox<>();
        HosteseBox = new javax.swing.JComboBox<>();
        AdiTxt = new javax.swing.JTextField();
        GitBtn = new javax.swing.JButton();
        label5 = new java.awt.Label();
        Pilotlabel = new java.awt.Label();
        label3 = new java.awt.Label();
        Hosteselabel = new java.awt.Label();
        SirketTxt = new javax.swing.JTextField();
        Nlabel9 = new java.awt.Label();
        UcakTipiBox = new javax.swing.JComboBox<>();
        SirkettBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PilotBox.setSelectedItem(HavaYolu.Airports);
        PilotBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PilotBoxMouseClicked(evt);
            }
        });
        PilotBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PilotBoxActionPerformed(evt);
            }
        });

        HosteseBox.setToolTipText("");
        HosteseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HosteseBoxActionPerformed(evt);
            }
        });

        AdiTxt.setText(" ");

        GitBtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        GitBtn.setText("Git");
        GitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GitBtnActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        label5.setText("Uçak Tipi");

        Pilotlabel.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        Pilotlabel.setText("Pilot");

        label3.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        label3.setText("Ucak Adi");

        Hosteselabel.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        Hosteselabel.setText("Hostese");

        SirketTxt.setText(" ");

        Nlabel9.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        Nlabel9.setText("sirket adi");

        UcakTipiBox.setToolTipText("");
        UcakTipiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UcakTipiBoxActionPerformed(evt);
            }
        });

        SirkettBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SirkettBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SirkettBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(609, 609, 609))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(SirkettBox, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AdiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Pilotlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Hosteselabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SirketTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HosteseBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PilotBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UcakTipiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(Nlabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AdiTxt)
                            .addComponent(Pilotlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PilotBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Hosteselabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(HosteseBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(SirkettBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(Nlabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SirketTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(UcakTipiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(231, 231, 231)
                .addComponent(GitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HosteseBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HosteseBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HosteseBoxActionPerformed

    private void Gonder(String tip, String name, String pilot, String host, String sirket) {
        Pilot pilot1 = null;
        Hostese host1 = null;
        System.out.println(tip + name + pilot + host + sirket);
        for (User user : HavaYolu.PersonelList) {
            if (user.getName().equals(pilot)) {
                pilot1 = (Pilot) user;
                System.out.println(user.getName());
            }
            if (user.getName().equals(host)) {
                host1 = (Hostese) user;
                System.out.println(user.getName());
            }
        }

        new Ucak(tip, name, pilot1, host1, sirket);

    }
    private void GitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GitBtnActionPerformed

        sirket = SirketTxt.getText().trim();
            name = AdiTxt.getText().trim();
        if (ucakvar) {
            ucak.name = name;
            ucak.sirketadi = sirket;

            Pilot pilot1 = null;
            Hostese host1 = null;
            System.out.println(tip + name + pilot + hostes + sirket);
            for (User user : HavaYolu.PersonelList) {
                if (user.getName().equals(pilot)) {
                    pilot1 = (Pilot) user;
                    System.out.println(user.getName());
                }
                if (user.getName().equals(hostes)) {
                    host1 = (Hostese) user;
                    System.out.println(user.getName());
                }
            }
            ucak.pilot = pilot1;
            ucak.hosteseList.add(host1);
            
            
        } else {
            

            Gonder(tip, name, pilot, hostes, sirket);

            
        }
        Ucuslar ucus = new Ucuslar("Ucak");
            ucus.setVisible(true);
            setVisible(false);


    }//GEN-LAST:event_GitBtnActionPerformed

    private void PilotBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilotBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PilotBoxActionPerformed

    private void PilotBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PilotBoxMouseClicked

    }//GEN-LAST:event_PilotBoxMouseClicked

    private void UcakTipiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UcakTipiBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UcakTipiBoxActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (User air : HavaYolu.PersonelList) {
            if (air.gettip().equals("Pilot")) {
                PilotBox.addItem(air.getName());
            } else if (air.gettip().equals("Hostese")) {
                HosteseBox.addItem(air.getName());
            }

        }
        for (String tip : HavaYolu.UcakTipi) {
            UcakTipiBox.addItem(tip);
        }
        for (Sirket tip : HavaYolu.SirketiList) {
            SirkettBox.addItem(tip.name.toString());
        }

        UcakTipiBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ucak tipi " + (String) UcakTipiBox.getSelectedItem());
                tip = (String) UcakTipiBox.getSelectedItem();
            }
        });
        HosteseBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ucak host " + (String) HosteseBox.getSelectedItem());
                hostes = (String) HosteseBox.getSelectedItem();
            }
        });
        PilotBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ucak pilotu " + (String) PilotBox.getSelectedItem());
                pilot = (String) PilotBox.getSelectedItem();
                GitBtn.setEnabled(true);
            }
        });
        GitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //PilotBox
    }//GEN-LAST:event_formWindowOpened

    private void SirkettBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SirkettBoxActionPerformed
        SirkettBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = SirkettBox.getSelectedIndex();
                System.out.println("Selected Index: " + selectedIndex);

                if (!HavaYolu.SirketiList.isEmpty() && selectedIndex >= 0 && selectedIndex < HavaYolu.SirketiList.size()) {
                    Sirket sefer = HavaYolu.SirketiList.get(selectedIndex);

                    SirketTxt.setText(sefer.name.toString());

                } else {
                    System.out.println("Invalid selection or SeferList is empty.");
                }
            }
        });
    }//GEN-LAST:event_SirkettBoxActionPerformed

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
            java.util.logging.Logger.getLogger(UcakPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UcakPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UcakPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UcakPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UcakPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdiTxt;
    private javax.swing.JButton GitBtn;
    private javax.swing.JComboBox<String> HosteseBox;
    private java.awt.Label Hosteselabel;
    private java.awt.Label Nlabel9;
    private javax.swing.JComboBox<String> PilotBox;
    private java.awt.Label Pilotlabel;
    private javax.swing.JTextField SirketTxt;
    private javax.swing.JComboBox<String> SirkettBox;
    private javax.swing.JComboBox<String> UcakTipiBox;
    private java.awt.Label label3;
    private java.awt.Label label5;
    // End of variables declaration//GEN-END:variables
}
