package Entity.Logger;


import Entity.Logger.Appender.Appender;
import Entity.Logger.LoggerReference.LoggerReference;
import Entity.Logger.Root.RootAppenderRef;
import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */

@XmlRootElement(name = "configuration")
@XmlType(propOrder = {"scan","scanPeriod","basicAppender","basicLoggerReference","rootAppenderRef"})
@XmlAccessorType(XmlAccessType.FIELD)
public class RootConfiguration {
    @XmlAttribute(name = "scan")
    private String scan = "false";
    @XmlAttribute(name = "scanPeriod")
    private String scanPeriod = "5 seconds";
    @XmlElement(name = "appender")
    private List<Appender> basicAppender;
    @XmlElement(name = "logger")
    private List<LoggerReference> basicLoggerReference;
    @XmlElement(name = "root")
    private RootAppenderRef rootAppenderRef;
    public RootConfiguration() {
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getScanPeriod() {
        return scanPeriod;
    }

    public void setScanPeriod(String scanPeriod) {
        this.scanPeriod = scanPeriod;
    }

    public List<Appender> getBasicAppender() {
        return basicAppender;
    }

    public void setBasicAppender(List<Appender> basicAppender) {
        this.basicAppender = basicAppender;
    }

    public RootAppenderRef getRoot() {
        return rootAppenderRef;
    }

    public void setRoot(RootAppenderRef rootAppenderRef) {
        this.rootAppenderRef = rootAppenderRef;
    }

    public List<LoggerReference> getBasicLoggerReference() {
        return basicLoggerReference;
    }

    public void setBasicLoggerReference(List<LoggerReference> basicLoggerReference) {
        this.basicLoggerReference = basicLoggerReference;
    }

    public RootAppenderRef getRootAppenderRef() {
        return rootAppenderRef;
    }

    public void setRootAppenderRef(RootAppenderRef rootAppenderRef) {
        this.rootAppenderRef = rootAppenderRef;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "scan='" + scan + '\'' +
                ", scanPeriod='" + scanPeriod + '\'' +
                ", basicAppender=" + basicAppender +
                '}';
    }
}
