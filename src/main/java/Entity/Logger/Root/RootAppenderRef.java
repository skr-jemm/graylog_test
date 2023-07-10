package Entity.Logger.Root;

import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"level","appenderRef"})
public class RootAppenderRef {
    @XmlAttribute(name = "level")
    private String level;
    @XmlElement(name = "appender-ref")
    private List<AppenderRef> appenderRef;

    public RootAppenderRef() {
    }

    public RootAppenderRef(String level, List<AppenderRef> appenderRef) {
        this.level = level;
        this.appenderRef = appenderRef;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public List<AppenderRef> getAppenderRef() {
        return appenderRef;
    }

    public void setAppenderRef(List<AppenderRef> appenderRef) {
        this.appenderRef = appenderRef;
    }

    @Override
    public String toString() {
        return "Root{" +
                "level='" + level + '\'' +
                ", appenderRef=" + appenderRef +
                '}';
    }
}
