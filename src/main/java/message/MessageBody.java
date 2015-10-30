package message;

import java.io.Serializable;

/**
 * Created by wzgong on 10/14/2015.
 */
public class MessageBody implements Serializable {
    private Class table;
    private Object primaryKey;

    public MessageBody() {
    }

    public MessageBody(Class table, Object primaryKey) {
        this.table = table;
        this.primaryKey = primaryKey;
    }

    public Class getTable() {
        return table;
    }

    public void setTable(Class table) {
        this.table = table;
    }

    public Object getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Object primaryKey) {
        this.primaryKey = primaryKey;
    }
}
