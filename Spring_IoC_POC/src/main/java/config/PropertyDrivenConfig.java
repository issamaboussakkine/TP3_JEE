package config;

import dao.IDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import java.util.Map;

@Configuration
@PropertySource("classpath:app.properties")
public class PropertyDrivenConfig {

    private final Map<String, IDao> candidates;

    public PropertyDrivenConfig(Map<String, IDao> candidates) {
        this.candidates = candidates;
        System.out.println("=== DAO disponibles ===");
        candidates.forEach((key, value) ->
                System.out.println(key + " = " + value.getValue()));
    }

    @Value("${dao.target:dao}")
    private String target;

    @Bean(name = "selectedDao")
    public IDao selectedDao() {
        System.out.println("Target demandé = " + target);
        IDao bean = candidates.get(target);
        if (bean == null) {
            throw new IllegalArgumentException(
                    "Implémentation inconnue: " + target +
                            " (dao | dao2 | daoFile | daoApi)");
        }
        System.out.println("Bean sélectionné: " + target +
                " → valeur = " + bean.getValue());
        return bean;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}