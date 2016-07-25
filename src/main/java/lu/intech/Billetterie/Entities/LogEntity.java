package lu.intech.Billetterie.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Adriano on 25/07/16.
 */
@Entity
public class LogEntity {


    private int idLog;
    private Date date;
    private String operation;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public int hashCode() {
        int result = idLog;
        result = 31 * result + date.hashCode();
        result = 31 * result + operation.hashCode();
        return result;
    }

    @Id
    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntity)) return false;

        LogEntity logEntity = (LogEntity) o;

        if (idLog != logEntity.idLog) return false;
        if (!date.equals(logEntity.date)) return false;
        return operation.equals(logEntity.operation);

    }
}
