package net.ryzech.cosmicshaders.utils;

import finalforeach.cosmicreach.io.SaveLocation;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ShaderFileList {

    public static List<String> getShaderFiles() {
        File dir = new File(SaveLocation.getSaveFolderLocation() + "/mods/shaders");
        return Arrays.asList(dir.list());
    }

}
