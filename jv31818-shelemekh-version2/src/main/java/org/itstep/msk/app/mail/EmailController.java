package org.itstep.msk.app.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/checkmail")
public class EmailController {

    @Autowired
    private EmailProperties properties;

    @PostMapping("/mail")
    public void sendMailfromUsers(@RequestBody EmailAnswer emailAnswer, BindingResult bindingResult)
            throws ValidationException {

        if (bindingResult.hasErrors()){
            throw new ValidationException("Answer is not valid");
        }

        //Create mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.properties.getHost());
        mailSender.setPort(this.properties.getPort());
        mailSender.setUsername(this.properties.getUsername());
        mailSender.setPassword(this.properties.getPassword());

        //mail instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailAnswer.getEmail());
        mailMessage.setTo("user@mail.com");
        mailMessage.setSubject("New messsage from " + emailAnswer.getName());
        mailMessage.setText(emailAnswer.getAnswer());

        mailSender.send(mailMessage);
    }
}
