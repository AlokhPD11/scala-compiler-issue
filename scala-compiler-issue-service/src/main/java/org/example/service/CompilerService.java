package org.example.service;

import org.example.util.CompilerUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CompilerService {

    @PostConstruct
    private void init() {
        CompilerUtil.compileAndLoadFiles(List.of(""));
    }
}
