package Lesson_6;

public class ArrayChecker {

    public boolean containsFourAndOne(int[] arrayToCheck) {
        boolean isThereFour = false;
        boolean isThereOne = false;

        for (int i : arrayToCheck) {
            if (i == 1) isThereOne = true;
            if (i == 4) isThereFour = true;
        }
        if (!isThereFour && !isThereOne) {
            throw new RuntimeException("No '1' and '4' in array");
        }
        if (!isThereFour) {
            throw new RuntimeException("No '4' in array!");
        }
        if (!isThereOne) {
            throw new RuntimeException("No '1' in array!");
        }

        return isThereFour && isThereOne;
    }
}
