package me.question.ui.manager;

import me.question.ui.util.NumberConversions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ConfigManager {
    private final ClassLoader classLoader = ConfigManager.class.getClassLoader();

    public File getFile() {
        return new File("src/main/resources/config.yml");
    }

    protected final ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public InputStream getResource(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        } else {
            try {
                URL url = this.getClassLoader().getResource(filename);
                if (url == null) {
                    return null;
                } else {
                    URLConnection connection = url.openConnection();
                    connection.setUseCaches(false);
                    return connection.getInputStream();
                }
            } catch (IOException var4) {
                return null;
            }
        }
    }
}
