
import './App.scss'
import { Main } from './components/Main';
import { Provider } from 'react-redux';
import {store} from "./redux/Store"



function App() {
  return (
      <div className="app-container">
          <Provider store={store}>
          <Main/>
          </Provider>
      </div>
  );
}

export default App
