package mainsender
import com.sun.mail.util.MailLogger
import javax.activation._
import javax.mail
import javax.mail.internet.{InternetAddress, MimeMessage}
import javax.mail.{Authenticator, Message, PasswordAuthentication, Session}

/**
  * Created by levidu on 1/30/17.
  */
object Sender extends App{

  val sender = "levidualahakoon@gmail.com"
  val recipient = "levidualahakoon@gmail.com"
  val host = "smtp.gmail.com"
  val port = "587"

  val properties = System.getProperties()
  properties.setProperty("mail.smtp.host", host)
  properties.setProperty("mail.smtp.port", port)
  properties.setProperty("mail.smtp.starttls.enable", "true")
  properties.setProperty("mail.smtp.auth", "true")
  properties.setProperty("mail.user", sender)
  properties.setProperty("mail.password", "nqkdjokpvttugpbc")

  //smtp server
  //how to install the smtp sever
  //

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
  message.setText("This is actual message");

  // Send message
  val tr = session.getTransport("smtp")
  tr.connect( host,"levidualahakoon@gmail.com","nqkdjokpvttugpbc")
  tr.sendMessage(message, message.getAllRecipients());





}
