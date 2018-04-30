package lesson19.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();

        File file1 = new File(11, "File1", "doc", 3);
        File file2 = new File(22, "File2", "mp3", 5);
        File file3 = new File(33, "File3", "jpg", 10);
        File file4 = new File(44, "File4", "txt", 20);
        File file5 = new File(55, "File5", "mkv", 50);
        File file6 = new File(66, "File6", "doc", 3);
        File file7 = null;
        File file8 = new File(88, "File8", "mp3", 5);

        File[] files1 = new File[]{file1, file2, file3, null};
        File[] files2 = new File[]{file1, file2, null};
        File[] files3 = new File[]{file1, file2, file3, file4};
        File[] files4 = null;
        File[] files5 = new File[]{file4, null, null};
        File[] files6 = new File[]{file4, null, null};


        String formatSupported1 = "doc";
        String formatSupported2 = "mp3";
        String formatSupported3 = "jpg";
        String formatSupported4 = "txt";
        String formatSupported5 = "mkv";

        String[] formatSupportedSt1 = new String[]{formatSupported1, formatSupported2, formatSupported3};
        String[] formatSupportedSt2 = new String[]{formatSupported1};
        String[] formatSupportedSt3 = new String[]{formatSupported2, formatSupported5};

        Storage st1 = new Storage(111, files1, formatSupportedSt1, "Ukraine", 50);
        Storage st2 = new Storage(222, files5, formatSupportedSt1, "Ukraine", 100);
        Storage st3 = new Storage(333, files6, formatSupportedSt1, "Ukraine", 500);


        System.out.println("st1 " + Arrays.toString(st1.getFiles()));
        System.out.println();

        //добавление файла
        controller.put(st1, file1);
        System.out.println("st1 " + Arrays.toString(st1.getFiles()));
        System.out.println();

        //удаление файла
        controller.delete(st1, file8);
        System.out.println("st1 " + Arrays.toString(st1.getFiles()));
        System.out.println();

        //трансфер файла по id
        System.out.println("st1 " + Arrays.toString(st1.getFiles()));
        System.out.println("st2 " + Arrays.toString(st2.getFiles()));
        controller.transferFile(st1, st2, 11);
        System.out.println("st1 " + Arrays.toString(st1.getFiles()));
        System.out.println("st2 " + Arrays.toString(st2.getFiles()));
        System.out.println();

        //трансфер всех файлов
        System.out.println("st1 " + Arrays.toString(st1.getFiles()));
        System.out.println("st3 " + Arrays.toString(st3.getFiles()));
        controller.transferAll(st1, st3);
        System.out.println("st1 " + Arrays.toString(st1.getFiles()));
        System.out.println("st3 " + Arrays.toString(st3.getFiles()));
    }
}
