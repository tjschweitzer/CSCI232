  import java.util.Random;
  public class ComputePi {
    public static void main(String[] args) {
        int pieNumber;
//        pieNumber=Integer.parseInt(args[0]); //grabs an argument from command line converst the string to an int
      StdOut.println("Pi is about "+ compute__pi(100000000));
    }
    
    public static double compute__pi(int num) {
        double pi_num=0;
        Random random = new Random();
        for (int i =0; i<num;i++) {
            double x = random.nextDouble(); // Random double from 0 to 1
            double y = random.nextDouble(); // Random double from 0 to 1
            if(Math.sqrt(x*x+y*y)<1)pi_num++; //increments pi_num if the value is within the unit circle
        }
        return 4*pi_num/num;
    } 
  }