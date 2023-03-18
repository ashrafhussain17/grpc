package com.dohatec;

import java.util.ArrayList;
import java.util.List;

public class TempDB {

    public static List<Author> getAuthorsFromTempDb() {
        return new ArrayList<Author>() {
            {
                add(Author.newBuilder().setAuthorId(5).setFirstName("Agatha").setLastName("Christie").setGender("female").build());
                add(Author.newBuilder().setAuthorId(1).setBookId(1).setFirstName("Charles").setLastName("Dickens").setGender("male").build());
                add(Author.newBuilder().setAuthorId(2).setFirstName("William").setLastName("Shakespeare").setGender("male").build());
                add(Author.newBuilder().setAuthorId(3).setFirstName("JK").setLastName("Rowling").setGender("female").build());
                add(Author.newBuilder().setAuthorId(4).setFirstName("Virginia").setLastName("Woolf").setGender("female").build());
            }
        };
    }

    public static List<Book> getBooksFromTempDb() {
        return new ArrayList<Book>() {
            {
                add(Book.newBuilder().setBookId(1).setAuthorId(1).setTitle("Oliver Twist").setPrice(123.3f).setPages(100).build());
                add(Book.newBuilder().setBookId(2).setAuthorId(1).setTitle("A Christmas Carol").setPrice(223.3f).setPages(150).build());
                add(Book.newBuilder().setBookId(3).setAuthorId(2).setTitle("Hamlet").setPrice(723.3f).setPages(250).build());
                add(Book.newBuilder().setBookId(4).setAuthorId(3).setTitle("Harry Potter").setPrice(423.3f).setPages(350).build());
                add(Book.newBuilder().setBookId(5).setAuthorId(3).setTitle("The Casual Vacancy").setPrice(523.3f).setPages(450).build());
                add(Book.newBuilder().setBookId(6).setAuthorId(4).setTitle("Mrs. Dalloway").setPrice(623.3f).setPages(550).build());
            }
        };
    }

    public static List<SupplyOrder> getSupplyOrderList() {
        List<Item> itemList = new ArrayList<Item>() {
            {
                add(Item.newBuilder().setItemId(0).setName("item0").build());
                add(Item.newBuilder().setItemId(1).setName("item1").build());
                add(Item.newBuilder().setItemId(2).setName("item2").build());
                add(Item.newBuilder().setItemId(3).setName("item3").build());
            }
        };
        return new ArrayList<SupplyOrder>() {
            {
                add(SupplyOrder.newBuilder().setSupplyOrderID(1).addItems(Item.newBuilder().setItemId(0).setName("item0").build()).build());
                add(SupplyOrder.newBuilder().setSupplyOrderID(2).build());
                add(SupplyOrder.newBuilder().setSupplyOrderID(3).build());
            }
        };
    }
}
