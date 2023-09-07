import React from 'react';
import './App.css';
import AppLayout from './Layout/AppLayout';
import NavbarLocal from './Component/Navbar';
import Footer from './Component/Footer';
import HomePage from './Pages/HomePage';
import { HashRouter, Route, Switch } from 'react-router-dom';
import MatchPage from './Pages/MatchPage';
import MatchDetailsPage from './Pages/MatchDetailsPage';
import CountryPage from './Pages/CountryPage';
import Countries from './Pages/CountriesPage';

function App() {
  return (
    <div className="App">
      <HashRouter>
      <AppLayout
        header={<NavbarLocal />} 
          content={
          
            <Switch>
              <Route exact={ true} path='/matches/:id' component={MatchPage} />
              <Route exact={ true} path='/match/:year/:id' component={MatchDetailsPage} />
              <Route exact={ true} path='/countries' component={Countries} />
              <Route exact={ true} path='/country/:name' component={CountryPage} />
              <Route exact={ true} path='/' component={HomePage} />
            </Switch>}
        footer={<Footer />} />
        </HashRouter>
    </div>
  );
}

export default App;
