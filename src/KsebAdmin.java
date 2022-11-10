import java.util.Scanner;

public class KsebAdmin {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Kseb Consumer Management");
            System.out.println("1.Add Consumer ");
            System.out.println("2.Search Consumer ");
            System.out.println("3.Delete Consumer ");
            System.out.println("4.Update Consumer ");
            System.out.println("5.View all Consumers ");
            System.out.println("6.Generate Bill ");
            System.out.println("7.View Bill  ");
            System.out.println("8.Top two high bill paying consumers  ");
            System.out.println("9.Exit ");
            System.out.println("Enter your choice:  ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Add Consumer");



                    break;
                case 2:
                    System.out.println("Search Consumer");

                    break;
                case 3:
                    System.out.println("Delete Consumer");


                    break;
                case 4:
                    System.out.println("Update Consumer");


                    break;
                case 5:
                    System.out.println("View all Consumers");


                    break;
                case 6:
                    System.out.println("Generate Bill");

                    break;
                case 7:
                    System.out.println("View Bill");

                    break;
                case 8:
                    System.out.println("Top two high bill paying consumers");

                    break;
                case 9:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice");


            }
        }
    }
}
