package mainsender

import javax.mail.{Message, Session}
import javax.mail.internet.{InternetAddress, MimeMessage}

/**
  * Created by levidu on 1/31/17.
  */
object PostfixSender extends App {

  val sender = "levidu@Levidu-ThinkPad"
  val recipient = "levidualahakoon@gmail.com"
  val host = "localhost"
//  val port = "25"

  val properties = System.getProperties

  properties.setProperty("mail.smtp.host", host)
//  properties.setProperty("mail.smtp.port", port)
  properties.setProperty("mail.smtp.starttls.enable", "true")
  properties.setProperty("mail.smtp.ssl.trust","localhost")
  properties.setProperty("mail.smtp.auth", "true")
  properties.setProperty("mail.user", sender)
  properties.setProperty("mail.password", "root@123")

  val session = Session.getInstance(properties)

  val message = new MimeMessage(session);

  // Set From: header field of the header.
  message.setFrom(new InternetAddress(sender));

  // Set To: header field of the header.
  message.addRecipient(Message.RecipientType.TO,
    new InternetAddress(recipient));

  // Set Subject: header field
  message.setSubject("This is the Subject Line!");

  // Now set the actual message
  message.setText("This is actual message: Test with Muhu ");

  // Send message
  val tr = session.getTransport("smtp")
  tr.connect(host,"levidu@Levidu-ThinkPad","root@123")
  tr.sendMessage(message, message.getAllRecipients());


}
