package lib;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by earthgee on 2017/2/19.
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;

        public Node(Key key,Value val,int N){
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }

    public BST(){

    }

    public void put(Key key,Value value){
        root=put(root,key,value);
    }

    private Node put(Node x,Key key,Value value){
        if(x==null) return new Node(key,value,1);
        int cmp=key.compareTo(x.key);
        if(cmp<0){
            x.left=put(x.left,key,value);
        }else if(cmp>0){
            x.right=put(x.right,key,value);
        }else x.val=value;
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return get(x.left,key);
        else if(cmp>0) return get(x.right,key);
        else return x.val;
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

    private int size(Node x){
        if(x==null) return 0;
        else return x.N;
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
        root=deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left==null) return x.right;
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public void delete(Key key){
        root=delete(root,key);
    }

    private Node delete(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) x.left=delete(x.left,key);
        else if(cmp>0) x.right=delete(x.right,key);
        else{
            if(x.right==null) return x.left;
            if(x.left==null) return x.right;
            Node t=x;
            x=min(t.right);
            x.right=deleteMin(t.right);
            x.left=t.left;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue=new LinkedList<>();
        keys(root,queue,lo,hi);
        return queue;
    }

    private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
        if(x==null) return;
        int cmplo=lo.compareTo(x.key);
        int cmphi=hi.compareTo(x.key);
        if(cmplo<0) keys(x.left,queue,lo,hi);
        if(cmplo<=0&&cmphi>=0) queue.offer(x.key);
        if(cmphi>0) keys(x.right,queue,lo,hi);
    }

}


















