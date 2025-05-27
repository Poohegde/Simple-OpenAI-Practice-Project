package ai.generator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        GPTClient gpt = new GPTClient();
        Scanner scanner = new Scanner(System.in);

        System.out.println("JavaMethodStubGenerator - Describe a method to generate:");

        while (true) {
            System.out.print("Description (or type 'exit'): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) break;

            String stub = gpt.generateMethodStub(input);
            System.out.println("\nGenerated Java Method Stub:\n");
            System.out.println(stub);
            System.out.println("\n------------------------------\n");
        }
    }
}
