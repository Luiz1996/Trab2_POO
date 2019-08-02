package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import service.FormataDatas;

/**
 *
 * @author luiz.pereira
 */
public class ConsultaTable extends AbstractTableModel {

    private List<Consulta> dados = new ArrayList<Consulta>();
    private String[] colunas = {"ID", "NOME_PAC", "DT_NASC", "ENDEREÇO", "NOME_MED", "DT_NASC", "CRM", "DT_CONSULTA", "TIPO"};

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        FormataDatas dtFormat = new FormataDatas();
                
        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getNomePac();
            case 2:
                return dtFormat.formataPadraoBrasil(dados.get(linha).getDtNascPac(), "Data de Nascimento");
            case 3:
                return dados.get(linha).getEnderecoPac();
            case 4:
                return dados.get(linha).getNomeMed();
            case 5:
                return dtFormat.formataPadraoBrasil(dados.get(linha).getDtNascMed(), "Data de Nascimento");
            case 6:
                return dados.get(linha).getCrm();
            case 7:
                return dtFormat.formataPadraoBrasilComHora(dados.get(linha).getDtConsulta(), "Data da Consulta");   
            case 8:
                return dados.get(linha).getTpConsulta();
        }

        return null;
    }
    
    public void addRow(Consulta cons){
        this.dados.add(cons);
        this.fireTableDataChanged();        
    }
    
    public void removeRow(int linha){ 
        this.dados.removeAll(dados);
        this.fireTableRowsDeleted(linha, dados.size());
    }
}
