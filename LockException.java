/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 5/16/17.
 */
public class LockException extends Exception {
  private String msg;
  public LockException(String msg) {
    switch (msg) {
      case "RangeOutOfBound" : this.msg = "Error : Key range out of bound";
      break;
      default : this.msg = "Error : Unspecified";
      break;
    }
  }

  public String toString() {
    return msg;
  }
}
