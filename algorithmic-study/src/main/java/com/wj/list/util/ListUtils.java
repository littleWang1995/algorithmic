package com.wj.list.util;

import com.wj.list.entity.ListNode;

public class ListUtils {

    /**
     * 生成一个链表
     * @return
     */
    public static ListNode generateListNode(int[] values, boolean addVirtualHeadListNode){
        ListNode head = new ListNode(0);

        ListNode temp = head;
        for (int a : values){
            ListNode listNode = new ListNode(a);
            temp.setNext(listNode);
            temp = listNode;
        }
        return addVirtualHeadListNode ? head : head.getNext();
    }
}
