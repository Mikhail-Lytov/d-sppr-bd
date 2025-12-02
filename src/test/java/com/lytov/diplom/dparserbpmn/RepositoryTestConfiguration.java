package com.lytov.diplom.dparserbpmn;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

@SpringBootConfiguration
@EnableAutoConfiguration
public class RepositoryTestConfiguration {

    @Bean(initMethod = "start")
    public PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:14.2-alpine"));
    }

    @Bean
    public DataSource dataSource() {
        final PostgreSQLContainer<?> postgresContainer = postgresContainer();

        final HikariConfig config = new HikariConfig();
        config.setDriverClassName(postgresContainer.getDriverClassName());
        config.setJdbcUrl(postgresContainer.getJdbcUrl());
        config.setUsername(postgresContainer.getUsername());
        config.setPassword(postgresContainer.getPassword());

        return new HikariDataSource(config);
    }
}
