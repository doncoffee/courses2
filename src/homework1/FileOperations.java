package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    public File createFile() {
        File file = new File("in.txt");
        System.out.println("Пожалуйста, заполните таблицу");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку");
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строку");
        String str2 = scanner.nextLine();
        System.out.println("Введите третью строку");
        String str3 = scanner.nextLine();
        String[] arr1 = str1.split("\\s+");
        String[] arr2 = str2.split("\\s+");
        String[] arr3 = str3.split("\\s+");
        try (FileWriter writer = new FileWriter(file)) {
            for (String s : arr1) {
                writer.write(s + "\t");
            }
            writer.write("\n");
            for (String s : arr2) {
                writer.write(s + "\t");
            }
            writer.write("\n");
            for (String s : arr3) {
                writer.write(s + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public List<String> readFromFile(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeCollection(File file, List<String[]> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String[] line : list) {
                for (String word : line) {
                    writer.write(word.concat("\t"));
                }
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
