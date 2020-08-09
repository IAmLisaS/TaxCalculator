// Lisa Sinn
// Intro to Java - CSCI 1146 
// CSCI 1146-241
// Unit 7, Exercise #12
// PrepareTax.java

import java.util.*;

public class PrepareTax {

      // helper method to get valid ssn from user

      static String getValidSSN(Scanner scanner) {

            // asking and getting ssn

            System.out.print("Enter your social security number: ");

            String ssn = scanner.nextLine();

            boolean valid = true;

            // validating

            if (ssn.length() == 11) {

                  // length is valid, now checking for numbers and dashes

                  for (int i = 0; i < ssn.length(); i++) {

                        if (i == 3 || i == 6) {

                              // should be '-' at these locations

                              if (ssn.charAt(i) != '-') {

                                    // nope! mismatch found

                                    valid = false;

                                    break;

                              }

                        }

                        // other characters should be digits

                        else if (!Character.isDigit(ssn.charAt(i))) {

                              // not a digit

                              valid = false;

                              break;

                        }

                  }

            } else {

                  // not a valid length

                  valid = false;

            }

            // if valid, returning ssn

            if (valid) {

                  return ssn;

            } else {

                  // otherwise printing error and asking again

                  System.out.println("Invalid SSN, try again!");

                  return getValidSSN(scanner); // simple recursion

            }

      }

      // helper method to get valid zip code

      static String getValidZip(Scanner scanner) {

            System.out.print("Enter your zip code: ");

            String zip = scanner.nextLine();

            boolean valid = true;

            // checking that zip contains 5 digits

            if (zip.length() == 5) {

                  for (int i = 0; i < zip.length(); i++) {

                        if (!Character.isDigit(zip.charAt(i))) {

                              valid = false;

                              break;

                        }

                  }

            } else {

                  valid = false;

            }

            if (valid) {

                  return zip;

            } else {

                  System.out.println("Invalid zip, try again!");

                  return getValidZip(scanner);

            }

      }

      // helper method to get valid marital status

      static char getValidMaritalStatus(Scanner scanner) {

            System.out.print("Enter your marital status: ");

            // reading status and converting to upper case

            String status = scanner.nextLine().toUpperCase();

            // checking that status begins with 'S' or 'M'

            if (status.length() > 0

                        && (status.charAt(0) == 'S' || status.charAt(0) == 'M')) {

                  return status.charAt(0);

            } else {

                  System.out.println("Invalid marital status, try again!");

                  return getValidMaritalStatus(scanner);

            }

      }

      // helper method to get valid annual income

      static double getValidAnnualIncome(Scanner scanner) {

            System.out.print("Enter your annual income: ");

            double income = Double.parseDouble(scanner.nextLine());

            // income must not be negative

            if (income >= 0) {

                  return income;

            } else {

                  System.out.println("Invalid income, try again!");

                  return getValidAnnualIncome(scanner);

            }

      }

      public static void main(String[] args) {

            // declaring a Scanner, reading inputs

            Scanner scanner = new Scanner(System.in);

            String ssn = getValidSSN(scanner);

            System.out.print("Enter your last name: ");

            String last = scanner.nextLine();

            System.out.print("Enter your first name: ");

            String first = scanner.nextLine();

            System.out.print("Enter your address: ");

            String address = scanner.nextLine();

            System.out.print("Enter your city: ");

            String city = scanner.nextLine();

            System.out.print("Enter your state: ");

            String state = scanner.nextLine();

            String zip = getValidZip(scanner);

            double income = getValidAnnualIncome(scanner);

            char status = getValidMaritalStatus(scanner);

            // creating a TaxReturn object, displaying report

            TaxReturn taxReturn = new TaxReturn(ssn, last, first, address, city,

                        state, zip, income, status);

            taxReturn.display();

      }

}