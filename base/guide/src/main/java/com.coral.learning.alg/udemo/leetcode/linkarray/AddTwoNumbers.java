package com.coral.learning.alg.udemo.leetcode.linkarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(8);
        init(l1, 4);
        init(l2, 3);
        print(l1);
        print(l2);
        addTwoNumbers(l1, l2);
        print(l1);
    }

    public ListNode addTwoNumbersLc(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header1 = l1;
        ListNode header2 = l2;
        ListNode header = null;
        ListNode last = null;
        if (header1 == null && header2 == null){
            return null;
        }
        int h = 0;
        while (header1 != null || header2 != null){
            if (header1 == null){
                header2.val = header2.val + h;
                h = header2.val / 10;
                int l = header2.val % 10;
                header2.val = l;
                last = header2;
                header2 = header2.next;
                header = l2;

            } else if(header2 == null){
                header1.val = header1.val + h;
                h = header1.val / 10;
                int l = header1.val % 10;
                header1.val = l;
                last = header1;
                header1 = header1.next;
                header = l1;
            } else {
                header1.val = header1.val + header2.val + h;
                h = header1.val / 10;
                int l = header1.val % 10;
                header1.val = l;
                header2.val = header1.val;
                last = header1;
                header1 = header1.next;
                header2 = header2.next;
                header = l1;
            }
        }
        if(h == 1){
            last.next = new ListNode(h);
        }
        return header;
    }
    static void init(ListNode listNode, int size){
        ListNode tmp = listNode;
        while (size > 0){
            ListNode listNode1 = new ListNode(new Random().nextInt(9));
            tmp.next = listNode1;
            tmp = listNode1;
            size--;
        }

    }
    static void print(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 解决方案

     方法：初等数学

     思路

     我们使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。

     Illustration of Adding two numbers

     图1，对两数相加方法的可视化:
     3
     4
     2
     +
     4
     6
     5
     =
     8
     0
     7
     342+465=807， 每个结点都包含一个数字，并且数字按位逆序存储。

     算法

     就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表
     l
     1
     l1 和
     l
     2
     l2 的表头开始相加。由于每位数字都应当处于
     0
     …
     9
     0…9 的范围内，我们计算两个数字的和时可能会出现“溢出”。例如，
     5
     +
     7
     =
     1
     2
     5+7=12。在这种情况下，我们会将当前位的数值设置为
     2
     2，并将进位
     c
     a
     r
     r
     y
     =
     1
     carry=1 带入下一次迭代。进位
     c
     a
     r
     r
     y
     carry 必定是
     0
     0 或
     1
     1，这是因为两个数字相加（考虑到进位）可能出现的最大和为
     9
     +
     9
     +
     1
     =
     1
     9
     9+9+1=19。

     伪代码如下：

     将当前结点初始化为返回列表的哑结点。
     将进位
     c
     a
     r
     r
     y
     carry 初始化为
     0
     0。
     将
     p
     p 和
     q
     q 分别初始化为列表
     l
     1
     l1 和
     l
     2
     l2 的头部。
     遍历列表
     l
     1
     l1 和
     l
     2
     l2 直至到达它们的尾端。
     将
     x
     x 设为结点
     p
     p 的值。如果
     p
     p 已经到达
     l
     1
     l1 的末尾，则将其值设置为
     0
     0。
     将
     y
     y 设为结点
     q
     q 的值。如果
     q
     q 已经到达
     l
     2
     l2 的末尾，则将其值设置为
     0
     0。
     设定
     s
     u
     m
     =
     x
     +
     y
     +
     c
     a
     r
     r
     y
     sum=x+y+carry。
     更新进位的值，
     c
     a
     r
     r
     y
     =
     s
     u
     m
     /
     1
     0
     carry=sum/10。
     创建一个数值为
     (
     s
     u
     m
     1
     0
     )
     (summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     同时，将
     p
     p 和
     q
     q 前进到下一个结点。
     检查
     c
     a
     r
     r
     y
     =
     1
     carry=1 是否成立，如果成立，则向返回列表追加一个含有数字
     1
     1 的新结点。
     返回哑结点的下一个结点。
     请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。

     请特别注意以下情况：

     测试用例	说明
     l
     1
     =
     [
     0
     ,
     1
     ]
     l1=[0,1]
     l
     2
     =
     [
     0
     ,
     1
     ,
     2
     ]
     l2=[0,1,2]	当一个列表比另一个列表长时。
     l
     1
     =
     [
     ]
     l1=[]
     l
     2
     =
     [
     0
     ,
     1
     ]
     l2=[0,1]	当一个列表为空时，即出现空列表。
     l
     1
     =
     [
     9
     ,
     9
     ]
     l1=[9,9]
     l
     2
     =
     [
     1
     ]
     l2=[1]	求和运算最后可能出现额外的进位，这一点很容易被遗忘
     复杂度分析

     时间复杂度：
     O
     (
     max
     (
     m
     ,
     n
     )
     )
     O(max(m,n))，假设
     m
     m 和
     n
     n 分别表示
     l
     1
     l1 和
     l
     2
     l2 的长度，上面的算法最多重复
     max
     (
     m
     ,
     n
     )
     max(m,n) 次。

     空间复杂度：
     O
     (
     max
     (
     m
     ,
     n
     )
     )
     O(max(m,n))， 新列表的长度最多为
     max
     (
     m
     ,
     n
     )
     +
     1
     max(m,n)+1。

     拓展

     如果链表中的数字不是按逆序存储的呢？例如：

     (
     3
     →
     4
     →
     2
     )
     +
     (
     4
     →
     6
     →
     5
     )
     =
     8
     →
     0
     →
     7
     (3→4→2)+(4→6→5)=8→0→7
     *

     */



}
