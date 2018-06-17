package lesson34.homework.transferFileContent;

public class Demo {
    public static void main(String[] args) throws Exception {

        try {
            Solution.transferFileContent("D:/test1.txt", "D:/test2.txt");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
