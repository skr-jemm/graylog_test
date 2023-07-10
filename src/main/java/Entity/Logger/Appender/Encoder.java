package Entity.Logger.Appender;

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
@XmlType(propOrder = {"pattern","className",
        "name","originHost","includeRawMessage","includeMarker","includeMdcData",
        "includeCallerData","includeRootCauseData","includeLevelName", "graylogPattern",
        "graylogPatternFull","numbersAsString","staticField"})
public class Encoder {
    @XmlElement(name = "pattern")
    private String pattern;
    //--> Elementos usados para Graylog
    @XmlAttribute(name = "class")
    private String className;
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "originHost")
    private String originHost;
    @XmlElement(name = "includeRawMessage")
    private boolean includeRawMessage;
    @XmlElement(name = "includeMarker")
    private boolean includeMarker;
    @XmlElement(name = "includeMdcData")
    private boolean includeMdcData;
    @XmlElement(name = "includeCallerData")
    private boolean includeCallerData;
    @XmlElement(name = "includeRootCauseData")
    private boolean includeRootCauseData;
    @XmlElement(name = "includeLevelName")
    private boolean includeLevelName;
    @XmlElement(name = "shortPatternLayout")
    private GraylogPattern graylogPattern;
    @XmlElement(name = "fullPatternLayout")
    private GraylogPattern graylogPatternFull;
    @XmlElement(name = "numbersAsString")
    private boolean numbersAsString;
    @XmlElement(name = "staticField")
    private List<String> staticField;
    public Encoder() {
    }

    /**
     * Constructor modificado para recibir la información del patrón
     * @param pattern Patrón
     */
    public Encoder(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginHost() {
        return originHost;
    }

    public void setOriginHost(String originHost) {
        this.originHost = originHost;
    }

    public boolean isIncludeRawMessage() {
        return includeRawMessage;
    }

    public void setIncludeRawMessage(boolean includeRawMessage) {
        this.includeRawMessage = includeRawMessage;
    }

    public boolean isIncludeMarker() {
        return includeMarker;
    }

    public void setIncludeMarker(boolean includeMarker) {
        this.includeMarker = includeMarker;
    }

    public boolean isIncludeMdcData() {
        return includeMdcData;
    }

    public void setIncludeMdcData(boolean includeMdcData) {
        this.includeMdcData = includeMdcData;
    }

    public boolean isIncludeCallerData() {
        return includeCallerData;
    }

    public void setIncludeCallerData(boolean includeCallerData) {
        this.includeCallerData = includeCallerData;
    }

    public boolean isIncludeRootCauseData() {
        return includeRootCauseData;
    }

    public void setIncludeRootCauseData(boolean includeRootCauseData) {
        this.includeRootCauseData = includeRootCauseData;
    }

    public boolean isIncludeLevelName() {
        return includeLevelName;
    }

    public void setIncludeLevelName(boolean includeLevelName) {
        this.includeLevelName = includeLevelName;
    }

    public GraylogPattern getGraylogPattern() {
        return graylogPattern;
    }

    public void setGraylogPattern(GraylogPattern graylogPattern) {
        this.graylogPattern = graylogPattern;
    }

    public GraylogPattern getGraylogPatternFull() {
        return graylogPatternFull;
    }

    public void setGraylogPatternFull(GraylogPattern graylogPatternFull) {
        this.graylogPatternFull = graylogPatternFull;
    }

    public boolean isNumbersAsString() {
        return numbersAsString;
    }

    public void setNumbersAsString(boolean numbersAsString) {
        this.numbersAsString = numbersAsString;
    }

    public List<String> getStaticField() {
        return staticField;
    }

    public void setStaticField(List<String> staticField) {
        this.staticField = staticField;
    }

    @Override
    public String toString() {
        return "Encoder{" +
                "pattern='" + pattern + '\'' +
                ", className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", originHost='" + originHost + '\'' +
                ", includeRawMessage=" + includeRawMessage +
                ", includeMarker=" + includeMarker +
                ", includeMdcData=" + includeMdcData +
                ", includeCallerData=" + includeCallerData +
                ", includeRootCauseData=" + includeRootCauseData +
                ", includeLevelName=" + includeLevelName +
                ", graylogPattern=" + graylogPattern +
                ", graylogPatternFull=" + graylogPatternFull +
                ", numbersAsString=" + numbersAsString +
                ", staticField=" + staticField +
                '}';
    }
}
