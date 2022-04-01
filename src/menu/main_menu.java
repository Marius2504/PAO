package menu;
import client.*;
import company.*;
import employee.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class main_menu {
     public void start() throws ParseException {
          // Helpful data/classes/methods
         Date date = new Date();
         boolean ct = false;
         settings st = new settings(true,20);
         List<String> ev = Collections.singletonList("unpaid event for 12.22.2021");
         List<String> title_ev = Collections.singletonList("unpaid event");
         List<Double> salariess= List.of(1800.0,1800.0,1950.0);
         List<String> commentaries = List.of("nimic","nimic","a lipsit 2 zile");
         List<Integer> ratings = List.of(5,5,5,4,5,3);
         Map<Integer,Boolean> workDays = new HashMap<Integer, Boolean>();
         for(int i = 1;i<30;i++) {
             workDays.put(i, ct);
             ct= i % 2 == 0;
         }
         clear cl = new clear();
         contracts contr = contracts.getContracts();
         contr.addCompay("fds");
         payment.setFormula("basic formula");
         payment.setTaxes(3000.0);
         payment.setListTaxes(Arrays.asList("Gouvern 5%","Company 10%","Consumption 10%"));
         //(String name, String surname, String phone, String email, String password, Date birthDate, List<Double> salaries, List<String> comments, Integer overall, Map<Integer, Boolean> workDays)
         List<car> car_list = new ArrayList<>(Collections.singletonList(new car("Volvo", 11.3f, 1200, false, false)));
         List<driver> driver_list = new ArrayList<>(Collections.singletonList(new driver("Patrick", "Hense", "0767167788", "patrick_2000@hotmail.com", "patrick11", date, salariess, commentaries, 4, workDays, ratings, car_list.get(0))));
         List<employee> employee_list = new ArrayList<>(Collections.singletonList(new employee("John", "William", "john_william@yahoo.com", "0722345609", "wiliam01", date, salariess, commentaries, 4, workDays)));
         List<history> history_list = new ArrayList<>(Collections.singletonList(new history(123, "Bucharest, Street Lotrioara 35", "Street Ion Mihalache 18A", date)));
         List<register> clients_list = new ArrayList<>(Collections.singletonList(new register("Will", "Smith", "0725677901", "willsmith@gmail.com", "willie0123", date, history_list, st, 4, ev, title_ev)));
         List<help> help_list = new ArrayList<>(List.of(new help("message", "help", clients_list.get(0))));
         List<map> map_list = new ArrayList<>(Collections.singletonList(new map(true, false, 10, driver_list.get(0), clients_list.get(0))));

         //metoda prin care curatam terminalul
         boolean isOn = true;
         boolean isMenu = true;
         boolean isOpt = true;
         Scanner sc=new Scanner(System.in);
         int choose,choose1,choose2;
         while (isOn)
         {
             System.out.println("1.Client");
             System.out.println("2.Company");
             System.out.println("3.Employee");
             System.out.println("9.Exit");

             choose = sc.nextInt();
             cl.clearAll();
             isMenu = true;
             if(choose == 1)
             {
                 while (isMenu) {
                     System.out.println("1.Human");
                     System.out.println("2.Help");
                     System.out.println("3.History");
                     System.out.println("4.Preferences");
                     System.out.println("5.Register");
                     System.out.println("6.Settings");
                     System.out.println("9.Back");
                     choose1 = sc.nextInt();
                     cl.clearAll();
                     isOpt = true;

                     if (choose1 == 1) {
                         System.out.println("Human is an abstract class, can't initialize an object");
                     }
                     if (choose1 == 2) {
                         while (isOpt) {
                             System.out.println("\nHelp class is useful to receive messages from clients");
                             System.out.println("1.Show all");
                             System.out.println("2.Add help");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             cl.clearAll();
                             if (choose2 == 1) {
                                 for (client.help help : help_list) {
                                     System.out.println("Title: " + help.getTitle());
                                     System.out.println("Message: " + help.getMessage());
                                     System.out.println("Sender's name: " + help.getAcc().getName());
                                     System.out.println("---------------------------------");
                                 }
                             }
                             if (choose2 == 2) {
                                 help aux= new help();
                                 String var;
                                 //String name, String surname, String phone, String email, String password, Date birthDate, List<history> hst, settings st, int rating, List<String> events, List<String> titleEvents
                                 System.out.println("Title: ");
                                 var = sc.next();
                                 aux.setTitle(var);
                                 System.out.println("Message: ");
                                 var = sc.next();
                                 aux.setMessage(var);

                                 System.out.println("====== Account details ======");
                                 register acc1 = new register();
                                 aux.setAcc(acc1);
                                 System.out.println("Name: ");
                                 var = sc.next();
                                 aux.getAcc().setName(var);
                                 System.out.println("Surname: ");
                                 var = sc.next();
                                 aux.getAcc().setSurname(var);
                                 System.out.println("Phone number: ");
                                 var = sc.next();
                                 aux.getAcc().setPhone(var);
                                 System.out.println("Password: ");
                                 var = sc.next();
                                 aux.getAcc().setPassword(var);
                                 System.out.println("Email: ");
                                 var = sc.next();
                                 aux.getAcc().setEmail(var);
                                 System.out.println("Birthdate(dd/MM/yyyy): ");
                                 var=sc.next();
                                 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(var);
                                 aux.getAcc().setBirthDate(date1);

                                 help_list.add(aux);
                             }
                             if (choose2 == 9)
                                 isOpt = false;
                         }
                     }
                     if (choose1 == 3) {
                         while (isOpt)
                         {
                             System.out.println("\nHistory class is used to store information about clients' rides");
                             System.out.println("1.Show all");
                             System.out.println("2.Add help");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             cl.clearAll();
                             if (choose2 == 1) {
                                 for (client.history history : history_list) {
                                     System.out.println("Price: " + history.getPrice());
                                     System.out.println("Start location: " + history.getStartLocation());
                                     System.out.println("End location: " + history.getEndLocation());
                                     System.out.println("---------------------------------");
                                 }
                             }
                             if (choose2 == 2) {
                                 history aux= new history();
                                 String var;
                                 double pr;
                                 //String name, String surname, String phone, String email, String password, Date birthDate, List<history> hst, settings st, int rating, List<String> events, List<String> titleEvents
                                 System.out.println("Pricee: ");
                                 pr = sc.nextInt();
                                 aux.setPrice(pr);
                                 System.out.println("Start location: ");
                                 var = sc.next();
                                 aux.setStartLocation(var);
                                 System.out.println("End location: ");
                                 var = sc.next();
                                 aux.setEndLocation(var);
                                 System.out.println("Date(dd/MM/yyyy): ");
                                 var=sc.next();
                                 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(var);
                                 aux.setDate(date1);

                                 history_list.add(aux);
                             }
                             if(choose2 == 9)
                                 isOpt = false;
                         }
                     }
                     if (choose1 == 4) {
                         System.out.println("\nPreferences are set up for client in order to obtain a better understanding of client's necessity ");
                     }
                     if (choose1 == 5)
                     {
                         while (isOpt) {
                             System.out.println("\nRegister class is used to store values about clients");
                             System.out.println("1.Show all");
                             System.out.println("2.Add a client");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             cl.clearAll();
                             if (choose2 == 1) {
                                 for (client.register register : clients_list) {
                                     System.out.println("Name: " + register.getName());
                                     System.out.println("Surname: " + register.getSurname());
                                     System.out.println("Phone: " + register.getPhone());
                                     System.out.println("Email: " + register.getEmail());
                                     System.out.println("Password: " + register.getPassword());
                                     System.out.println("Birthdate: " + register.getBirthDate());
                                     System.out.println("History events prices:");
                                     for (client.history history : register.getHst())
                                         System.out.println(history.getPrice());
                                     System.out.println("Settings: " + register.getSt());
                                     System.out.println("Rating:" + register.getRating());
                                     System.out.println("Events:" + Arrays.toString(register.getEvents().toArray()));
                                     System.out.println("Titles for events:" + Arrays.toString(register.getTitleEvents().toArray()));
                                     System.out.println("---------------------------------");
                                 }
                             }
                             if (choose2 == 2) {
                                 register aux= new register();
                                 String var;
                                 int n;
                                 //String name, String surname, String phone, String email, String password, Date birthDate, List<history> hst, settings st, int rating, List<String> events, List<String> titleEvents
                                 System.out.println("Name: ");
                                 var = sc.next();
                                 aux.setName(var);
                                 System.out.println("Surname: ");
                                 var = sc.next();
                                 aux.setSurname(var);
                                 System.out.println("Phone number: ");
                                 var = sc.next();
                                 aux.setPhone(var);
                                 System.out.println("Password: ");
                                 var = sc.next();
                                 aux.setPassword(var);
                                 System.out.println("Email: ");
                                 var = sc.next();
                                 aux.setEmail(var);
                                 System.out.println("Birthdate(dd/MM/yyyy): ");
                                 var=sc.next();
                                 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(var);
                                 aux.setBirthDate(date1);
                                 System.out.println("Rating: ");
                                 n = sc.nextInt();
                                 aux.setRating(n);

                                 aux.setHst(history_list);
                                 aux.setSt(st);
                                 aux.setEvents(ev);
                                 aux.setTitleEvents(title_ev);
                                 clients_list.add(aux);
                             }
                             if (choose2 == 9)
                                 isOpt = false;
                         }
                     }
                     if (choose1 == 6) {
                         System.out.println("\nSettings are chosen by client for a better experience with the application");
                     }
                     if (choose1 == 9)
                         isMenu = false;
                 }
             }
             if(choose == 2)
             {
                 while (isMenu) {
                     System.out.println("1.Contacts");
                     System.out.println("2.Employee");
                     System.out.println("3.Payment");
                     System.out.println("9.Back");
                     choose1 = sc.nextInt();
                     cl.clearAll();
                     if(choose1 == 1)
                     {
                         while (isOpt){
                             System.out.println("\nContracts is a singleton class which describes the contracts of the company");
                             System.out.println("1.Show actual contracts");
                             System.out.println("2.Add a company name");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             if(choose2 == 1)
                             {
                                 for(String company: contr.getCompanies())
                                     System.out.println("Company name: "+company);
                             }
                             if(choose2 == 2)
                             {
                                 String company = sc.next();
                                 contr.addCompay(company);
                             }
                             if (choose2 == 9)
                                 isOpt = false;
                         }
                     }

                     if( choose1 == 2)
                     {
                         while (isOpt){
                             System.out.println("\nEmployee class gives information about an employee");
                             System.out.println("1.Show all employees");
                             System.out.println("2.Add an employee");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             if(choose2 == 1)
                             {
                                    for(employee emp:employee_list)
                                    {
                                        System.out.println("Name: "+emp.getName());
                                        System.out.println("Surname: "+emp.getSurname());
                                        System.out.println("Overall rating: "+emp.getOverall());
                                        System.out.println("Salaries: ");
                                        for(double sa:emp.getSalaries())
                                        {
                                            System.out.print(sa + " ");
                                        }
                                        System.out.println("\nComments: ");
                                        for(String sa:emp.getComments())
                                        {
                                            System.out.print(sa + " ");
                                        }
                                        System.out.println("\nWorking days: ");
                                        for(Map.Entry<Integer,Boolean> entry : emp.getWorkDays().entrySet())
                                        {
                                            if(entry.getValue())
                                                System.out.print(entry.getKey() + ", ");
                                        }
                                        System.out.println();
                                    }
                             }
                             if (choose2 == 2) {
                                 employee aux = new employee();
                                 String var;
                                 int n;
                                 //String name, String surname, String phone, String email, String password, Date birthDate, List<history> hst, settings st, int rating, List<String> events, List<String> titleEvents
                                 System.out.println("Name: ");
                                 var = sc.next();
                                 aux.setName(var);
                                 System.out.println("Surname: ");
                                 var = sc.next();
                                 aux.setSurname(var);
                                 System.out.println("Phone number: ");
                                 var = sc.next();
                                 aux.setPhone(var);
                                 System.out.println("Password: ");
                                 var = sc.next();
                                 aux.setPassword(var);
                                 System.out.println("Email: ");
                                 var = sc.next();
                                 aux.setEmail(var);
                                 System.out.println("Birthdate(dd/MM/yyyy): ");
                                 var = sc.next();
                                 Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(var);
                                 aux.setBirthDate(date1);

                                 aux.setSalaries(salariess);
                                 aux.setComments(commentaries);
                                 aux.setWorkDays(workDays);

                                 employee_list.add(aux);
                             }
                             if (choose2 == 9)
                                 isOpt = false;
                         }

                     }
                     if(choose1 == 3)
                     {
                         System.out.println("\nPayment is a class which describes the actual payment method");
                         System.out.println("Formula: "+payment.getFormula());
                         System.out.println("Total sum of taxes: "+payment.getTaxes());
                         System.out.print("Taxes: ");
                         for(String t:payment.getListTaxes())
                         {
                             System.out.print(t+", ");
                         }
                         System.out.println();
                     }
                     if (choose1 == 9)
                         isMenu = false;
                 }
             }
             if(choose == 3)
             {
                 while (isMenu) {
                     System.out.println("1.Car");
                     System.out.println("2.Driver");
                     System.out.println("3.Map");
                     System.out.println("9.Back");
                     choose1 = sc.nextInt();
                     cl.clearAll();
                     if(choose1 == 1)
                     {
                         while (isOpt) {
                             System.out.println("\nCar is a class that describes cars");
                             System.out.println("1.Show all cars");
                             System.out.println("2.Add a car");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             if (choose2 == 1) {
                                 for (car cr : car_list) {
                                     System.out.println("Brand: " + cr.getBrand());
                                     System.out.println("Avg consum: " + cr.getAvgConsum());
                                     System.out.println("Total km: " + cr.getTotalKm());
                                     System.out.println("Is the car electric? " + cr.isElectric());
                                     System.out.println("Does the care have a child seat ? " + cr.isHasChildSeat());
                                 }
                             }
                             if (choose2 == 2) {
                                 car aux = new car();
                                 String var;
                                 int n;
                                 float avg;
                                 //String brand, float avgConsum, Integer totalKm, boolean isElectric, boolean hasChildSeat
                                 System.out.println("Brand: ");
                                 var = sc.next();
                                 aux.setBrand(var);
                                 System.out.println("Average consume: ");
                                 avg = sc.nextFloat();
                                 aux.setAvgConsum(avg);
                                 System.out.println("Total km: ");
                                 n = sc.nextInt();
                                 aux.setTotalKm(n);
                                 System.out.println("Is electric?[yes/no] ");
                                 var = sc.next();
                                 if (var.equals("yes"))
                                     aux.setIsElectric(true);
                                 else
                                     aux.setIsElectric(false);
                                 System.out.println("Does it have a child seat?[yes/no] ");
                                 var = sc.next();
                                 if (var.equals("yes"))
                                     aux.setHasChildSeat(true);
                                 else
                                     aux.setHasChildSeat(false);

                                 car_list.add(aux);

                             }
                             if (choose2 == 9)
                                 isOpt = false;
                         }
                     }
                     if (choose1 == 2)
                     {
                         while (isOpt) {
                             System.out.println("\nDriver is a class used to get and set information about a driver");
                             System.out.println("1.Show all drivers");
                             System.out.println("2.Add a driver");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             if (choose2 == 1) {
                                 for (driver dv : driver_list) {
                                     System.out.println("Name: " + dv.getName());
                                     System.out.println("Surname: " + dv.getSurname());
                                     System.out.println("Overall rating: " + dv.getOverall());
                                     System.out.println("Salaries: ");
                                     for (double sa : dv.getSalaries()) {
                                         System.out.print(sa + " ");
                                     }
                                     System.out.println("\nComments: ");
                                     for (String sa : dv.getComments()) {
                                         System.out.print(sa + " ");
                                     }
                                     System.out.println("\nWorking days: ");
                                     for (Map.Entry<Integer, Boolean> entry : dv.getWorkDays().entrySet()) {
                                         if (entry.getValue())
                                             System.out.print(entry.getKey() + ", ");
                                     }
                                     System.out.println("\nRatings: ");
                                     for (Integer r : dv.getRatings()) {
                                         System.out.print(r + " ");
                                     }
                                     System.out.println("\nCar information: ");
                                     System.out.println("Brand: " + dv.getCr().getBrand());
                                     System.out.println("Avg consum: " + dv.getCr().getAvgConsum());
                                     System.out.println("Total km: " + dv.getCr().getTotalKm());
                                     System.out.println("Is the car electric? " + dv.getCr().isElectric());
                                     System.out.println("Does the care have a child seat ? " + dv.getCr().isHasChildSeat());
                                 }
                             }
                             if (choose2 == 2) {
                                 driver aux = new driver();
                                 String var;
                                 int n;
                                 //String name, String surname, String phone, String email, String password, Date birthDate, List<history> hst, settings st, int rating, List<String> events, List<String> titleEvents
                                 System.out.println("Name: ");
                                 var = sc.next();
                                 aux.setName(var);
                                 System.out.println("Surname: ");
                                 var = sc.next();
                                 aux.setSurname(var);
                                 System.out.println("Phone number: ");
                                 var = sc.next();
                                 aux.setPhone(var);
                                 System.out.println("Password: ");
                                 var = sc.next();
                                 aux.setPassword(var);
                                 System.out.println("Email: ");
                                 var = sc.next();
                                 aux.setEmail(var);
                                 System.out.println("Birthdate(dd/MM/yyyy): ");
                                 var = sc.next();
                                 Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(var);
                                 aux.setBirthDate(date1);
                                 System.out.println("Overall rating: ");
                                 n = sc.nextInt();
                                 aux.setOverall(n);

                                 aux.setSalaries(salariess);
                                 aux.setComments(commentaries);
                                 aux.setWorkDays(workDays);
                                 aux.setRatings(ratings);
                                 aux.setCr(car_list.get(0));

                                 driver_list.add(aux);
                             }
                             if (choose2 == 9)
                                 isOpt = false;
                         }
                     }
                     if(choose1 == 3)
                     {
                         while (isOpt) {
                             System.out.println("\nMap is a class used to store data about rides");
                             System.out.println("1.Show all maps");
                             System.out.println("2.Add a map");
                             System.out.println("9.Go back");
                             choose2 = sc.nextInt();
                             if (choose2 == 1) {
                                 for (map mp : map_list) {
                                     System.out.println("Is the traffic busy? " + mp.isBusy());
                                     System.out.println("Is the weather bad? " + mp.isBadWeather());
                                     System.out.println("Total km: " + mp.getTotalKm());
                                     System.out.println("Information about driver: ");
                                     System.out.println("Name: " + mp.getDrv().getName());
                                     System.out.println("Surname: " + mp.getDrv().getSurname());
                                     System.out.println("Overall rating: " + mp.getDrv().getOverall());
                                     System.out.println("=====Information about the client===== ");
                                     System.out.println("Name: " + mp.getReg().getName());
                                     System.out.println("Surname: " + mp.getReg().getSurname());
                                     System.out.println("Phone: " + mp.getReg().getPhone());
                                 }
                             }
                             if (choose2 == 2) {
                                 map aux = new map();
                                 String var;
                                 int n;
                                 float avg;
                                 //boolean isBusy,boolean badWeather, Integer totalKm, driver drv, register reg
                                 System.out.println("Is the traffic busy?[yes/no]: ");
                                 var = sc.next();
                                 if (var.equals("yes"))
                                     aux.setBusy(true);
                                 else
                                     aux.setBusy(false);
                                 System.out.println("Is the weather bad?[yes/no] ");
                                 var = sc.next();
                                 if (var.equals("yes"))
                                     aux.setBadWeather(true);
                                 else
                                     aux.setBadWeather(false);
                                 System.out.println("Total km: ");
                                 n = sc.nextInt();
                                 aux.setTotalKm(n);
                                 aux.setDrv(driver_list.get(0));
                                 aux.setReg(clients_list.get(0));

                                 map_list.add(aux);
                             }
                             if (choose2 == 9)
                                 isOpt = false;
                         }
                     }
                     if (choose1 == 9)
                         isMenu = false;
                 }
             }
             if(choose == 9)
                 isOn = false;
         }
    }
}
