package com.di1shuai.test.mail.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

/**
 * @author: shea
 * @date: 2021/7/6
 * @description:
 */
@Configuration
@Slf4j
public class MailConfig {




    @Bean
    public Session session(@Value("${spring.mail.properties.mail.store.protocol}") String mailProtocol,
                           @Value("${spring.mail.properties.mail.imap.host}") String mailHost,
                           @Value("${spring.mail.properties.mail.imap.port}") String mailPort) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", mailProtocol);
        props.setProperty("mail.imap.host", mailHost);
        props.setProperty("mail.imap.port", mailPort);
        // 创建Session实例对象
        Session session = Session.getInstance(props);
        return session;
    }

    @Bean
    public Store store(Session session,
                       @Value("${spring.mail.properties.mail.store.protocol}") String mailProtocol) {
        // 创建IMAP协议的Store对象
        Store store = null;
        try {
            store = session.getStore(mailProtocol);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return store;
    }


}
