package com.csnobugteam.java.leetcode;

import java.util.HashMap;

/**
 * 缓存淘汰策略
 *  实现思路：双向链表+哈希表
 *  必要条件：
 *      1、元素必须有时序，用于区分最近使用、许久未用。当容量满，需要删除许久未使用数据
 *      2、在cache中快速找到某个key是否存在，并找到对应的value
 *      3、每次访问cache中的key，要变为最近使用，（能快速插入、删除元素）
 *      核心数据结构：LinkedHashMap（双向链表+哈希表）
 * @author aixu
 * @since 2023/11/18
 */
// 整合哈希表
public class LRUCache {
    // key ---> Node(key,val)
    private HashMap<Integer, Node> map;

    // Node(k1, v1) <----> Node(k2, v2)
    private DoubleList cache;

    // 最大容量
    private int cap;

    // 初始化
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    // 思考：由于要同时维护一个双链表cache和一个哈希表，容易漏操作
    // 如删除某个key时，在cache中删除node，但是忘记map中的key
    // 解决：通过在这两种数据结构上提供一层抽像的API
    /* 将某个key提升为最近使用的 */
    private void makeRecently(int key) {
        Node x = map.get(key);
        // 先从链表中次删除这个节点
        cache.remove(x);
        // 再重写插入到队尾
        cache.addList(x);
    }

    /*
        添加最近使用的元素
     */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 在链表尾部添加最近使用的元素
        cache.addList(x);
        // 在map中添加key映射
        map.put(key, x);
    }

    /*
        删除某个key
     */
    private void deleteKey(int key) {
        Node x = map.get(key);
        // 从链表中删除
        cache.remove(x);
        // 从map中删除
        map.remove(key);
    }
    /*
        删除最久未使用的元素
     */
    private void removeLeastRecently(){
        // 链表头部的第一个元素就是最久未使用的
        Node deletedNode = cache.removeFirst();
        // 同时从map中删除
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    // 下面是暴露出来使用的接口
    /*
        get(key) 方法
     */
    public int get(int key) {
        // 1、判断是否有值
        if (!map.containsKey(key)) return -1;
        // 2、将key提升为最近使用
        makeRecently(key);
        return map.get(key).val;
    }

    /*
        put(key, val):
        if key 存在：修改为最近使用makeRecently(key)
        else 不存在：需要插入新的节点
        if cap == size 满：需要淘汰最久未使用，在用尾插新加入
        else 不满：直接尾插，为最近使用
     */
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // 删除旧数据
            deleteKey(key);
            // 插入新数据
            addRecently(key, val);
            return;
        }
        // cap == size 满
        if (cap == cache.size()) {
            // 删除许久为使用的元素
            removeLeastRecently();
        }
        // 添加新数据
        addRecently(key, val);
    }
}

//构建双向链表节点
class Node {
    public int key, val;
    public Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
// 构建一个双向链表
class DoubleList {
    // 虚拟头节点、尾节点
    private Node head, tail;
    // 链表元素个数据
    private int size;

    // 初始化链表数据
    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    // 尾叉法插入，新节点
    public void addList(Node x) {
        x.prev = tail.prev;
        x.next = tail;

        tail.prev.next = x;
        tail.prev = x;

        size++;
    }

    // 删除节点
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链中的第一个节点
    public Node removeFirst() {
        if(head.next == tail) return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    // 返回链表长度
    public int size() {return size;}
}