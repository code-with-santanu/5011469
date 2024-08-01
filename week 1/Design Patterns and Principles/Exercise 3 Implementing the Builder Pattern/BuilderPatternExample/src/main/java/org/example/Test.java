package org.example;

public class Test {
    public static void main(String[] args) {
        // Creating different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.ComputerBuilder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setOS("Windows 10")
                .build();

        Computer officePC = new Computer.ComputerBuilder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setOS("Windows 10")
                .build();

        Computer homePC = new Computer.ComputerBuilder()
                .setCPU("AMD Ryzen 5")
                .setRAM("8GB")
                .setStorage("1TB HDD")
                .setOS("Linux")
                .build();

        // Print the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
        System.out.println(homePC);
    }
}