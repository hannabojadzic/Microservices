import React from 'react';
import logo from './logo.svg';
import './App.css';
import Login from './Login';
import ArticleList from './Login';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import TechList from './TechList';
import Chatbox from './Chatbox';
import News from './News';

function App() {
  return (
    <Router>
    <div className="App">
    <Switch>
      <Route path="/tech" component={TechList} />
      <Route path="/chatbox" component={Chatbox} />
      <Route path="/news" component={News} />
      <Route path="/" component={Login} />
      
      </Switch>
    </div>
    </Router>
  );
}

export default App;
