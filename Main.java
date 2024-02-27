package СonsoleApp;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Main {
        // Use Scanner for reading input from the user
        Scanner scanner = new Scanner(System.in);
        List<String> todoList = new ArrayList<>();

        public static void main(String[] args) {
            Main main = new Main();
            main.start();
        }

        public void start() {
            // Этот бесконечный цикл предназначен для того, чтобы приложение работало
            // пока пользователь не захочет выйти выбрав в меню команду номер 5
            while (true) {
                displayMenu();
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    handleMenuChoice(choice);
                }
            }
        }

        public void displayMenu() {
            System.out.println("Список доступных команд");
            System.out.println("1. Вывести спискок дел");
            System.out.println("2. Добавить дело");
            System.out.println("3. Заменить дело");
            System.out.println("4. Удалить дело");
            System.out.println("5. Выход");
            System.out.println("Введите число от 1 до 5 чтобы выбрать действие:");
        }

        public void handleMenuChoice(int choice) {
            switch (choice) {
                case 1:
                    list();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Введите индекс дела для редактирования:");
                    int index = scanner.nextInt();
                    System.out.println("Введите новое дело:");
                    String newTodo = scanner.next();
                    edit(index, newTodo);
                    break;
                case 4:
                    System.out.println("Введите индекс дела для удаления:");
                    int deleteIndex = scanner.nextInt();
                    delete(deleteIndex);

                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    // обработка остальных возмножных варантов ввода пользователя
            }
        }


        // реализация всех методов ToDoList
        private void list() {
            System.out.println("список дел");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i)+ todoList.get(i));
                
            }

        }

        void add() {
            System.out.println("Введите дело которое хотите добавить:");

            if (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                todoList.add(command);

                System.out.println("Дело " + command + " успешно добавлено");
            }
        }
      private void edit(int index, String newTodo) {
            if (index >= 0 && index < todoList.size()) {
                todoList.set(index, newTodo);
                System.out.println("Дело отредактировано.");
            } else {
                System.out.println("Неверный индекс дела.");
            }
        }

         void delete(int index) {
            if (index >= 0 && index < todoList.size()) {
                todoList.remove(index);
                System.out.println("Дело удалено.");
            } else {
                System.out.println("Неверный индекс дела.");
            }
        }
    }


