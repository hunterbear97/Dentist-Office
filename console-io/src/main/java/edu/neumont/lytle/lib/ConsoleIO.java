package edu.neumont.lytle.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO {

	//PRO TIP: Make sure to create a new BufferedReader in each method
		//where a BufferedReader is required. Do NOT close the reader as that will cause
        //other issues. Also, catch ALL IOExceptions and NumberFormatExceptions.
        //Do not simply mark the method with a "throws" statement
	
	/**
	 * Generates a console-based menu using the Strings in options as the menu items.
	 * Reserves the number 0 for the "quit" option when withQuit is true.
	 * @param options - Strings representing the menu options
	 * @param withQuit - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 */
	public static int promptForMenuSelection(String[] options, boolean withQuit)
	{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = true;
		int choice = -1;
		int min = 1;
		int max = options.length;
		
		do
		{
			for(int i = 0; i < options.length; i++)
			{
				System.out.println((i+1) + ") " + options[i]);
			}
			
			if (withQuit)
			{
				System.out.println("0) Quit");
				min = 0;
			}
			
			System.out.print("\nInput: ");
			try 
			{
				input = reader.readLine();
				choice = Integer.parseInt(input);
			} 
			catch (IOException ioe) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				ioe.printStackTrace();
			}
			catch(NumberFormatException nfe)
			{
				
			}
			
			isValid = choice >= min && choice <= max;
			if(!isValid)
			{
				System.out.println("Please choose a valid input.");
			}
			
		}while(!isValid);
		return choice;
		
	}
	
	/**
	 * Generates a prompt that expects the user to enter one of two responses that will equate
	 * to a boolean value. The trueString represents the case insensitive response that will equate to true. 
	 * The falseString acts similarly, but for a false boolean value.
	 * 		Example: Assume this method is called with a trueString argument of "yes" and a falseString argument of
	 * 		"no". If the enters "YES", the method returns true. If the user enters "no", the method returns false.
	 * 		All other inputs are considered invalid, the user will be informed, and the prompt will repeat.
	 * @param prompt - the prompt to be displayed to the user
	 * @param trueString - the case insensitive value that will evaluate to true
	 * @param falseString - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 */
	public static boolean promptForBool(String prompt, String trueString, String falseString)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		boolean isValid = false;
		boolean isTrueStatement = false;
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		if(trueString.equalsIgnoreCase(falseString))
		{
			throw new IllegalArgumentException("The true string and false string should be different.");
		}
		
		if(trueString.isEmpty() || falseString.isEmpty() || trueString.equals(null) || falseString.equals(null))
		{
			throw new IllegalArgumentException("The true and false strings should be filled.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
			}
			catch (IOException ioe) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				ioe.printStackTrace();
			}
			
			isValid = input.equalsIgnoreCase(trueString) || input.equalsIgnoreCase(falseString);
			if(!isValid)
			{
				System.out.println("Please choose either " + trueString + " or " + falseString);
			}
			
		}while(!isValid);
		
		isTrueStatement = input.equalsIgnoreCase(trueString);
		
		
		return isTrueStatement;
		
		
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a byte value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the byte value
	 */
	public static byte promptForByte(String prompt, byte min, byte max)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = true;
		byte num = (byte) (min - 1);
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
				num = Byte.parseByte(input);
			} 
			catch (IOException ioe) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				ioe.printStackTrace();
			}
			catch(NumberFormatException nfe)
			{
				
			}
			
			isValid = num >= min && num <= max;
			
			if (!isValid)
			{
				System.out.println("Please choose a number between " + min + " and " + max);
			}
			
		}while(!isValid);
		
		return (byte) num;
		
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a short value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the short value
	 */
	public static short promptForShort(String prompt, short min, short max)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = false;
		short num = (short) (min - 1);
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		if(min > max)
		{
			throw new IllegalArgumentException("The minimum should be less than the maximum.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
				num = Short.parseShort(input);
			} 
			catch (IOException ioe) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				ioe.printStackTrace();
			}
			catch(NumberFormatException nfe)
			{
				
			}
			
			isValid = num >= min && num <= max;
			
			if (!isValid)
			{
				System.out.println("Please choose a number between " + min + " and " + max);
			}
			
		}while(!isValid);
		
		return (short) num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the int value
	 */
	public static int promptForInt(String prompt, int min, int max)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = true;
		int num = min - 1;
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		if(min > max)
		{
			throw new IllegalArgumentException("The minimum should be less than the maximum.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
				num = Integer.parseInt(input);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				e.printStackTrace();
			}
			catch(NumberFormatException nfe) {
				
			}
			
			isValid = num >= min && num <= max;
			
			if (!isValid)
			{
				System.out.println("Please choose a number between " + min + " and " + max);
			}
			
		}while(!isValid);
		
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a long value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the long value
	 */
	public static long promptForLong(String prompt, long min, long max)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = true;
		long num = min - 1;
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		if(min > max)
		{
			throw new IllegalArgumentException("The minimum should be less than the maximum.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
				num = Long.parseLong(input);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				e.printStackTrace();
			}
			catch(NumberFormatException nfe) {
				
			}
			
			isValid = num >= min && num <= max;
			
			if (!isValid)
			{
				System.out.println("Please choose a number between " + min + " and " + max);
			}
			
		}while(!isValid);
		
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a float value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the float value
	 */
	public static float promptForFloat(String prompt, float min, float max)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = true;
		float num = min - 1;
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		if(min > max)
		{
			throw new IllegalArgumentException("The minimum should be less than the maximum.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
				num = Float.parseFloat(input);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				e.printStackTrace();
			}
			catch(NumberFormatException nfe) {
				
			}
			
			isValid = num >= min && num <= max;
			
			if (!isValid)
			{
				System.out.println("Please choose a number between " + min + " and " + max);
			}
			
		}while(!isValid);
		
		return (float) num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a double value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the double value
	 */
	public static double promptForDouble(String prompt, double min, double max)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = true;
		double num = min - 1;
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
	
		if(min > max)
		{
			throw new IllegalArgumentException("The minimum should be less than the maximum.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
				num = Double.parseDouble(input);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				e.printStackTrace();
			}
			catch(NumberFormatException nfe) {
				
			}
			
			isValid = num >= min && num <= max;
			
			if (!isValid)
			{
				System.out.println("Please choose a number between " + min + " and " + max);
			}
			
		}while(!isValid);
		
		return num;
	}
	
	/**
	 * Generates a prompt that allows the user to enter any response and returns the String.
	 * When allowEmpty is true, empty responses are valid. When false, responses must contain
	 * at least one character (including whitespace).
	 * @param prompt - the prompt to be displayed to the user.
	 * @param allowEmpty - when true, makes empty responses valid
	 * @return the input from the user as a String
	 */
	public static String promptForInput(String prompt, boolean allowEmpty)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		boolean isValid = true;
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		do
		{
			isValid = true;
			System.out.print(prompt);
			
			try
			{
				input = reader.readLine();
			} 
			catch (IOException ioe) 
			{
				ioe.printStackTrace();
				System.out.println("Something went screwy on our end. Please try again.");
				isValid = false;
			}
			
			if(!allowEmpty && input.isEmpty())
			{
				isValid = false;
				System.out.println("Please enter something. Anything.");
			}
			
		}while (!isValid);
		
		return input;
	}
	
	/**
	 * Generates a prompt that expects a single character input representing a char value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the char value
	 */
	public static char promptForChar(String prompt, char min, char max)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean isValid = true;
		char c = 0;
		
		if(prompt.isEmpty())
		{
			throw new IllegalArgumentException("The prompt should be filled.");
		}
		
		do
		{
			System.out.print(prompt);
			try 
			{
				input = reader.readLine();
				c = input.charAt(0);
			} 
			catch (IOException ioe) 
			{
				System.out.println("Something went screwy on our end. Please try again.");
				ioe.printStackTrace();
			}
			catch(IndexOutOfBoundsException ioobe)
			{
				
			}
			catch(NullPointerException npe)
			{
				
			}
			isValid = c >= min && c <= max;
			
			
			
			if (!isValid)
			{
				System.out.println("Please choose a letter between " + min + " and " + max);
				
			}
			
		}while(!isValid);
		
		return c;
	}

	public static void displayMessage(String string) {
		System.out.println(string);
		
	}

}
