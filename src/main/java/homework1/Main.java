package homework1;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // создаю файл in.txt и читаю его содержимое
        FileOperations file = new FileOperations();
        List<String> list = file.readFromFile(file.createFile());

        // сравниваю элементы массивов, сортирую и записываю в файл
        MyComparator comparator = new MyComparator();
        List<String[]> sortedList = list.stream()
                .map(s -> s.split("\\s+"))
                .sorted(comparator)
                .toList();
        File newFile = new File("out.txt");
        file.writeCollection(newFile, sortedList);
    }
}
