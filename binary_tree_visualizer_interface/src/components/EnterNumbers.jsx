import { useState } from "react";
import { processNumbers } from "../services/api";
import TreeVisualizer from "./TreeVisualizer";

const EnterNumbers = ({ onShowPrevious }) => {
  const [input, setInput] = useState("");
  const [tree, setTree] = useState(null);
  const [error, setError] = useState("");
  const [balance, setBalance] = useState(false);

  // Validate input and parse numbers then send to the backend API
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const numbers = input
        .split(",")
        .map((num) => parseInt(num.trim()))
        .filter((num) => !isNaN(num));

      if (numbers.length === 0)
        throw new Error("Invalid input. Please try again.");

      const response = await processNumbers(numbers, balance);
      setTree(response.data);
      setError("");
    } catch (err) {
      setError(err.response?.data || err.message);
    }
  };

  return (
    <div className="enter-numbers">
      <form onSubmit={handleSubmit}>
        <div className="form-row">
          <input
            type="text"
            value={input}
            onChange={(e) => setInput(e.target.value)}
            placeholder="e.g., 5,3,7,2"
          />
          <label>
            <input
              type="checkbox"
              checked={balance}
              onChange={(e) => setBalance(e.target.checked)}
            />
            Balance Tree
          </label>
        </div>
        <div className="form-buttons">
          <button id="submit-button" type="submit">
            Submit
          </button>
          <button id="show-previous-button" onClick={onShowPrevious}>
            Show Previous Trees
          </button>
        </div>
      </form>
      {error && <p className="error">{error}</p>}
      {tree && <TreeVisualizer tree={tree} />}
    </div>
  );
};

export default EnterNumbers;
