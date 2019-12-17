package by.siarhei.xml.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = {"/upload/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadingServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "C:\\temp";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String uploadFileDir = File.separator + UPLOAD_DIR + File.separator;
        File fileSaveDir = new File(uploadFileDir);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
            System.out.println("Output directory was created");
        }
        request.getParts().stream().forEach(part -> {
            try {
                part.write(UPLOAD_DIR + File.separator + part.getSubmittedFileName());
                request.setAttribute("upload_result", " upload successfully ");
            } catch (IOException e) {
                request.setAttribute("upload_result", " upload failed ");
            }
        });
        request.getRequestDispatcher("upload_res.jsp").forward(request, response);
    }
}