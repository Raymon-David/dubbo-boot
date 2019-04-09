package com.raymon.provider.service.impl.email;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.service.email.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Author: raymon
 * Date: 2019/4/8
 * Description:邮件发送接口实现类
 */
@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class EmailServiceImpl implements EmailService{

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * @param to
     * @param subject
     * @param content
     * 发送简单邮件
     */
    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        log.info("发送简单邮件 start: {}, {}, {}" + to, subject, content);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(from);

        javaMailSender.send(simpleMailMessage);
        log.info("发送简单邮件 成功 end");

    }

    /**
     * @param to
     * @param subject
     * @param content
     * 发送html邮件
     */
    @Override
    public void sendHtmlEmail(String to, String subject, String content) {
        log.info("发送html邮件 start: {}, {}, {}" + to, subject, content);

        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            log.error("发送html邮件失败", e);
            e.printStackTrace();
        }

        log.info("发送html邮件 成功 end");
    }

    /**
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * 发送带有附件的邮件
     */
    @Override
    public void sendAttachmentEmail(String to, String subject, String content, String filePath) {

        log.info("发送带有附件的邮件 start: {}, {}, {}, {}" + to, subject, content, filePath);
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = file.getFilename();
            mimeMessageHelper.addAttachment(fileName, file);

            javaMailSender.send(mailMessage);

        } catch (MessagingException e) {
            log.error("发送带有附件的邮件失败", e);
            e.printStackTrace();
        }
        log.info("发送带有附件的邮件 成功 end");
    }

    /**
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param recId
     * 发送带有图片的邮件
     */
    @Override
    public void sendInlineResourceEmail(String to, String subject, String content, String rscPath, String recId) {
        log.info("发送带有图片的邮件 start: {}, {}, {}, {}, {}" + to, subject, content, rscPath, recId);
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(rscPath));
            mimeMessageHelper.addInline(recId, file);

            javaMailSender.send(mailMessage);

        } catch (MessagingException e) {
            log.error("发送带有图片的邮件失败", e);
            e.printStackTrace();
        }
        log.info("发送带有图片的邮件 成功 end");
    }
}
