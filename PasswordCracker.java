/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 5/16/17.
 */
public class PasswordCracker {
  private  Lock lock;
  private int[] keyCode;
  private String keyVal;
  private int crackCounter;

  public PasswordCracker(Lock lock) {
    this.lock = lock;
    keyCode = new int [lock.getKeyLength()];
    for (int i = 0; i < keyCode.length; i++) {
      keyCode[i] = lock.firstCode;
    }
    keyToString();
    crackCounter = 1;
  }

  public String crackLock() {
    while (!lock.isUnlockedBy(keyVal)) {
      keyCode[0]++;
      if (keyCode[0] > lock.lastCode) {
        for (int i = 0; i < lock.getKeyLength() - 1; i++) {
          if (keyCode[i] > lock.lastCode) {
            keyCode[i+1]++;
            keyCode[i] = lock.firstCode;
          }
        }
      }
      keyToString();
      crackCounter++;
    }
    return keyVal;
  }

  public void keyToString() {
    keyVal = "";
    for (int i = 0; i < lock.getKeyLength(); i++) {
      keyVal = keyVal + Character.toString((char) keyCode[i]);
    }
  }

  public int[] getKeyCode() {
    return keyCode;
  }

  public Lock getLock() {
    return lock;
  }

  public String getKeyVal() {
    return keyVal;
  }

  public int getCrackCounter() {
    return crackCounter;
  }
}
