package com.raymon.consumer.controller.email;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.service.email.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;


/**
 * Author: raymon
 * Date: 2019/4/8
 * Description:邮件发送controller
 */
@RestController
public class EmailController {
    private static final Logger log = LoggerFactory.getLogger(EmailController.class);

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private EmailService emailService;

    @Resource
    TemplateEngine templateEngine;

    /**
     * 发送简单邮件
     * @return
     */
    @RequestMapping(value ="/email/sendSimpleEmail" ,method = RequestMethod.GET)
    public void sendSimpleEmail(){

        emailService.sendSimpleEmail("xingyunruyubb@hotmail.com", "hello world", "hello world");
    }

    /**
     * 发送html邮件
     * @return
     */
    @RequestMapping(value ="/email/sendHtmlEmail" ,method = RequestMethod.GET)
    public void sendHtmlEmail(){
        String content = "<html>\n"+
                        "<body>\n"+
                            "<h3> hello html !</h3>\n"+
                        "</body>\n"+
                        "</html>";

        emailService.sendHtmlEmail("xingyunruyubb@hotmail.com", "hello world html",  content);
    }

    /**
     * 发送带附件邮件
     * @return
     */
    @RequestMapping(value ="/email/sendAttachmentEmail" ,method = RequestMethod.GET)
    public void sendAttachmentEmail() {
        String content = "<html>\n" +
                "<body>\n" +
                "<h3> hello html !</h3>\n" +
                "</body>\n" +
                "</html>";

        String emailPath = "/user/raymon/download/与孩子一起学编程.pdf";

        emailService.sendAttachmentEmail("xingyunruyubb@hotmail.com", "hello world html", content, emailPath);
    }

    /**
     * 发送带图片邮件
     * @return
     */
    @RequestMapping(value ="/email/sendInlineResourceEmail" ,method = RequestMethod.GET)
    public void sendInlineResourceEmail() {
        String imagePath = "/user/raymon/desktop/WechatIMG48.jpeg";
        String rscid = "001";

        String content = "<html>\n" +
                "<body>\n" +
                "<h3> hello html !</h3>\n" +
                "<img src=\'cid:" + rscid + "\'></img>" +
                "</body>\n" +
                "</html>";

        emailService.sendInlineResourceEmail("xingyunruyubb@hotmail.com", "hello world html", content, imagePath, rscid);
    }

    /**
     * 发送模板邮件，基于html邮件
     * @return
     */
    @RequestMapping(value ="/email/sendTemplateEmail" ,method = RequestMethod.GET)
    public void sendTemplateEmail() {
        Context context = new Context();
        context.setVariable("id", "002");

        String emailContent = templateEngine.process("emailTemplate", context);

        emailService.sendHtmlEmail("xingyunruyubb@hotmail.com", "hello world 模板邮件", emailContent);
    }
}
