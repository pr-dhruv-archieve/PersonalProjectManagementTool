import React from 'react';
import './App.css';
import Dashboard from './component/Dashboard';
import Header from './component/Layout/Header';
import 'bootstrap/dist/css/bootstrap.min.css'
import { BrowserRouter as Router, Route} from 'react-router-dom'; // Creating 2 alias(Router and Route) for the BrowserRouter
import AddProject from './component/Project/AddProject';

function App() {
  return (
    <Route>
      <div className="App">
        <Header />
        <Dashboard />
        <Route path="/addProject" component={AddProject}/>
      </div>
    </Route>
  );
}

export default App;
