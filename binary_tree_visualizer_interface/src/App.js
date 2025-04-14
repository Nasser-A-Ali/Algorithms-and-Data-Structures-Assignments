import { useState } from "react";
import EnterNumbers from "./components/EnterNumbers";
import PreviousTrees from "./components/PreviousTrees";
import "./App.css";

function App() {
  const [showPrevious, setShowPrevious] = useState(false);

  return (
    <div className="App">
      <h1>Binary Search Tree Visualizer</h1>
      {/* Toggles the page view between the input form and the previous trees */}
      {showPrevious ? (
        <PreviousTrees onBack={() => setShowPrevious(false)} />
      ) : (
        <EnterNumbers onShowPrevious={() => setShowPrevious(true)} />
      )}
    </div>
  );
}

export default App;
