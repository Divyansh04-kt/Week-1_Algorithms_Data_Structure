
package com.financial.forecasting;
import java.util.*;

public class FinancialForecasting {
	public static double calculateFutureValue(double currentvalue, double growthrate, int years) {
		if(years == 0) {
			return currentvalue;
		}
		else {
			return calculateFutureValue(currentvalue*(1+growthrate), growthrate, years-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double initialvalue;
		double growthrate;
		int years;
		
		System.out.println("Enter the current value : ");
		initialvalue = sc.nextDouble();
		
		System.out.println("Enter the growth rate : ");
		growthrate = sc.nextDouble();
		
		System.out.println("Enter the number of years : ");
		years = sc.nextInt();
		
		double futurevalue = calculateFutureValue(initialvalue, growthrate, years);
		System.out.printf("Future Value after %d years: %.2f\n", years, futurevalue);
	}
}
