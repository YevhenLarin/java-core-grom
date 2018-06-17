package lesson34.homework.standartCopyMethods;

public class Demo {
    public static void main(String[] args) throws Exception {

        try {
            Solution.copyFileContent("D:/test5.txt", "D:/test2.txt");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            Solution.copyFileContentApacheIO("D:/test1.txt", "D:/test6.txt");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
