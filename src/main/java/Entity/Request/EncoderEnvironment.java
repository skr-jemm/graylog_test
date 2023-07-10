package Entity.Request;

import java.util.List;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
public class EncoderEnvironment {
    private String className;
    private String originHost;
    private boolean includeRawMessage;
    private boolean includeMarker;
    private boolean includeMdcData;
    private boolean includeCallerData;
    private boolean includeRootCauseData;
    private boolean includeLevelName;
    private boolean numberAsString;
    private List<PatternLayout> patternLayout;

    public EncoderEnvironment() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public boolean isNumberAsString() {
        return numberAsString;
    }

    public void setNumberAsString(boolean numberAsString) {
        this.numberAsString = numberAsString;
    }

    public List<PatternLayout> getPatternLayout() {
        return patternLayout;
    }

    public void setPatternLayout(List<PatternLayout> patternLayout) {
        this.patternLayout = patternLayout;
    }

    @Override
    public String toString() {
        return "EncoderEnvironment{" +
                "className='" + className + '\'' +
                ", originHost='" + originHost + '\'' +
                ", includeRawMessage=" + includeRawMessage +
                ", includeMarker=" + includeMarker +
                ", includeMdcData=" + includeMdcData +
                ", includeCallerData=" + includeCallerData +
                ", includeRootCauseData=" + includeRootCauseData +
                ", includeLevelName=" + includeLevelName +
                ", numberAsString=" + numberAsString +
                ", patternLayout=" + patternLayout +
                '}';
    }
}
