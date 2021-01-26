package main

func merge(nums1 []int, m int, nums2 []int, n int) {

	pointer1 := m - 1
	pointer2 := n - 1
	index := len(nums1) - 1

	for pointer1 >= 0 && pointer2 >= 0 {
		if nums1[pointer1] > nums2[pointer2] {
			nums1[index] = nums1[pointer1]
			pointer1--
		} else {
			nums1[index] = nums2[pointer2]
			pointer2--
		}
		index--
	}

	for pointer1 >= 0 {
		nums1[index] = nums1[pointer1]
		pointer1--
		index--
	}

	for pointer2 >= 0 {
		nums1[index] = nums2[pointer2]
		pointer1--
		index--
	}

}
