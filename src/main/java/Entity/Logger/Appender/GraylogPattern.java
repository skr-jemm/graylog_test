package Entity.Logger.Appender;

import jakarta.xml.bind.annotation.*;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-07-07
 * Description:
 * Last change:
 * Version:
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"className","pattern"})
public class GraylogPattern {
    @XmlAttribute(name = "class")
    private String className;
    @XmlElement(name = "pattern")
    private String pattern;

    public GraylogPattern() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "GraylogPattern{" +
                "className='" + className + '\'' +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
