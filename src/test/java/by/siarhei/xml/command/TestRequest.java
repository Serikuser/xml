package by.siarhei.xml.command;

import org.mockito.Mockito;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class TestRequest implements HttpServletRequest {

    @Override
    public String getAuthType() {
        return Mockito.mock(String.class);
    }

    @Override
    public Cookie[] getCookies() {
        return Mockito.mock(Cookie[].class);
    }

    @Override
    public long getDateHeader(String s) {
        return Mockito.mock(long.class);
    }

    @Override
    public String getHeader(String s) {
        return Mockito.mock(String.class);
    }

    @Override
    public Enumeration<String> getHeaders(String s) {
        return Mockito.mock(Enumeration.class);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return Mockito.mock(Enumeration.class);
    }

    @Override
    public int getIntHeader(String s) {
        return Mockito.mock(int.class);
    }

    @Override
    public String getMethod() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getPathInfo() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getPathTranslated() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getContextPath() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getQueryString() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getRemoteUser() {
        return Mockito.mock(String.class);
    }

    @Override
    public boolean isUserInRole(String s) {
        return Mockito.mock(boolean.class);
    }

    @Override
    public Principal getUserPrincipal() {
        return Mockito.mock(Principal.class);
    }

    @Override
    public String getRequestedSessionId() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getRequestURI() {
        return Mockito.mock(String.class);
    }

    @Override
    public StringBuffer getRequestURL() {
        return Mockito.mock(StringBuffer.class);
    }

    @Override
    public String getServletPath() {
        return Mockito.mock(String.class);
    }

    @Override
    public HttpSession getSession(boolean b) {
        return Mockito.mock(HttpSession.class);
    }

    @Override
    public HttpSession getSession() {
        return Mockito.mock(HttpSession.class);
    }

    @Override
    public String changeSessionId() {
        return Mockito.mock(String.class);
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return Mockito.mock(boolean.class);
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return Mockito.mock(boolean.class);
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return Mockito.mock(boolean.class);
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return Mockito.mock(boolean.class);
    }

    @Override
    public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
        return Mockito.mock(boolean.class);
    }

    @Override
    public void login(String s, String s1) throws ServletException {

    }

    @Override
    public void logout() throws ServletException {

    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return null;
    }

    @Override
    public Part getPart(String s) throws IOException, ServletException {
        return Mockito.mock(Part.class);
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return Mockito.mock(Object.class);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return Mockito.mock(Enumeration.class);
    }

    @Override
    public String getCharacterEncoding() {
        return Mockito.mock(String.class);
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }

    @Override
    public int getContentLength() {
        return Mockito.mock(int.class);
    }

    @Override
    public long getContentLengthLong() {
        return Mockito.mock(long.class);
    }

    @Override
    public String getContentType() {
        return Mockito.mock(String.class);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return Mockito.mock(ServletInputStream.class);
    }

    @Override
    public String getParameter(String s) {
        return "dom";
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Mockito.mock(Enumeration.class);
    }

    @Override
    public String[] getParameterValues(String s) {
        return Mockito.mock(String[].class);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return Mockito.mock(Map.class);
    }

    @Override
    public String getProtocol() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getScheme() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getServerName() {
        return Mockito.mock(String.class);
    }

    @Override
    public int getServerPort() {
        return Mockito.mock(int.class);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return Mockito.mock(BufferedReader.class);
    }

    @Override
    public String getRemoteAddr() {
        return Mockito.mock(String.class);
    }

    @Override
    public String getRemoteHost() {
        return Mockito.mock(String.class);

    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public Locale getLocale() {
        return Mockito.mock(Locale.class);

    }

    @Override
    public Enumeration<Locale> getLocales() {
        return Mockito.mock(Enumeration.class);

    }

    @Override
    public boolean isSecure() {
        return Mockito.mock(boolean.class);

    }

    @Override
    public RequestDispatcher getRequestDispatcher(String s) {
        return Mockito.mock(RequestDispatcher.class);

    }

    @Override
    public String getRealPath(String s) {
        return Mockito.mock(String.class);

    }

    @Override
    public int getRemotePort() {
        return Mockito.mock(int.class);

    }

    @Override
    public String getLocalName() {
        return Mockito.mock(String.class);

    }

    @Override
    public String getLocalAddr() {
        return Mockito.mock(String.class);

    }

    @Override
    public int getLocalPort() {
        return Mockito.mock(int.class);

    }

    @Override
    public ServletContext getServletContext() {
        return Mockito.mock(ServletContext.class);

    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return Mockito.mock(AsyncContext.class);


    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return Mockito.mock(AsyncContext.class);

    }

    @Override
    public boolean isAsyncStarted() {
        return Mockito.mock(boolean.class);

    }

    @Override
    public boolean isAsyncSupported() {
        return Mockito.mock(boolean.class);

    }

    @Override
    public AsyncContext getAsyncContext() {
        return Mockito.mock(AsyncContext.class);

    }

    @Override
    public DispatcherType getDispatcherType() {
        return Mockito.mock(DispatcherType.class);

    }
}
