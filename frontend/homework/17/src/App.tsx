import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ScrollToTop from "./component/ScrollToTop";
import FocusOnFirstInput from "./component/FocusOnFirstInput";
import Timer from "./component/Timer";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/scrollToTop" element={<ScrollToTop />} />
        <Route path="/focusOnFirstInput" element={<FocusOnFirstInput />} />
        <Route path="/timer" element={<Timer />} />
        <Route path="/" element={<Timer />} />
      </Routes>
    </Router>
  );
}

export default App;
