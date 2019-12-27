package by.siarhei.xml.command.impl;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.manager.ConfigurationManager;
import by.siarhei.xml.manager.MessageManager;
import by.siarhei.xml.service.UploadFileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;

public class UploadCommand implements ActionCommand {
    private static final Logger logger = LogManager.getLogger();

    private static final String PAGE = "path.page.upload";
    private static final String ERROR_PAGE = "path.page.error";
    private static final String MESSAGE_FILE_NOT_VALID = "message.file.notvalid";
    private static final String MESSAGE_FILE_UPLOAD_ERROR = "message.file.cantupload";
    private static final String REQUEST_ATTRIBUTE_FILE = "file";
    private static final String REQUEST_ATTRIBUTE_FILE_NAME = "fileName";
    private static final String REQUEST_ATTRIBUTE_EXCEPTION = "exception";
    private static final String REQUEST_ATTRIBUTE_ERROR_MESSAGE = "errorMessage";

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        UploadFileService uploadService = new UploadFileService();
        Part filePart = request.getPart(REQUEST_ATTRIBUTE_FILE);
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String currentPage;
        try {
            String uploadedFilePath = uploadService.upload(filePart, fileName);
            request.setAttribute(REQUEST_ATTRIBUTE_FILE, uploadedFilePath);
            request.setAttribute(REQUEST_ATTRIBUTE_FILE_NAME, fileName);
            currentPage = ConfigurationManager.getProperty(PAGE);
        } catch (IOException e) {
            logger.error(String.format("can't write file: %s throws exception: %s ", fileName, e.getMessage()));
            request.setAttribute(REQUEST_ATTRIBUTE_ERROR_MESSAGE, MessageManager.getProperty(MESSAGE_FILE_UPLOAD_ERROR));
            request.setAttribute(REQUEST_ATTRIBUTE_EXCEPTION, e);
            currentPage = ConfigurationManager.getProperty(ERROR_PAGE);
        } catch (SAXException e) {
            logger.error(String.format("cant validate file: %s with message: %s ", fileName, e.getMessage()));
            request.setAttribute(REQUEST_ATTRIBUTE_ERROR_MESSAGE, MessageManager.getProperty(MESSAGE_FILE_NOT_VALID));
            request.setAttribute(REQUEST_ATTRIBUTE_EXCEPTION, e);
            currentPage = ConfigurationManager.getProperty(ERROR_PAGE);
        }
        return currentPage;
    }
}
