package datastructure.lesson;

class Node<E> {     // 单链表结点泛型类
    E data;             // 结点的数据域
    Node<E> next;   // 后继结点的指针域

    public Node() { //构造方法
        this.next = null;
    }

    public Node(E d) {  //重载构造方法
        // 完成：将d赋值给结点的数据域， 完成结点的初始化
        this.data = d;
        this.next = null;
    }

    public Node(E d, Node<E> next) {  //重载构造方法
        // 完成：将d赋值给结点的数据域， 完成结点的初始化
        this.data = d;
        this.next = next;
    }
}

// 单链表泛型类
public class LinkListClass<E> {         // 链表泛型类
    Node<E> head;                   // 存放头结点
    public LinkListClass() {            // 构造方法
        // 完成：创建头结点
        this.head = new Node<>();
    }

    private Node<E> geti(int i) {   // 返回序号为i的结点
        Node<E> p = head;
        // 完成：找到序号为i的结点p，并返回该结点
        while (i-- > 0) {
            p = p.next;
        }
        return p;
    }

    //线性表的基本运算算法
    public void CreateListF(E[] a) {    //头插法：由数组a整体建立单链表
        for (E e : a) {    //循环建立结点s
            head.next = new Node<>(e, head.next);
        }
    }
    public void CreateListR(E[] a) {    // 尾插法：由数组a整体建立单链表
/*        Node<E> s, t = head;        // t始终指向尾结点，开始时指向头结点
        for (int i = 0; i < a.length; i++) {    //循环建立结点s
            s = new Node<E>(a[i]);  // 新建存放a[i]元素值的结点s

            // 完成：将s结点插入t结点之后

            // 完成：将t结点向后移
            t = s;
        }
        t.next = null;  //将尾结点的next字段置为null*/
        Node<E> temp = head;
        for (E e : a) {
            Node<E> trail = new Node<>(e, null);
            temp.next = trail;
            temp = trail;
        }
    }

    public void Add(E e) {  //在线性表的末尾添加一个元素值e的结点
/*        Node<E> s = new Node<E>(e); //新建结点s
        Node<E> p = head;

        // 完成：查找尾结点p

        // 完成：在尾结点之后插入结点s*/
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(e, null);
    }
    public int size() {     //求链表的长度
        Node<E> p = head;
        int cnt = 0;
        while (p.next != null) {    //找到尾结点为止
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public void Setsize(int nlen) {     //设置线性表的长度
        int len = size();
        if (nlen < 0 || nlen > len) {
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        if (nlen == len) {
            return;
        }
        Node<E> p = geti(nlen - 1); //找到序号为nlen-1的结点p
        p.next = null;  //将结点p置为尾结点
    }


    public E GetElem(int i) {   
/*        // 完成：返回链表中序号为i的结点的元素值
        // 1. 判断i的值是否合理
        // 2. 调用geti()方法得到序号为i的结点p
        // 3. 返回结点p的元素值*/
        Node<E> temp = head;
        while (i-- > 0) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void SetElem(int i, E e) {   //设置序号i的结点的元素值为e
        if (i < 0 || i > size() - 1) {
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
        Node<E> p = geti(i);    //找到序号为i的结点p
        p.data = e;
    }

    public int GetNo(E e) { 
/*        // 完成：查找第一个值为为e的结点的序号，并返回结点序号
        // 循环查找，条件为：结点不为null 且 结点的值不为e，记录结点的序号
        // 根据是否找到进行返回，未找到返回-1，找到则返回序号 */
        int index = 0;
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            index++;
            if (e == temp.data) {
                break;
            }
        }
        return index;
    }

    public void swap(int i, int j) {    //交换序号i和序号j的结点的值
        Node<E> p = geti(i);
        Node<E> q = geti(j);
        E tmp = p.data;
        p.data = q.data;
        q.data = tmp;
    }

    public void Insert(int i, E e) {    //在链表中的序号i插入值为e的结点
        if (i < 0 || i > size()) {      //参数错误抛出异常
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
/*        // 完成：在i位置插入结点e
        // 1. 创建值为e的新结点
        // 2. 找到i位置结点的前驱结点p（也就是i-1位置的结点）
        // 3. 设置s的后继结点为p的后继结点
        // 4. 设置p的后继结点为s结点*/
        Node<E> temp = head;
        while (i-- > 1) {
            temp = temp.next;
        }
        temp.next = new Node<E>(e, temp.next);
    }

    public void Delete(int i) {         //在链表中删除序号i位置的结点
        if (i < 0 || i > size() - 1) {  //参数错误抛出异常
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        }
/*        // 完成：删除i位置的结点
        // 1. 找到i位置结点的前驱结点p（也就是i-1位置的结点）
        // 2. 设置p的后继结点为p的后继结点的后继结点*/
        Node<E> temp = head;
        while (i-- > 1) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    @Override
    public String toString() {  //将线性表转换为字符串
        String ans = "";
        Node<E> p = head.next;
        while (p != null) {
            ans += p.data + " ";
            p = p.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        //测试1：数据为整型
        System.out.println("****************测试1****************");
        Integer[] a = {1, 2, 3, 4, 5};
        
        // 完成：尾插法创建链表，并输出链表
        LinkListClass linkList = new LinkListClass<Integer>();
        linkList.CreateListR(a);
        System.out.println(linkList);

        
        // 完成：在末尾添加元素值为10的结点，并输出链表
        linkList.Add(10);
        // 完成：遍历链表的每个结点的元素值
        System.out.println("linkList = " + linkList);

        // 重置长度
        // System.out.println("重新置长度为5");
        // L1.Setsize(5);
        // System.out.println("L1: " + L1);

        // 完成：在指定位置i插入结点，结点值为20，并输出链表
        int i = 1;
        Integer x = 20;
        linkList.Insert(i, x);
        System.out.println("linkList = " + linkList);
        // 完成：删除指定位置i的结点，并输出链表
		i = 3;
        linkList.Delete(i);
        System.out.println("linkList = " + linkList);
        // 完成：替换指定位置i的结点的值为16，并输出链表
		i = 2;
        x = 16;
        linkList.SetElem(i, x);
        System.out.println("linkList = " + linkList);
        // 完成：获取值为5的结点的序号
        System.out.println("linkList.GetNo(5) = " + linkList.GetNo(5));


        // 测试：数据为字符串，头插法创建单链表
        System.out.println();
        System.out.println("****************测试3****************");
        String c = "abcdef";
        LinkListClass<Character> L3 = new LinkListClass<>();
        L3.CreateListF(c.chars()            // IntStream，也可使用c.codePoints()
                .mapToObj(ch ->(char)ch)    // Stream<Character>
                .toArray(Character[]::new));
        System.out.println("L3: " + L3);
    }


}
