package main

func maxProfit(prices []int) int {
	purchasePrice := prices[0]
	maxProfit := 0

	for _, price := range prices[1:] {
		if price < purchasePrice {
			purchasePrice = price
		}
		currentProfit := price - purchasePrice
		maxProfit = Max(currentProfit, maxProfit)
	}

	return maxProfit
}

func Max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
