public class Node {

int x,y,value;

int distance=0;//how far away from starting node

int approaches=0;//how many ways from starting node to this node

public Node(int x, int y){

this.x=x;

this.y=y;

}

public Node(int x, int y, int value){

this.x=x;

this.y=y;

this.value=value;

}

}

