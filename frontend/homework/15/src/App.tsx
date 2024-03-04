import React from 'react';
import './App.scss';
import Main from './component/Main';
import { persistor, store } from './redux/Store';
import {Provider} from "react-redux"
import { PersistGate } from 'redux-persist/integration/react';


function App() {
  return (
    <Provider store={store}>
      <PersistGate loading={null}persistor={persistor}>
    <div className='main-container'>
      <Main/>
    </div>
      </PersistGate>
    </Provider>
  );
}

export default App;
