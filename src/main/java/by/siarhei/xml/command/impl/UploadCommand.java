package by.siarhei.xml.command.impl;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.service.ConfigurationManager;
import by.siarhei.xml.validator.TariffsXMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

public class UploadCommand implements ActionCommand {
    private static final Logger logger = LogManager.getLogger();

    private static final String PAGE = "path.page.upload";
    private static final String VALIDATION_ERROR_PAGE = "path.page.validationError";
    private static final String UPLOAD_PATH = "path.upload.uploadDir";
    private static final String TARIFFS_XSD = "tariffs.xsd";
    private static final String REQUEST_ATTRIBUTE_FILE = "file";
    private static final String REQUEST_ATTRIBUTE_FILE_NAME = "fileName";
    private static final String REQUEST_ATTRIBUTE_EXCEPTION = "exception";
    private static final char EXTENSION_SPLIT_CHAR = '.';

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String uploadDir = ConfigurationManager.getProperty(UPLOAD_PATH);
        String uploadFileDir = uploadDir + File.separator;
        TariffsXMLValidator validator = new TariffsXMLValidator();
        Part filePart = request.getPart(REQUEST_ATTRIBUTE_FILE);
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String currentPage;
        try {
            String randFilename = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf(EXTENSION_SPLIT_CHAR));
            String uploadedFilePath = uploadDir + File.separator + randFilename;
            filePart.write(uploadedFilePath);
            validator.validate(uploadedFilePath, uploadFileDir + TARIFFS_XSD);
            logger.info(String.format("File %s is valid and loaded on server with UUID: %s", fileName, randFilename));
            request.setAttribute(REQUEST_ATTRIBUTE_FILE, uploadedFilePath);
            request.setAttribute(REQUEST_ATTRIBUTE_FILE_NAME, fileName);
            currentPage = ConfigurationManager.getProperty(PAGE);
        } catch (IOException e) {
            logger.error(String.format("can't write file: %s throws exception: %s ", fileName, e.getMessage()));
            request.setAttribute(REQUEST_ATTRIBUTE_EXCEPTION, e);
            currentPage = ConfigurationManager.getProperty(VALIDATION_ERROR_PAGE);
        } catch (SAXException e) {
            logger.error(String.format("cant validate file: %s with message: %s ", fileName, e.getMessage()));
            request.setAttribute(REQUEST_ATTRIBUTE_EXCEPTION, e);
            currentPage = ConfigurationManager.getProperty(VALIDATION_ERROR_PAGE);
        }
        return currentPage;
    }
}
