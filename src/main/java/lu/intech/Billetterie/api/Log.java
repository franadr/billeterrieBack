package lu.intech.Billetterie.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Adriano on 25/07/16.
 */
@XmlRootElement
public class Log {
    private int idLog;
    private String date;
    private String operation;

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
