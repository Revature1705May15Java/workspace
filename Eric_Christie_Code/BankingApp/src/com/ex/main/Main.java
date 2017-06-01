package com.ex.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.ex.logging.Logger;
import com.ex.pojos.Account;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;
import com.ex.service.BankingService;

public class Main {
  
  private static enum View {
    START, REGISTER, LOGIN, LOGOUT, HOME, UPDATE_USER, MANAGE_ACCOUNT, OPEN_ACCOUNT, CLOSE_ACCOUNT,
    ADD_ACCOUNT_HOLDER, REMOVE_ACCOUNT_HOLDER, DEPOSIT, WITHDRAW, TRANSFER, EXIT
  }
  
  private static final String bankName = "FakeBank";
  
  /*
   * the home view should display the type and balance for all of the current user's open accounts
   * 
   * TODO try implementing this cli program with each view getting saved to a stack (view history)
   */

  static String[] start = {"[1] Register as a new bank user.",
      "[2] Login as a current bank user.",
      "[3] Exit"};
  static String[] register = {"Email address:",
      "(A verification code was sent to this email address. Please input that code here.)\n"
      + "(At the moment, the code is just 123456)\n"
      + "Verification code:",
      "Password: (be sure of what you're typing)", "First name:", "Last name:"};
  static String[] login = {"Email address:", "Password:"};
  static String[] logout = {"Are you sure you want to logout? (y/n)"};
  static String[] home = {"[%d] Manage Account: #%d (%s) - Balance= $%s\n",
      "[%d] Open a new account\n",
      "[%d] View/Update user information\n",
      "[%d] Logout\n",
      "[%d] Exit\n"};
  static String[] update = {"Email address: (enter nothing to leave unchanged)",
      "Password: (enter nothing to leave unchanged)",
      "First name: (enter nothing to leave unchanged)",
      "Last name: (enter nothing to leave unchanged)"};
  static String[] manage = {"[1] Deposit money into this account",
      "[2] Withdraw money from this account",
      "[3] Transfer money between accounts",
      "[4] Add another user to this account",
      "[5] Remove a user from this account",
      "[6] Close this account",
      "[7] Return to home menu"};
  static String[] open = {"[%d] %s\n"};
  static String[] close = {"Are you sure you want to close this account? (y/n)"};
  static String[] add = {"Enter the email address of the user you want to add to this account:"};
  static String[] remove = {"Enter the email address of the user you want to remove from this account:"};
  static String[] deposit = {"Specify the amount you are depositing: (positive number, no dollar sign, 2 decimal places)"};
  static String[] withdraw = {"Specify the amount you are depositing: (positive number, no dollar sign, 2 decimal places)"};
  static String[] transfer = {"Specify the ID of the other account:",
      "Specify the amount to be transferred: (positive number, no dollar sign, 2 decimal places)",
      "Are you transferring money to or from this account? (t/f)"};
  static String[] exit = {"Are you sure you want to exit? (y/n)"};
  
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    BankingService service = new BankingService(true, true);
    Logger logger = Logger.getInstance();
    
    User current = null; // the user that is currently logged in
    Account selected = null; // the account that is currently being viewed/modified
    
    List<AccountType> accountTypes = new ArrayList<>();
    accountTypes.addAll(service.getAccountTypes());
    accountTypes.sort((a, b) -> (a.getId() - b.getId()));
    
    boolean running = true;
    View view = View.START;
    
    while (running) {
      try {
        switch (view) {
        case START: // done
          if (current == null) {
            System.out.println("Welcome to " + bankName);
            System.out.println("Whenever you need to select an option, enter the corresponding number.");
            for (String o: start) {
              System.out.println(o);
            }
            Integer input = Integer.parseInt(in.nextLine());
            if (input == 1) {
              view = View.REGISTER;
            } else if (input == 2) {
              view = View.LOGIN;
            } else if (input == 3) {
              view = View.EXIT;
            } else {
              System.out.println("Invalid input. You must select an option.");
            }
          } else {
            view = View.HOME;
          }
          break;
        case REGISTER: // done
          if (current == null) {
            System.out.println("Pleae specify your user information.");
            System.out.println(register[0]);
            String inputEmail = in.nextLine();
            String correctCode = service.sendVerificationCode(inputEmail);
            System.out.println(register[1]);
            String verificationCode = in.nextLine();
            if (service.verifyEmail(inputEmail, correctCode, verificationCode)) {
              System.out.println(register[2]);
              String inputPass = in.nextLine();
              System.out.println(register[3]);
              String inputFname = in.nextLine();
              System.out.println(register[4]);
              String inputLname = in.nextLine();
              if (inputEmail.equals("") || inputPass.equals("") || inputFname.equals("") || inputLname.equals("")) {
                System.out.println("Registration failed. You must input something for each field. Please try again.");
              } else {
                User result = service.registerUser(inputEmail, inputPass, inputFname, inputLname);
                if (result != null) {
                  System.out.println("Registration successful. Logging in as new user.");
                  current = result;
                  view = View.HOME;
                } else {
                  System.out.println("Registration Failed.");
                  view = View.START;
                }
              }
            } else {
              System.out.println("Email verifiction failed, please try again.");
            }
          } else {
            view = View.HOME;
          }
          break;
        case LOGIN: // done
          if (current == null) {
            System.out.println(login[0]);
            String inputEmail = in.nextLine();
            System.out.println(login[1]);
            String inputPass = in.nextLine();
            User result = service.loginUser(inputEmail, inputPass);
            if (result != null) {
              current = result;
              System.out.println("Welcome back " + current.getFirstname() + " " + current.getLastname());
              view = View.HOME;
            } else {
              System.out.println("login failed.");
              view = View.START;
            }
          } else {
            view = View.HOME;
          }
          break;
        case LOGOUT: // done
          if (current != null) {
            System.out.println(logout[0]);
            String response = in.nextLine();
            if (response.equalsIgnoreCase("y")) {
              current = null;
              selected = null;
            }
            view = View.START;
          } else {
            view = View.START;
          }
          break;
        case HOME:
          if (current != null) {
            current.setAccounts(service.getCurrentAccounts(current));
            System.out.println(current);
            List<Account> currentAccounts = new ArrayList<>();
            currentAccounts.addAll(current.getAccounts());
            int i;
            for (i = 0; i < currentAccounts.size(); i++) {
              Account a = currentAccounts.get(i);
              System.out.printf(home[0], i, a.getId(), a.getType().getName(), a.getBalance().toString());
            }
            System.out.printf(home[1], i);
            System.out.printf(home[2], i + 1);
            System.out.printf(home[3], i + 2);
            System.out.printf(home[4], i + 3);
            Integer response = Integer.parseInt(in.nextLine());
            if (response < i) {
              selected = currentAccounts.get(response);
              view = View.MANAGE_ACCOUNT;
            } else if (response == i) {
              view = View.OPEN_ACCOUNT;
            } else if (response == i + 1) {
              view = View.UPDATE_USER;
            } else if (response == i + 2) {
              view = View.LOGOUT;
            } else if (response == i + 3) {
              view = View.EXIT;
            } else {
              System.out.println("Please enter a valid number.");
            }
          } else {
            view = View.START;
          }
          break;
        case UPDATE_USER: // done
          if (current != null) {
            // display current user information before prompting for update
            System.out.println(current);
            System.out.println(update[0]);
            String email = in.nextLine();
            if (email == null || email.equals("")) {
              email = current.getEmail();
            }
            System.out.println(update[1]);
            String pass = in.nextLine();
            if (pass.equals("")) {
              pass = null;
            }
            System.out.println(update[2]);
            String fname = in.nextLine();
            if (fname == null || fname.equals("")) {
              fname = current.getFirstname();
            }
            System.out.println(update[3]);
            String lname = in.nextLine();
            if (lname == null || lname.equals("")) {
              lname = current.getLastname();
            }
            User result = service.updateUser(current, email, pass, fname, lname);
            if (result != null) {
              current = result;
              view = View.HOME;
            } else {
              System.out.println("Update failed.");
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case MANAGE_ACCOUNT: // done
          if (current != null) {
            if (selected != null) {
              // TODO refresh current and selected
              // display account information before listing options
              System.out.println("Manage account: " + selected);
              for (String o: manage) {
                System.out.println(o);
              }
              Integer input = Integer.parseInt(in.nextLine());
              switch (input) {
              case 1:
                view = View.DEPOSIT;
                break;
              case 2:
                view = View.WITHDRAW;
                break;
              case 3:
                view = View.TRANSFER;
                break;
              case 4:
                view = View.ADD_ACCOUNT_HOLDER;
                break;
              case 5:
                view = View.REMOVE_ACCOUNT_HOLDER;
                break;
              case 6:
                view = View.CLOSE_ACCOUNT;
                break;
              case 7:
                view = View.HOME;
                selected = null;
                break;
              }
            } else {
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case OPEN_ACCOUNT: // done
          if (current != null) {
            // user must select an account type
            if (current.getAccounts().size() < 6) {
              System.out.println("Select an account type.");
              for (AccountType t: accountTypes) {
                System.out.printf(open[0], accountTypes.indexOf(t), t.getName());
              }
              Integer ndx = Integer.parseInt(in.nextLine());
              AccountType type = accountTypes.get(ndx);
              Account result = service.createAccount(current, type);
              if (result != null) {
                Set<Account> newAccounts = current.getAccounts();
                newAccounts.add(result);
                current.setAccounts(newAccounts);
                System.out.println("New account created.");
              } else {
                System.out.println("Account creation failed.");
              }
              view = View.HOME;
            } else {
              System.out.println("You cannot have more than 6 open accounts at one time.");
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case CLOSE_ACCOUNT: // done
          if (current != null) {
            if (selected != null) {
              // check if account has a non-zero balance before closing it
              if (selected.getBalance().compareTo(new BigDecimal(0.00)) == 0) {
                System.out.println(close[0]);
                String response = in.nextLine();
                if (response.equalsIgnoreCase("y")) {
                  System.out.println("Account has been closed.");
                  selected = null;
                  current.setAccounts(service.getCurrentAccounts(current));
                  view = View.HOME;
                } else {
                  System.out.println("Failed to close account.");
                  view = View.MANAGE_ACCOUNT;
                }
              } else {
                System.out.println("You cannot close an account that has a non-zero balance.");
                System.out.println("Please withdraw or transfer the balance then try again.");
                view = View.MANAGE_ACCOUNT;
              }
            } else {
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case ADD_ACCOUNT_HOLDER: // done
          if (current != null) {
            if (selected != null) {
              if (selected.getAccountHolders().size() < 4) {
                System.out.println(add[0]);
                String inputEmail = in.nextLine();
                if (service.getCurrentAccounts(inputEmail).size() < 6) {
                  Account result = service.addAccountHolder(selected, inputEmail);
                  current.setAccounts(service.getCurrentAccounts(current));
                  selected = result;
                  view = View.MANAGE_ACCOUNT;
                } else {
                  System.out.println("This user alread has 6 accounts.");
                  view = View.MANAGE_ACCOUNT;
                }
              } else {
                System.out.println("An account cannot be shared by more than 4 users at once.");
                view = View.MANAGE_ACCOUNT;
              }
            } else {
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case REMOVE_ACCOUNT_HOLDER: // done
          if (current != null) {
            if (selected != null) {
              if (selected.getAccountHolders().size() > 1) {
                System.out.println(remove[0]);
                String inputEmail = in.nextLine();
                Account result = service.removeAccountHolder(selected, inputEmail);
                if (result != null) {
                  System.out.println("Removed a user from the account.");
                  selected = result;
                  view = View.MANAGE_ACCOUNT;
                } else {
                  System.out.println("Account holder removal failed.");
                  view = View.MANAGE_ACCOUNT;
                }
              } else {
                System.out.println("An open account must have at least 1 user.");
                view = View.MANAGE_ACCOUNT;
              }
            } else {
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case DEPOSIT: // done
          if (current != null) {
            if (selected != null) {
              System.out.println(deposit[0]);
              BigDecimal inputAmount = new BigDecimal(in.nextLine());
              Account result = service.deposit(selected, inputAmount);
              System.out.println("Deposit complete.");
              selected = result;
              view = View.MANAGE_ACCOUNT;
            } else {
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case WITHDRAW: // done
          if (current != null) {
            if (selected != null) {
              System.out.println(withdraw[0]);
              BigDecimal inputAmount = new BigDecimal(in.nextLine());
              Account result = service.withdraw(selected, inputAmount);
              System.out.println("Withdraw complete.");
              selected = result;
              view = View.MANAGE_ACCOUNT;
            } else {
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case TRANSFER: // done
          if (current != null) {
            if (selected != null) {
              System.out.println(transfer[0]);
              Integer inputId = Integer.parseInt(in.nextLine());
              System.out.println(transfer[1]);
              BigDecimal inputAmount = new BigDecimal(in.nextLine());
              System.out.println(transfer[2]);
              String response = in.nextLine();
              boolean result = false;
              if (response.equalsIgnoreCase("t")) {
                result = service.transfer(inputId, selected.getId(), inputAmount);
              } else {
                result = service.transfer(selected.getId(), inputId, inputAmount);
              }
              if (result) {
                System.out.println("Transfer complete.");
              } else {
                System.out.println("Transfer failed.");
              }
              view = View.MANAGE_ACCOUNT;
            } else {
              view = View.HOME;
            }
          } else {
            view = View.START;
          }
          break;
        case EXIT: // done
          System.out.println(exit[0]);
          String response = in.nextLine();
          if (response.equalsIgnoreCase("y")) {
            current = null;
            selected = null;
            running = false;
          }
          view = View.START;
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. You must enter a number corresponding to one of the options:");
      } catch (Exception e) {
        logger.alert("Exception thrown in main loop: " + e.getMessage());
        e.printStackTrace();
        running = false;
      }
      
    }
  }
  
//  private static void refresh(User current, Account selected) {
//    
//  }
 
  
//  public static void printOptions(String[] options) {
//    for (int i = 0; i < options.length; i++) {
//      System.out.println(options[i]);
//    }
//  }

}
