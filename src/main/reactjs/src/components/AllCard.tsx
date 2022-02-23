import React from 'react';
import '../css/allCard.scss';
import * as CreditCard from '../model/CreditCard';
import * as CardService from '../api/CardService'

class AllCards extends React.Component<{}, CreditCard.AllCards>
{
  constructor(props:CreditCard.AllCardsProps){
    super(props);
    this.state = {
      allCards:[]
    }
  }

  public getCards = () =>{
    CardService.getAllCreditCards((response:any)=>{
      console.log(response);
        this.setState({allCards:response.data})
    })
  }

  componentDidMount(){this.getCards();}

  public render(){
    const{allCards} = this.state;
    return (
    <React.Fragment>
      <table>
        <thead>
        <tr>
          <th>Name</th>
          <th>Card Number</th>
          <th>Limit</th>
        </tr>
        </thead>
        <tbody>
          {allCards.length > 0
          ? allCards.map((card)=>{return <tr key={card.id}>
          <td>{card.cardName}</td>
          <td>{card.cardNumber}</td>
          <td>{card.cardLimit}</td>
          </tr>}): <tr><td colSpan={3}>No records found</td></tr>}
        </tbody>
      </table>
    </React.Fragment>
    )
  }
}

export default AllCards;