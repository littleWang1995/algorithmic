package com.wj.list.impl;

import com.wj.list.entity.ListNode;

import java.util.LinkedList;

/**
 * 设计一个链表，包含以下操作：
 * 获取链表第index个节点的数值
 * 在链表的最前面插入一个节点
 * 在链表的最后面插入一个节点
 * 在链表第index个节点前面插入一个节点
 * 删除链表的第index个节点
 */
public class DesignLinkList {

    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.addNodeAtFirst(5);
        myLinkList.addNodeAtTail(8);
        myLinkList.addNodeAtIndex(2,7);
        int i = myLinkList.get(0);
        System.out.println(i);

        myLinkList.deleteNode(1);
        int j = myLinkList.get(1);
        System.out.println(j);
    }

}

class MyLinkList{

    int size;

    ListNode head;

    public MyLinkList() {
        this.size = 0;
        head = new ListNode(0);
    }

    /**
     * 在第index个节点前增加一个节点
     * 如果index为0，新增的节点为头结点
     * 如果index为size，新增的节点为尾节点
     * @param index
     * @param val
     * @return
     */
    public int addNodeAtIndex(int index, int val){
        if (index > size || index < 0){
            return -1;
        }

        //找到要插入节点的前驱!!!
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.getNext();
        }

        ListNode listNode = new ListNode(val);
        listNode.setNext(pre.getNext());
        pre.setNext(listNode);

        size++;

        return 1;
    }

    public void addNodeAtFirst(int val){
        addNodeAtIndex(0,val);
    }

    public void addNodeAtTail(int val){
        addNodeAtIndex(size,val);
    }

    /**
     * 删除第index个节点
     * @param index
     */
    public int deleteNode(int index){
        if (index > size || index < 0){
            return -1;
        }
        //找到要删除节点的前驱
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.getNext();
        }

        pre.setNext(pre.getNext().getNext());

        size--;

        return 1;
    }



    public int get(int index){
        if (index >= size || index < 0){
            return -1;
        }

        ListNode cur = head;
        for (int i = 0; i <= index; i++) {//因为包含了虚拟头结点，所以要遍历index+1个元素
            cur = cur.getNext();
        }
        return cur.getValue();
    }

}
