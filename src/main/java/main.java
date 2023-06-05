import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-05-08
 * Description:
 * Last change:
 * Version:
 */
public class main {
    public static void main(String[] args) {
        Environment.createInstance();

        Environment.logMessage("generic","Prueba de loggeo de tipo INFO en el puerto: {12302}X");
        Environment.logMessage("batch","Prueba de loggeo de tipo DEBUG en el puerto: {12303}Y");
        //Environment.logMessage("batcho","Prueba de loggeo de tipo DEBUG en el puerto: {12303}C");
        Environment.logMessage("audit","Prueba de loggeo de tipo WARN en el puerto: {12304}J");
        Environment.logMessage("error","Prueba de loggeo de tipo ERROR en el puerto: {12305}R");

    }
}
