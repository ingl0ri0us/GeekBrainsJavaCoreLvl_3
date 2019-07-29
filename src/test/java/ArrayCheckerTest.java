import Lesson_6.ArrayChecker;
import org.junit.Assert;
import org.junit.Test;

public class ArrayCheckerTest {
    ArrayChecker arrayChecker = new ArrayChecker();

    @Test
    public void test1() {
        Assert.assertTrue(arrayChecker.containsFourAndOne(new int[]{1,2,3,4,5,6,7,8,9}));
    }

    @Test (expected = RuntimeException.class)
    public void test2() {
        Assert.assertTrue(arrayChecker.containsFourAndOne(new int[]{0,2,3,3,5,6,7,8,9}));
    }

    @Test
    public void test3() {
        Assert.assertTrue(arrayChecker.containsFourAndOne(new int[]{1,4}));
    }

    @Test (expected = RuntimeException.class)
    public void test4() {
        Assert.assertTrue(arrayChecker.containsFourAndOne(new int[]{}));
    }
}
