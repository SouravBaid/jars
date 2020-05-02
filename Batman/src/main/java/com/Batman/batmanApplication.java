package com.Batman;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.Batman.resources.batmanResource;

import ch.qos.logback.access.joran.JoranConfigurator;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class batmanApplication extends Application<batmanConfiguration> {

    public static void main(final String[] args) throws Exception {
        new batmanApplication().run(args);
    }

    @Override
    public String getName() {
        return "batman";
    }

    @Override
    public void initialize(final Bootstrap<batmanConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final batmanConfiguration configuration,
                    final Environment environment) throws JoranException {
        // TODO: implement application
    	LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		context.reset();
		ContextInitializer initializer = new ContextInitializer(context);

		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			configurator.doConfigure(new InputSource("logback.xml"));
			initializer.autoConfig();
			context.start();
			System.out.println("\n ******* Logger/Logback started *********** \n");
		} catch (JoranException e) {
			e.printStackTrace();
			System.out.println("\n ******* Logger/Logback FAILED TO START  *********** \n");
			throw e;
		}

		Logger logger = (Logger) LoggerFactory.getLogger("logger");
		logger.info("------logging LOGGERrr---------");


		//jokerservice compservice = new jokerservice();
		batmanResource compresource = new batmanResource();
		environment.jersey().register(compresource);

    }

}
