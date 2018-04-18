package lesson19.homework;

public class Controller {

    //добавляет файл в хранилище
    public void put(Storage storage, File file) {
        if (file == null)
            throw new NullPointerException("file is null");

        format(storage, file);
        checkId(storage, file);
        checkStorageSize(storage, file);

        storage.getFiles()[freeSpace(storage, file)] = file;
        System.out.println("File " + file.getId() + " was saved to the Storage " + storage.getId());
    }

    //удаляет файл из хранилища
    public void delete(Storage storage, File file) {
        if (file == null)
            throw new NullPointerException("file is null");
        if (storage.getFiles() == null)
            throw new NullPointerException("storage " + storage.getId() + " doesn't have files");

        //int index = 0;
        boolean index = false;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                storage.getFiles()[i] = null;
                System.out.println("File " + file.getId() + " was deleted from the Storage " + storage.getId());
//                index++;
                index = true;
                break;
            }
        }
        if (!index)
            throw new RuntimeException("Can't delete file from the storage because storage " + storage.getId() + " doesn't have file " + file.getId());
    }

    //трансфер всех файлов
    public void transferAll(Storage storageFrom, Storage storageTo) {
        if (storageFrom.getFiles() == null)
            throw new RuntimeException("Can't transfer all files from the storage because storage " + storageFrom.getId() + " doesn't have files");

        if (countsFiles(storageFrom) > storageTo.getFiles().length - countsFiles(storageTo))
            throw new RuntimeException("Can't transfer all files from the storage because storage " + storageTo.getId() + " doesn't have free space");

        for (File f : storageFrom.getFiles()) {
            if (f != null)
                transferFile(storageFrom, storageTo, f.getId());
        }
    }


    //трансфер файла с хранилища по его id
    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        if (findFile(storageFrom, id) == null)
            throw new RuntimeException("Can't transfer file from the storage because storage " + storageFrom.getId() + " doesn't have file " + id);

        format(storageTo, findFile(storageFrom, id));
        checkId(storageTo, findFile(storageFrom, id));
        checkStorageSize(storageTo, findFile(storageFrom, id));

        put(storageTo, findFile(storageFrom, id));
        delete(storageFrom, findFile(storageFrom, id));
        System.out.println("File " + id + " was transferred from the storage " + storageFrom.getId() + " to the storage " + storageTo.getId());
    }

    //метод для проверки совместимости форматов файла и хранилища
    private void format(Storage storage, File file) {
        int index = 0;
        for (String str : storage.getFormatsSupported()) {
            if (str != null && str.equals(file.getFormat()))
                index++;
        }
        if (index == 0)
            throw new RuntimeException("Storage " + storage.getId() + " doesn't supported file format");
    }

    //метод для проверки нет ли в хранилище файла с таким же id
    private void checkId(Storage storage, File file) {
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == file.getId()) {
                throw new RuntimeException("Can't save file " + file.getId() + " to the storage " + storage.getId() + " because id already exists");
            }
        }
    }

    //метод для поиска свободного места в хранилище для сохранения файла
    private int freeSpace(Storage storage, File file) {
        int index = -1;

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1)
            throw new RuntimeException("Can't save file " + file.getId() + " to the storage " + storage.getId() + " because storage doesn't have free space");

        return index;
    }

    //метод для проверки хватит ли размера хранилища для сохранения файла
    private void checkStorageSize(Storage storage, File file) {
        if ((storage.getStorageSize() - file.getSize()) < file.getSize())
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
}
