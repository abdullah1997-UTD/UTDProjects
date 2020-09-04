/*The project is a flash card where the user begins with typing their name in. 
 * After that they select what kind of Mathematical operation they would like to do, 
 * including Addition, Subtraction, Multiplication and Division. 
 * They can only select one operation per run of the program. After that, it will ask the user for the 
 * highest and lowest number of factors they would like to be involved in the math problems. Following that, 
 * they will be asked to input the number of problems they would like to solve.
 * It will then directly process the information and output a question to the user. 
 * If the user is correct, it will print out “Correct”, else it will say “Incorrect”. 
 * After going through the number of problems (iterations) that the user wanted, it will go the Session Summary 
 * where it will state the number of problems done, the number of correct answer, a score, the amount of time taken to complete 
 * the game along with the User’s name, the type of operation they did, and the date and time.
 */
import java.util.*;  // Importing Keyboard input.
import java.util.Random; // Importing Random generator
import java.util.concurrent.TimeUnit; // Importing TimeUnit conversion system.


public class Project1_FlashCardGame {
	
	public static void main(String[] args) {
		// Design Outline
		Scanner scan = new Scanner(System.in); // Initializing keyboard input called "scan" for the main method.
				// Main method
	
				// Get input values
				String name = getName(); 		 // Initializing String "name" and Invoking getName method to get name
				String ops = getOperation();	 // Initializing String "ops" and Invoking getOperation method to get the type of math operation
				String caseName = null;			 // Initializing a string as caseName to let user know what operation they undertook.
				int maxRange = getMaxRange();    //	Initializing integer maxRange for the highest digit user wants to use and invoking getMaxRange method
				int minRange = getMinRange();    // Initializing integer maxRange for the lowest digit user wants to use and invoking getMinRange method
				int sysAns = 0;					 // Initializing integer sysAns, which is the Answer the system will calculate
				int userAns = 0;				 // Initializing integer useAns, which is the Answer the user will input
				int userScore = 0;				 // Initializing integer userScore, which is the Score for correct answers.
				int numProblem = getProbNum();	 //	Number of Problems the user wants to do.
				
				long startTime = System.currentTimeMillis();  // Starting time for the clock when the user starts the application.
				
				// For Loop to keep the application running for whatever number of executions needed that the user inputs for the numProblem.
				for (int i = numProblem; i > 0; i--) { //i is number of instances which will decrease till i becomes 0 and then the loop will not execute anymore.
					
				int rand1 = getRand1(maxRange, minRange); // initializing rand1 to get a random number from getRand1 method
				int rand2 = getRand2(maxRange, minRange); // initializing rand2 to get a random number from getRand2 method
				
				
				/* Operation cases (switch) for string ops. In the getOperation method, user will select what Operation they want
				 * to do. 
				 */
				switch (ops) 
				
				{
				
				//  Addition: If user presses A for input, it will start case 'A', for Addition.
					case "A":{
						caseName = "Addition"; // Case name Addition activated for the Session Summary. It is a permanent variable.
						System.out.print(rand1 + " + " + rand2 + " = "); // Math Addition question displayed to the user.
						sysAns = rand1 + rand2; // System calculates the Addition problem, but does not show to user.
						break; // Stops the case here and does not let it flow to the next Case, as it will execute unwanted code.
					}
				
				//  Subtraction: If user presses S for input, it will start case 'S', for Subtraction.
					case "S": {	
						caseName = "Subtraction";	// Case name Subtraction activated for the Session Summary. It is a permanent variable.	
						int minuend = rand1 + rand2; // Initializing minuend variable to add the two generated numbers for the user. Not visible to user.
						System.out.print(minuend + " - " + rand2 + " = "); // Math Subtraction question displayed to the user.
						sysAns = minuend - rand2;	// System calculates the Subtraction problem, but does not show to user.
						break; // Stops the case here and does not let it flow to the next Case, as it will execute unwanted code.
					}
				
				//  Multiplication: If user presses M for input, it will start case 'M', for Multiplication.
					case "M":{
						caseName = "Multiplication"; // Case name Multiplication activated for the Session Summary. It is a permanent variable.
						System.out.print(rand1 + " * " + rand2 + " = "); // Math multiplication question displayed to the user.
						sysAns = rand1 * rand2; // System calculates the multiplication problem, but does not show to user.
						break; // Stops the case here and does not let it flow to the next Case, as it will execute unwanted code.
					}
				
				//  Division: If user presses D for input, it will start case 'D', for Division.
					case "D": {
						caseName = "Division"; // Case name Division activated for the Session Summary. It is a permanent variable.
						int product = 0; // Initializing a product variable
						product = rand1 * rand2; // Multiplying the two values and saving it in product, not visible to user.
						System.out.print(product + " / " + rand2 + " = "); // Math Division question displayed to the user.	The math problem will be the product value divided by rand2 value.	
						sysAns = product / rand2; // Calculates and sysAns for the user.	
						break; // Stops the case here and does not let it flow to the next Case, as it will execute unwanted code.
					}
				
				
				}
			
				userAns = scan.nextInt(); // Answer that the user inputs
				
			    // If-else condition
				if (userAns == sysAns) { // If the user input and the system answer are equal, it will print out Correct on the screen
					System.out.println("Correct.");
					userScore++; // With correct answer, it will also increase the user's score.
				} 
				else {
					System.out.println("Incorrect"); // Else it will print Incorrect and not increase the user score.
				}
				}
		
				int percent = (int) ((userScore*100) / numProblem); // Calculation of the percentage the user scored. Answer will come out in percentage, not decimal.
				long endTime = System.currentTimeMillis(); // Program ending time counted in millisecond.
				
				long totalTime = endTime - startTime; // Calculation of how long the program ran or how long it took the user to complete the game.
				double totalTimeinSeconds = (double) TimeUnit.MILLISECONDS.toSeconds(totalTime); // The time counted in milliseconds is converted to seconds.
				
				//  Session summary				
				System.out.println("\n" + "Session Summary" + "\n"); // Session Summary headline printed to the user
				System.out.println(numProblem + " problems, " + userScore + " correct"); // Prints the number of problems the user wanted to do and the number of answer they got correct.
				System.out.println("Score is " + Math.ceil(percent) + ", Time is " + Math.round(totalTimeinSeconds) + " seconds"); //Prints the score in percentage and the time it took the user.
				System.out.println("Session for " + name + " was " + caseName + " on " + java.time.LocalDate.now() + " at " + java.time.LocalTime.now()); // Prints the name of the user, the date and time the game was run.
				
	
				scan.close(); // Closing the keyboard input for the main method.
	}
	
				// *****  Methods are below  ******
				// getName – method to get the name of the user
			public static String getName() { // getName method to ask user for their name
				Scanner input = new Scanner(System.in); // Initializing input for getName method
				System.out.print("Enter your name: "); // Printing out on the screen asking user to enter their name
				String mName = input.next(); // user inputs their name
				return mName; // the string is returns to the main method with the user name
				}
	
			
				// getOperation – method to get the operation for the session
			public static String getOperation() { // getOperation method to ask user for the type of math problems they want to do.
				Scanner input = new Scanner(System.in); // Initializing input for getOperation method
				System.out.print("Enter 'A' for Addition, 'S' for Subtraction, 'M' for Multiplication, 'D' for Division: "); // Printing out operation options to user
				String mOps = input.next(); // User inputs their choice of operation
				return mOps.toUpperCase(); // the string returns to the main method as an uppercase even if the user inputs a lower case
				}
			
			
			public static int getProbNum() { // getProbNum method to ask user the number of math problems they want to solve.
				Scanner input = new Scanner(System.in); // Initializing input for getProbNum method
				System.out.print("Please tell me the number of problem you want to do: "); // Asking user by printing out
				int mProbNum = input.nextInt(); // User inputs number of problems they want to solve	
				return mProbNum; // Integer value returns from the method to the main method
				}	
			
			// HIGHEST Number
			public static int getMaxRange() { // Method to ask user for the highest integer they can be asked.
				Scanner input = new Scanner(System.in); // Initializing input for getMaxRange method
				System.out.print("Please tell me your highest number: "); // Asking user their highest number by printing out
				int mMaxRange = input.nextInt(); // User enters max value they can be asked.				
				return mMaxRange; // Integer value returns from the method to the main method.
				}
			
			// Lowest Number
			public static int getMinRange() {
				Scanner input = new Scanner(System.in); // Initializing input for getMinRange method
				System.out.print("Please tell me your lowest number: "); // Asking user their lower number by printing out
				int mMinRange = input.nextInt(); // User  enters min value they can be asked.
				return mMinRange; // Integer value returns from the method to the main method.
			}
			
			public static int getRand1(int maxRange, int minRange) { // getRand1 method to get random number 1 from the range.
				Random generator = new Random(); // Random number generator initialized
				int mRand1 = (int) (Math.random() * (maxRange - minRange + 1) + minRange); // random number 1 generated
				return mRand1; // random number 1 returned to the main method
			}
			
			public static int getRand2(int maxRange, int minRange) { // getRand1 method to get random number 2 from the range.
				Random generator = new Random(); // Random number generator initialized
				int mRand2; // Starting variable mRand2.
				mRand2 = (int) (Math.random() * (maxRange - minRange + 1) + minRange); // random number 2 generated	
				do 
				{
					mRand2 = (int) (Math.random() * (maxRange - minRange + 1) + minRange); // random number 2 generated	
				} while (mRand2 == 0); // do-while loop to prevent any 0 value to be made, as it will crash
				return mRand2; // random number 2 returned to the main method		
			}
			
			
				// getProbNum
			
	}
	
	
	
	/* SAMPLE TEST
	* Enter your name: Mohammed
	* Enter 'A' for Addition, 'S' for Subtraction, 'M' for Multiplication, 'D' for Division: d
	* Please tell me your highest number: 10
	* Please tell me your lowest number: 0
	* Please tell me the number of problem you want to do: 5
	* 60 / 6 = 10
	* Correct.
	* 14 / 2 = 7
	* Correct.
	* 50 / 10 = 5
	* Correct.
	* 21 / 3 = 7
	* Correct.
	* 9 / 1 = 9
	* Correct.
	
	* Session Summary
	
	* 5 problems, 5 correct
	* Score is 100.0, Time is 12 seconds
	* Session for Mohammed was Division on 2020-09-04 at 14:02:38.799
	*/