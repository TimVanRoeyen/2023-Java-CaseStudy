package be.abis.projectING.repository;

import be.abis.projectING.model.SandwichType;
import be.abis.projectING.model.ToppingType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Initialize Sandwich Data
public class SandwichTypeRepository {
    private List<SandwichType> sandwichTypes;

    public SandwichTypeRepository(){
        sandwichTypes = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(new File("be/abis/projectING/data/SandwichTypes.csv"));
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                List<String> lineToArray = List.of(sc.next().split(";"));
                if(lineToArray.size() == 3){
                    sandwichTypes.add(new SandwichType(lineToArray.get(0), lineToArray.get(1), Double.parseDouble(lineToArray.get(2))));
                } else if(lineToArray.size() == 4){
                    sandwichTypes.add(new SandwichType(lineToArray.get(0), lineToArray.get(1), Double.parseDouble(lineToArray.get(2)), lineToArray.get(3)));
                }
            }
            System.out.println("Initialized sandwich types. Sandwich names are now:");
            for(SandwichType s:sandwichTypes){
                System.out.println(s.getName() + " of type " + s.getToppingType().toString() + " with price " + s.getPrice());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load input file");
        }

    }

    public SandwichType getSandwichTypeByName(String name){
        return sandwichTypes.stream()
                .filter(st -> st.getName().equalsIgnoreCase(name))
                .findFirst()
                .get();
    }
    public void addSandwichType(String name, String toppingType, Double price){
        sandwichTypes.add(new SandwichType(name, toppingType, price));
    }
    public void addSandwichTypeWithDescription(String name, String toppingType, Double price, String description){
        sandwichTypes.add(new SandwichType(name, toppingType, price, description));
    }

    public void removeSandwichTypeByName(String name){
        sandwichTypes.removeIf(st -> st.getName().equalsIgnoreCase(name));
    }

    public String getOverviewOfSandwichTypes(){
        StringBuilder sb = new StringBuilder();
        sandwichTypes.stream()
                .forEach(type -> sb.append(type.getName() + ","));
        sb.append("\n");
        return sb.toString();
    }
}
