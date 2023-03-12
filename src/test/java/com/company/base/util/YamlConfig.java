package com.company.base.util;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class YamlConfig {

    public static String read(String configName) {
        Yaml yaml = new Yaml();
        Map<String, Object> ymlConfig = null;

        //Retorna ambiente enviado por VM Arg
        String environment=System.getProperty("environment");
        try {
            ymlConfig = (Map<String, Object>) yaml.load(new FileInputStream(new File(
                    "./src/test/resources/dominio/application-"+environment+".yml")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> configPath = Arrays.asList(configName.split("\\."));
        Object config = ymlConfig.get(configPath.get(0));
        for (int i = 1; i < configPath.size(); i++) {
            config = ((Map<String, Object>) config).get(configPath.get(i));
        }
        if (Objects.isNull(config)) config = "";
        return String.valueOf(config);
    }
}
