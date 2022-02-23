export interface CreditCard {
  cardNumber:string;
  cardName:string;
  cardLimit:number;
  cardNameValid: boolean,
  cardNumberValid: boolean,
  formValid:boolean,
  formErrors:{},
  existingCardRef:any
}

export interface CreditCardState {
  id:number,
  cardNumber:string;
  cardName:string;
  cardLimit:number;
  cardNameValid: boolean,
  cardNumberValid: boolean,
  formValid:boolean,
  formErrors:{}       
}

export interface AllCards {
  allCards:CreditCardState[];
}

export interface AllCardsProps {
  name:string;
}





