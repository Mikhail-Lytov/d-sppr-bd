package com.lytov.diplom.dspprbd.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

import java.net.URI;


@Configuration
@Profile("!test")
public class S3Config {

    @Value("${s3.aws.access-key}")
    private String accessKey;

    @Value("${s3.aws.secret-key}")
    private String secretKey;

    @Value("${s3.aws.region}")
    private String region;

    @Value("${s3.aws.endpoint:}")
    private String endpoint;

    @Value("${s3.aws.path-style-access:false}")
    private boolean pathStyle;

    @Bean
    public S3Configuration s3Configuration() {
        return S3Configuration.builder()
            .pathStyleAccessEnabled(pathStyle)
            .build();
    }

    @Bean
    public S3Client s3Client(S3Configuration s3Config) {
        var creds = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));

        return S3Client.builder()
            .credentialsProvider(creds)
            .region(Region.of(region))
            .serviceConfiguration(s3Config)
            .httpClient(UrlConnectionHttpClient.builder().build())
            .endpointOverride(URI.create(endpoint))
            .build();
    }

    @Bean
    public S3Presigner s3Presigner(S3Configuration s3Config) {
        var creds = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));

        S3Presigner.Builder builder = S3Presigner.builder()
            .region(Region.of(region))
            .credentialsProvider(creds)
            .serviceConfiguration(s3Config);

        if (endpoint != null && !endpoint.isBlank()) {
            builder.endpointOverride(URI.create(endpoint));
        }

        return builder.build();
    }
}
