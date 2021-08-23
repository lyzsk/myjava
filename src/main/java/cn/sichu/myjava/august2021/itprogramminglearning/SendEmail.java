package cn.sichu.myjava.august2021.itprogramminglearning;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class SendEmail {

    /**
     * 通过JavaMail API连接到SMTP服务器上
     * <p>
     * 连接SMTP服务器时，需要准备一个Properties对象，填入相关信息。最后获取Session实例时，如果服务器需要认证，还需要传入一个Authenticator对象，并返回指定的用户名和口令。
     * <p>
     * 发送邮件时，我们需要构造一个Message对象，然后调用Transport.send(Message)即可完成发送
     * 
     * @throws Exception
     * @throws AddressException
     * 
     */
    public static void sendEmail() throws AddressException, Exception {
        // SMTP SERVER
        String outlook_smtp = "smtp.office365.com";
        // LOG IN USER NAME
        String outlook_username = "sichu.huang2021@outlook.com";
        // LOG IN PASSWORD
        // TODO add password
        String outlook_password = "***";
        Properties props = new Properties();
        // SMTP主机名
        props.put("mail.smtp.host", outlook_smtp);
        // 主机端口号
        props.put("mail.smtp.port", "587");
        // 是否需要用户认证
        props.put("mail.smtp.auth", "true");
        // 启用TLS加密
        props.put("mail.smtp.starttls.enable", "true");
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(outlook_username, outlook_password);
            }
        });
        // 设置debug模式便于调试:
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        // 设置发送方地址
        message.setFrom(new InternetAddress("sichu.huang2021@outlook.com"));
        // 设置接收方地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("875441244@qq.com"));
        // 设置邮件主题
        message.setSubject("Hello", "UTF-8");
        // 设置邮件正文
        // message.setText("Hello xiaoming...", "UTF-8");
        // 发送HTML邮件
        // message.setText("<h1>Hello</h1><p>Hi, xxx</p>", "UTF-8", "html");
        // 发送
        // Transport.send(message);

        // 要在电子邮件中携带附件，我们就不能直接调用message.setText()方法，而是要构造一个Multipart对象
        Multipart multipart = new MimeMultipart();
        // 添加text
        BodyPart textpart = new MimeBodyPart();
        textpart.setContent("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "  <head>\r\n"
            + "    <meta charset=\"UTF-8\" />\r\n" + "    <meta name=\"viewport\" content=\"device-width\" />\r\n"
            + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\r\n" + "    <title>Document</title>\r\n"
            + "    <dl id=\"drink-menu\" style=\"border: solid 1px #ccc; padding: 6px\">\r\n" + "      <dt>摩卡</dt>\r\n"
            + "      <dd>热摩卡咖啡</dd>\r\n" + "      <dt>酸奶</dt>\r\n" + "      <dd>北京老酸奶</dd>\r\n"
            + "      <dt>果汁</dt>\r\n" + "      <dd>鲜榨苹果汁</dd>\r\n" + "    </dl>\r\n" + "  </head>\r\n" + "  <body>\r\n"
            + "    <h1>Hello World</h1>\r\n" + "    <script src=\"index.js\"></script>\r\n" + "  </body>\r\n"
            + "</html>", "text/html;charset=utf-8");
        multipart.addBodyPart(textpart);
        // 添加image
        BodyPart imagepart = new MimeBodyPart();
        imagepart.setFileName(new File("/myjava/img/big_news.jpg").getName());
        imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource("Content-ID", "application/octet-stream")));
        multipart.addBodyPart(imagepart);
        // 设置邮件内容为multipart:
        message.setContent(multipart);
        Transport.send(message);
    }

    public static void main(String[] args) throws AddressException, Exception {
        sendEmail();
    }

}
