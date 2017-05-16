import java.util.Objects;
import java.util.Random;

/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 5/16/17.
 */
public class Lock {
  private String keyVal;
  private int keyLength;
  private int keyRange;
  public final int firstCode = 32;
  public final int lastCode;

  public Lock(int length, int keyRange) throws LockException {
    if (keyRange > 95 || keyRange < 1) {
      throw new LockException("RangeOutOfBound");
    }

    lastCode = firstCode + length - 1;
    this.keyLength = length;
    this.keyRange = keyRange;
    generateKey();
  }

  public void generateKey() {
    keyVal = "";
    Random rand = new Random();
    int asciiCode;

    for (int i = 0; i < keyLength; i++) {
      asciiCode = rand.nextInt(keyRange) + firstCode;
      keyVal = keyVal + Character.toString((char) asciiCode);
    }
  }

  public boolean isUnlockedBy(String string) {
    return Objects.equals(keyVal, string);
  }

  String getKeyVal() {
    return keyVal;
  }

  public int getKeyLength() {
    return keyLength;
  }

  public int getKeyRange() {
    return keyRange;
  }
}