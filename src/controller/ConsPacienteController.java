package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Paciente;
import model.SecretariaExecucao;
import service.FormataDatas;
import view.ConsPacienteView;

/**
 *
 * @author luiz.pereira
 */
public class ConsPacienteController {
    private SecretariaExecucao secME;
    private ConsPacienteView consPacV = new ConsPacienteView();
    private ActionListener actionListener;

    public ConsPacienteController(ConsPacienteView consPacV, SecretariaExecucao secME) {
        this.consPacV = consPacV;
        this.consPacV.setVisible(true);
        this.secME = secME;
        consultarPaciente();
    }

    private void consultarPaciente() {
        actionListener = (ActionEvent ae) -> {
            Paciente pac = new Paciente();
            FormataDatas dtFormat = new FormataDatas();
            
            //buscando dados do paciente desejado
            pac = secME.buscarPacienteDao(consPacV.getTxtCpfConsulta().getText());
            
            //caso não encontre registros então os campos são limpos
            if (pac == null) {
                consPacV.getTxtNome().setText("");
                consPacV.getTxtCpf().setText("");
                consPacV.getTxtRg().setText("");
                consPacV.getTxtEndereco().setText("");
                consPacV.getTxtCelular().setText("");
                consPacV.getTxtEmail().setText("");
                consPacV.getTxtDtNasc().setText("");
                consPacV.getTxtConvenio().setText("");
                consPacV.getTxtCpfConsulta().setText("");
                consPacV.getTxtCpfConsulta().requestFocus();
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //carregando os txtFields
            consPacV.getTxtNome().setText(pac.getNome().trim());
            consPacV.getTxtNome().setText(pac.getNome().trim());
            consPacV.getTxtCpf().setText(pac.getCpf().trim());
            consPacV.getTxtRg().setText(pac.getRg().trim());
            consPacV.getTxtEndereco().setText(pac.getEndereco().trim());
            consPacV.getTxtCelular().setText(pac.getCelular().trim());
            consPacV.getTxtEmail().setText(pac.getEmail().trim());
            
            //obtendo a data de nascimento formatada
            consPacV.getTxtDtNasc().setText(dtFormat.formataPadraoBrasil(pac.getDtNasc(), "Data de Nascimento"));
            
            //obtendo o tipo de convenio do paciente
            if (pac.getConvenio() == 0) {
                consPacV.getTxtConvenio().setText("Particular");
            } else {
                consPacV.getTxtConvenio().setText("Plano de Saúde");
            }
            consPacV.getTxtCpfConsulta().setText("");
        };
        consPacV.getBtnConsultar().addActionListener(actionListener);
    }
}
