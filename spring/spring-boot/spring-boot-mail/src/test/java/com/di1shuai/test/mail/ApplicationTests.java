package com.di1shuai.test.mail;


import com.di1shuai.test.mail.bean.Mail;
import com.di1shuai.test.mail.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.di1shuai.test.mail.MailApplication.class)
public class ApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	EmailService emailService;

	@Autowired
	Store store;

	@Value("${spring.mail.username}")
	String username;

	@Value("${spring.mail.password}")
	String password;



	@Test
	public void sendSimpleMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xxxx@xxx.com");
		message.setTo("xxxx@xxxx.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");

		mailSender.send(message);
	}


	@Test
	public void sendTemplateMail() throws Exception {
		Mail mail = new Mail();
		mail.setFrom("xxx");
		mail.setTo("xxx");
		mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", "Memorynotfound.com");
		model.put("location", "Belgium");
		model.put("signature", "http://memorynotfound.com");
		mail.setModel(model);

		emailService.sendHTMLMessage(mail);
	}


	@Test
	public void receiveMail() throws MessagingException {
		Folder folder = null;
		try {
			store.connect(username,password);
			folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);
			log.info("收件箱中共" + folder.getMessageCount() + "封邮件!");
			log.info("收件箱中共" + folder.getUnreadMessageCount() + "封未读邮件!");
			log.info("收件箱中共" + folder.getNewMessageCount() + "封新邮件!");
			log.info("收件箱中共" + folder.getDeletedMessageCount() + "封已删除邮件!");


		} catch (MessagingException e) {
			e.printStackTrace();
		}finally {
			folder.close(true);
			store.close();
		}
	}

}