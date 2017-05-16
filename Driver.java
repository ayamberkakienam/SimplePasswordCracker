import java.util.Random;
import java.util.Scanner;

/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 5/16/17.
 */
public class Driver {
  public static void main(String[] args) throws LockException {

    Lock lock;
    PasswordCracker cracker;
    double startTime;
    double duration;
    final int maxRange = 95;
    final int maxLength = 16;

    /*
    Length sebagai sumbu x
    Range sebagai sumbu y
     */
    System.out.print("Range");
    for (int i = 1; i <= maxLength; i++) {
      System.out.printf(",%d", i);
    }
    System.out.println();

    for (int range = 1; range <= maxRange; range++) {
      System.out.print(range);
      for (int length = 1; length <= maxLength; length++) {
        lock = new Lock(length, range);
        cracker = new PasswordCracker(lock);

        startTime = System.currentTimeMillis();
        cracker.crackLock();
        duration = System.currentTimeMillis() - startTime;
        System.out.printf(",%.2f", duration);
      }
      System.out.println();
    }
  }
}
