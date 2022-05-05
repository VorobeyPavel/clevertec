package ru.clevertec.check.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.clevertec.check.bean.Product;
import ru.clevertec.check.dao.Dao;
import ru.clevertec.check.service.MailService;
import ru.clevertec.check.view.Print;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.clevertec.check");

        Dao dao = context.getBean(Dao.class);
        MailService mailService = context.getBean(MailService.class);
        Print print = context.getBean(Print.class);

        System.out.println("Введите набор параметров в формате itemId-quantity+номер дисконтной карты" +
                "\n(itemId - идентификатор товара, quantity - его количество)" +
                "\nпример для ввода: 3-2 2-5 5-3 card-1234");

        Scanner sc = new Scanner(System.in);
        String productLine = sc.nextLine();
        ArrayList<Product> listProduct = dao.shoppingList(productLine);

        /*
        В зависимости от того откуда мы хотим брать доступные для заказа товары(из коллекции в классе DaoImpl,
        из файла или из БД, используем соответствующий параметр в методе.
        */

        // Вариант получения товаров из коллекции в классе DaoImpl. Используем dao.getWarehouse()
        //ArrayList<Product> listProductAndPrice = dao.priceProduct(listProduct, dao.getWarehouse());

        //Вариант получения товаров из файла. Используем getWarehouseWithFile()
        //ArrayList<Product> listProductAndPrice = dao.priceProduct(listProduct, dao.getWarehouseWithFile());

        //Вариант получения товаров из базы данных. Используем getWarehouseDB()
        ArrayList<Product> listProductAndPrice = dao.priceProduct(listProduct, dao.getWarehouseDB());


        /*Получаем скидку по количеству заказанных товаров. Если количество кого либо приобретаемого товара больше 5,
        то по данной позиции предоставляется скидка 10%.*/
        double quantityDiscount = dao.quantityDiscount(listProductAndPrice);

        int numberCard = dao.getNumberCard(productLine);


        // Метод для отправки чека на Email
        mailService.sendEmail("Vorobey_Pavel@mail.ru", "Check", String.valueOf(print.printCheckToEmail(listProductAndPrice, quantityDiscount, numberCard)));

        // Метод для вывода чека в консоль
        print.printCheckToConsole(listProductAndPrice, quantityDiscount, numberCard);

        //Метод для вывода чека в файл
        print.printCheckToFile(listProductAndPrice, quantityDiscount, numberCard);

    }
}
