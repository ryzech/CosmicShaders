package net.ryzech.cosmicshaders;

import finalforeach.cosmicreach.io.SaveLocation;
import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CosmicShaders implements ModInitializer {
    public static final String MOD_ID = "cosmicshaders";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Cosmic Shaders Initialized");

        // make sure shader folder exists
        File shaderDir = new File(SaveLocation.getSaveFolderLocation() + "/shaders");
        if(shaderDir.exists()) {
            LOGGER.info("Shader Folder Found!");
            try {
                List<File> files = Files.list(Path.of(shaderDir.toURI()))
                        .map(Path::toFile)
                        .filter(File::isFile)
                        .collect(Collectors.toList());

                files.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            LOGGER.warning("Shader Folder Doesn't Exist. Creating now...");
            try {
                Files.createDirectory(Path.of(shaderDir.toURI()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            LOGGER.info("Successfully Created Shader Folder!");
        }
    }
}