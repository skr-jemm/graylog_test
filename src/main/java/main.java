import Entity.Request.EncoderEnvironment;
import Entity.Request.Environment;
import Entity.Request.PatternLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-05-08
 * Description:
 * Last change:
 * Version:
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        List<Environment> environments = new ArrayList<>();

        Environment environment = new Environment();
        environment.setAppenderName("console");
        environment.setClassName("ch.qos.logback.core.ConsoleAppender");
        environment.setTypeAppender("console");
        environment.setEncoderPattern("%d{HH:mm:ss.SSS} %-5level %logger{36} - %msg%n");
        environments.add(environment);
        //--------------------------------------------->
        Environment environment2 = new Environment();
        environment2.setTypeAppender("graylog");
        environment2.setAppName("MAIN TEST");
        environment2.setAppenderName("GENERIC_LOGGER_LGB");
        environment2.setLoggerAccessName("GENERIC_LOGGER");
        environment2.setLevelLogger("INFO");
        environment2.setClassName("de.siegmar.logbackgelf.GelfTcpAppender");
        environment2.setGraylogHost("54.187.63.254");
        environment2.setGraylogPort("12302");
        environment2.setConnectTimeout("15000");
        environment2.setSocketTimeout("5000");
        environment2.setReconnectInterval("300");
        environment2.setMaxRetries("2");
        environment2.setRetryDelay("3000");
        environment2.setPoolSize("2");
        environment2.setPoolMaxWaitTime("5000");
        environment2.setPoolMaxIdleTime("10");
        EncoderEnvironment encoderEnvironment = new EncoderEnvironment();
        encoderEnvironment.setOriginHost("https://www.pruebajemm.com");
        encoderEnvironment.setIncludeRawMessage(false);
        encoderEnvironment.setIncludeMarker(false);
        encoderEnvironment.setIncludeMdcData(false);
        encoderEnvironment.setIncludeCallerData(false);
        encoderEnvironment.setIncludeRootCauseData(false);
        encoderEnvironment.setIncludeLevelName(false);
        encoderEnvironment.setNumberAsString(false);
        List<PatternLayout> patternLayouts = new ArrayList<>();
        patternLayouts.add(new PatternLayout("ch.qos.logback.classic.PatternLayout","%m%nopex"));
        patternLayouts.add(new PatternLayout("ch.qos.logback.classic.PatternLayout","%m%n"));
        encoderEnvironment.setPatternLayout(patternLayouts);
        environment2.setEncoderEnvironment(encoderEnvironment);
        environments.add(environment2);

        SkrLogger.createInstance(environments);
        Thread.sleep(1800);

        SkrLogger.logFile("loggeo test post compilación 1");
        SkrLogger.logFile("loggeo test post compilación 2");
        SkrLogger.logGenericLogger("Loggeo desde testes de la información!!!!---&&");

        //Throwable error = new Throwable("Error de prueba");

        //SkrLogger.logMessage("generic","Prueba de loggeo de tipo INFO en el puerto: {12302} INFO_!");
        //SkrLogger.logMessage("batch","Prueba de loggeo de tipo DEBUG en el puerto: {12303} INFO_Y");
        //Environment.logMessage("batcho","Prueba de loggeo de tipo DEBUG en el puerto: {12303}C");
        //SkrLogger.logMessage("audit","Prueba de loggeo de tipo WARN en el puerto: {12304} INFO_J");
        //SkrLogger.logMessage("error","Prueba de loggeo de tipo ERROR en el puerto: {12305} INFO_R");

        //JsonObject jsonObject = new JsonObject("{\"title\":\"Mi tituo\",\"body\":{\"id\":7890,\"description\":\"Mi componente :)\",\"sectores\":[{\"sector\":\"1\"},{\"sector\":\"2\"},{\"sector\":\"3\"}],\"cat\":{\"c0\":{\"message\":\"1\"},\"c1\":{\"message\":\"1\"},\"c2\":{\"message\":\"1\"}}}}");
        //SkrLogger.logMessage("generic",jsonObject.encodePrettily());;
        //jsonObject.remove("title");
        //SkrLogger.logMessage("generic", jsonObject.encodePrettily());
        //jsonObject.getJsonObject("body").getJsonObject("cat").remove("c0");
        //SkrLogger.logMessage("generic",jsonObject.encodePrettily());
        //Integer e = null;
        //int position; //--> se declara afuera de for para que el compilador no lo declare en cada interación
        //for(position = 0; position <= jsonObject.getJsonObject("body").getJsonArray("sectores").size()-1 ;position++){
        //    JsonObject aux = jsonObject.getJsonObject("body").getJsonArray("sectores").getJsonObject(position);
        //    if(aux.getString("sector").equals("1")){
        //        jsonObject.getJsonObject("body").getJsonArray("sectores").remove(position);
        //    }
        //}

        /*for(Object element: jsonObject.getJsonObject("body").getJsonArray("sectores")){
            JsonObject aux = (JsonObject) element;
            if(aux.getString("sector").equals("1")){
                elementDelete = aux;
            }
        }
        */

        //SkrLogger.logMessage("generic",jsonObject.encodePrettily());

    }
}
