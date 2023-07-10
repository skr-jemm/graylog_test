package Entity.Logger.Root;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"ref"})
public class AppenderRef {
    @XmlAttribute(name = "ref")
    private String ref;

    public AppenderRef(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "AppenderRef{" +
                "ref='" + ref + '\'' +
                '}';
    }
}
