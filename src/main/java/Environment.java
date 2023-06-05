import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-04
 * Description: Patrón singleton para la contención de una única instancia de los objetos
 * Last change:
 * Version:
 */
public class Environment {
    private Logger ENVIRONMENT = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Environment.class);
    ///--> Diferentes tipos de loggeos,
    private Logger AUDIT_BUSSINESS_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("AUDIT_BUSINESS_LOGGER");
    private Logger ERROR_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("ERROR_LOGGER");
    private Logger GENERIC_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("GENERIC_LOGGER");
    private Logger BATCH_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("BATCH_LOGGER");

    //---> Instancia de la clase
    private static Environment environment;

    private Environment(Logger AUDIT_BUSSINESS_LOGGER, Logger ERROR_LOGGER, Logger GENERIC_LOGGER, Logger BATCH_LOGGER) {
        this.AUDIT_BUSSINESS_LOGGER = AUDIT_BUSSINESS_LOGGER;
        this.ERROR_LOGGER = ERROR_LOGGER;
        this.GENERIC_LOGGER = GENERIC_LOGGER;
        this.BATCH_LOGGER = BATCH_LOGGER;
    }

    public static void createInstance(){
        if(environment == null){
            environment = new Environment(
                    (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("AUDIT_BUSINESS_LOGGER"),
                    (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("ERROR_LOGGER"),
                    (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("GENERIC_LOGGER"),
                    (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("BATCH_LOGGER"));
        }
    }

    public Logger getAUDIT_BUSSINESS_LOGGER() {
        return AUDIT_BUSSINESS_LOGGER;
    }

    public void setAUDIT_BUSSINESS_LOGGER(Logger AUDIT_BUSSINESS_LOGGER) {
        this.AUDIT_BUSSINESS_LOGGER = AUDIT_BUSSINESS_LOGGER;
    }

    public Logger getERROR_LOGGER() {
        return ERROR_LOGGER;
    }

    public void setERROR_LOGGER(Logger ERROR_LOGGER) {
        this.ERROR_LOGGER = ERROR_LOGGER;
    }

    public Logger getGENERIC_LOGGER() {
        return GENERIC_LOGGER;
    }

    public void setGENERIC_LOGGER(Logger GENERIC_LOGGER) {
        this.GENERIC_LOGGER = GENERIC_LOGGER;
    }

    public Logger getBATCH_LOGGER() {
        return BATCH_LOGGER;
    }

    public void setBATCH_LOGGER(Logger BATCH_LOGGER) {
        this.BATCH_LOGGER = BATCH_LOGGER;
    }

    public static Environment getEnvironment() {
        return environment;
    }

    public static void setEnvironment(Environment environment) {
        Environment.environment = environment;
    }

    public Logger getENVIRONMENT() {
        return ENVIRONMENT;
    }

    public void setENVIRONMENT(Logger ENVIRONMENT) {
        this.ENVIRONMENT = ENVIRONMENT;
    }

    //---> Método de envío de información
    //--> 1.- generic: info
    //--> 2.- batch: debug
    //--> 3.- audit: warn
    //--> 4.- error: error
    public static void logMessage(String level, String message){
        try {
            if(environment != null) {
                switch (level) {
                    case "generic":
                        Environment.environment.getGENERIC_LOGGER().info(message);
                        break;
                    case "batch":
                        Environment.environment.getBATCH_LOGGER().debug(message);
                        break;
                    case "audit":
                        Environment.environment.getAUDIT_BUSSINESS_LOGGER().warn(message);
                        break;
                    case "error":
                        Environment.environment.getERROR_LOGGER().error(message);
                        break;
                    default:
                        System.out.println("Mensaje fuera de los estatus declarados, no se enviará el mensaje: " + message);
                        break;
                }
            }
        } catch (Exception e){
          e.printStackTrace();
          System.out.println("Error fatal:"+e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Environment{" +
                "AUDIT_BUSSINESS_LOGGER=" + AUDIT_BUSSINESS_LOGGER +
                ", ERROR_LOGGER=" + ERROR_LOGGER +
                ", GENERIC_LOGGER=" + GENERIC_LOGGER +
                ", BATCH_LOGGER=" + BATCH_LOGGER +
                '}';
    }
}
