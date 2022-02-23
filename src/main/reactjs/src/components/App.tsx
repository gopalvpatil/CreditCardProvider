import React from 'react';
import AddCard from './AddCard';
import AllCards from './AllCard';
import '../css/app.scss';
import * as CardDataTypes from '../model/CreditCard';


class App extends React.Component {
  
  public render() {
    return(
      <div className="card-container">
        <h1>Credit Card System</h1>
        <AddCard/>
      </div>
    )
  }
}

export default App;