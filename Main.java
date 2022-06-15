

class Main {
  public static void main(String[] args) {

    //Clear the console
    System.out.print("\033[H\033[2J");
    System.out.flush();

    String secret1 = files.String_read("Secret1.txt");
    String secret2 = files.String_read("Secret2.txt");
    
    String decrypted = "";
    decrypted = cryptography.caesarShiftFrequencyDecode(secret1);
    System.out.println(decrypted);
    System.out.println("");
    
    decrypted = cryptography.caesarShiftFrequencyDecode(secret2);
    System.out.println(decrypted);
    System.out.println("");
  }
}