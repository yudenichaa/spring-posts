package nightzen.posts;

import nightzen.posts.configuration.CustomPropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostsApplication.class, args);
    }

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        PropertyEditorRegistrar[] registrars = {new CustomPropertyEditorRegistrar()};
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setPropertyEditorRegistrars(registrars);
        return configurer;
    }
}
