package nrlssc.demo;

import nrlssc.demo.config.DemoConfig;
import nrlssc.demo.servlets.HelloHttpService;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class DemoServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DemoServlet.class);
    private transient VelocityEngine velocityEngine;


    private transient String message;
    private transient DemoConfig demoConfig;


    public DemoServlet() {
        super();
    }

    HelloHttpService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.setProperty( "runtime.log.logsystem.log4j.logger", "root" );
        velocityEngine.setProperty(RuntimeConstants.VM_LIBRARY, "nrlssc/demo/templates/macro_library.html");
        velocityEngine.init();


        message = config.getInitParameter("message");
        service = new HelloHttpService("hello", message);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        service.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.doPost(req, resp);
    }

}
