// A component that displays nodes recursively to visualize a binary tree structure
const TreeNode = ({ node }) => {
  if (!node) return <span className="null-node">null</span>;
  return (
    <div className="tree-node">
      <div className="node-value">
        <span className="value-node">Value: </span>
        {node.value}
      </div>
      <div className="node-children">
        <div>
          <span className="left-node">Left: </span>
          <TreeNode node={node.left} />
        </div>
        <div>
          <span className="right-node">Right: </span>
          <TreeNode node={node.right} />
        </div>
      </div>
    </div>
  );
};

// Visualizes the binary tree structure
const TreeVisualizer = ({ tree }) => {
  return (
    <div className="tree-visualization">
      <TreeNode node={tree} />
    </div>
  );
};

export default TreeVisualizer;
