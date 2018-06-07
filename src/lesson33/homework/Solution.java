package lesson33.homework;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    public static void writeToFileFromConsole(String path) throws Exception {
        File file = new File(path);
        if (!file.exists())
            throw new FileNotFoundException("File with path " + path + " not found");

        System.out.println("Enter file content to write in the file:");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        FileWriter writer = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        try {
            String line;
            while (!(line = bufferedReader.readLine()).equals("wr")) {
                bufferedWriter.append("\n");
                bufferedWriter.append(line);
            }
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(bufferedReader);
        }
    }

    public static void readFileByConsolePath() throws Exception {
        System.out.println("Please, enter file path to read:");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String path = br.readLine();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            readFile(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
//            return;
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(fileReader);
        }
    }

    private static void readFile(String path) throws FileNotFoundException {

        FileReader fileReader = new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(fileReader);
        }
    }
}

