package Entity.Request;

import java.util.List;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
public class Environment {
    //--> Appender && Variable
    private String appenderName;
    private String value;

    //--> Only Appender Generic
    private String className;
    private String pattern;
    private String typeAppender;
    private String loggerAccessName;
    private String levelLogger;
    //--> GrayLog Appender
    private String graylogHost;
    private String graylogPort;
    private String connectTimeout;
    private String socketTimeout;
    private String reconnectInterval;
    private String maxRetries;
    private String retryDelay;
    private String poolSize;
    private String poolMaxWaitTime;
    private String poolMaxIdleTime;
    private EncoderEnvironment encoderEnvironment;

    //----> RollingPolicy
    private String fileNamePattern;
    private Integer maxFileSize;
    private Integer totalSizeCap;
    private Integer maxHistory;
    private String encoderPattern;
    private String appName;

    public Environment() {
    }

    public String getAppenderName() {
        return appenderName;
    }

    public void setAppenderName(String appenderName) {
        this.appenderName = appenderName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getTypeAppender() {
        return typeAppender;
    }

    public void setTypeAppender(String typeAppender) {
        this.typeAppender = typeAppender;
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

    public String getFileNamePattern() {
        return fileNamePattern;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Integer maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public Integer getTotalSizeCap() {
        return totalSizeCap;
    }

    public void setTotalSizeCap(Integer totalSizeCap) {
        this.totalSizeCap = totalSizeCap;
    }

    public Integer getMaxHistory() {
        return maxHistory;
    }

    public void setMaxHistory(Integer maxHistory) {
        this.maxHistory = maxHistory;
    }

    public String getEncoderPattern() {
        return encoderPattern;
    }

    public void setEncoderPattern(String encoderPattern) {
        this.encoderPattern = encoderPattern;
    }

    public EncoderEnvironment getEncoderEnvironment() {
        return encoderEnvironment;
    }

    public void setEncoderEnvironment(EncoderEnvironment encoderEnvironment) {
        this.encoderEnvironment = encoderEnvironment;
    }

    public String getLoggerAccessName() {
        return loggerAccessName;
    }

    public void setLoggerAccessName(String loggerAccessName) {
        this.loggerAccessName = loggerAccessName;
    }

    public String getLevelLogger() {
        return levelLogger;
    }

    public void setLevelLogger(String levelLogger) {
        this.levelLogger = levelLogger;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "appenderName='" + appenderName + '\'' +
                ", value='" + value + '\'' +
                ", className='" + className + '\'' +
                ", pattern='" + pattern + '\'' +
                ", typeAppender='" + typeAppender + '\'' +
                ", loggerAccessName='" + loggerAccessName + '\'' +
                ", levelLogger='" + levelLogger + '\'' +
                ", graylogHost='" + graylogHost + '\'' +
                ", graylogPort='" + graylogPort + '\'' +
                ", connectTimeout='" + connectTimeout + '\'' +
                ", socketTimeout='" + socketTimeout + '\'' +
                ", reconnectInterval='" + reconnectInterval + '\'' +
                ", maxRetries='" + maxRetries + '\'' +
                ", retryDelay='" + retryDelay + '\'' +
                ", poolSize='" + poolSize + '\'' +
                ", poolMaxWaitTime='" + poolMaxWaitTime + '\'' +
                ", poolMaxIdleTime='" + poolMaxIdleTime + '\'' +
                ", encoderEnvironment=" + encoderEnvironment +
                ", fileNamePattern='" + fileNamePattern + '\'' +
                ", maxFileSize=" + maxFileSize +
                ", totalSizeCap=" + totalSizeCap +
                ", maxHistory=" + maxHistory +
                ", encoderPattern='" + encoderPattern + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
