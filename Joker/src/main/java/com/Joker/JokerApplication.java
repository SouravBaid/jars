package com.Joker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.Joker.resources.jokerResource;
import com.codahale.metrics.MetricRegistry;


import ch.qos.logback.access.joran.JoranConfigurator;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class JokerApplication extends Application<JokerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new JokerApplication().run(args);
    }

    @Override
    public String getName() {
        return "JOKER";
    }

    @Override
    public void initialize(final Bootstrap<JokerConfiguration> bootstrap) {
        // TODO: application initialization
    	
    }

    @Override
    public void run(final JokerConfiguration configuration,
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
		jokerResource compresource = new jokerResource();
		environment.jersey().register(compresource);

    }
}
