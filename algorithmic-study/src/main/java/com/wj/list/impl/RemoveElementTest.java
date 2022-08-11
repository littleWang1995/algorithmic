package com.wj.list.impl;

import com.wj.list.entity.ListNode;

/**
 * 移除链表中的指定元素
 *
 * 添加虚拟头结点保证所有节点的处理逻辑是一样的
 * 不添加头结点的方式，先处理一遍链表保证头结点不是目标元素，后续的操作和添加虚拟头结点的方式一样
 */
public class RemoveElementTest {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2,listNode);
        ListNode listNode2 = new ListNode(4,listNode1);
        ListNode listNode3 = new ListNode(6,listNode2);
        ListNode listNode4 = new ListNode(3,listNode3);
        ListNode listNode5 = new ListNode(2,listNode4);

//        ListNode result =  removeElementWithDummy(listNode5,2);
        ListNode result =  removeElement(listNode5,2);
        while (result != null){
            System.out.println(result.getValue());
            result = result.getNext();
        }
    }

    private static ListNode removeElement(ListNode listNode, Integer target) {
        //先遍历排除目标元素，保证头结点不是目标元素
        while (listNode != null && listNode.getValue() == target){
            listNode = listNode.getNext();
        }

        if (listNode == null){
            return listNode;
        }

        ListNode pre = listNode;
        ListNode cur = listNode.getNext();

        while (cur != null){
            if (cur.getValue() == target){
                //移除元素的操作，即把【当前元素的上一个元素】的指针指向【当前元素的下一个元素】，完成当前元素的移除
                pre.setNext(cur.getNext());
            }else {
                //当前元素设置为前一个元素
                pre = cur;
            }
            //【当前元素的下一个元素】设置为当前元素
            cur = cur.getNext();
        }

        return listNode;
    }

    /**
     * 添加虚拟头结点的方式
     * @param listNode
     * @return
     */
    private static ListNode removeElementWithDummy(ListNode listNode,Integer target) {
        if (listNode == null){
            return listNode;
        }

        //定义一个虚拟头结点，指向第一个元素
        ListNode dummy  = new ListNode(-1,listNode);

        ListNode cur = dummy.getNext();//当前正在操作的节点
        ListNode pre = dummy;//前一个节点

        while (cur != null){
            if (cur.getValue() == target){
                //移除元素的操作，即把【当前元素的上一个元素】的指针指向【当前元素的下一个元素】，完成当前元素的移除
                pre.setNext(cur.getNext());
            }else {
                //当前元素设置为前一个元素
                pre = cur;
            }
            //【当前元素的下一个元素】设置为当前元素
            cur = cur.getNext();
        }

        return dummy.getNext();
    }
}
