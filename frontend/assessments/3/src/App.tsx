
import { Provider } from 'react-redux'
import './App.css'
import { store } from './redux/Store'
import { Main } from './component/Main'

function App() {
  return (
    <Provider store={store}>
      <Main/>
    </Provider>
  )
}

export default App
