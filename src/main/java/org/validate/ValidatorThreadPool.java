package org.validate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aman on 22/7/15.
 */

/********
 * creates a thread pool with the
 * number of threads = number of cores in the system
 * created a executor
 */
public class ValidatorThreadPool {
    public static void main(String[] args) {
        ArrayList<String> inputArr = new ArrayList<String>();
        int cores = Runtime.getRuntime().availableProcessors();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext() == true) {
            inputArr.add(scanner.nextLine());
        }
        scanner.close();
        if (inputArr.size() == 0) {
            System.out.println("Invalid");
        }


        ExecutorService executor = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < inputArr.size(); i++) {
            Runnable worker = new ValidatorTask(i, inputArr.get(i));
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }
}
