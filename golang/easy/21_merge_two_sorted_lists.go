package main

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{
		Val:  0,
		Next: nil,
	}
	pointer := head

	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			pointer.Next = &ListNode{
				Val:  l1.Val,
				Next: nil,
			}
			l1 = l1.Next
		} else {
			pointer.Next = &ListNode{
				Val:  l2.Val,
				Next: nil,
			}
			l2 = l2.Next
		}
		pointer = pointer.Next
	}

	for l1 != nil {
		pointer.Next = &ListNode{
			Val:  l1.Val,
			Next: nil,
		}
		l1 = l1.Next

		pointer = pointer.Next
	}

	for l2 != nil {
		pointer.Next = &ListNode{
			Val:  l2.Val,
			Next: nil,
		}
		l2 = l2.Next

		pointer = pointer.Next
	}

	return head.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}
