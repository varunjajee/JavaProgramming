package com.muks.Algorithm.AlgosOnArrays.Basics;

public class TwoMissingNumberFrom0To100 {
	/*
	sum - sum2 = a + b
			sq_sum - sq_sum2 = a^2 + b^2

			(a + b)(a + b) = a^2 + b^2 + 2ab
			(a + b)(a + b) - (a^2 + b^2) = 2ab
			(sum*sum - sq_sum) = 2ab

			(a - b)(a - b) = a^2 + b^2 - 2ab
			               = sq_sum - (sum*sum - sq_sum) = 2sq_sum - sum*sum
			sqrt(2sq_sum - sum*sum) = sqrt((a - b)(a - b)) = a - b
			((a + b) - (a - b)) / 2 = b
			(a + b) - b = a


	Let a and b are the missing numbers.
	{
		Sum of 100 num = Sum of 98 num + a +b
		=> a + b = (Sum of 100 num ) - (Sum of 98 num ) = x suppose
		
		Product of 100 num = Product of 98 num * a *b
		=> a*b = Product of 100 num /Product of 98 num = y suppose
		
		x and y are known. We need to find a and b
		
		a+b = x -----1
		a*b = y .......2
		
		(a-b)^2 = (a+b)^2 - 4ab
		From 1 and 2
		=> a-b = sqrt(x^2 - 4y) = z suppose
		a + b = x
		
		=> a = (x+z)/2
		b = x - b
	} 

	 */	

}
