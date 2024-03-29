/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Luiz Flávio
 */
public class AltMedicoView extends javax.swing.JFrame {

    /**
     * Creates new form AltMedicoView
     */
    public AltMedicoView() {
        setTitle("Alterar Médico | Saúde & Cia");
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

        lblRg = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        lblEmail = new javax.swing.JLabel();
        txtCrm = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCpfConsulta = new javax.swing.JLabel();
        lblDtNasc = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpfConsulta = new javax.swing.JTextField();
        txtDtNasc = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("##/##/####");
            txtDtNasc = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());    
        }
        lblCelular = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        lblConvenio = new javax.swing.JLabel();
        lblDtAdmissao = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtDtAdmissao = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("##/##/####");
            txtDtAdmissao = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());    
        }
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblRg.setText("RG");

        lblEmail.setText("E-mail");

        lblNome.setText("Nome");

        lblEndereco.setText("Endereço");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblCpfConsulta.setText("Informe o CPF");

        lblDtNasc.setText("Data de Nascimento");

        lblCpf.setText("CPF");

        lblCelular.setText("Celular");

        btnConsultar.setBackground(new java.awt.Color(153, 153, 255));
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");

        lblConvenio.setText("CRM");

        lblDtAdmissao.setText("Data de Admissão");

        btnAlterar.setBackground(new java.awt.Color(255, 102, 102));
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Alterar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separador)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCpfConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnConsultar))
                    .addComponent(txtNome)
                    .addComponent(txtCpf)
                    .addComponent(txtRg)
                    .addComponent(txtEndereco)
                    .addComponent(txtCelular)
                    .addComponent(txtEmail)
                    .addComponent(txtDtNasc)
                    .addComponent(txtCrm)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpfConsulta)
                            .addComponent(lblNome)
                            .addComponent(lblCpf)
                            .addComponent(lblRg)
                            .addComponent(lblEndereco)
                            .addComponent(lblCelular)
                            .addComponent(lblEmail)
                            .addComponent(lblDtNasc)
                            .addComponent(lblConvenio)
                            .addComponent(lblDtAdmissao))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDtAdmissao)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAlterar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCpfConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDtNasc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConvenio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDtAdmissao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDtAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

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
            java.util.logging.Logger.getLogger(AltMedicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltMedicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltMedicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltMedicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltMedicoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblConvenio;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCpfConsulta;
    private javax.swing.JLabel lblDtAdmissao;
    private javax.swing.JLabel lblDtNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtCpfConsulta;
    private javax.swing.JTextField txtCrm;
    private javax.swing.JTextField txtDtAdmissao;
    private javax.swing.JTextField txtDtNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRg;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("icone.png"))));
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setBtnConsultar(JButton btnConsultar) {
        this.btnConsultar = btnConsultar;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(JTextField txtCelular) {
        this.txtCelular = txtCelular;
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public void setTxtCpf(JTextField txtCpf) {
        this.txtCpf = txtCpf;
    }

    public JTextField getTxtCpfConsulta() {
        return txtCpfConsulta;
    }

    public void setTxtCpfConsulta(JTextField txtCpfConsulta) {
        this.txtCpfConsulta = txtCpfConsulta;
    }

    public JTextField getTxtCrm() {
        return txtCrm;
    }

    public void setTxtCrm(JTextField txtCrm) {
        this.txtCrm = txtCrm;
    }

    public JTextField getTxtDtAdmissao() {
        return txtDtAdmissao;
    }

    public void setTxtDtAdmissao(JTextField txtDtAdmissao) {
        this.txtDtAdmissao = txtDtAdmissao;
    }

    public JTextField getTxtDtNasc() {
        return txtDtNasc;
    }

    public void setTxtDtNasc(JTextField txtDtNasc) {
        this.txtDtNasc = txtDtNasc;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtEndereco() {
        return txtEndereco;
    }

    public void setTxtEndereco(JTextField txtEndereco) {
        this.txtEndereco = txtEndereco;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
    }

    public JTextField getTxtRg() {
        return txtRg;
    }

    public void setTxtRg(JTextField txtRg) {
        this.txtRg = txtRg;
    }

    public JButton getBtnAlterar() {
        return btnAlterar;
    }

    public void setBtnAlterar(JButton btnAlterar) {
        this.btnAlterar = btnAlterar;
    }
}
