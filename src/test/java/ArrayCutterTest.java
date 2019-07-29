import Lesson_6.ArrayCutter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayCutterTest {
    ArrayCutter arrayCutter;

    @Before
    public void inti() {
        System.out.println("init!");
        arrayCutter = new ArrayCutter();
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{2, 3, 3, 1, 7},
                arrayCutter.splitArrayAfterFour(new int[] {1, 2, 4, 4, 2, 3, 3, 1, 7}));
    }

    @Test (expected = RuntimeException.class)
    public void test2() {
        Assert.assertArrayEquals(new int[]{2, 3, 3, 1, 7},
                arrayCutter.splitArrayAfterFour(new int[] {1, 2, 3, 5, 2, 3, 3, 1, 7}));
    }

    @Test (expected = RuntimeException.class)
    public void test3() {
        Assert.assertArrayEquals(new int[]{},
                arrayCutter.splitArrayAfterFour(new int[] {}));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[]{},
                arrayCutter.splitArrayAfterFour(new int[] {4}));
    }

    @After
    public void shutdown() {
        System.out.println("end");
    }
}
