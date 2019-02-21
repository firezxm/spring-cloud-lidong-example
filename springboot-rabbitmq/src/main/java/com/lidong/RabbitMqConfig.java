package com.lidong;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMqConfig {
  private String host;
  private int port;
  private String userName;
  private String password;
 
  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host,port);
    cachingConnectionFactory.setUsername(userName);
    cachingConnectionFactory.setPassword(password);
    cachingConnectionFactory.setVirtualHost("/");
    cachingConnectionFactory.setPublisherConfirms(true);
    return cachingConnectionFactory;
  }
 
  @Bean
  public RabbitTemplate rabbitTemplate() {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
    return rabbitTemplate;
  }

  @Bean("myContainerFactory")
  public SimpleRabbitListenerContainerFactory myContainerFactory(
          SimpleRabbitListenerContainerFactoryConfigurer configurer) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    //开启手动确认消息
    factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
    factory.setPrefetchCount(100);
    configurer.configure(factory, connectionFactory());
    return factory;
  }


  public String getHost() {
    return host;
  }
 
  public void setHost(String host) {
    this.host = host;
  }
 
  public int getPort() {
    return port;
  }
 
  public void setPort(int port) {
    this.port = port;
  }
 
  public String getUserName() {
    return userName;
  }
 
  public void setUserName(String userName) {
    this.userName = userName;
  }
 
  public String getPassword() {
    return password;
  }
 
  public void setPassword(String password) {
    this.password = password;
  }
}