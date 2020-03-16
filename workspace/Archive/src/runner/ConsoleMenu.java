package runner;

/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */
public class ConsoleMenu {
	
	public ConsoleMenu() {
	
	}
	
	public void start() {
		startMenu();
	}
	
	private void startMenu() {
		System.out.println("Архив");
		System.out.println("Введиет число");
		System.out.println("1. Просмотр архива");
		System.out.println("2. Изменить архив");
		System.out.println("3. Добавить");
		System.out.println("4. Выход");		
	}
	
}
