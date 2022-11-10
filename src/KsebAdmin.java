import java.util.Scanner;
import java.sql.*;

public class KsebAdmin {
    public static void main(String[] args) {
        int choice, consumerCode;
        String consumerName, consumerPhone, consumerEmail, consumerAddress;

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
                    System.out.println("Enter the consumer code: ");
                    consumerCode = input.nextInt();
                    System.out.println("Enter Consumer Name: ");
                    consumerName = input.next();
                    System.out.println("Enter Consumer Phone: ");
                    consumerPhone = input.next();
                    System.out.println("Enter Consumer Email Id: ");
                    consumerEmail = input.next();
                    System.out.println("Enter Consumer Address: ");
                    consumerAddress = input.next();


                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "INSERT INTO `consumer`(`consumerCode`, `consumerName`, `consumerPhone`, `consumerEmail`, `consumerAddress`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,consumerCode);
                        stmt.setString(2,consumerName);
                        stmt.setString(3,consumerPhone);
                        stmt.setString(4,consumerEmail);
                        stmt.setString(5,consumerAddress);
                        stmt.executeUpdate();
                        System.out.println("Data inserted successfully.");
                    }
                    catch (Exception e ){
                        System.out.println(e);
                    }
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
