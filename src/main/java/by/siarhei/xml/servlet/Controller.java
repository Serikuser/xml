package by.siarhei.xml.servlet;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.factory.ActionFactory;
import by.siarhei.xml.service.ConfigurationManager;
import by.siarhei.xml.service.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
@MultipartConfig()
public class Controller extends HttpServlet {

    public static final String MAIN_PAGE = "path.path.index";
    public static final String NULL_PAGE = "nullPage";
    public static final String MESSAGE_NULLPAGE = "message.nullpage";

    @Override
    protected void doPost(HttpServletRequest request
            , HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request
            , HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
        String page;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty(MAIN_PAGE);
            request.getSession().setAttribute(NULL_PAGE
                    , MessageManager.getProperty(MESSAGE_NULLPAGE));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}