import Entity.Adapters.Adapter;
import Entity.Logger.Appender.Encoder;
import Entity.Logger.LoggerReference.LoggerReference;
import Entity.Logger.Root.RootAppenderRef;
import Entity.Logger.RootConfiguration;
import Entity.Request.Environment;
import Entity.Logger.Appender.Appender;
import Entity.Logger.Root.AppenderRef;
import ch.qos.logback.classic.Logger;
import io.vertx.core.json.Json;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-04
 * Description: Patrón singleton para la contención de una única instancia de los objetos
 * Last change:
 * Version:
 */
public class SkrLogger {
    ///--> Diferentes tipos de loggeos,
    private static Logger AUDIT_BUSSINESS_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("AUDIT_BUSINESS_LOGGER");
    private static Logger ERROR_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("ERROR_LOGGER");
    private static Logger GENERIC_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("GENERIC_LOGGER");
    private static Logger BATCH_LOGGER;// = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("BATCH_LOGGER");
    private static Logger FILE_LOGGER;

    private static String[] patterns = new String[] {
            // This will remove empty elements that look like <ElementName/>
            "\\s*<\\w+/>",
            // This will remove empty elements that look like <ElementName></ElementName>
            "\\s*<\\w+></\\w+>",
            // This will remove empty elements that look like
            // <ElementName>
            // </ElementName>
            "\\s*<\\w+>\n*\\s*</\\w+>"
    };
    private SkrLogger(Logger element,Logger GENERIC_LOGGER){
        this.FILE_LOGGER = element;
    }

    public static void createInstance(List<Environment> loggerEnvironment){
        //--> 1.- Generar archivo XML
        try {
            if (loggerEnvironment != null && loggerEnvironment.size() > 0){
                //--> Creamos el elemento principal
                RootConfiguration rootConfiguration = new RootConfiguration();

                List<Appender> APPENDERS_BASIC_LIST = new ArrayList<>();
                List<AppenderRef> APPENDERS_REF_ROOT = new ArrayList<>();
                List<LoggerReference> APPENDERS_LOGGER_REFERENCE = new ArrayList<>();

                //-------> Procedemos a interar la lista de los entornos creados
                for(Environment environment: loggerEnvironment){
                    switch (environment.getTypeAppender()){
                        case "console":
                            Appender consoleAppender = createConsoleAppender(environment);
                            AppenderRef consoleAppenderRef = createRootAppender(environment);

                            APPENDERS_BASIC_LIST.add(consoleAppender);
                            APPENDERS_REF_ROOT.add(consoleAppenderRef);
                            setFileLogger((ch.qos.logback.classic.Logger) LoggerFactory.getLogger("TEST_LOGGER"));
                            break;
                        case "graylog":
                            System.out.println("&&&");
                            Appender consoleAppenderGrayLog = createGraylogAppender(environment);
                            LoggerReference loggerReference = createLoggerReference(environment);

                            APPENDERS_BASIC_LIST.add(consoleAppenderGrayLog);
                            APPENDERS_LOGGER_REFERENCE.add(loggerReference);

                            switch (environment.getLoggerAccessName()){
                                case "GENERIC_LOGGER":
                                    setGenericLogger((ch.qos.logback.classic.Logger)LoggerFactory.getLogger("GENERIC_LOGGER"));
                                    break;
                            }
                            break;
                    }
                }
                //--> Creamos el elemento root
                RootAppenderRef rootAppenderRef = new RootAppenderRef("debug",APPENDERS_REF_ROOT);
                rootConfiguration.setBasicAppender(APPENDERS_BASIC_LIST);
                rootConfiguration.setBasicLoggerReference(APPENDERS_LOGGER_REFERENCE);
                rootConfiguration.setRoot(rootAppenderRef);
                //---> 2.- Creación del fichero
                String xmlElement = Adapter.POJOToXMLString(rootConfiguration);
                Document xmlClean = Adapter.convertStringToXMLDoc(cleanXMLString(xmlElement));
                Adapter.writeXMLFile(xmlClean,"src/main/resources/logback.xml");
                //---> Procedemos a la creación de los logger de código
                    /*skrLogger = new SkrLogger(
                    (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("AUDIT_BUSINESS_LOGGER"),
                    (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("ERROR_LOGGER"),,
                    (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("BATCH_LOGGER"));*/

                    /*skrLogger = new SkrLogger(
                            );*/

            } else {
                throw new RuntimeException("Error: lista de entorno vacía");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error al generar la instancia de loggeo");
        }
    }

    //--> Métodos de setter


    public static Logger getAuditBussinessLogger() {
        return AUDIT_BUSSINESS_LOGGER;
    }

    public static void setAuditBussinessLogger(Logger auditBussinessLogger) {
        AUDIT_BUSSINESS_LOGGER = auditBussinessLogger;
    }

    public static Logger getErrorLogger() {
        return ERROR_LOGGER;
    }

    public static void setErrorLogger(Logger errorLogger) {
        ERROR_LOGGER = errorLogger;
    }

    public static Logger getGenericLogger() {
        return GENERIC_LOGGER;
    }

    public static void setGenericLogger(Logger genericLogger) {
        GENERIC_LOGGER = genericLogger;
    }

    public static Logger getBatchLogger() {
        return BATCH_LOGGER;
    }

    public static void setBatchLogger(Logger batchLogger) {
        BATCH_LOGGER = batchLogger;
    }

    public static Logger getFileLogger() {
        return FILE_LOGGER;
    }

    public static void setFileLogger(Logger fileLogger) {
        FILE_LOGGER = fileLogger;
    }

    public static void logFile(String log){
        getFileLogger().info(log);
    }
    public static void logGenericLogger(String log){
        GENERIC_LOGGER.info(log);
    }

    //---> Método de envío de información
    //--> 1.- generic: info
    //--> 2.- batch: debug
    //--> 3.- audit: warn
    //--> 4.- error: error
    ///---> Separar LogTipoDeLogger()
    /*public static void logMessage(String level, String message){
        try {
            if(skrLogger != null) {
                switch (level) {
                    case "generic":
                        SkrLogger.skrLogger.getGENERIC_LOGGER().info(message);
                        break;
                    case "batch":
                        SkrLogger.skrLogger.getBATCH_LOGGER().debug(message);
                        break;
                    case "audit":
                        SkrLogger.skrLogger.getAUDIT_BUSSINESS_LOGGER().warn(message);
                        break;
                    case "error":
                        SkrLogger.skrLogger.getERROR_LOGGER().error(message);
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
    }*/

    /**
     * Método para la creación de appenders de tipo console.
     *
     * @param environment Objeto de Environment de la implementación de los loggeos
     * @return Appender
     */
    private static Appender createConsoleAppender(Environment environment){
        if((environment.getAppenderName() != null && !environment.getAppenderName().isEmpty()) &&
           (environment.getClassName() != null && !environment.getClassName().isEmpty()) &&
           (environment.getEncoderPattern() != null && !environment.getEncoderPattern().isEmpty())){
            return new Appender(environment.getAppenderName(), environment.getClassName(),environment.getEncoderPattern());
        } else {
            throw new RuntimeException("Error: Elementos necesarios para crear un appender de tipo consola faltantes o vacíos");
        }
    }

    /**
     * Método para la creación de los appenders necesarios para la cominicación con Graylog
     * @param environment Objeto de Environmente de la implementación de los loggeos
     * @return Appender
     */
    private static Appender createGraylogAppender(Environment environment){
        Appender appender = new Appender();
        appender.setName(environment.getAppenderName());
        appender.setClassName(environment.getClassName());
        appender.setGraylogHost(environment.getGraylogHost());
        appender.setGraylogPort(environment.getGraylogPort());
        appender.setConnectTimeout(environment.getConnectTimeout());
        appender.setSocketTimeout(environment.getSocketTimeout());
        appender.setReconnectInterval(environment.getReconnectInterval());
        appender.setMaxRetries(environment.getMaxRetries());
        appender.setRetryDelay(environment.getRetryDelay());
        appender.setPoolSize(environment.getPoolSize());
        appender.setPoolMaxWaitTime(environment.getPoolMaxWaitTime());
        appender.setPoolMaxIdleTime(environment.getPoolMaxIdleTime());
        Encoder encoder = new Encoder();
        encoder.setClassName(environment.getEncoderEnvironment().getClassName());
        encoder.setOriginHost(environment.getEncoderEnvironment().getOriginHost());
        encoder.setIncludeRawMessage(encoder.isIncludeRawMessage());
        encoder.setIncludeMarker(encoder.isIncludeMarker());
        encoder.setIncludeMdcData(encoder.isIncludeMdcData());
        encoder.setIncludeCallerData(encoder.isIncludeCallerData());
        encoder.setIncludeRootCauseData(encoder.isIncludeRootCauseData());
        encoder.setIncludeLevelName(encoder.isIncludeLevelName());
        encoder.setNumbersAsString(encoder.isNumbersAsString());
        List<String> stringList = new ArrayList<>();
        stringList.add("app_name:"+ environment.getAppName().trim());
        stringList.add("os_arch:${os.arch}");
        stringList.add("os_name:${os.name}");
        stringList.add("os_version:${os.version}");
        encoder.setStaticField(stringList);
        appender.setEncoder(encoder);
        return  appender;
    }

    /**
     * Método para la creación de los loggers de referencias
     * @param environment
     * @return
     */
    private static LoggerReference createLoggerReference(Environment environment){
        return new LoggerReference(environment.getLoggerAccessName(), environment.getLevelLogger(), new AppenderRef(environment.getAppenderName()));
    }
    /**
     * Método para la creación de un appender de tipo ref para el apartado de root
     *
     * @param environment Objeto de Environment de la implementación de los loggeos
     * @return AppenderRef
     */
    private static AppenderRef createRootAppender(Environment environment){
        if(environment.getAppenderName() != null && !environment.getAppenderName().isEmpty()){
            return new AppenderRef(environment.getAppenderName());
        } else {
            throw new RuntimeException("Error: Elemento nameAppender vació");
        }
    }
    private static String cleanXMLString(String xml){
        for (String pattern : patterns) {
            Matcher matcher = Pattern.compile(pattern).matcher(xml);
            xml = matcher.replaceAll("");
        }
        return xml;
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
