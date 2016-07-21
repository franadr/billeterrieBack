package lu.intech.Billetterie.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Adriano on 21/07/16.
 */
@XmlRootElement(name="message")
public class Message {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;


}
