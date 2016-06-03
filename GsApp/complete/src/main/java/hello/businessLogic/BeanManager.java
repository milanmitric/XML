package hello.businessLogic;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.DocumentMetadataPatchBuilder;
import com.marklogic.client.document.XMLDocumentManager;
import hello.util.Converter;
import hello.util.Database;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by milan on 27.5.2016..
 * Class used for CRUD operations on bean classes.
 */
public class BeanManager <T>{


    /**
     * Default docId for CRUD operations.
     */
    private final String DOC_ID_DEFAULT = "default/document";

    /**
     * Default colId for CRUD operations.
     */
    private final String COL_ID_DEFAULT = "default/collection";

    /**
     * Database client to communicate with MarkLogic database.
     */
    private DatabaseClient client;
    /**
     * Manages CRUD operations on XML documents and JAXB beans..
     */
    private XMLDocumentManager xmlManager;

    /**
     * Schema factory for creating validation schemas.
     */
    private SchemaFactory schemaFactory;

    /**
     * Default schema located in <b>"./schema/Akt.xsd"</b>
     */
    private Schema schema;

    /**
     * Encapsulates all read-related operations.
     */
    private ReadManager<T> ReadManager;

    /**
     * Encapsulates all write-related operations.
     */
    private WriteManager<T> writeManager;

    /**
     * Support class for xml-bean conversion.
     */
    private Converter<T> converter;

    /**
     * Encapsulates all update, delete operations and all validations.
     */
    private CustomManager<T> customManager;
    /**
     * Initializes database client and XML manager.
     */
    public BeanManager() {
        try {
            client = Database.getDbClient();
            xmlManager = client.newXMLDocumentManager();
            schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema(new File("schema/Akt.xsd"));
            ReadManager = new ReadManager<T>(client,xmlManager,schemaFactory,schema);
            writeManager = new WriteManager<>(client,xmlManager,schemaFactory,schema);
            customManager = new CustomManager<>(client,xmlManager,schemaFactory,schema);
            converter = new Converter<>();
        } catch (Exception e){
            System.out.println("Can't initialize Bean manager.");
            e.printStackTrace();
        }
    }

    /**
     * Initializes database client and XML manager.
     * @param schemaFilePath Schema to validateBeanBySchema xmls from.
     */
    public BeanManager(String schemaFilePath) {
        try {
            client = Database.getDbClient();
            xmlManager = client.newXMLDocumentManager();
            schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema(new File(schemaFilePath));
            ReadManager = new ReadManager<T>(client,xmlManager,schemaFactory,schema);
            writeManager = new WriteManager<>(client,xmlManager,schemaFactory,schema);
            customManager = new CustomManager<>(client,xmlManager,schemaFactory,schema);
            converter = new Converter<>();
        } catch (Exception e){
            System.out.println("Can't initialize Bean manager.");
        }
    }

    /**
     * Writes file to database.
     * @param inputStream File to be written.
     * @param docId URI for document to be written.
     * @param colId URI for collection if the docue.
     * @return Indicator of success.
     */
    public boolean write(FileInputStream inputStream, String docId, String colId) {
        return  writeManager.write(inputStream,docId,colId);
    }


    /**
     * Writes bean to database.
     * @param bean JAXB bean to be written.
     * @param docId URI for document to be written.
     * @param colId URI for collection if the docue.
     * @return Indicator of success.
     */
    public boolean write(T bean, String docId, String colId) {
        return writeManager.write(bean,docId,colId);
    }

    /**
     * Read a xml document from database for given docId. Assignes it to bean field.
     * @param docId Document URI to read from database.
     * @return Read bean, <code>null</code> if not successful.
     */
    public T read(String docId){
        return ReadManager.read(docId);
    }

    /**
     * Coverts given File to JAXB bean.
     * @param file File to be written.
     * @return Converted bean,<code>null</code> if not not successful.
     */
    public T convertFromXml(File file){
        return converter.convertFromXml(file,schema);
    }

    /**
     * Converts JAXB bean to XML file on tmp location.
     * @return Indicator of success.
     */
    public boolean convertToXml(T  bean){
       return converter.convertToXml(bean);
    }

    /**
     * Deletes a document from given URI.
     * @param docId URI of document to be deleted.
     * @return Indicator of success.
     */
    public boolean deleteDocument(String docId){
        return  customManager.deleteDocument(docId);
    }

    /**
     * Updates document from given URI and patchHandle
     * @param docId URI of document to be deleted.
     * @param patchHandle Contains updates on document using XPath, positions to be inserted and patches as Strings.
     * @return Indicator of success.
     */
    public boolean updateDocument(String docId, DocumentMetadataPatchBuilder.PatchHandle patchHandle){
       return customManager.updateDocument(docId,patchHandle);
    }

    /**
     * Validates JAXB bean by <code>schema</code> field of class.
     * @param akt Bean to be validated
     * @return Indicator of success.
     */
    public boolean validateBeanBySchema(T bean){
        return customManager.validateBeanBySchema(bean);
    }

    /**
     * Validates xml documnt by <code>schema</code> field of class.
     * @param filePath Path of file to be validated.
     * @return Indicator of success.
     */
    public boolean validateXmlBySchema(String filePath){
        return customManager.validateXmlBySchema(filePath);
    }

    /**
     * Validates signed xml document from <b>tmp.xml</b>.
     * @param filepath Path of xml file to be validated.s
     * @return Indicator of success.
     */
    public boolean validateXMLBySignature(String filepath){
        return ReadManager.validateXMLBySignature(filepath);
    }








}