package Entity.Request;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
public class PatternLayout {
    private String className;
    private String pattern;

    public PatternLayout() {
    }

    /**
     *
     * @param className
     * @param pattern
     */
    public PatternLayout(String className, String pattern) {
        this.className = className;
        this.pattern = pattern;
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
        return "PatternLayout{" +
                "className='" + className + '\'' +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
