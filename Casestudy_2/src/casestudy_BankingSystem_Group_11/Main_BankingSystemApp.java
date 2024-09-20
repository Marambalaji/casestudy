package casestudy_BankingSystem_Group_11;

import java.util.Scanner;
import java.util.List;
public class Main_BankingSystemApp {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        BankingService bankingService = new BankingServiceImpl();

	        while (true) {
	            System.out.println("\nBanking System");
	            System.out.println("1. Add Customers");
	            System.out.println("2. Add Accounts");
	            System.out.println("3. Add Beneficiary");
	            System.out.println("4. Add Transaction");
	            System.out.println("5. Find Customer by Id");
	            System.out.println("6. List all Accounts of specific Customer");
	            System.out.println("7. List all transactions of specific Account");
	            System.out.println("8. List all beneficiaries of specific customer");
	            System.out.println("9. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter Customer Details");
	                    System.out.print("Customer Id: ");
	                    int customerId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Address: ");
	                    String address = scanner.nextLine();
	                    System.out.print("Contact No.: ");
	                    String contact = scanner.nextLine();
	                    bankingService.addCustomer(new Customer(customerId, name, address, contact));
	                    break;

	                case 2:
	                    System.out.println("Enter Account Details");
	                    System.out.print("Account Id: ");
	                    int accountId = scanner.nextInt();
	                    System.out.print("Customer Id: ");
	                    int accCustomerId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Account Type (Saving/Current): ");
	                    String type = scanner.nextLine();
	                    System.out.print("Balance: ");
	                    double balance = scanner.nextDouble();
	                    bankingService.addAccount(new Account(accountId, accCustomerId, type, balance));
	                    break;

	                case 3:
	                    System.out.println("Enter Beneficiary Details");
	                    System.out.print("Customer Id: ");
	                    int benefCustomerId = scanner.nextInt();
	                    System.out.print("Beneficiary Id: ");
	                    int beneficiaryId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Beneficiary Name: ");
	                    String benefName = scanner.nextLine();
	                    System.out.print("Beneficiary Account No.: ");
	                    String accountNumber = scanner.nextLine();
	                    System.out.print("Beneficiary Bank Details: ");
	                    String bankDetails = scanner.nextLine();
	                    bankingService.addBeneficiary(new Beneficiary(beneficiaryId, benefCustomerId, benefName, accountNumber, bankDetails));
	                    break;

	                case 4:
	                    System.out.println("Enter Transaction Details");
	                    System.out.print("Transaction Id: ");
	                    int transactionId = scanner.nextInt();
	                    System.out.print("Account Id: ");
	                    int transAccountId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Type (Deposit/Withdrawal): ");
	                    String transType = scanner.nextLine();
	                    System.out.print("Amount: ");
	                    double amount = scanner.nextDouble();
	                    bankingService.addTransaction(new Transaction(transactionId, transAccountId, transType, amount));
	                    break;

	                case 5:
	                    System.out.println("List of Customers:");
	                    for (Customer c : bankingService.getAllCustomers()) {
	                        System.out.println("Customer ID: " + c.getCustomerID() + ", Name: " + c.getName());
	                    }
	                    System.out.print("Enter Customer ID: ");
	                    int findCustomerId = scanner.nextInt();
	                    Customer customer = bankingService.findCustomerById(findCustomerId);
	                    if (customer != null) {
	                        System.out.println("Customer: " + customer.getName());
	                    } else {
	                        System.out.println("Customer not found!");
	                    }
	                    break;

	                case 6:
	                	 for (Account c : bankingService.getAllAccounts()) {
		                        System.out.println("Account ID: " + c.getAccountID() +" , "+ "Customer ID: " + c.getCustomerID() +" , " + "Balance: " + c.getBalance());
		                    }
	                    System.out.print("Enter Customer ID: ");
	                    int custId = scanner.nextInt();
	                    List<Account> accounts = bankingService.getAccountsByCustomerId(custId);
	                    if (!accounts.isEmpty()) {
	                        System.out.println("Accounts for Customer ID: " + custId);
	                        for (Account account : accounts) {
	                            System.out.println("Account ID: " + account.getAccountID() + ", Balance: " + account.getBalance());
	                        }
	                    } else {
	                        System.out.println("No accounts found for Customer ID: " + custId);
	                    }
	                    break;

	                case 7:
	                    System.out.print("Enter Account ID: ");
	                    int accId = scanner.nextInt();
	                    List<Transaction> transactions = bankingService.getTransactionsByAccountId(accId);
	                    if (!transactions.isEmpty()) {
	                        System.out.println("Transactions for Account ID: " + accId);
	                        for (Transaction transaction : transactions) {
	                            System.out.println("Transaction ID: " + transaction.getTransactionID() + 
	                                               ", Type: " + transaction.getType() + 
	                                               ", Amount: " + transaction.getAmount() + 
	                                               ", Timestamp: " + transaction.getTimestamp());
	                        }
	                    } else {
	                        System.out.println("No transactions found for Account ID: " + accId);
	                    }
	                    break;

	                case 8:
	                	for (Beneficiary c : bankingService.getAllBeneficiaries()) {
	                        System.out.println("Beneficiary ID: " + c.getBeneficiaryID() + " , "+ "Name: " + c.getName());
	                    }
	                	System.out.println("----------------------------------");
	                    System.out.print("Enter Customer ID: ");
	                    int customerIdForBeneficiaries = scanner.nextInt();
	                    List<Beneficiary> beneficiaries = bankingService.getBeneficiariesByCustomerId(customerIdForBeneficiaries);
	                    if (!beneficiaries.isEmpty()) {
	                        System.out.println("Beneficiaries for Customer ID: " + customerIdForBeneficiaries);
	                        for (Beneficiary beneficiary : beneficiaries) {
	                            System.out.println("Beneficiary ID: " + beneficiary.getBeneficiaryID() + 
	                                               ", Name: " + beneficiary.getName());
	                        }
	                    } else {
	                        System.out.println("No beneficiaries found for Customer ID: " + customerIdForBeneficiaries);
	                    }
	                    break;

	                case 9:
	                    System.out.println("Thank you!");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}
	