package Entity.Logger.Appender;

import jakarta.xml.bind.annotation.*;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","className","graylogHost","graylogPort","connectTimeout",
        "socketTimeout","reconnectInterval","maxRetries","retryDelay","poolSize",
        "poolMaxWaitTime","poolMaxIdleTime","encoder"})
public class Appender {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "class")
    private String className;
    @XmlElement(name = "graylogHost")
    private String graylogHost;
    @XmlElement(name = "graylogPort")
    private String graylogPort;
    @XmlElement(name = "connectTimeout")
    private String connectTimeout;
    @XmlElement(name = "socketTimeout")
    private String socketTimeout;
    @XmlElement(name = "reconnectInterval")
    private String reconnectInterval;
    @XmlElement(name = "maxRetries")
    private String maxRetries;
    @XmlElement(name = "retryDelay")
    private String retryDelay;
    @XmlElement(name = "poolSize")
    private String poolSize;
    @XmlElement(name = "poolMaxWaitTime")
    private String poolMaxWaitTime;
    @XmlElement(name = "poolMaxIdleTime")
    private String poolMaxIdleTime;
    @XmlElement(name = "encoder")
    private Encoder encoder;


    /**
     * Constructor básico
     */
    public Appender() {
    }

    /**
     * Constructor modificado para la creación de un appender básico
     * @param name Nombre del appender básico
     * @param className Nombre de la clase para usar en el appeder básico
     * @param encoderPatter Patron del enconder a usar
     */
    public Appender(String name, String className, String encoderPatter) {
        this.name = name;
        this.className = className;
        this.encoder = new Encoder(encoderPatter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Encoder getEncoder() {
        return encoder;
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    public String getGraylogHost() {
        return graylogHost;
    }

    public void setGraylogHost(String graylogHost) {
        this.graylogHost = graylogHost;
    }

    public String getGraylogPort() {
        return graylogPort;
    }

    public void setGraylogPort(String graylogPort) {
        this.graylogPort = graylogPort;
    }

    public String getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(String socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getReconnectInterval() {
        return reconnectInterval;
    }

    public void setReconnectInterval(String reconnectInterval) {
        this.reconnectInterval = reconnectInterval;
    }

    public String getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(String maxRetries) {
        this.maxRetries = maxRetries;
    }

    public String getRetryDelay() {
        return retryDelay;
    }

    public void setRetryDelay(String retryDelay) {
        this.retryDelay = retryDelay;
    }

    public String getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(String poolSize) {
        this.poolSize = poolSize;
    }

    public String getPoolMaxWaitTime() {
        return poolMaxWaitTime;
    }

    public void setPoolMaxWaitTime(String poolMaxWaitTime) {
        this.poolMaxWaitTime = poolMaxWaitTime;
    }

    public String getPoolMaxIdleTime() {
        return poolMaxIdleTime;
    }

    public void setPoolMaxIdleTime(String poolMaxIdleTime) {
        this.poolMaxIdleTime = poolMaxIdleTime;
    }

    @Override
    public String toString() {
        return "Appender{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", encoder=" + encoder +
                '}';
    }
}
