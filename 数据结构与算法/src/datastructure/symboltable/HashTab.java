package datastructure.symboltable;

/**
 * @author qzy
 * @time 2023/10/31 11:10 星期二
 * @title 哈希表
 */
public class HashTab {
    static class Entry {
        int hash;   // 哈希码
        Object key;
        Object value;
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    Entry[] table = new Entry[16];
    int size = 0;
    int threshold = 12;
    float loadFactor = 0.75f;

    // 根据hash码获取value
    Object get(int hash, Object key) {
        // & 运算符的条件是 table.length 是2的n次方
        int idx = hash & (table.length - 1);
        Entry p = table[idx];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    // 向 hash 表存入新 key value，如果 key 重复，则更新 value
    void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 1. idx 处有空位, 直接新增
            table[idx] = new Entry(hash, key, value);
        } else {
            // 2. idx 处无空位, 沿链表查找 有重复key更新，否则新增
            Entry p = table[idx];
            while (true) {
                if (key.equals(p.key)) {
                    p.value = value;
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value);
        }
        size++;
        if (size >= threshold) {
            resize();
        }
    }

    // 根据hash码删除并返回其value
    Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry prev = null;
        Entry p = table[idx];
        while (p != null) {
            if (key.equals(p.key)) {    // 找到了结点
                if (prev == null) { // 删除的是首节点
                    table[idx] = p.next;
                } else {    // 删除的不是首节点
                    prev.next = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;
            p = p.next;
        }
        return null;
    }

    public void resize() {
        Entry[] newTable = new Entry[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i]; // 拿到每个链表头
            if (p != null) {
                /*
                    拆分链表，移动到新数组，拆分规律
                    * 一个链表最多拆成两个
                    * hash & table.length == 0 的一组
                    * hash & table.length != 0 的一组
                    p
                    0->8->16->24->32->40->48->null
                    a
                    0->16->32->48->null
                    b
                    8->24->40->null
                */
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                while (p != null) {
                    if ((p.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = p;
                        } else {
                            aHead = p;
                        }
                        a = p; // 分配到a
                    } else {
                        if (b != null) {
                            b.next = p;
                        } else {
                            bHead = p;
                        }
                        b = p; // 分配到b
                    }
                    p = p.next;
                }
                // 规律： a 链表保持索引位置不变，b 链表索引位置+table.length
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }

}
