/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.ConsultaTable;

/**
 *
 * @author luiz.pereira
 */
public class ConsConsultaAmanhaView extends javax.swing.JFrame {
    private ConsultaTable tableModel = new ConsultaTable();
    /**
     * Creates new form ConsultasAmanhaView
     */
    public ConsConsultaAmanhaView() {
        setTitle("Consultas de Amanhã | Saúde & Cia");
        setIcon();
        initComponents();
        tblResultado.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRadGroup = new javax.swing.ButtonGroup();
        btnRadTodosPac = new javax.swing.JRadioButton();
        btnRadPacEmailCelular = new javax.swing.JRadioButton();
        btnConsultar = new javax.swing.JButton();
        btnEmail = new javax.swing.JButton();
        btnSms = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        sclPane = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRadGroup.add(btnRadTodosPac);
        btnRadTodosPac.setText("Todos os pacientes");

        btnRadGroup.add(btnRadPacEmailCelular);
        btnRadPacEmailCelular.setText("Pacientes com e-mail/celular");

        btnConsultar.setBackground(new java.awt.Color(153, 153, 255));
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");

        btnEmail.setBackground(new java.awt.Color(102, 102, 0));
        btnEmail.setForeground(new java.awt.Color(255, 255, 255));
        btnEmail.setText("E-mail");

        btnSms.setBackground(new java.awt.Color(102, 102, 0));
        btnSms.setForeground(new java.awt.Color(255, 255, 255));
        btnSms.setText("SMS");

        btnExportar.setBackground(new java.awt.Color(0, 102, 51));
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setText("Exportar (*.xlsx)");

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.setColumnSelectionAllowed(true);
        sclPane.setViewportView(tblResultado);
        tblResultado.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separador)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRadTodosPac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRadPacEmailCelular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSms, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnExportar))
                    .addComponent(sclPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRadTodosPac)
                        .addComponent(btnRadPacEmailCelular))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConsultar)
                        .addComponent(btnEmail)
                        .addComponent(btnSms)
                        .addComponent(btnExportar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sclPane, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ConsConsultaAmanhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsConsultaAmanhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsConsultaAmanhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsConsultaAmanhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsConsultaAmanhaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnExportar;
    private javax.swing.ButtonGroup btnRadGroup;
    private javax.swing.JRadioButton btnRadPacEmailCelular;
    private javax.swing.JRadioButton btnRadTodosPac;
    private javax.swing.JButton btnSms;
    private javax.swing.JScrollPane sclPane;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("icone.png"))));
    }

    public ConsultaTable getTableModel() {
        return tableModel;
    }

    public void setTableModel(ConsultaTable tableModel) {
        this.tableModel = tableModel;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setBtnConsultar(JButton btnConsultar) {
        this.btnConsultar = btnConsultar;
    }

    public JButton getBtnEmail() {
        return btnEmail;
    }

    public void setBtnEmail(JButton btnEmail) {
        this.btnEmail = btnEmail;
    }

    public JButton getBtnExportar() {
        return btnExportar;
    }

    public void setBtnExportar(JButton btnExportar) {
        this.btnExportar = btnExportar;
    }

    public JRadioButton getBtnRadPacEmailCelular() {
        return btnRadPacEmailCelular;
    }

    public void setBtnRadPacEmailCelular(JRadioButton btnRadPacEmailCelular) {
        this.btnRadPacEmailCelular = btnRadPacEmailCelular;
    }

    public JRadioButton getBtnRadTodosPac() {
        return btnRadTodosPac;
    }

    public void setBtnRadTodosPac(JRadioButton btnRadTodosPac) {
        this.btnRadTodosPac = btnRadTodosPac;
    }

    public JButton getBtnSms() {
        return btnSms;
    }

    public void setBtnSms(JButton btnSms) {
        this.btnSms = btnSms;
    }

    public JTable getTblResultado() {
        return tblResultado;
    }

    public void setTblResultado(JTable tblResultado) {
        this.tblResultado = tblResultado;
    }

    public JScrollPane getSclPane() {
        return sclPane;
    }

    public void setSclPane(JScrollPane sclPane) {
        this.sclPane = sclPane;
    }
}
