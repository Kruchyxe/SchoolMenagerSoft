package pl.coderslab.schoolmenagersoft;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pl.coderslab.schoolmenagersoft.SchoolMenagerSoftApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SchoolMenagerSoftApplication.class);
    }

}
