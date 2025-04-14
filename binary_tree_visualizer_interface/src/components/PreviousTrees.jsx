import { useEffect, useState } from "react";
import { getPreviousTrees } from "../services/api";
import TreeVisualizer from "./TreeVisualizer";

const PreviousTrees = ({ onBack }) => {
  const [trees, setTrees] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [showJSON, setShowJSON] = useState(false);

  useEffect(() => {
    const fetchTrees = async () => {
      try {
        const response = await getPreviousTrees();
        setTrees(response.data);
      } catch (err) {
        setError(
          "Failed to load trees. Please ensure your database is running."
        );
      } finally {
        setLoading(false);
      }
    };
    fetchTrees();
  }, []);

  return (
    <div className="previous-trees">
      <h2>Previous Trees</h2>

      <div className="form-row">
        <button id="back-button" onClick={onBack}>
          Back to Input
        </button>
        {/* Toggle between displaying visualized tree or raw JSON */}
        <label className="toggle-switch">
          <input
            type="checkbox"
            checked={showJSON}
            onChange={(e) => setShowJSON(e.target.checked)}
          />
          <span className="slider"></span>
          Show JSON
        </label>
      </div>
      {loading && <p>Loading...</p>}
      {error && <p className="error">{error}</p>}
      {/* Iterate through the trees and display them with most-recent being first */}
      {trees
        .slice()
        .reverse()
        .map((tree, index) => (
          <div key={index}>
            <h3>Input: {tree.inputNumbers}</h3>
            {showJSON ? (
              <pre>
                {JSON.stringify(JSON.parse(tree.treeStructure), null, 2)}
              </pre>
            ) : (
              <TreeVisualizer tree={JSON.parse(tree.treeStructure)} />
            )}
          </div>
        ))}
    </div>
  );
};

export default PreviousTrees;
