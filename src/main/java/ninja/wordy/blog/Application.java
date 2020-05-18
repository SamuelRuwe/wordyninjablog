package ninja.wordy.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.context.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.web.context.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }

///* TODO: uncomment to disable httponly cookies */
//    @Override
//    public void customize(final ConfigurableEmbeddedServletContainer container) {
//        ((TomcatEmbeddedServletContainerFactory) container).addContextCustomizers(new TomcatContextCustomizer() {
//            @Override
//            public void customize(Context context) {
//                context.setUseHttpOnly(false);
//            }
//        });
//    }

//}