 import java.util.Scanner;
  class BankDeatils{
    private String acc_no;
    private String name;
    private String acc_type;
    private Long balance;
    Scanner sc=new Scanner(System.in);
    // method  to open new account
    public void openAccount(){
        System.out.println("Enter Account Number: ");
        acc_no=sc.nextLine();
        System.out.println("Enter Name: ");
        name=sc.nextLine();
        System.out.println("Enter Account Type: ");
        acc_type=sc.nextLine();
        System.out.println("Enter Balance: ");
        balance=sc.nextLong();
    }
    // method to display account details
    public void  showAccount(){
        System.out.println("Name of account holder"+name);
        System.out.println("Account no."+ acc_no);
        System.out.println("Account type"+ acc_type);
        System.out.println("Balance"+ balance);
    }
    // method to deposit money
    public void depositMoney(){
        Long amt;
        System.out.println("Enter amount to deposit: ");
        amt=sc.nextLong();
        balance=balance+amt;
    }
        // method to withdrwal amount
    public void withdraw(){
            Long amt;
            System.out.println("Enter amount to withdraw: ");
            amt=sc.nextLong();
            if(balance<amt){
                System.out.println("Insufficient balance");
            }
            else{
                balance=balance-amt;
            System.out.println("balance after withdrawl:"+balance);
            }
        }
        // method to search an account number
        public  boolean searchAccount( String ac_no){
            if(acc_no.equals(ac_no)){
                showAccount();
                return(true);

            }
            return (false);
        }
    }
        public class BankingApp{
            public static void main(String[] args) {
                Scanner sc=new Scanner(System.in);
                //creating initial accounts
                System.out.println("how many numbers of customer do you want to input?");
                int n=sc.nextInt();
             BankDeatils c[]=new BankDeatils[n];
             for(int i=0;i<n;i++){
                
               c[i]=new BankDeatils();
                c[i].openAccount();


            }
            // loop runs untill number 5 is not pressed to exit
            int choice;
            do{
                System.out.println("\n * * * Banking System Application");
                System.out.println("1. Display all accounts details\n");
                System.out.println("2. Search account number\n");
                System.out.println("3. Deposit money\n");
                System.out.println("4. Withdraw money\n");
                System.out.println("5. Exit\n");
                System.out.println("Enter your choice: ");
                choice=sc.nextInt();
                switch(choice){
                    case 1:
                    for(int i=0;i<n;i++){
                        c[i].showAccount();
                    }
                    break;
                    case 2:
                    System.out.println("Enter account number to search: ");
                    String ac_no=sc.next();
                    boolean found=false;
                    for(int i=0;i<c.length;i++){
                        found=c[i].searchAccount(ac_no);
                        if(found){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Account not found");
                    }
                    break;
                    case 3:
                    System.out.println("Enter account number to deposit: ");
                    ac_no=sc.next();
                    boolean found1=false;
                    for(int i=0;i<c.length;i++){
                        found1=c[i].searchAccount(ac_no);
                        if(found1){
                            c[i].depositMoney();
                            break;
                    }
                }
                if(!found1){
                    System.out.println("Account not found");
                }
                break;
                case 4:
                System.out.println("Enter account number to withdraw: ");
                ac_no=sc.next();
                boolean found2=false;
                for(int i=0;i<c.length;i++){
                    found2=c[i].searchAccount(ac_no);
                    if(found2){
                        c[i].withdraw();
                        break;
                        }
                        }
                        if(!found2){
                            System.out.println("Account not found");
                            }
                            break;
                            case 5:
                            System.out.println("see you soon ,exit");
                            break;
                            default:
                            System.out.println("Invalid choice");
                 }
                }
                 while(choice!=5);
                
            }
        }
    

    

                       
            
    

    


