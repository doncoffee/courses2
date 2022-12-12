package homework1;

import java.util.Comparator;

public class MyComparator implements Comparator<String[]> {

    public int compare(String[] arr1, String[] arr2) {
        int result;
        for (int i = 0; i < Integer.min(arr1.length, arr2.length); i++) {

            if (isNumeric(arr1[i]) && isNumeric(arr2[i])) {
                result = Double.compare(Double.parseDouble(arr1[i]), Double.parseDouble(arr2[i]));
                if (result == 0) {
                    continue;
                } else {
                    return result;
                }
            }

            if (!isNumeric(arr1[i]) && !isNumeric(arr2[i])) {
                result = arr1[i].compareTo(arr2[i]);
                if (result == 0) {
                    continue;
                } else {
                    return result;
                }
            }

            if (isNumeric(arr1[i]) ) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}

