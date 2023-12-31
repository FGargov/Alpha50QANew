import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /*BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.title);
        System.out.println(item.dueDate);
        System.out.println(item.status);
*/

       /* BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.status);
        item.advanceStatus();
        System.out.println(item.status);
        item.advanceStatus();
        System.out.println(item.status);
        item.revertStatus();
        System.out.println(item.status);*/


        /*BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.viewInfo());*/


        /*BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        item.advanceStatus();
        BoardItem anotherItem = new BoardItem("Encrypt user data", LocalDate.now().plusDays(10));

        *//*Board.items.add(item);
        Board.items.add(anotherItem);*//*

        Board.items.add(item);
        Board.items.add(anotherItem);

        for (BoardItem boardItem : Board.items) {
            boardItem.advanceStatus();
        }

        for (BoardItem boardItem : Board.items) {
            System.out.println(boardItem.viewInfo());
        }*/

/*        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        item.advanceStatus(); // properly changing the status
        item.advanceStatus();
        System.out.println(item.viewInfo()); // Status: InProgress

        item.setStatus(Status.OPEN);
        System.out.println(item.viewInfo());; // Status: Open*/


       /* BoardItem item = new BoardItem("Rewrite everything", LocalDate.now().plusDays(2));

        // compilation error if you uncomment the next line:
        // item.title = "Rewrite everything immediately!!!";
        // we made title private so it cannot be accessed directly anymore

        item.setTitle("Rewrite everything ASAP!!!"); // properly changing the title
        System.out.println(item.getTitle()); // properly accessing the title
        item.setTitle("Huh?"); // Exception thrown: Please provide a title with length between 5 and 30 chars*/


        EventLog log = new EventLog("An important thing happened");
        System.out.println(log.getDescription());
        System.out.println(log.viewInfo());

     //  EventLog log2 = new EventLog();



        /*BoardItem item = new BoardItem("Refactor this mess", LocalDate.now().plusDays(2));
        item.setDueDate(item.getDueDate().plusYears(2));
        item.setTitle("Not that important");
        item.revertStatus();
        item.advanceStatus();
        item.revertStatus();

        System.out.println(item.displayHistory());

        System.out.println("\n--------------\n");

        BoardItem anotherItem = new BoardItem( "Don't refactor anything",  LocalDate.now().plusDays(10));
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        anotherItem.advanceStatus();
        System.out.println(anotherItem.displayHistory());*/


        /*BoardItem item1 = new BoardItem("Implement login/logout", LocalDate.now().plusDays(3));
        BoardItem item2 = new BoardItem("Secure admin endpoints", LocalDate.now().plusDays(5));

        Board board = new Board();

        board.addItem(item1); // add item1
        board.addItem(item2); // add item2
       // board.addItem(item1); // do nothing - item1 already in the list
       board.addItem(item2); // do nothing - item2 already in the list

        System.out.println(board.totalItems()); // count: 2*/
    }
}