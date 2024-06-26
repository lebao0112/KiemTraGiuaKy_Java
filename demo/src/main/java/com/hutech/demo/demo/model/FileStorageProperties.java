package com.hutech.demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FileStorageProperties {
    private String uploadDir;

}
