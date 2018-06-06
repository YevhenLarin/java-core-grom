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
        BufferedReader br = new BufferedReader(reader);
        FileWriter wr = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(wr);

        try {
            String line;
            while (!(line = br.readLine()).equals("wr")) {
                bw.append("\n");
                bw.append(line);
            }
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(bw);
            IOUtils.closeQuietly(wr);
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

    public static void readFileByConsolePath() throws Exception {
        System.out.println("Please, enter file path to read:");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String path = br.readLine();
        FileReader fileReader;
        try {
            fileReader = new FileReader(path);
        }catch (FileNotFoundException e){
            System.err.println("File with path " + path + " not found");
            return;
        }

        br = new BufferedReader(fileReader);

        try {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.err.println("Can't read file by path " + path);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(fileReader);
        }
    }
}

