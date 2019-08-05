/*	Filename: AcmePay.java
	Date: 8/2/2019
	Author: David T.
	
	description...
*/

import java.util.Scanner;

public class AcmePay
{
	
	private static final double PAYRATE_FIRST = 17.0;
	private static final double PAYRATE_SECOND = 18.5;
	private static final double PAYRATE_THIRD = 22.0;
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int shiftWorked;
		String shiftString;
		double hoursWorked;
		double hoursWorkedOvertime = 0.0;
		double payRate;
		double payHourly;
		double payOvertime;
		double deduction = 0;
		double netPay;
		boolean retirementPlan = false;
		
		System.out.print("\nWhich shift have you worked?\n1: First Shift\n2: Second Shift\n3: Third Shift\n\n>> ");
		shiftWorked = keyboard.nextInt();
		
		System.out.print("\nHow many hours have you worked this week?\n\n>> ");
		hoursWorked = keyboard.nextDouble();
		
		if(shiftWorked == 1)
		{
			shiftString = "First Shift";
			payRate = PAYRATE_FIRST;
			
		}
		else if(shiftWorked == 2)
		{
			shiftString = "Second Shift";
			payRate = PAYRATE_SECOND;
			
		}
		else if(shiftWorked == 3)
		{
			shiftString = "Third Shift";
			payRate = PAYRATE_THIRD;
			
		}
		else
		{
			System.out.print("\nInvalid shift.");
			shiftString = "";
			payRate = 1;
		}
		
		if(shiftWorked == 2 || shiftWorked == 3)
		{
			System.out.print("\nDo you participate in the company retirement plan?\n1: Yes\n2: No\n\n>> ");
			retirementPlan = (keyboard.nextInt() == 1);
		}
		
		System.out.println();
		System.out.println("Hours Worked:            "+hoursWorked+ ((hoursWorked > 79)?" (get a new job)":""));
		
		if(hoursWorked > 40.0)
		{
			hoursWorkedOvertime = hoursWorked-40.0;
			hoursWorked -= hoursWorkedOvertime;
		}
		
		
		payHourly = payRate*hoursWorked;
		payOvertime = (payRate*hoursWorkedOvertime)*1.5;
		
		if(retirementPlan) deduction = (payHourly+payOvertime)*0.03;
		
		System.out.println("Shift:                   "+shiftString);
		System.out.println("Hourly Pay Rate:         "+asCash(payRate));
		System.out.println("Regular Pay:             "+asCash(payHourly));
		System.out.println("Overtime Pay:            "+asCash(payOvertime));
		System.out.println("Total Pay:               "+asCash(payHourly+payOvertime));
		if(retirementPlan) System.out.println("Retirement Deduction:   -"+asCash(deduction));
		System.out.println("-------------------------------------");
		System.out.println("Net Pay:                 "+asCash((payHourly+payOvertime)-deduction));
	}
	
	private static String asCash(double value)
	{
		return "$"+String.format("%.2f",value);
	}
}