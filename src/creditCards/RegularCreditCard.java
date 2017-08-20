package creditCards;

public class RegularCreditCard {
	  //Instance Variables 
	  private String cardName;
	  private String cardNumber; 
	  
	  //Constructor 
	  public RegularCreditCard (String name, String string) {
	    cardName = name;
	    cardNumber = string;
	  }

	  //Mutator/Setter
	  public void setCardName(String name){
	    cardName = name;
	  }
	  
	  public void setCarNumber(String number){
	    cardNumber = number;
	  }
	 
	  //Accessors /Getter
	  public String getCardName () {
	    return cardName; 
	  }
	  
	  public String getCardNumber () {
	    return cardNumber;
	  }

	  //toString
	  public String toString () {
	    return "Card: " + cardName + "\n"
	    		+ "Number: " + cardNumber;
	  }
}
