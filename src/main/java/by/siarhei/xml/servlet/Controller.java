package by.siarhei.xml.servlet;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.service.CommandProvider;

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
        ActionCommand command = CommandProvider.defineCommand(request);
        page = command.execute(request);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}