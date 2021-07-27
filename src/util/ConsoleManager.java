package util;

import model.Group;
import model.enums.Complexity;
import model.enums.Resolution;
import storage.Storage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleManager {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String userCommand = "";

    //Group fields
    private static String groupName;
    private static Group parentGroup;

    //Item fields
    private static String itemName;
    private static double price;
    private static Complexity complexity;
    private static Resolution resolution;

    private ConsoleManager() {
    }

    //At first in console we collect all required information about Group
    public static void readGroup() {

        //Initialising group name
        System.out.println("Please Enter the name of Group");
        while (true) {
            groupName = SCANNER.nextLine();
            if (!groupName.isEmpty()) {
                break;
            } else System.out.println("You entered empty name, please reenter");
        }

        //Initializing parent group ID if it exists
        System.out.println("Please Enter the ID of the parent group, or press 'Enter'");
        while (true) {
            int groupID;
            String id = SCANNER.nextLine();
            if(id.isEmpty()) {
                break;
            }else if(isValidNumeric(id)){
                groupID = Integer.parseInt(id);
                if(groupID>0){
                    parentGroup = Storage.getByID(groupID);
                    break;
                } else System.out.println("Negative digit not allowed");
            }  else {
                System.out.println("You entered wrong data, please input only digits");
            }
        }


        System.out.println("Please input 'continue' if You want to finish creation of groups, and go to next step, or press 'Enter'");
        userCommand = SCANNER.nextLine().toUpperCase();
    }

    //Then we collect all required information about Item
    public static void readItem() {

        //name
        System.out.println("Please input the name of Item");
        itemName = SCANNER.nextLine();

        //price
        System.out.println("Please input the price of Item");
        price = Double.parseDouble(SCANNER.nextLine());

        //complexity
        System.out.println("Please input the complexity of item (1 or 2) if you want to create GenerativeItem, " +
                "or press 'Enter' to create StockItem type");
        String comp = SCANNER.nextLine();
        if (!comp.equals("1") && !comp.equals("2") && !comp.isEmpty()) {
            System.out.println("Wrong input. Creating StockItem");
        }
        if (!comp.isEmpty()) {
            complexity = (Integer.parseInt(comp) == 1) ? Complexity.ONE : Complexity.TWO;
        }

        //resolution
        System.out.println("Please input resolution of visual (1 for HD, 2 for FHD, 3 for UHD) " +
                "or press 'Enter' to set resolution to HD by default");
        String res = SCANNER.nextLine();
        if (res.isEmpty()) {
            resolution = Resolution.HD;
        }
        if (!res.equals("1") && !res.equals("2") && !res.equals("3") && !res.isEmpty()) {
            System.out.println("Wrong input, setting resolution to HD by default");
            resolution = Resolution.HD;
        }
        if (!res.isEmpty()) {
            int rez = Integer.parseInt(res);
            if (rez == 1) {
                resolution = Resolution.HD;
            } else if (rez == 2) {
                resolution = Resolution.FHD;
            } else if (rez == 3) {
                resolution = Resolution.UHD;
            }
        }

        //command
        System.out.println("Please input 'exit' if You want to finish adding Items, or press 'Enter'");
        userCommand = SCANNER.nextLine().toUpperCase();
    }

    public static boolean isValidNumeric(String s){
        String regex = "[0-9]";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(s).matches();
    }

    public static String getUserCommand() {
        return userCommand;
    }

    public static String getGroupName() {
        return groupName;
    }

    public static Group getParentGroup() {
        return parentGroup;
    }

    public static String getItemName() {
        return itemName;
    }

    public static double getPrice() {
        return price;
    }

    public static Complexity getComplexity() {
        return complexity;
    }

    public static Resolution getResolution() {
        return resolution;
    }
}
