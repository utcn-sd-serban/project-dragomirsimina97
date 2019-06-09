import React from 'react';
import './App.css';

import { HashRouter, Switch, Route } from "react-router-dom";
import SmartOffersList from './view/SmartOffersList';
import SmartCreateOffer from './view/SmartCreateOffer';
import SmartOfferDetails from './view/SmartOfferDetails';
import SmartFilterByTitle from  './view/SmartFilterByTitle';
import SmartFilterByLocation from  './view/SmartFilterByLocation';
import SmartAuthorDetails from './view/SmartAuthorDetails';


const App = () => (
  <div className="App">
    <HashRouter>
      <Switch>
        <Route exact={true} component={SmartOffersList} path="/" />
        <Route exact={true} component={SmartCreateOffer} path="/create-offer" />
        <Route exact={true} component={SmartOfferDetails} path="/offer-details/:index" />
        <Route exact={true} component={SmartFilterByTitle} path="/filter-title-offer" />
        <Route exact={true} component={SmartFilterByLocation} path="/filter-location-offer" />
        <Route exact={true} component={SmartAuthorDetails} path="/author-details/:index" />
       
        
       
      </Switch>
    </HashRouter>
  </div>
);


export default App;