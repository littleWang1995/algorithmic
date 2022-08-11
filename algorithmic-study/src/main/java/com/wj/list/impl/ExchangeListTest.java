package com.wj.list.impl;

import com.wj.list.entity.ListNode;
import com.wj.list.util.ListUtils;

/**
 * 两两交换链表的两个节点
 */
public class ExchangeListTest {
    public static void main(String[] args) {
       int[] a = new int[]{2,3,5,4,8,9};
        ListNode listNode = ListUtils.generateListNode(a, false);
        ListNode result = exchangeListNode(listNode);
        while (result!=null){
            System.out.println(result.getValue());
            result = result.getNext();
        }

    }

    private static ListNode exchangeListNode(ListNode head) {
        ListNode dummyNode = new ListNode(0);//虚拟头结点
        dummyNode.setNext(head);

        ListNode pre = dummyNode;//当前节点的上一个节点

        while (pre.getNext() != null && pre.getNext().getNext() != null){
            ListNode next = head.getNext().getNext();//暂存
            pre.setNext(head.getNext());
            head.getNext().setNext(head);
            head.setNext(next);

            pre = head;
            head = head.getNext();
        }

        return dummyNode.getNext();
    }
}
