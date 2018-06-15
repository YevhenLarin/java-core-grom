package lesson34.homework.standartCopyMethods;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception{
        validate(fileFromPath, fileToPath);
        Files.copy(new File(fileFromPath).toPath(), new File(fileToPath).toPath());
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception{
        validate(fileFromPath, fileToPath);
        FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
//            throw new FileNotFoundException("File " + fileFrom + " does not exist");
            System.err.println("File " + fileFrom + " does not exist");
            System.exit(0);
        }

        if (!fileTo.exists()) {
//            throw new FileNotFoundException("File " + fileTo + " does not exist");
            System.err.println("File " + fileTo + " does not exist");
            System.exit(0);
        }

        if (!fileFrom.canRead() || !fileTo.canWrite()) {
            throw new Exception("File does not have permissions");
        }
    }


}
