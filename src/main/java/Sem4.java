import java.util.*;

public class Sem4 {
    static LinkedList<ArrayList<String>> contacts = new LinkedList<>();
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        GetData();
        System.out.println("Общий список:");
        PrintContacts();
        System.out.println();

        Comparator<ArrayList<String>> comparatorAge = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> t1, ArrayList<String> t2) {
                if (Integer.parseInt(t1.get(3)) > Integer.parseInt(t2.get(3))) return 1;
                else if (Integer.parseInt(t1.get(3)) < Integer.parseInt(t2.get(3))) return -1;
                else return 0;
            }
        };
        System.out.println("Сортировка по возрасту:");
        contacts.sort(comparatorAge);
        PrintContacts();
        System.out.println();

        Comparator<ArrayList<String>> comparatorGender = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> t1, ArrayList<String> t2) {
                if (t1.get(4).charAt(0) > t2.get(4).charAt(0)) return 1;
                else if (t1.get(4).charAt(0) < t2.get(4).charAt(0)) return -1;
                else return 0;
            }
        };
        contacts.sort(comparatorGender);
        System.out.println("Сортировка по полу:");
        PrintContacts();
    }
    private static void PrintContacts() {
        for (ArrayList<String> record :
                contacts) {
            System.out.print(record.get(0) + " ");
            System.out.print(record.get(1).toUpperCase().charAt(0) + ".");
            System.out.print(record.get(2).toUpperCase().charAt(0) + ". ");
            System.out.print(record.get(3) + " ");
            System.out.println(record.get(4));
        }

    }
    private static void GetData() {
        String command;
        System.out.println("Введите '1' для ввода новой записи\n Введите '2' для завершения ввода данных\n ");
        command = myScanner.nextLine();
        while (command.equals("1")) {
            contacts.add(GetRecord());
            System.out.println("Введите '1' для ввода новой записи\n Введите '2' для завершения ввода данных\n ");
            command = myScanner.nextLine();
        }
    }
    private static ArrayList<String> GetRecord() {
        ArrayList<String> newRecord = new ArrayList<>();
        System.out.println("Введите Фамилию:");
        String lastName = myScanner.nextLine();
        newRecord.add(lastName);
        System.out.println("Введите Имя:");
        String firstName = myScanner.nextLine();
        newRecord.add(firstName);
        System.out.println("Введите Отчество:");
        String middleName = myScanner.nextLine();
        newRecord.add(middleName);
        System.out.println("Введите Год Рождения:");
        String age = myScanner.nextLine();
        newRecord.add(age);
        System.out.println("Введите Пол:");
        String gender = myScanner.nextLine();
        newRecord.add(gender);
        return newRecord;
    }
}

//    public class SortArrayInt{
//        public static ArrayList
//        sortingArray(ArrayList<Integer> id, ArrayList<String[]> data, Integer args){
//            int i = 0;
//            int l = id.size();
//            while (i < id.size()) {
//                for(int j = 0; j < l - 1; j++){
//                    if(Integer.parseInt(data.get(id.get(j + 1))[args])<Integer.parseInt(data.get(id.get(j + 1))[args])){
//                        int temp = id.get(j);
//                        id.set(j, id.get(j+1));
//                        id.set(j + 1, temp);
//                        l--;
//                    }
//                }
//                i++;
//            }
//            return id;
//        }

