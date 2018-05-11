package lesson25.homework;

public class GeneralDAO<T extends IdEntity>{

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new IdEntity[10];

    public <T extends IdEntity> void validate(T t) throws Exception {
        if (t.getId() <= 0)
            throw new Exception("id can't be negative");

        if (findById(t.getId()) != null)
            throw new Exception("File with id " + t.getId() + " already exist");
    }

    public T save(T t) throws Exception {
        validate(t);
        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }
        throw new Exception("File " + t.getId() + " can't be saved");
    }

    public T[] getAll() {
        return array;
    }

    public T findById(long id) {
        for (T el : array) {
            if (el != null && el.getId() == id)
                return el;
        }
        return null;
    }
}
