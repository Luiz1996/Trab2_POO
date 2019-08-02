/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author luiz.pereira
 */
public class AltConsultaView extends javax.swing.JFrame {

    /**
     * Creates new form AltConsultaView
     */
    public AltConsultaView() {
        setTitle("Alterar Consulta | Saúde & Cia");
        setIcon();
        initComponents();
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
        lblDtNascPac = new javax.swing.JLabel();
        txtDtConsulta = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("##/##/#### ##:##");
            txtDtConsulta = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());    
        }
        txtDtNascPac = new javax.swing.JTextField();
        lblTipoConsulta = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        lblNomeMed = new javax.swing.JLabel();
        txtNomeMed = new javax.swing.JTextField();
        lblDtNascMed = new javax.swing.JLabel();
        txtDtNascMed = new javax.swing.JTextField();
        lblCrm = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblConsulta = new javax.swing.JLabel();
        lblInforme = new javax.swing.JLabel();
        txtIdBusca = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        lblNomePac = new javax.swing.JLabel();
        txtCrm = new javax.swing.JTextField();
        txtNomePac = new javax.swing.JTextField();
        lblDtConsulta = new javax.swing.JLabel();
        btnRadNormal = new javax.swing.JRadioButton();
        btnRadRetorno = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDtNascPac.setText("Data de Nascimento");

        txtDtNascPac.setEditable(false);
        txtDtNascPac.setBorder(null);

        lblTipoConsulta.setText("Tipo de Consulta");

        lblEndereco.setText("Endereço");

        txtEndereco.setEditable(false);
        txtEndereco.setBorder(null);

        btnAlterar.setBackground(new java.awt.Color(255, 102, 102));
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Alterar");

        lblNomeMed.setText("Nome do Médico");

        txtNomeMed.setEditable(false);
        txtNomeMed.setBorder(null);

        lblDtNascMed.setText("Data de Nascimento");

        txtDtNascMed.setEditable(false);
        txtDtNascMed.setBorder(null);

        lblCrm.setText("CRM");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 51, 0));
        lblId.setText("ID");

        lblConsulta.setText("da Consulta");

        lblInforme.setText("Informe o ");

        btnConsulta.setBackground(new java.awt.Color(153, 153, 255));
        btnConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta.setText("Consultar");

        lblNomePac.setText("Nome do Paciente");

        txtCrm.setEditable(false);
        txtCrm.setBorder(null);

        txtNomePac.setEditable(false);
        txtNomePac.setBorder(null);

        lblDtConsulta.setText("Data e Hora da Consulta");

        btnRadGroup.add(btnRadNormal);
        btnRadNormal.setText("Normal");

        btnRadGroup.add(btnRadRetorno);
        btnRadRetorno.setText("Retorno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separador)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInforme)
                                .addGap(2, 2, 2)
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblConsulta)
                                .addGap(0, 166, Short.MAX_VALUE))
                            .addComponent(txtIdBusca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsulta))
                    .addComponent(txtNomePac)
                    .addComponent(txtDtNascPac)
                    .addComponent(txtEndereco)
                    .addComponent(txtNomeMed)
                    .addComponent(txtDtNascMed)
                    .addComponent(txtCrm)
                    .addComponent(txtDtConsulta)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAlterar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomePac)
                            .addComponent(lblDtNascPac)
                            .addComponent(lblEndereco)
                            .addComponent(lblNomeMed)
                            .addComponent(lblDtNascMed)
                            .addComponent(lblCrm)
                            .addComponent(lblDtConsulta)
                            .addComponent(lblTipoConsulta)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRadNormal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRadRetorno)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblConsulta)
                    .addComponent(lblInforme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomePac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDtNascPac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDtNascPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeMed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDtNascMed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDtNascMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCrm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDtConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRadNormal)
                    .addComponent(btnRadRetorno))
                .addGap(7, 7, 7)
                .addComponent(btnAlterar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(AltConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltConsultaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.ButtonGroup btnRadGroup;
    private javax.swing.JRadioButton btnRadNormal;
    private javax.swing.JRadioButton btnRadRetorno;
    private javax.swing.JLabel lblConsulta;
    private javax.swing.JLabel lblCrm;
    private javax.swing.JLabel lblDtConsulta;
    private javax.swing.JLabel lblDtNascMed;
    private javax.swing.JLabel lblDtNascPac;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblInforme;
    private javax.swing.JLabel lblNomeMed;
    private javax.swing.JLabel lblNomePac;
    private javax.swing.JLabel lblTipoConsulta;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtCrm;
    private javax.swing.JTextField txtDtConsulta;
    private javax.swing.JTextField txtDtNascMed;
    private javax.swing.JTextField txtDtNascPac;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIdBusca;
    private javax.swing.JTextField txtNomeMed;
    private javax.swing.JTextField txtNomePac;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("icone.png"))));
    }

    public JButton getBtnAlterar() {
        return btnAlterar;
    }

    public void setBtnAlterar(JButton btnAlterar) {
        this.btnAlterar = btnAlterar;
    }

    public JButton getBtnConsulta() {
        return btnConsulta;
    }

    public void setBtnConsulta(JButton btnConsulta) {
        this.btnConsulta = btnConsulta;
    }

    public JTextField getTxtCrm() {
        return txtCrm;
    }

    public void setTxtCrm(JTextField txtCrm) {
        this.txtCrm = txtCrm;
    }

    public JTextField getTxtDtConsulta() {
        return txtDtConsulta;
    }

    public void setTxtDtConsulta(JTextField txtDtConsulta) {
        this.txtDtConsulta = txtDtConsulta;
    }

    public JTextField getTxtDtNascMed() {
        return txtDtNascMed;
    }

    public void setTxtDtNascMed(JTextField txtDtNascMed) {
        this.txtDtNascMed = txtDtNascMed;
    }

    public JTextField getTxtDtNascPac() {
        return txtDtNascPac;
    }

    public void setTxtDtNascPac(JTextField txtDtNascPac) {
        this.txtDtNascPac = txtDtNascPac;
    }

    public JTextField getTxtEndereco() {
        return txtEndereco;
    }

    public void setTxtEndereco(JTextField txtEndereco) {
        this.txtEndereco = txtEndereco;
    }

    public JTextField getTxtIdBusca() {
        return txtIdBusca;
    }

    public void setTxtIdBusca(JTextField txtIdBusca) {
        this.txtIdBusca = txtIdBusca;
    }

    public JTextField getTxtNomeMed() {
        return txtNomeMed;
    }

    public void setTxtNomeMed(JTextField txtNomeMed) {
        this.txtNomeMed = txtNomeMed;
    }

    public JTextField getTxtNomePac() {
        return txtNomePac;
    }

    public void setTxtNomePac(JTextField txtNomePac) {
        this.txtNomePac = txtNomePac;
    }

    public JRadioButton getBtnRadNormal() {
        return btnRadNormal;
    }

    public void setBtnRadNormal(JRadioButton btnRadNormal) {
        this.btnRadNormal = btnRadNormal;
    }

    public JRadioButton getBtnRadRetorno() {
        return btnRadRetorno;
    }

    public void setBtnRadRetorno(JRadioButton btnRadRetorno) {
        this.btnRadRetorno = btnRadRetorno;
    } 
}
