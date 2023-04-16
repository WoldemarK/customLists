package ru.astondev;

import java.util.Collection;

/**
 * Предоставляется общий интерфейс для всех классов которые наследуют интерфейс MyList<E>
 * Данный интерфейс параметризирован что дает возможность работы с любым типом данных
 *
 * @author Kovtunov Vladimir
 */
public interface СustomList<T> {
    /**
     * Данный метод служит для добавления в коллекцию данных {@link СustomArrayList#add)}
     *
     * @param element вставляемый элемент
     * @return вернет true если элемент добавлен в коллекцию
     */
    boolean add(T element);

    /**
     * Данный метод служит для добавления в коллекцию данных по index-у {@link СustomArrayList#add(int, Object)} )}
     *
     * @param index   ячейки куда будет осуществлена ставка
     * @param element вставляемый элемент
     */

    void add(int index, T element);

    /**
     * Данный метод служит для получения элемента по его index {@link СustomArrayList#get(int)} )}
     *
     * @param index получение элемента
     * @return вернет элемент под index
     */
    T get(int index);

    /**
     * Данный метод предназначен для вставки элемента по index {@link СustomArrayList#set(int, Object)} )}
     *
     * @param index   в какую ячейку будет осуществлена вставка элемента
     * @param element вставляемый элемент
     * @return вернет новый элемент
     */
    Object set(int index, T element);

    /**
     * Данный метод предназначен для поиска элемента {@link СustomArrayList#indexOf(Object)} )}
     *
     * @param target элемент который нужно найти
     * @return найденный элемент
     */
    int indexOf(Object target);

    /**
     * Данный метод служит для сравнения элементов
     * {@link СustomArrayList#equals(Object, Object)} )}
     *
     * @param target  элемент с которым идет сравнение
     * @param element элемент по коронному идет сравнение
     * @return вернет true если элементы равны
     * r
     */
    boolean equals(Object target, Object element);

    /**
     * Метод служит для удаления элемента по его index
     * {@link СustomArrayList#remove(int)} )}
     *
     * @param index удаляемый элемент
     * @return вернет удаленный элемент
     */
    T remove(int index);

    /**
     * Метод служит для отображения всех элементов коллекции
     * {@link СustomArrayList#getAll()} )}
     */
    void getAll();

    /**
     * Метод тестирования для {@link СustomArrayList#isEmpty()}.}.
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Метод тестирования для {@link СustomArrayList#size()}.}.
     *
     * @return
     */
    int size();

    boolean contains(Object obj);

    /**
     * Метод тестирования для {@link СustomArrayList#addAll(Collection)}}.
     *
     * @param collection
     * @return
     */
    boolean addAll(Collection<? extends T> collection);

    /**
     * Метод тестирования для {@link СustomArrayList#clear()} )}}.
     */
    void clear();
}
