import React from 'react';
import './App.css';
import Dashboard from './component/Dashboard';
import Header from './component/Layout/Header';
import 'bootstrap/dist/css/bootstrap.min.css'
import { BrowserRouter as Router, Route} from 'react-router-dom'; // Creating 2 alias(Router and Route) for the BrowserRouter
import AddProject from './component/Project/AddProject';

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Route exact path="/Dashboard" component={Dashboard}/>
        <Route exact path="/addProject" component={AddProject}/>
      </div>
    </Router>
  );
}

export default App;
