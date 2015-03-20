/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.showcase.infrastructure.mail;


import org.seedstack.showcase.application.MailService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.VelocityException;
import org.seedstack.seed.core.api.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;

/**
 * MailService implementation.
 */
public class MailServiceImpl implements MailService {
    @Inject
    @Named("smtp-mycompany")
    Session smtpSession;

    @Configuration("seedstore.mail.activation.template")
    private String templatePath;

    @Configuration("seedstore.mail.activation.subject")
    private String subject;

    @Configuration("seedstore.mail.activation.from")
    private String from;

    @Override
    public void sendMail(String to, Map<String, Object> values) throws VelocityException, MessagingException {
        Message message = new MimeMessage(smtpSession);
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setFrom(new InternetAddress(from));
        message.setSubject(subject);
        message.setSentDate(new Date());

        Template template = Velocity.getTemplate(templatePath);
        StringWriter stringWriter = new StringWriter();
        template.merge(new VelocityContext(values), stringWriter);
        message.setText(stringWriter.toString());

        Transport transport = smtpSession.getTransport();
        transport.connect();
        transport.sendMessage(message, message.getAllRecipients());
    }
}
