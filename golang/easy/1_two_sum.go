package main

func twoSum(nums []int, target int) []int {
	result := make([]int, 2)
	memory := make(map[int]int)

	for index, value := range nums {
		reminder := target - value
		if v, present := memory[reminder]; present {
			result[0] = index
			result[1] = v
			return result
		} else {
			memory[value] = index
		}
	}
	return result
}

func twoSumNew(nums []int, target int) []int {
	memory := make(map[int]int)

	for index, value := range nums {
		reminder := target - value
		if v, present := memory[reminder]; present {
			return []int{index, v}
		} else {
			memory[value] = index
		}
	}
	return nil
}
