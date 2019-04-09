package com.demo.structures.linkedlist;

import lombok.Data;

/**
 * 单链表结点数据结构
 *
 * @author guopeng
 * @create 2019/4/9
 */
@Data
public class SingleLinkedNode {
    private SingleLinkedNode next;
    private int data;

    /**
     * 默认空链表构造方法
     */
    public SingleLinkedNode() {
        this(null, -1);
    }

    /**
     * 指定参数的构造方法
     *
     * @param next 下一节点
     * @param data 当前结点值
     */
    public SingleLinkedNode(SingleLinkedNode next, int data) {
        this.next = next;
        this.data = data;
    }

    /**
     * 将新节点加到头部
     *
     * @param node 新节点
     */
    public void addToHead(SingleLinkedNode node) {
        if (null == node) {
            throw new IllegalArgumentException("新增头结点不可为空");
        }

        node.setNext(this.getNext());
        this.setNext(node);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList content: [").append(this.getData());
        SingleLinkedNode next = this.getNext();
        while (next != null) {
            sb.append(",").append(next.getData());
            next = next.getNext();
        }
        sb.append("]");
        System.out.println(sb);
    }
}
