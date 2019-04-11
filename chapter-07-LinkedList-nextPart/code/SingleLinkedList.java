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

    /**
     * 链表是否含有环
     * 快慢指针算法：当进入环之后，快的指针最终一定会追上慢的指针
     *
     * @param list 待检测链表
     * @return 是否包含环
     */
    public static boolean checkCircle(SingleLinkedNode list) {
        // 待检测为空，则不存在环
        if (list == null) {
            return false;
        }

        // 慢指针，每次移动一步
        SingleLinkedNode slow = list;
        // 快指针，每次移动两步
        SingleLinkedNode fast = list.getNext();

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = list.getNext();
            fast = list.getNext().getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLinkedNode list = new SingleLinkedNode(null, 1);
        list.addTail(new SingleLinkedNode(null, 2));
        list.addTail(new SingleLinkedNode(null, 3));
        list.addTail(new SingleLinkedNode(null, 4));
        list.print();
        list = reverse(list);
        list.print();

        SingleLinkedNode circleList = new SingleLinkedNode(null, 1);
        SingleLinkedNode circleIn = new SingleLinkedNode(null, 2);
        SingleLinkedNode circleSec = new SingleLinkedNode(null, 3);
        circleList.addTail(circleIn);
        circleIn.setNext(circleSec);
        circleSec.setNext(circleIn);
        System.out.println("checkCircle: " + checkCircle(circleList));

    }
}
