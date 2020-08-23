import java.io.*;
import java.util.Random;    

//Code to check N runtimes of sum of two vectors
class Main {

  public static final int SUMLOOP = 10;
	
  public static void main(String[] args) {
    int[] vectA, vectB;
		long runtimes = 0, memoryUsage;
		
		Main main = new Main();
    Writer w = new Writer("output.txt");
    Runtime run = Runtime.getRuntime();

    int vectorSize = 10;

    while(vectorSize <= 100) {
      vectA = main.initializeVector(vectorSize);
      vectB = main.initializeVector(vectorSize);

      for(int i = 0; i < SUMLOOP; i++) {
        long start = System.nanoTime();
        main.sumVectors(vectA, vectB, vectorSize);
        long finish = System.nanoTime();

        runtimes += finish - start;
      }

      memoryUsage = run.totalMemory() - run.freeMemory();
      long averageRunTimes = runtimes / SUMLOOP;
      int instructions = main.countInstructions(vectorSize);

      System.out.println(vectorSize + 
                         " Average: "       + averageRunTimes +
                         " Instructions: "  + instructions +
                         " Memory Used: "   + memoryUsage + "KB"
                        );

      w.writeToFile(averageRunTimes + "\t" + instructions + "\t" + memoryUsage + "\n");        
      vectorSize++;    
    }
  }

  /***
    * Check how many instructions we have in sumVectors method
    * @param size
    * @return count
  ***/
  public int countInstructions(int size) {
    return 2*size + 1;
  }

  
  /***
	 * To sum 2 vectors and store into a result vector, so we can check runtimes later
	 * @param vectA
	 * @param vectB
	 * @param size
	***/
  public void sumVectors(int[] vectA, int[] vectB, int size) {
    int[] vectR = new int[size];        //1

    for(int i = 0; i < size; i++) {     //2N+1
      vectR[i] = vectA[i] + vectB[i];
    }
  }

  /***
    * Initialize a vector with random integers
    * @param size
    * @return vector
  ***/
  public int[] initializeVector(int size) {
    int[] vector = new int[size];
    Random r = new Random();

    for(int i = 0; i < size; i++) {
      vector[i] = r.nextInt();
    }

    return vector;
  }

}