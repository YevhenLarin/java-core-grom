package lesson34.homework.transferFileContent;

import java.io.*;

public class Solution {

    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);

        StringBuffer backupFromContent = readFromFile(fileFromPath);
        StringBuffer backupToContent = readFromFile(fileToPath);

        try {
            writeToFile(fileToPath, readFromFile(fileFromPath));
            delContentFromFile(fileFromPath);
        }catch (Exception e){
            writeToFile(fileToPath, backupToContent);
            writeToFile(fileFromPath, backupFromContent);
            System.err.println("Writing of file was incorrect");
        }
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append("\r\n");
                res.append(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
            System.exit(0);
        }
        return res;
    }


    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }


    private static void delContentFromFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append("");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
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

        if (!fileFrom.canRead() || !fileFrom.canWrite() || !fileTo.canWrite()) {
            throw new Exception("File does not have permissions");
        }
    }
}
