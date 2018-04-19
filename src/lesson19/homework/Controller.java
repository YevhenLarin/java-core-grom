package lesson19.homework;

public class Controller {

    //добавляет файл в хранилище
//    public void put(Storage storage, File file) {
    public File put(Storage storage, File file){
        if (file == null)
            throw new NullPointerException("file is null");

        if (findFile(storage, file.getId()) != null && findFile(storage, file.getId()).equals(file))
            throw new RuntimeException("Can't put file " + file.getId() + " to the storage " + storage.getId() + " because file already exists");

//        checkFormat(storage, file);
//        checkStorageSize(storage, file);

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                System.out.println("File " + file.getId() + " was saved to the Storage " + storage.getId());
                return storage.getFiles()[i];
            }
        }
        return null;
    }

    //удаляет файл из хранилища
    public void delete(Storage storage, File file){
        if (file == null)
            throw new NullPointerException("file is null");
        if (storage.getFiles() == null)
            throw new NullPointerException("storage " + storage.getId() + " doesn't have files");

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(findFile(storage, file.getId()))) {
                storage.getFiles()[i] = null;
                System.out.println("File " + file.getId() + " was deleted from the Storage " + storage.getId());
                return;
            }
        }
        throw new RuntimeException("Can't delete file from the storage because storage " + storage.getId() + " doesn't have file " + file.getId());
    }

    //трансфер всех файлов
    public void transferAll(Storage storageFrom, Storage storageTo){
        if (storageFrom.getFiles() == null)
            throw new RuntimeException("Can't transfer all files from the storage because storage " + storageFrom.getId() + " doesn't have files");

        if (countsFiles(storageFrom) > storageTo.getFiles().length - countsFiles(storageTo))
            throw new RuntimeException("Can't transfer all files from the storage because storage " + storageTo.getId() + " doesn't have free places");

        for (File f : storageFrom.getFiles()) {
            if (f != null)
                transferFile(storageFrom, storageTo, f.getId());
        }
    }


    //трансфер файла с хранилища по его id
    public void transferFile(Storage storageFrom, Storage storageTo, long id){
        if (findFile(storageFrom, id) == null)
            throw new RuntimeException("Can't transfer file from the storage because storage " + storageFrom.getId() + " doesn't have file");

//        checkFormat(storageTo, findFile(storageFrom, id));
//        checkStorageSize(storageTo, findFile(storageFrom, id));

        put(storageTo, findFile(storageFrom, id));
        delete(storageFrom, findFile(storageFrom, id));
        System.out.println("File " + id + " was transferred from the storage " + storageFrom.getId() + " to the storage " + storageTo.getId());
    }

    //метод для проверки совместимости форматов файла и хранилища
    private void checkFormat(Storage storage, File file) {
        for (String str : storage.getFormatsSupported()) {
            if (str != null && str.equals(file.getFormat()))
                return;
        }
        throw new RuntimeException("Storage " + storage.getId() + " doesn't supported file format");
    }

    //метод для проверки хватит ли размера хранилища для сохранения файла
    private void checkStorageSize(Storage storage, File file) throws RuntimeException {
        if (storage.getStorageSize() - sumFilesSizes(storage) < file.getSize())
            throw new RuntimeException("Can't save file " + file.getId() + " to the storage " + storage.getId() + " because storage doesn't have free space");
    }

    //метод для поиска файла в хранилище по id
    private File findFile(Storage storage, long id) {
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == id)
                return f;
        }
        return null;
    }

    //метод для подсчета количества файлов в хранилище
    private int countsFiles(Storage storage) {
        int count = 0;
        for (File f : storage.getFiles()) {
            if (f != null)
                count++;
        }
        return count;
    }

    //метод для подсчета объема файлов в хранилище
    private int sumFilesSizes(Storage storage) {
        int sumFilesSizes = 0;
        for (File f : storage.getFiles()) {
            if (f != null)
                sumFilesSizes += f.getSize();
        }
        return sumFilesSizes;
    }
}
