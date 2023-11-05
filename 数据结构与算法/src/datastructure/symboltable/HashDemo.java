package datastructure.symboltable;

/**
 * @author qzy
 * @time 2023/10/31 12:35 星期二
 * @title
 */
public class HashDemo {
    public static void main(String[] args) {
        HashTab hashTable = new HashTab();
        hashTable.put(0, 9, 9);
        hashTable.put(0, 9, 10);
        hashTable.put(0, 8, 8);
        System.out.println("hashTable.get(0, 9) = " + hashTable.get(0, 9));
        System.out.println("hashTable.get(0, 8) = " + hashTable.get(0, 8));
    }
}
