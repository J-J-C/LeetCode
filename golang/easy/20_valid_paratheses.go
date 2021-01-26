package main

func isValid(s string) bool {
	array := make([]rune, len(s))

	for _, c := range s {
		if c == '(' || c == '{' || c == '[' {
			array = append(array, c)
		} else if c == ')' || c == ']' || c == '}' {
			if len(array) == 0 {
				return false
			}
			if c == ')' {
				if array[len(array)-1] != '(' {
					return false
				} else {
					array = array[:len(array)-1]
				}
			} else if c == ']' {
				if array[len(array)-1] != '[' {
					return false
				} else {
					array = array[:len(array)-1]
				}
			} else if c == '}' {
				if array[len(array)-1] != '{' {
					return false
				} else {
					array = array[:len(array)-1]
				}
			}
		}
	}
	return len(array) == 0
}
