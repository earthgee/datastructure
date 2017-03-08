package lib;

/**
 * Created by earthgee on 2017/2/22.
 */
public class RBTree<Key extends Comparable<Key>,Value> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private Node root;

    private class Node{
        Key key;
        Value value;
        Node left,right;
        int N;
        boolean color;

        Node(Key key,Value value,int N,boolean color){
            this.key=key;
            this.value=value;
            this.N=N;
            this.color=color;
        }
    }

    private boolean isRed(Node x){
        if(x==null) return false;
        return x.color==RED;
    }

    Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }

    Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }

    void flipColor(Node h){
        h.color=!h.color;
        h.left.color=!h.left.color;
        h.right.color=!h.right.color;
    }

    int size(Node node){
        if(node==null) return 0;
        return 1+size(node.left)+size(node.right);
    }

    public void put(Key key,Value value){
        root=put(root,key,value);
        root.color=BLACK;
    }

    private Node put(Node root,Key key,Value value){
        if(root==null){
            return new Node(key,value,1,RED);
        }

        int cmp=key.compareTo(root.key);
        if(cmp<0) root.left=put(root.left,key,value);
        else if(cmp>0) root.right=put(root.right,key,value);
        else root.value=value;

        if(isRed(root.right)&&!isRed(root.left)) root=rotateLeft(root);
        if(isRed(root.left)&&isRed(root.left.left)) root=rotateRight(root);
        if(isRed(root.left)&&isRed(root.right)) flipColor(root);

        root.N=size(root.left)+size(root.right)+1;
        return root;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return get(x.left,key);
        else if(cmp>0) return get(x.right,key);
        else return x.value;
    }

    boolean contains(Key key){
        return get(key)!=null;
    }

    boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return size(root);
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x=floor(root,key);
        if(x==null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        if(cmp<0) return floor(x.left,key);
        Node t=floor(x.right,key);
        if(t!=null) return t;
        else return x;
    }

    public Key select(int k){
        return select(root,k).key;
    }

    private Node select(Node x,int k){
        if(x==null) return null;
        int t=size(x.left);
        if(t>k) return select(x.left,k);
        else if(t<k) return select(x.right,k-t-1);
        else return x;
    }

    public int rank(Key key){
        return rank(key,root);
    }

    private int rank(Key key,Node x){
        if(x==null) return 0;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return rank(key,x.left);
        else if(cmp>0) return 1+size(x.left)+rank(key,x.right);
        else return size(x.left);
    }

    public void deleteMin(){
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color=RED;
        }
        root=deleteMin(root);
        if(!isEmpty()){
            root.color=BLACK;
        }
    }

    private Node deleteMin(Node h){
        if(h.left==null) return null;
        if(!isRed(h.left)&&!isRed(h.left.left)){
            h=moveRedLeft(h);
        }
        h.left=deleteMin(h.left);
        return balance(h);
    }

    private Node moveRedLeft(Node h){
        flipColor(h);
        if(isRed(h.right.left)){
            h.right=rotateRight(h.right);
            h=rotateLeft(h);
            flipColor(h);
        }
        return h;
    }

    private Node balance(Node root){
        if(!isRed(root.left)&&isRed(root.right)) root=rotateLeft(root);
        if(isRed(root.left)&&isRed(root.left.left)) root=rotateRight(root);
        if(isRed(root.left)&&isRed(root.right)) flipColor(root);

        root.N=size(root.left)+size(root.right)+1;
        return root;
    }

    public void deleteMax(){
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color=RED;
        }
        root=deleteMax(root);
        if(!isEmpty()) root.color=BLACK;
    }

    private Node deleteMax(Node h){
        if(isRed(h.left)) h=rotateRight(h);
        if(h.right==null) return null;
        if(!isRed(h.right)&&!isRed(h.right.left)){
            h=moveRedRight(h);
        }
        h.right=deleteMax(h.right);
        return balance(h);
    }

    private Node moveRedRight(Node h){
        flipColor(h);
        if(!isRed(h.left.left)){
            h=rotateRight(h);
            flipColor(h);
        }
        return h;
    }

    public void delete(Key key){
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color=RED;
        }
        root=delete(root,key);
        root.color=BLACK;
    }

    private Node delete(Node node,Key key){
        if(key.compareTo(node.key)<0){
            if(!isRed(node.left)&&!isRed(node.left.left)){
                node=moveRedLeft(node);
            }
            node.left=delete(node.left,key);
        }else{
            if(isRed(node.left)){
                node=rotateRight(node);

                if(key.compareTo(node.key)==0&&node.right==null)
                    return null;

                if(key.compareTo(node.key)==0){
                    Node tmp=min(node.right);
                    node.key=tmp.key;
                    node.value=tmp.value;
                    node.right=deleteMin(node.right);
                }else{
                    if(!isRed(node.right)&&!isRed(node.right.left)){
                        node=moveRedRight(node);
                    }
                    node.right=delete(node.right,key);
                }
            }
        }

        return balance(node);
    }


}









