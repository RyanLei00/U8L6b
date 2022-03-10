public class Encryptor
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;

  /** The number of rows of letterBlock, set by the constructor */
  private int numRows;

  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;

  /** Constructor*/
  public Encryptor(int r, int c)
  {
    letterBlock = new String[r][c];
    numRows = r;
    numCols = c;
  }

  public String[][] getLetterBlock()
  {
    return letterBlock;
  }

  public void fillBlock(String str)
  {
    int size = numRows * numCols;
    if(str.length() != size){
      if(str.length() > size){
        str = str.substring(0, size);
      }
      else{
        for(int i = str.length(); i < size; i++) {
          str = str + "A";
        }
      }
    }
    int i = 0;
      for(int r = 0; r < letterBlock.length; r++) {
        for (int c = 0; c < letterBlock[0].length; c++) {
          letterBlock[r][c] = str.substring(i, i + 1);
          i++;
      }
    }
  }

  public String encryptBlock()
  {
    String encrypted = "";
    for(int c = 0; c < letterBlock[0].length; c++){
      for(int r = 0; r < letterBlock.length; r++){
        encrypted += letterBlock[r][c];
      }
    }
    return encrypted;
  }

  public String encryptMessage(String message)
  {
    String str = "";
    while(message.length() > 0) {
      fillBlock(message);
      if(message.length() > numRows * numCols){
        message = message.substring(numRows * numCols);
      }
      else{
        message = "";
      }
      str += encryptBlock();
    }
    return str;
  }

  public String decryptMessage(String encryptedMessage)
  {
    encryptedMessage = decryptor(encryptedMessage);
    Encryptor decrypt = new Encryptor(numCols,numRows);
    return decryptor(decrypt.encryptMessage(encryptedMessage));
  }

  public static String decryptor(String str)
  {
    int length = str.length();
    for (int i = str.length() - 1; i >= 0 ; i--) {
      if(str.charAt(i) != 'A')
      {
        length = i + 1;
        break;
      }
    }
    return str.substring(0,length);
  }
}
