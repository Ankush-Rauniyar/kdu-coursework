import React from 'react';
import './App.css';
import Main from './component/Main';
import { store } from './redux/Store';
import {Provider} from "react-redux"


function App() {
  return (
    <Provider store={store}>
    <div className='main-container'>
      <Main/>
    </div>
    </Provider>
  );
}

export default App;
