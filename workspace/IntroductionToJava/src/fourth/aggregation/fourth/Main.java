package fourth.aggregation.fourth;

/**
 * 
 * @author Dima Zosimov
 *
 */

public class Main {

	public static void main(String[] args) {
		Person per1 = new Person("Zosimov", "Dmitriy", "Aleksandrovich");
		Person per2 = new Person("Ivanov", "ivan", "Ivanovich");
		Person per3 = new Person("Zinchenko", "Aleksey", "Alekseevich");
		
		BankAccount ac1 = new BankAccount(per1);
		BankAccount ac2 = new BankAccount(per1);
		BankAccount ac3 = new BankAccount(per2);
		BankAccount ac4 = new BankAccount(per2);
		BankAccount ac5 = new BankAccount(per3);
		BankAccount ac6 = new BankAccount(per3);
		
		createRandomBalance();
		
		ac3.blocking();
		ac3.withdrawMoney(100);
		
		//поиск счетов клиента
		System.out.println("\nПоиск счетов клиента");
		Functions.printAccounts(Functions.find(per1));
		
		//сортировка счетов по номеру
		System.out.println("\nСортировка по номеру");
		Functions.sortByNumber();
		Functions.printAccounts(Functions.accounts);
		
		//вычисление общей суммы по счетам
		System.out.printf("Общая сумма %.2f\n", Functions.sumBalanceAllAccounts());
		
		//вычисление суммы положительных аккаунтов
		System.out.printf("Cумма положительных балансов %.2f\n", Functions.sumBalance(Functions.getPositiveBalances()));
		
		//вычисление суммы отрицательных балансов
		System.out.printf("Вычисление суммы отрицательных балансов %.2f" , Functions.sumBalance(Functions.getNegativeBalances()));
		

	}
	
	public static void createRandomBalance() {
		for(BankAccount ac : Functions.accounts) {
			ac.putMoney(Math.random() * 1000 * 2 - 1000);
		}
	}

}
