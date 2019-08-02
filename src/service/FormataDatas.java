/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Flávio
 */
public class FormataDatas {

    public Calendar formataPadraoBanco(String data, String tipoData) {
        Calendar cal = Calendar.getInstance();
        
        //convertendo data para padrão do banco de dados
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
            cal.setTime(sdf.parse(data));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, tipoData.concat(" não informada ou falha na conversão da Data.\nException: ".concat(e.getMessage())), "Falha na conversão da data", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return cal;
    }

    public String formataPadraoBrasil(Calendar cal, String tipoData) {
        String dataConvertida;
        
        //convertendo data para padrão do banco de dados
        try {
            SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");
            return dataConvertida = sDF.format(cal.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, tipoData.concat(" não informada ou falha na conversão da Data.\nException: ".concat(e.getMessage())), "Falha na conversão da data", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Calendar formataPadraoBancoComHora(String data, String tipoData) {
        Calendar cal = Calendar.getInstance();
        
        //convertendo data para padrão do banco de dados
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
            cal.setTime(sdf.parse(data));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, tipoData.concat(" não informada ou falha na conversão da Data.\nException: ".concat(e.getMessage())), "Falha na conversão da data", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return cal;
    }
    
    public String formataPadraoBrasilComHora(Calendar cal, String tipoData) {
        String dataConvertida;
        
        //convertendo data para padrão do banco de dados
        try {
            SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return dataConvertida = sDF.format(cal.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, tipoData.concat(" não informada ou falha na conversão da Data.\nException: ".concat(e.getMessage())), "Falha na conversão da data", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
