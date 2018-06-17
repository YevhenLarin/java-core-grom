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

    private static StringBuffer readFromFile(String path) throws IOException{
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append("\r\n");
                res.append(line);
            }
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " failed");
        }
        return res;
    }


    private static void writeToFile(String path, StringBuffer contentToWrite) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file");
        }
    }


    private static void delContentFromFile(String path) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append("");
        } catch (IOException e) {
            throw new IOException("Can't write to file");
        }
    }


    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead() || !fileFrom.canWrite() || !fileTo.canWrite()) {
            throw new Exception("File does not have permissions");
        }
    }
}
