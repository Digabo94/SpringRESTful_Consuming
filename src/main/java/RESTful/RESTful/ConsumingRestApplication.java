package RESTful.RESTful;

//Las siguientes dos importaciones son para enviar una respuesta a la consola por la respuesta del RESTful
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Un CommandLineRunner que ejecuta RestTemplate (y, en consecuencia, obtiene nuestro quote) al inicio.
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

//Esta importacion usa la libreria Jackson JSON para procesar la informacion entrante
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }

}
