# 原题
把一个有序链表中所有重复的数字全部删光，删除后不再有原先重复的那些数字。

注意点：

  - 头节点也可能是重复的对象

例子：

输入: 1->1->2->3->3

输出: 2

# 解题思路
这道题与[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/)的区别
就是要把所有重复的node删除。因此，还是利用[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/)中去重的方法，
引用双指针，并且增加一个新的指针，指向当前的前一个node，使用3个指针（prev，current，post）来遍历链表。 

最开始还是需要建立一个fakehead，让fakehead的next指向head。然后，使用我刚才说过的3个指针方法来初始化3个指针，如下： 

```java
  ListNode ptr0 = fakehead; //prev
  ListNode ptr1 = fakehead.next; //current
  ListNode ptr2 = fakehead.next.next; //post
```

同时还需要引入一个布尔型的判断flag，来帮助判断当前是否遇到有重复，这个flag能帮助识别是否需要删除重复。

当没有遇到重复值（flag为false）时，3个指针同时往后移动：

```java
 ptr0 = ptr1;

 ptr1 = ptr2;

 ptr2 = ptr2.next; 
```

当遇到重复值时，设置flag为true，并让ptr2一直往后找找到第一个与ptr1值不等的位置时停止，
这时，ptr1指向的node的值是一个重复值，需要删除，所以这时就需要让ptr0的next连上当前的ptr2，
这样就把所有重复值略过了。然后，让ptr1和ptr2往后挪动继续查找。

这里还需要注意的是，当ptr2一直往后找的过程中，
是有可能ptr2==null（这种情况就是list的最后几个元素是重复的，例如1->2->3->3->null)，
这时ptr1指向的值肯定是需要被删除的，所以要特殊处理，令ptr0的next等于null，把重复值删掉。
其他情况说明最后几个元素不重复，不需要处理结尾，遍历就够了。
