package com.mycompany.demo;

import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.repositories.ProductRepository;
import com.mycompany.demo.repositories.UserRepository;
import com.mycompany.demo.view.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
public class EcommerceT1LpApplication {

    public static MainFrame mainFrame;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EcommerceT1LpApplication.class)
                .headless(false) // Permite que o Spring gerencie componentes gráficos
                .run(args);

        // Obtem a instância de MainFrame do contexto do Spring
        mainFrame = context.getBean(MainFrame.class);

        // Exibe a janela principal
        mainFrame.starting();

    }

}
