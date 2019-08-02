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
 * @author Vini
 */
public class AtestadoAcompanhanteView extends javax.swing.JFrame {

    /**
     * Creates new form AtestadoAcompanhanteView
     */
    public AtestadoAcompanhanteView() {
        setTitle("Atestado de Acompanhante | Saúde & Cia");
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

        separador = new javax.swing.JSeparator();
        lblCpfPac = new javax.swing.JLabel();
        txtCpfPac = new javax.swing.JTextField();
        lblNomeAcomp = new javax.swing.JLabel();
        txtNomeAcomp = new javax.swing.JTextField();
        txtDeclaro = new javax.swing.JTextField();
        txtNomeAcompAtestado = new javax.swing.JTextField();
        txtEsteve = new javax.swing.JTextField();
        txtDtAtendAtestado = new javax.swing.JTextField();
        txtDas = new javax.swing.JTextField();
        txthrIniAtes = new javax.swing.JTextField();
        txtAs = new javax.swing.JTextField();
        txtHrFimAtest = new javax.swing.JTextField();
        txtAcompanhando = new javax.swing.JTextField();
        txtNomePac = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtNomeMed = new javax.swing.JTextField();
        txtCrm = new javax.swing.JTextField();
        lblCpfMed = new javax.swing.JLabel();
        txtCpfMed = new javax.swing.JTextField();
        lblDtAtend = new javax.swing.JLabel();
        txtDtAtendimento = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("##/##/####");
            txtDtAtendimento = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());    
        }
        lblHoraIni = new javax.swing.JLabel();
        txtHrIni = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("##:##");
            txtHrIni = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());    
        }
        lblHrFim = new javax.swing.JLabel();
        txtHrFim = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("##:##");
            txtHrFim = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());    
        }
        btnGerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCpfPac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCpfPac.setText("CPF do Paciente");

        lblNomeAcomp.setText("Nome do Acompanhante");

        txtDeclaro.setEditable(false);
        txtDeclaro.setText("Declaro para os devidos fins, que o Sr(ª).");
        txtDeclaro.setBorder(null);

        txtNomeAcompAtestado.setEditable(false);
        txtNomeAcompAtestado.setBorder(null);

        txtEsteve.setEditable(false);
        txtEsteve.setText("esteve nesta unidade hospitalar/clínica no dia ");
        txtEsteve.setBorder(null);

        txtDtAtendAtestado.setEditable(false);
        txtDtAtendAtestado.setBorder(null);

        txtDas.setEditable(false);
        txtDas.setText(" das");
        txtDas.setBorder(null);

        txthrIniAtes.setEditable(false);
        txthrIniAtes.setBorder(null);

        txtAs.setEditable(false);
        txtAs.setText(" às");
        txtAs.setBorder(null);

        txtHrFimAtest.setEditable(false);
        txtHrFimAtest.setBorder(null);

        txtAcompanhando.setEditable(false);
        txtAcompanhando.setText("acompanhando, ");
        txtAcompanhando.setBorder(null);

        txtNomePac.setEditable(false);
        txtNomePac.setBorder(null);

        txtNomeMed.setEditable(false);
        txtNomeMed.setBorder(null);

        txtCrm.setEditable(false);
        txtCrm.setBorder(null);

        lblCpfMed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCpfMed.setText("CPF do Médico");

        lblDtAtend.setText("Data do atendimento");

        lblHoraIni.setText("Hora Inicial");

        lblHrFim.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHrFim.setText("Hora Final");

        btnGerar.setBackground(new java.awt.Color(0, 0, 0));
        btnGerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGerar.setText("Gerar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDtAtend)
                            .addComponent(lblNomeAcomp)
                            .addComponent(lblHoraIni))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeAcomp)
                            .addComponent(txtDtAtendimento)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHrIni, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHrFim, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHrFim, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGerar))
                    .addComponent(separador)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCpfPac, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCpfMed, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCpfPac, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(txtCpfMed)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtDeclaro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNomeAcompAtestado))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtEsteve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDtAtendAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txthrIniAtes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHrFimAtest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtAcompanhando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNomePac, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(txtCrm, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpfPac)
                    .addComponent(txtCpfPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpfMed)
                    .addComponent(txtCpfMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAcomp)
                    .addComponent(txtNomeAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtAtend)
                    .addComponent(txtDtAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraIni)
                    .addComponent(txtHrIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHrFim)
                    .addComponent(txtHrFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeclaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeAcompAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEsteve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDtAtendAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthrIniAtes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHrFimAtest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcompanhando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomePac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
            java.util.logging.Logger.getLogger(AtestadoAcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtestadoAcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtestadoAcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtestadoAcompanhanteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AtestadoAcompanhanteView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCpfMed;
    private javax.swing.JLabel lblCpfPac;
    private javax.swing.JLabel lblDtAtend;
    private javax.swing.JLabel lblHoraIni;
    private javax.swing.JLabel lblHrFim;
    private javax.swing.JLabel lblNomeAcomp;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtAcompanhando;
    private javax.swing.JTextField txtAs;
    private javax.swing.JTextField txtCpfMed;
    private javax.swing.JTextField txtCpfPac;
    private javax.swing.JTextField txtCrm;
    private javax.swing.JTextField txtDas;
    private javax.swing.JTextField txtDeclaro;
    private javax.swing.JTextField txtDtAtendAtestado;
    private javax.swing.JTextField txtDtAtendimento;
    private javax.swing.JTextField txtEsteve;
    private javax.swing.JTextField txtHrFim;
    private javax.swing.JTextField txtHrFimAtest;
    private javax.swing.JTextField txtHrIni;
    private javax.swing.JTextField txtNomeAcomp;
    private javax.swing.JTextField txtNomeAcompAtestado;
    private javax.swing.JTextField txtNomeMed;
    private javax.swing.JTextField txtNomePac;
    private javax.swing.JTextField txthrIniAtes;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("icone.png"))));
    }

    public JButton getBtnGerar() {
        return btnGerar;
    }

    public void setBtnGerar(JButton btnGerar) {
        this.btnGerar = btnGerar;
    }

    public JTextField getTxtAcompanhando() {
        return txtAcompanhando;
    }

    public void setTxtAcompanhando(JTextField txtAcompanhando) {
        this.txtAcompanhando = txtAcompanhando;
    }

    public JTextField getTxtAs() {
        return txtAs;
    }

    public void setTxtAs(JTextField txtAs) {
        this.txtAs = txtAs;
    }

    public JTextField getTxtCpfMed() {
        return txtCpfMed;
    }

    public void setTxtCpfMed(JTextField txtCpfMed) {
        this.txtCpfMed = txtCpfMed;
    }

    public JTextField getTxtCpfPac() {
        return txtCpfPac;
    }

    public void setTxtCpfPac(JTextField txtCpfPac) {
        this.txtCpfPac = txtCpfPac;
    }

    public JTextField getTxtCrm() {
        return txtCrm;
    }

    public void setTxtCrm(JTextField txtCrm) {
        this.txtCrm = txtCrm;
    }

    public JTextField getTxtDas() {
        return txtDas;
    }

    public void setTxtDas(JTextField txtDas) {
        this.txtDas = txtDas;
    }

    public JTextField getTxtDeclaro() {
        return txtDeclaro;
    }

    public void setTxtDeclaro(JTextField txtDeclaro) {
        this.txtDeclaro = txtDeclaro;
    }

    public JTextField getTxtDtAtendAtestado() {
        return txtDtAtendAtestado;
    }

    public void setTxtDtAtendAtestado(JTextField txtDtAtendAtestado) {
        this.txtDtAtendAtestado = txtDtAtendAtestado;
    }

    public JTextField getTxtDtAtendimento() {
        return txtDtAtendimento;
    }

    public void setTxtDtAtendimento(JTextField txtDtAtendimento) {
        this.txtDtAtendimento = txtDtAtendimento;
    }

    public JTextField getTxtEsteve() {
        return txtEsteve;
    }

    public void setTxtEsteve(JTextField txtEsteve) {
        this.txtEsteve = txtEsteve;
    }

    public JTextField getTxtHrFim() {
        return txtHrFim;
    }

    public void setTxtHrFim(JTextField txtHrFim) {
        this.txtHrFim = txtHrFim;
    }

    public JTextField getTxtHrFimAtest() {
        return txtHrFimAtest;
    }

    public void setTxtHrFimAtest(JTextField txtHrFimAtest) {
        this.txtHrFimAtest = txtHrFimAtest;
    }

    public JTextField getTxtHrIni() {
        return txtHrIni;
    }

    public void setTxtHrIni(JTextField txtHrIni) {
        this.txtHrIni = txtHrIni;
    }

    public JTextField getTxtNomeAcomp() {
        return txtNomeAcomp;
    }

    public void setTxtNomeAcomp(JTextField txtNomeAcomp) {
        this.txtNomeAcomp = txtNomeAcomp;
    }

    public JTextField getTxtNomeAcompAtestado() {
        return txtNomeAcompAtestado;
    }

    public void setTxtNomeAcompAtestado(JTextField txtNomeAcompAtestado) {
        this.txtNomeAcompAtestado = txtNomeAcompAtestado;
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

    public JTextField getTxthrIniAtes() {
        return txthrIniAtes;
    }

    public void setTxthrIniAtes(JTextField txthrIniAtes) {
        this.txthrIniAtes = txthrIniAtes;
    }
    
    
}
