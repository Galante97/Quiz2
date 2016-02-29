package mainPackage;
import java.util.Scanner;
import org.junit.Test;

/**
 * @author James
 */


public class quiz_2 {
	static Scanner userInput = new Scanner(System.in);

	//user input varibles
	private static double tuition;
	private static double percentIncrease;
	private static double APR;
	private static double repaymentYears;

	//calculated Variables
	private static double paybackMonthly;
	private static double priceOver4Years;
	
	/**
	 * Main method starting the program
	 * @param args
	 */
	public void main(String[] args) {
		getAmounts();
		
	}

	/**
	 * This method asks the users for there tuition,
	 * percent Increase of price per year, there APR, and how many years they want to pay.
	 * 
	 */
	
	 
	public static void getAmounts() {
		try {
			System.out.println("Enter yearly tuition: ");
			String tuit = userInput.next();
			tuition = Double.parseDouble(tuit);
			
			System.out.println("Enter the yearly percentage increase: ");
			String per = userInput.next();
			percentIncrease = Double.parseDouble(per);
			
			System.out.println("Enter you apr: ");
			String a = userInput.next();
			APR = Double.parseDouble(a);

			System.out.println("Enter how many years you want to pay off your student debt: ");
			String d = userInput.next();
			repaymentYears = Double.parseDouble(d);
			
			System.out.println(tuition);
			System.out.println(percentIncrease);
			System.out.println(APR);
			System.out.println(repaymentYears);
			
			
			
		} catch (NumberFormatException e) {
			System.out.println("Error. Please enter numbers");
			getAmounts();
		}
	}
	
	/**
	 * This method calculates the price of college after four years.
	 */
	@Test
	public void calculatePrice() {
		percentIncrease = percentIncrease/100;
		priceOver4Years = tuition * (((Math.pow(1+percentIncrease , 4)) - 1) *(1/percentIncrease));		
		priceOver4Years = Math.round(priceOver4Years * 100.0) / 100.0;
		System.out.println("Price at the end of 4 years $" + priceOver4Years);

		calculateMonthlyPayback();
	}
	
	
	/**
	 * This method calculates the the monthly payback after college.
	 */
	@Test
	public void calculateMonthlyPayback() {
		//SaveMonthly = TotalSaving*(((AnnualReturn/100)/12)/((Math.pow(1+(AnnualReturn/100)/12, numberOfYears*12))-1));
		paybackMonthly = priceOver4Years*(((APR/100)/12)/((Math.pow(APR/100/12, repaymentYears*12))-1));
		paybackMonthly = Math.abs(paybackMonthly);
		paybackMonthly = Math.round(paybackMonthly * 100.0) / 100.0;

		System.out.println("you will pay, $" + paybackMonthly + " per month for " + repaymentYears + " years.");

		
	}
	
	
	
	
}
