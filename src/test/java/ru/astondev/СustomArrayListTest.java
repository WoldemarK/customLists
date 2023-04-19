package ru.astondev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Kovtunov Vladimir
 */
class СustomArrayListTest {
    private final long startTime = System.currentTimeMillis();
   private СustomList<String> list;

    /**
     * @throws Exception
     */
    @BeforeEach
    void beforeEach() throws Exception {
        list = new СustomArrayList<>();
        list.add("Tom");
        list.add("Sara");
        list.add("Mark");
        list.add("Cati");
    }

    /**
     * Метод тестирования для {@link СustomArrayList#isEmpty()}
     */
    @Test
    @DisplayName("Данный тест проверяет что коллекция не пуста")
    void testMethodIsEmpty() {
        System.out.println("testIsEmpty = " + startTime);

        assertThat(list.isEmpty(), equalTo(false));
        list.clear();
        assertThat(list.isEmpty(), equalTo(true));
    }

    /**
     * Метод тестирования для {@link СustomArrayList#size()}
     */
    @Test
    @DisplayName("Метод проверки количество элементов в коллекции")
    void testMethodSize() {
        System.out.println("testSize = " + startTime);

        assertEquals(4, list.size());
    }

    /**
     * Метод тестирования для {@link СustomArrayList#contains(Object)}
     */
    @Test
    @DisplayName("Метод проверки содержания значений")
    void testMethodContains() {
        System.out.println("testContains = " + startTime);

        assertThat(list.contains("Tom"), equalTo(true));
        assertThat(list.contains("Mark"), equalTo(true));
        assertThat(list.contains(null), equalTo(false));

        list.add(null);

        assertThat(list.contains(null), equalTo(true));
    }

    /**
     * Метод тестирования для {@link СustomArrayList#indexOf(Object)} ()}
     */
    @Test
    @DisplayName("Метод возвращает index")
    void testMethodIndexOf() {
        System.out.println("testMethodIndexOf = " + startTime);

        int elementToFind = 31;

        int elementIndex = list.indexOf(elementToFind);

        Assertions.assertEquals(-1, elementIndex);
    }

    /**
     * Метод тестирования для {@link СustomArrayList#add(Object)} ()}
     */
    @Test
    @DisplayName("Метод добавления множество элементов в коллекцию")
    void testMethodBooleanAddAll() {
        System.out.println("testMethodBooleanAddAll = " + startTime);

        List<String> listI = new ArrayList<>();

        listI.add("1");
        listI.add("2");
        listI.add("3");

        assertTrue(list.addAll(listI));
    }

    /**
     * Метод тестирования для {@link СustomArrayList#add(Object)} ()}
     */
    @Test
    @DisplayName("Метод добавления элемента по индексу")
    void testMethodVoidAdd() {
        System.out.println("testMethodVoidAdd = " + startTime);

        list.add(0, "Tratatatata");

    }

    /**
     * Метод тестирования для {@link СustomArrayList#get(int)} ()}
     */
    @Test
    @DisplayName("Получение по индексу элемента")
    void testGet() {
        System.out.println("testGet = " + startTime);

        String name = (String) list.get(0);

        assertEquals("Tom", name);
    }

    /**
     * Метод тестирования для {@link СustomArrayList#set(int, Object)} ()}
     */
    @Test
    @DisplayName("Назначение нового элемента")
    void testMethodSet() {
        System.out.println("testMethodSet = " + startTime);

        list.set(1, "Katy");

        assertEquals("Katy", list.get(1));
    }
}
