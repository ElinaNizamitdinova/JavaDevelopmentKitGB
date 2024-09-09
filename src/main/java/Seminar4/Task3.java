package Seminar4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task3 {
//    В рамках выполнения задачи необходимо:
//            ● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
//            значение
//            ● Найдите человека с самым маленьким номером телефона
//            ● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
    public static void main(String[] args) {
        Map<String,String> phoneBook = new HashMap<>();
        phoneBook.put("89213465667","Elena");
        phoneBook.put("89312345643","Ivan");
        phoneBook.put("96567543","Ilona");
        phoneBook.put("89765634","Han");

    }

    public static String minNumber(Map<String,String> phoneNumber){
        Set<Long> numbers = phoneNumber.keySet().stream().map(el->Long.valueOf(el)).collect(Collectors.toSet());
       return String.format("Наименьший номер: %s ",numbers.stream().min(Comparator.naturalOrder()).get());
    }
    public static String finfPersonwithAlphobetName(Map<String,String> phoneNumber){
        Set<Map.Entry<String,String>> elements = phoneNumber.entrySet();
        Map.Entry<String,String> name =elements.stream().max((el1,el2)->(el1.getValue().compareTo(el2.getValue()))).get();
        return String.format("Самое большое имя в алфовитном порядке %s c номером %s",name.getValue(),name.getKey());
    }




}