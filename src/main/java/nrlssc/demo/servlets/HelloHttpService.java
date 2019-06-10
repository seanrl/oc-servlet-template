package nrlssc.demo.servlets;

import com.google.common.net.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloHttpService extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(HelloHttpService.class);

    private String serviceName;
    private String message;

    public HelloHttpService(String serviceName, String message)
    {

        this.serviceName = serviceName;
        this.message = message;
    }



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        logger.debug("made request to DemoServlet");
        logger.debug("path: " + req.getContextPath());
        logger.debug("query: " + req.getQueryString());

        resp.setContentType(MediaType.HTML_UTF_8.toString());
        String templateName = "nrlssc/demo/templates/hello.html";

        Map<String, Object> contextMap = new HashMap<>();
        contextMap.put("message", message);
        try {
            resp.getWriter().write(message);
        } catch (IOException e) {
            logger.error("Error: ", e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}

