import java.util.Random;
import java.util.Scanner;

/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 5/16/17.
 */
public class Driver {
  public static void main(String[] args) throws LockException {

    Lock lock = new Lock(3, 5);
    PasswordCracker cracker = new PasswordCracker(lock);
    String inputKey;
    Scanner reader = new Scanner(System.in);

    System.out.println("Key : " + lock.getKeyVal());
    System.out.println("Enter key : ");
    inputKey = cracker.crackLock();
    if (lock.isUnlockedBy(inputKey)) {
      System.out.println("Success!");
    } else {
      System.out.println("Failed!");
      System.out.println(cracker.getKeyVal());
    }
  }
}
