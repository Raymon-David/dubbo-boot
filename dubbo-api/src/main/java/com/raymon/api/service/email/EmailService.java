package com.raymon.api.service.email;

/**
 * 邮件发送接口
 * Created by raymon.
 */
public interface EmailService {

    void sendSimpleEmail(String to, String subject, String content);

    void sendHtmlEmail(String to, String subject, String content);

    void sendAttachmentEmail(String to, String subject, String content, String filePath);

    void sendInlineResourceEmail(String to, String subject, String content, String rscPath, String recId);
}
