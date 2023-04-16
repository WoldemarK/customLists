package ru.astondev;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Класс MyArrayList<E> наследуют интерфейс MyList<E> и переопределяет все полученные методы
 * Так же класс параметризирован что дает гибкость работы с любым типом данных
 * Для того чтобы была возможность отслеживать работу методов реализован Logger
 * Класс содержит приватные поля size - типа int возвращает количество элементов в этом списке, т.е. размер списка.
 * E[] array- для хранения элементов
 * Конструктор, который по умолчанию создает пустой массив на 16 ячеек
 *
 * @author Kovtunov Vladimir
 */
public class СustomArrayList<T> implements СustomList<T> {
    private final Logger log = Logger.getLogger(СustomArrayList.class.getName());
    private T[] elements;
    private int size;

    public СustomArrayList() {
        this.elements = (T[]) new Object[16];
    }

    public СustomArrayList(int capacity) {
        if (capacity >= 0) {
            this.elements = (T[]) new Object[capacity];
        }
    }

    /**
     * Метод проверяет если ли элемент в массиве
     *
     * @return true если элемент присутствует
     */

    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * @return возвращает количество элементов в списке
     */

    public int size() {
        return size;
    }

    /**
     * Проверяем содержится ли значение в списке
     *
     * @param obj
     * @return
     */

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /**
     * Поиск элемента
     *
     * @param target
     * @return если элемент найден вернет его, в противном случае вернет -1
     */

    public int indexOf(Object target) {
        if (target == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (target.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * Добавление списка селекции
     *
     * @param collection
     * @return true если операция прошла успешно
     */

    public boolean addAll(Collection<? extends T> collection) {
        boolean flag = true;
        for (T element : collection) {
            add(element);
        }
        return flag;
    }

    /**
     * Добавление нового элемента по его index
     *
     * @param index   по которому происходит поиск
     * @param element который нужно добавить по его index
     */


    public void add(int index, T element) {
        log.info("Добавление элемента в коллекцию по index  " + index + ", элемент " + element);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index равен 0, или index больше чем длинна");
        }
        add(element);

        for (int i = size - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
    }

    /**
     * Добавление нового элемента
     * Если в массиве нет места для нового элемента,
     * то при помощи вспомогательного метода increaseCapacity создается новый массив большего размера
     * (X= старый массив * 2) и копируем туда все элементы
     *
     * @param element вставляемый элемент
     * @return вернет true если операция прошла успешно
     */

    public boolean add(Object element) {
        log.info("Добавление элемента " + element + ", в коллекцию");
        if (size == elements.length - 1) {
            increaseCapacity(elements.length * 2);
        }
        elements[size++] = (T) element;
        return true;

    }

    /**
     * Вспомогательный метод для расширения списка {@link СustomArrayList#add}
     *
     * @param newLength новый список увеличенный в двое
     */
    private void increaseCapacity(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = (T[]) newArray;
    }


    /**
     * Очистка списка
     */

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    /**
     * Выведет все элементы коллекции
     *
     * @return все элементы коллекции
     */

    public void getAll() {
        for (Object obj : elements) {
            System.out.println(obj);
        }
    }


    /**
     * Поиск элемента по index
     *
     * @param index получение элемента
     * @return вернет запрашиваемый элемент,
     * в случае если запрашиваемый индекс меньше чем количество индексов или индекс превышает размер массива
     * выкинет исключение IndexOutOfBoundsException
     */

    public T get(int index) {
        log.info("Получение искомого элемента по index  " + index);
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Размер меньше 0 или размер вышел за пределы размера");
        }
       return (T)elements[index];

    }

    /**
     * Вставка элемента по index
     *
     * @param index   в какую ячейку будет осуществлена вставка элемента
     * @param element вставляемый элемент
     * @return вставляемый элемент
     */

    public Object set(int index, Object element) {
        for (int i = 0; i < elements.length; i++) {
            if (i == index) {
                elements[i] = (T) element;
            }
        }
        return element;
    }


    /**
     * Метод предназначен для сравнения элементов
     *
     * @param target  элемент с которым идет сравнение
     * @param element элемент по коронному идет сравнение
     * @return вернет результат true если элементы равны, в противном случае false
     */

    public boolean equals(Object target, Object element) {
        log.info("Реализация кастомного метода  equals");
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    /**
     * Метод предназначен для удаления элемента по его index
     * Сначала получаем нужный элемент по index
     * затем происходит сдвиг массива и удаление элемента
     *
     * @param index удаляемый элемент
     * @return удаленный элемент
     */

    public T remove(int index) {
        log.info("Удаление элемента  его индексу  " + index);
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T element = (T) get(index);

        for (int i = index; i < size - 1; i++) {
            elements[i] = null;
        }
        size--;
        return element;


    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
