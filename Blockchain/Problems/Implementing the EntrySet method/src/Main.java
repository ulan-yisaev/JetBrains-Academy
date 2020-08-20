import java.util.*;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);
            int agn = idx;

            if (idx == -1) {
                return false;
            }
// linear probing here:
//            do {
                if (table[idx] == null) {
                    table[idx] = new TableEntry(key, value);
                    return true;
                } else {
                    table[idx] = new TableEntry(key, table[idx].getValue() + " " + value);
//                    idx = (idx + 1) % size;
                }
//            } while (idx != agn);

            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public Set<TableEntry<T>> entrySet() {
            Set<TableEntry<T>> tableEntries = new HashSet<>();

            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    tableEntries.add(table[i]);
                }
            }
            return tableEntries;
        }

        private int findKey(int key) {
            int hash = key % size;

//            while (!(table[hash] == null || table[hash].getKey() == key)) {
            while (table[hash] != null && table[hash].getKey() != key) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            size = size * 2;
            TableEntry[] newtable = new TableEntry[size];
            System.arraycopy(table, 0, newtable, 0, table.length);
            table = newtable;
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                            + ", value=" + table[i].getValue());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        HashTable<String> table = new HashTable<>(size);

        for (int i = 0; i < size; i++) {
            table.put(sc.nextInt(), sc.nextLine());
        }

//        System.out.println("\n" + table.toString() + "\n");
        for (TableEntry<String> entry : table.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
//
//        HashMap<Integer, String> output = new HashMap<>();
//
//        for (TableEntry<String> entry : table.entrySet()) {
//            int key = entry.getKey();
//            String value = entry.getValue();
//            if (!output.containsKey(key)) {
//                output.put(key, value);
//            } else {
//                output.put(key, output.get(key) + value);
//            }
//        }
//
//        output.entrySet()
//                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }
}