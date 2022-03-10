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

  /** Encrypts a message.
   *
   *  @param message the string to be encrypted
   *
   *  @return the encrypted message; if message is the empty string, returns the empty string
   */
  public String encryptMessage(String message)
  {
    String str = "";
    fillBlock(message);
    str = encryptBlock();
    return str;
  }
  
  /**  Decrypts an encrypted message. All filler 'A's that may have been
   *   added during encryption will be removed, so this assumes that the
   *   original message (BEFORE it was encrypted) did NOT end in a capital A!
   *
   *   NOTE! When you are decrypting an encrypted message,
   *         be sure that you have initialized your Encryptor object
   *         with the same row/column used to encrypted the message! (i.e. 
   *         the �encryption key� that is necessary for successful decryption)
   *         This is outlined in the precondition below.
   *
   *   Precondition: the Encryptor object being used for decryption has been
   *                 initialized with the same number of rows and columns
   *                 as was used for the Encryptor object used for encryption. 
   *  
   *   @param encryptedMessage  the encrypted message to decrypt
   *
   *   @return  the decrypted, original message (which had been encrypted)
   *
   *   TIP: You are encouraged to create other helper methods as you see fit
   *        (e.g. a method to decrypt each section of the decrypted message,
   *         similar to how encryptBlock was used)
   */
  public String decryptMessage(String encryptedMessage)
  {
    int i = 0;
    for (int c = 0; c < letterBlock[0].length; c++) {
      for(int r = 0; r < letterBlock.length; r++) {
        letterBlock[r][c] = encryptedMessage.substring(i, i + 1);
        i++;
      }
    }
    String decrypted = "";
    for(int r = 0; r < letterBlock.length; r++){
      for(int c = 0; c < letterBlock[0].length; c++){
        decrypted += letterBlock[r][c];
      }
    }
    return decrypted;
  }
}