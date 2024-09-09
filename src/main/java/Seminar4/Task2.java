package Seminar4;

import java.util.*;

public class Task2 {
//    В рамках выполнения задачи необходимо:
//            ● Создайте коллекцию мужских и женских имен с помощью интерфейса List -
//              добавьте повторяющиеся значения
//            ● Получите уникальный список Set на основании List
//            ● Определите наименьший элемент (алфавитный порядок)
//            ● Определите наибольший элемент (по количеству букв в слове но в обратном
//            порядке
//            ● Удалите все элементы содержащие букву ‘A’


    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван","Сергей","Александр","Ирина","Светлана","Ирина"));
        Set<String> setNames = convertListToSet(names);
        System.out.println(setNames);
        String mimi = minLenghtName(setNames);
        System.out.println(mimi);
        List<String> newNames = minAndMaxLengthName(setNames);
        System.out.println(newNames);


    }
    public static Set<String> convertListToSet(List<String> list){
        return new HashSet<>(list);

    }
    public static String minLenghtName(Set<String> list){
         return list.stream().min(Comparator.naturalOrder()).orElse(null);

    }
    public static List<String> minAndMaxLengthName(Set<String> names){
        List<String> resultNames = new ArrayList<>();
        resultNames.add(names.stream().min(Comparator.comparing(String::length)).orElse(null));
        resultNames.add(names.stream().max(Comparator.comparing(String::length)).orElse(null));
        return resultNames;

    }
    public static void reverseNameByChar(Set<String> names, String symbol){
        names.removeIf(name -> name.toLowerCase().contains(symbol.toLowerCase()));
    }



}
