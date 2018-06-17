package lesson34.homework.transferSentences;

public class Demo {
    public static void main(String[] args) throws Exception {

        try {
            Solution.transferSentences("D:/test1.txt", "D:/test7.txt", "One");
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
