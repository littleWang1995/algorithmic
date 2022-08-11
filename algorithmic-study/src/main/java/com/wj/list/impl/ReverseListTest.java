package com.wj.list.impl;

import com.wj.list.entity.ListNode;
import com.wj.list.util.ListUtils;

/**
 * 翻转链表
 */
public class ReverseListTest {
    public static void main(String[] args) {
        int[] arrays = new int[]{3, 4, 5, 6, 1};
        ListNode listNode = ListUtils.generateListNode(arrays,false);
//        ListNode result = reverseList(listNode);
        ListNode result = reverseList1(listNode);
        while (result!=null){
            System.out.println(result.getValue());
            result = result.getNext();
        }

    }

    private static ListNode reverseList(ListNode listNode) {
        ListNode pre = null;
        ListNode cur = listNode;
        while (cur != null){
            //暂存下一个节点
            ListNode temp = cur.getNext();
            //翻转，指向前一个节点
            cur.setNext(pre);
            //移动pre指向
            pre = cur;
            //移动cur指向
            cur = temp;
        }
        return pre;
    }

    private static ListNode reverseList1(ListNode listNode) {
        ListNode pre = null;
        ListNode cur = listNode;
        return reverse(pre,cur);
    }

    private static ListNode reverse(ListNode pre,ListNode cur){
        if (cur == null){
            return pre;
        }

        ListNode temp = cur.getNext();
        cur.setNext(pre);

        return reverse(cur,temp);
    }
}
