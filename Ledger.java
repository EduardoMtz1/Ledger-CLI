import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ledger {

    public File indexFile;
    public File priceDBFile;
    public List<String> accounts = new ArrayList<String>();
    public String sufix;

    void errorHandling(String s) {
        System.out.println(s);
        System.exit(-1);
    }

    void registerFunction(){

    }

    void balanceFunction(){

    }

    void printFunction(){

    }

    public static void main(String[] args) {
        String priceDB = "", index = "", sortBy = "", action = "";
        Boolean sort = false, actionReady = false;
        Ledger ledger = new Ledger();
        List<String> actionArgs = new ArrayList<String>();
        if (args.length == 0) {
            ledger.errorHandling("No arguments found");
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].trim().equals("--price-db")) {
                actionReady = false;
                if(i + 1 == args.length) ledger.errorHandling("No price-db file defined");
                priceDB = args[i + 1].trim();
            } if (args[i].trim().equals("-f") || args[i].trim().equals("--file")) {
                actionReady = false;
                if(i + 1 == args.length) ledger.errorHandling("No file defined");
                index = args[i + 1].trim();
            }
            if (args[i].trim().equals("-s") || args[i].trim().equals("--sort")){
                actionReady = false;
                sort = true;
                if(i + 1 == args.length) ledger.errorHandling("No sort mode defined");
                sortBy = args[i + 1].trim();
            }
            if(args[i].trim().equals("bal")||args[i].trim().equals("balance")){
                action="bal";
                actionReady = true;
            }
            if(args[i].trim().equals("reg")||args[i].trim().equals("registry")){ 
                action="reg";
                actionReady = true;
            }
            if(args[i].trim().equals("print")){ 
                action="print";
                actionReady = true;
            }
            if(actionReady)actionArgs.add(args[i].trim());
        }
        
        ledger.indexFile = new File(index);
        if (!ledger.indexFile.exists()) {
            ledger.errorHandling("File " + index + " not found");
        }
        ledger.priceDBFile = new File(priceDB);
        if(!ledger.priceDBFile.exists()){
            ledger.errorHandling("File " + priceDB + " not found");
        }

        try {
            Scanner fileRead = new Scanner(ledger.indexFile);
            while(fileRead.hasNextLine()){
                String lineRead = fileRead.nextLine();
                String[] sliced = lineRead.split("\\s");
                if(sliced[0].trim().equals("!include")){
                    String[] name = sliced[1].split("\\.");
                    ledger.accounts.add(name[0].trim());
                    if(ledger.sufix == null) ledger.sufix = name[1].trim();
                }
            }
            fileRead.close();
        } catch (FileNotFoundException e) {
            ledger.errorHandling("File " + index + " not found\n" + e.getStackTrace());
        }

        if(action.equals(""))ledger.errorHandling("No action defined");
        if(action.equals("bal"))ledger.balanceFunction();
        if(action.equals("reg"))ledger.registerFunction();
        if(action.equals("print"))ledger.printFunction();
    }
}