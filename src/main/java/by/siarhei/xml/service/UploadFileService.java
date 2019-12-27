package by.siarhei.xml.service;

import by.siarhei.xml.manager.ConfigurationManager;
import by.siarhei.xml.validator.TariffsXMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadFileService {
    private static final Logger logger = LogManager.getLogger();

    private static final String UPLOAD_PATH = "path.upload.uploadDir";
    private static final char EXTENSION_SPLIT_CHAR = '.';
    private static final String TARIFFS_XSD = "tariffs.xsd";

    public String upload(Part filePart, String fileName) throws IOException, SAXException {
        TariffsXMLValidator validator = new TariffsXMLValidator();
        String uploadDir = ConfigurationManager.getProperty(UPLOAD_PATH);
        String uploadFileDir = uploadDir + File.separator;
        String randFilename = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf(EXTENSION_SPLIT_CHAR));
        String uploadedFilePath = uploadDir + File.separator + randFilename;
        filePart.write(uploadedFilePath);
        validator.validate(uploadedFilePath, uploadFileDir + TARIFFS_XSD);
        logger.info(String.format("File %s is valid and loaded on server with UUID: %s", fileName, randFilename));
        return uploadedFilePath;
    }
}
