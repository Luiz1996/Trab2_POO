/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import view.EnvioEmailView;

/**
 *
 * @author Luiz Flávio
 */
public class Email implements Mensageria{
    private EnvioEmailView emailV = new EnvioEmailView();
    private String emailDestinatario;
    private String assunto;
    private String msg;
    
    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    @Override
    public void enviarMensagem(String destinatario) {
        try {
            
            //atualizando a view 
            emailV.getTxtDestinatario().setText(destinatario);

            //config. do gmail
            Properties mailProps = new Properties();
            mailProps.put("mail.transport.protocol", "smtp");
            mailProps.put("mail.smtp.starttls.enable", "true");
            mailProps.put("mail.smtp.host", "smtp.gmail.com");
            mailProps.put("mail.smtp.auth", "true");
            mailProps.put("mail.smtp.user", "clinitecsgc@gmail.com");
            mailProps.put("mail.debug", "true");
            mailProps.put("mail.smtp.port", "465");
            mailProps.put("mail.smtp.socketFactory.port", "465");
            mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            mailProps.put("mail.smtp.socketFactory.fallback", "false");

            //eh necessario autenticar
            Session mailSession = Session.getInstance(mailProps, new Authenticator() {

                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("clinitecsgc@gmail.com", "clinica2019");
                }
            });
            
            mailSession.setDebug(false);

            Message mailMessage = new MimeMessage(mailSession);

            mailMessage.setFrom(new InternetAddress("clinitecsgc@gmail.com"));

            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(this.emailDestinatario));

            MimeBodyPart mbpMensagem = new MimeBodyPart();
            mbpMensagem.setText(this.msg);

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbpMensagem);

            mailMessage.setSubject(this.assunto);

            mailMessage.setContent(mp);

            Transport.send(mailMessage);
        } catch (HeadlessException | MessagingException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao enviar o e-mail para ".concat(destinatario).concat("\nErro: ").concat(e.getMessage().trim()), "Falha ao enviar email", JOptionPane.ERROR_MESSAGE);
            return;
        }
        emailV.setVisible(true);
    }
}
