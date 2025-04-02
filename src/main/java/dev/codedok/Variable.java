package dev.codedok;

public class Variable {
    private String name;
    private double value;

    public Variable(String name, double value) {

        if(name.equals("e")) {
            System.out.println('"' + 'e' + '"' + " is an invalid variable name");
            return;
        }

        if(name.equals("i")) {
            System.out.println('"' + 'i' + '"' + " is an invalid variable name");
            return;
        }

        this.name = name;
        this.value = value;

    }
}
