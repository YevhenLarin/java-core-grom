package lesson34.homework.transferSentences;

import java.io.*;

public class Solution {

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        StringBuffer backupFromContent = readFromFile(fileFromPath);
        StringBuffer backupToContent = readFromFile(fileToPath);

        StringBuffer fileFromContent = new StringBuffer();
        StringBuffer fileToContent = new StringBuffer();

        String[] sentences = readFromFile(fileFromPath).toString().split("\\.");

        for (String sentence : sentences) {
            if (validateSentence(sentence, word))
                fileToContent.append(sentence).append(".");
            else
                fileFromContent.append(sentence).append(".");
        }

        try {
            writeToFile(fileToPath, fileToContent);
            writeToFile(fileFromPath, fileFromContent);
        } catch (Exception e) {
            writeToFile(fileToPath, backupToContent);
            writeToFile(fileFromPath, backupFromContent);
            System.err.println("Writing of file was incorrect");
        }
    }


    private static StringBuffer readFromFile(String path) throws IOException {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " was failed");

        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
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


    private static boolean validateSentence(String sentence, String word) {
        String[] words = sentence.trim().split(" ");

        if (words.length <= 10)
            return false;

        for (String str : words) {
            if (str != null && str.equals(word))
                return true;
        }
        return false;
    }
}
