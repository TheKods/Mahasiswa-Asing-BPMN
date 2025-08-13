package io.university.gunadarma.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Pendaftaran Mahasiswa Asing API",
        version = "1.0.0",
        description = "API untuk Sistem Pendaftaran Mahasiswa Asing Universitas Gunadarma",
        contact = @Contact(
            name = "Tim Pengembang",
            email = "rafihermawan06@gmail.com",
            url = "https://github.com/TheKods/Mahasiswa-Asing-BPMN"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Lokal Server"),
        @Server(url = "https://mahasiswa-asing.gunadarma.ac.id", description = "Produksi Server")
    }
)
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("mahasiswa-asing")
            .pathsToMatch("/api/**")
            .build();
    }
} 