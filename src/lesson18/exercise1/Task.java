package lesson18.exercise1;

public class Task {

    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        String[] fileNames = {"test1", "test2"};
        fileStorage.setFiles(fileNames);

        System.out.println("Start printing name...");

        printer(fileStorage);

        System.out.println("Done");
    }


    public static void printer(Storage storage) {
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e) {
            System.out.println("5th name can not be fount...");
            //Sys.err.println(e.getMessage());
        }

        //solution 2
//        if (names.length < 5)
//            Sys.out.println("5th name can not be fount...");
//        else
//            Sys.out.println("5th name is " + names[4]);
    }
}
