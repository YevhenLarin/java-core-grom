package lesson19.homework;

public class Controller {

    //добавляет файл в хранилище
    public File put(Storage storage, File file) throws Exception{

        if (findFileById(storage, file.getId()) != null)
            return null;

        checkFormat(storage, file);
        checkStorageSize(storage, file);

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                return storage.getFiles()[i];
            }
        }
        throw new Exception("Can't save file " + " to the storage " + storage.getId() + " because storage doesn't have free place");
    }

    //удаляет файл из хранилища
    public void delete(Storage storage, File file) throws Exception {

        if (file == null || storage.getFiles() == null || findFileById(storage, file.getId()) == null)
            return;

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                storage.getFiles()[i] = null;
//                Sys.out.println("File " + file.getId() + " was deleted from the Storage " + storage.getId());
                return;
            }
        }
        throw new Exception("Can't delete file from the storage because storage " + storage.getId() + " doesn't have file " + file.getId());
    }

    //трансфер всех файлов
    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        try {
            for (File f : storageFrom.getFiles()) {
                if (f != null)
                    transferFile(storageFrom, storageTo, f.getId());
            }
        } catch (Exception e) {
            throw new Exception("Can't transfer all files from the storage " + storageFrom.getId() + " to the storage " + storageTo.getId());
        }
    }

    //трансфер файла с хранилища по его id
    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        try {
            put(storageTo, findFileById(storageFrom, id));
            delete(storageFrom, findFileById(storageFrom, id));
//            Sys.out.println("File " + id + " was transferred from the storage " + storageFrom.getId() + " to the storage " + storageTo.getId());
        } catch (Exception e) {
            throw new Exception("Can't transfer file " + id + "from the storage " + storageFrom.getId() + " to the storage " + storageTo.getId());
        }
    }

    //метод для проверки совместимости форматов файла и хранилища
    private void checkFormat(Storage storage, File file) throws Exception {
        for (String str : storage.getFormatsSupported()) {
            if (str != null && str.equals(file.getFormat()))
                return;
        }
        throw new Exception("Storage " + storage.getId() + " doesn't supported file format");
    }

    //метод для проверки хватит ли размера хранилища для сохранения файла
    private void checkStorageSize(Storage storage, File file) throws Exception {
        if (storage.getStorageSize() - sumFilesSizes(storage) < file.getSize())
            throw new Exception("Can't save file " + file.getId() + " to the storage " + storage.getId() + " because storage doesn't have free space");
    }

    //метод для поиска файла в хранилище по id
    private File findFileById(Storage storage, long id) /*throws Exception*/ {
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == id)
                return f;
        }
        return null;
//        throw new Exception("There isn't file " + id + " in the storage " + storage.getId() + " file: " + id);
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