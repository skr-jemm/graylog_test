package Entity.Logger.LoggerReference;


import Entity.Logger.Root.AppenderRef;
import jakarta.xml.bind.annotation.*;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
@XmlRootElement(name = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","level","appenderRef"})
public class LoggerReference {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "level")
    private String level;
    @XmlElement(name = "appender-ref")
    private AppenderRef appenderRef;

    public LoggerReference() {
    }

    public LoggerReference(String name, String level, AppenderRef appenderRef) {
        this.name = name;
        this.level = level;
        this.appenderRef = appenderRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public AppenderRef getAppenderRef() {
        return appenderRef;
    }

    public void setAppenderRef(AppenderRef appenderRef) {
        this.appenderRef = appenderRef;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
