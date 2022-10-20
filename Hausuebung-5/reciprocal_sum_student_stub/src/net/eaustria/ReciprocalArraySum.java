/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eaustria;

/**
 *
 * @author bmayr
 */

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Class wrapping methods for implementing reciprocal array sum in parallel.
 */
public final class ReciprocalArraySum {

    public static void main(String[] args) {
        double[] arr = {1,2,3,4,5,6};
        double result = parManyTaskArraySum(arr,0);
        System.out.println(result);
    }

    /**
     * Default constructor.
     */
    private ReciprocalArraySum() {
    }

    /**
     * Sequentially compute the sum of the reciprocal values for a given array.
     *
     * @param input Input array
     * @return The sum of the reciprocals of the array input
     */
    protected static double seqArraySum(final double[] input) {
        double sum = 0;

        for(double v : input){
            sum = sum + (1/v);
        }
       return sum;
    }
  

    /**
     * This class stub can be filled in to implement the body of each task
     * created to perform reciprocal array sum in parallel.
     */
    private static class ReciprocalArraySumTask extends RecursiveTask<Double> {
        /**
         * Starting index for traversal done by this task.
         */
        private final int startIndexInclusive;
        /**
         * Ending index for traversal done by this task.
         */
        private final int endIndexExclusive;
        /**
         * Input array to reciprocal sum.
         */
        private final double[] input;
        /**
         * Intermediate value produced by this task.
         */
        private double value;
        
        private static int SEQUENTIAL_THRESHOLD = 50000;

        /**
         * Constructor.
         * @param setStartIndexInclusive Set the starting index to begin
         *        parallel traversal at.
         * @param setEndIndexExclusive Set ending index for parallel traversal.
         * @param setInput Input values
         */
        ReciprocalArraySumTask(final int setStartIndexInclusive,
                final int setEndIndexExclusive, final double[] setInput) {
            this.startIndexInclusive = setStartIndexInclusive;
            this.endIndexExclusive = setEndIndexExclusive;
            this.input = setInput;
        }

        /**
         * Getter for the value produced by this task.
         * @return Value produced by this task
         */
        public double getValue() {
            return value;
        }

        @Override
        protected Double compute() {
            // TODO: Implement Thread forking on Threshold value. (If size of
            // array smaller than threshold: compute sequentially else, fork 
            // 2 new threads

            if (input.length < 3){
                return seqArraySum(input);
            }else {

                 double[] arr1;
                 arr1 = Arrays.copyOfRange(input, 0, input.length/2);
                 double[] arr2;
                 arr2 = Arrays.copyOfRange(input, input.length/2, input.length);

                 ReciprocalArraySumTask right = new ReciprocalArraySumTask(0, arr1.length, arr1);
                 ReciprocalArraySumTask left = new ReciprocalArraySumTask(0, arr2.length, arr2);

                 invokeAll(right, left);
                 return right.join() + left.join();

            }
        }
    }
  

    /**
     * TODO: Extend the work you did to implement parArraySum to use a set
     * number of tasks to compute the reciprocal array sum. 
     *
     * @param input Input array
     * @param numTasks The number of tasks to create
     * @return The sum of the reciprocals of the array input
     */
    protected static double parManyTaskArraySum(final double[] input,
            final int numTasks) {
        double sum = 0;
       // ToDo: Start Calculation with help of ForkJoinPool
       ForkJoinPool forkJoinPool = new ForkJoinPool();
       ReciprocalArraySumTask reciprocalArraySumTask = new ReciprocalArraySumTask(0, input.length, input);
        forkJoinPool.execute(reciprocalArraySumTask);
        sum = forkJoinPool.invoke(reciprocalArraySumTask);
       return sum;
    }
}

