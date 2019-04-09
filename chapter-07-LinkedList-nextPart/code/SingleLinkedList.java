package com.demo.structures.linkedlist;

/**
 * 单链表操作
 *
 * @author guopeng
 * @create 2019/4/9
 */
public class SingleLinkedList {

    /**
     * 单链表反转
     *
     * @param curr 待反转链表
     * @return 反转后的链表
     */
    public static SingleLinkedNode reverse(SingleLinkedNode curr) {
        SingleLinkedNode newNode = null;
        SingleLinkedNode nextNode;

        // 当前结点不为空，则进行结点搬移
        while (curr != null) {
            // 记录临时结点 nextNode，标识为当前结点的下一个结点
            nextNode = curr.getNext();
            // 将当前结点的 next 指向 newNode
            curr.setNext(newNode);
            // 将 newNode 指向当前结点
            newNode = curr;
            // 将当前结点指向临时结点 nextNode
            curr = nextNode;
        }

        return newNode;
    }

    public static void main(String[] args) {
        SingleLinkedNode list = new SingleLinkedNode();
        list.addToHead(new SingleLinkedNode(null, 3));
        list.addToHead(new SingleLinkedNode(null, 2));
        list.addToHead(new SingleLinkedNode(null, 1));
        list.print();
        list = reverse(list);
        list.print();

    }
}
