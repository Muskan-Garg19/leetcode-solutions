/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private static void clone(Node node,Node oldNode,HashMap<Integer,Node> map){
        for(int i=0;i<node.neighbors.size();i++){
            Node neighbourNode=node.neighbors.get(i);
            Node newNode;
            if(!map.containsKey(neighbourNode.val)){
                newNode=new Node(neighbourNode.val);
                map.put(neighbourNode.val,newNode);
                oldNode.neighbors.add(newNode);
                clone(neighbourNode,newNode,map);
            }
            else{
                oldNode.neighbors.add(map.get(neighbourNode.val));
            }
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Integer,Node> map=new HashMap<>();
        Node newNode=new Node(node.val);
        map.put(node.val,newNode);
        clone(node,newNode,map);
        return newNode;
    }
}