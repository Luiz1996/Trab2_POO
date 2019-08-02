/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.EnvioSmsView;

/**
 *
 * @author Luiz Flávio
 */
public class Sms implements Mensageria{
    @Override
    public void enviarMensagem(String destinatario) {
        
        //atualizando a view
        EnvioSmsView smsV = new EnvioSmsView();
        smsV.getTxtPara().setText(destinatario);
        smsV.setVisible(true);
           
        //Funcionalidade inativa
        System.out.println("                       Destinatário: " + destinatario);
        System.out.println("                        --------------------------------------Consulta Amanhã-------------------------------------------------");
        System.out.println("                       |   Venho por meio deste SMS, avisá-lo sobre a sua consulta de amanhã.                                |");
        System.out.println("                       |   Tente não atrasar !!!                                                                             |");
        System.out.println("                       |   A clinica Saude&Cia agradece a sua preferência...                                                 |");
        System.out.println("                        ------------------------------------------------------------------------------------------------------");
    } 
}
