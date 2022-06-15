public class cryptography{

  //"Helper" or "toolbox" class. 
  //Use static methods so they can be called from Main

  static String caesarShiftEncode(String message, int shift){
    //This method shifts lowercase messages. 

    //Housekeeping - make the message lower case. 
    message = message.toLowerCase();

    char[] array = message.toCharArray();
    String shiftedMessage = "";
    char newChar;
    
    for(int i =0; i < array.length; i++){
      //Encrypt the characters. 
      int charAsNum = (int)array[i];
      if(charAsNum > 96 && charAsNum < 123){
        int newNum = charAsNum + shift;

        //Check if shifted too high
        if(newNum >= 123){
          newNum -= 123;
          newNum = newNum%26;
          newNum += 97;
        }
        
        //Check if shifted too low
        while(newNum < 97){
          newNum += 26;
        }
        
        newChar = (char)newNum;
      }
      else{
        newChar = array[i];
      }
      
      shiftedMessage += newChar;
    }
    return shiftedMessage;
  }

  static String caesarShiftDecode(String encryptedMessage, int shift){
    return caesarShiftEncode(encryptedMessage, -shift);
  }
  
  static String caesarShiftFrequencyDecode(String encryptedMessage){
    char[] messageArray = encryptedMessage.toLowerCase().toCharArray();

    int[] letterCount = new int[26];

    for(int i = 0; i < messageArray.length; i++){
      if((int)messageArray[i] > 96 && (int)messageArray[i] < 123){
        letterCount[(int)messageArray[i] - 97]++;
      }
    }
    
    int mostFrequent = 0;
    for(int i = 0; i < letterCount.length; i++){
      if(letterCount[i] > letterCount[mostFrequent]){
        mostFrequent = i;
      }
    }
    
    int shift = 4 - mostFrequent;
    System.out.println("Shift was: " + shift); 
    return caesarShiftDecode(encryptedMessage, -shift);
  }
}