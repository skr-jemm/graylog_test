package Entity.Adapters;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author: Jorge E. Mohedano
 * Date: 2023-06-12
 * Description:
 * Last change:
 * Version:
 */
public class Adapter {
    /***
     * Convertir de Objeto POJO a un XMLString (Utilizando las anotaciones de XML de la libreria
     * @param pojo
     * @return String El resultado de la conversión
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/annotation/package-summary.html"/> Documentación de anotaciones XML</a>
     */
    public static String POJOToXMLString(Object pojo) {
        String retorno;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(pojo.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(pojo, stringWriter);
            retorno = stringWriter.toString();
            return retorno;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Método para la creación del archivo XML
     *
     * @param document Objeto XML
     * @param fileDirect Dirección de la creación
     */
    public static void writeXMLFile(Document document, String fileDirect){
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            FileOutputStream outStream = new FileOutputStream(new File(fileDirect));
            transformer.transform(new DOMSource(document), new StreamResult(outStream));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para construir un Documento de un XML
     *
     * @param xmlString Cadena de String
     * @return Document
     */
    public static Document convertStringToXMLDoc(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
