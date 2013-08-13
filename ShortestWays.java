import java.util.ArrayList;

import java.util.HashMap;



public class ShortestWays {

static HashMap<String, Integer> map=new HashMap<String, Integer>();

static ArrayList<Node> expanded=new ArrayList<Node>();

static ArrayList<Node> lastround=new ArrayList<Node>();

static ArrayList<Node> checked=new ArrayList<Node>();

static int WIDTH=4, HEIGHT=4;//note coordinates start from 0

static boolean reachedTarget=false;

static Node start=new Node(0,0);

static Node target=new Node(3,2);

public static void main(String[] args) {

//init 

int[] values={1,1,0,1,1,0,1,1,1,1,1,1,0,1,1,1};

System.out.println("------- initialization...");

for(int i=0; i<values.length; i++){

int x=i%WIDTH;

int y=i/WIDTH;

map.put(x+","+y, new Integer(values[i]));

}

System.out.println("------- start routing...");

expanded.add(start);

lastround.add(start);

checked.add(start);

start.approaches=1;

while(checked.size()<=WIDTH*HEIGHT){

System.out.println("checked totally "+checked.size()+" nodes.");

//for(int i=0; i<checked.size(); i++){

//System.out.print(" ("+checked.get(i).x+","+checked.get(i).y+"),");

//}

//System.out.println();

ArrayList<Node> candidates=new ArrayList<Node>();

System.out.println("last round has "+lastround.size()+" nodes.");

for(int i=0; i<lastround.size(); i++){

candidates=appendList(candidates,getNearby(lastround.get(i)));

}

System.out.println(candidates.size()+" candidates found...");

if(candidates.size()==0){

System.out.println("Map is not connected!");

break;

}

expanded=appendList(expanded, candidates);

System.out.println("expand to "+expanded.size()+ " nodes.");

//for(int i=0; i<expanded.size(); i++){

//System.out.print(" ("+expanded.get(i).x+","+expanded.get(i).y+"),");

//}

//System.out.println();

lastround=candidates;

if(reachedTarget){

//get target counters

System.out.println("Reach target with "+getNodeApproaches(target.x, target.y)+" shortest approaches.");

break;

}

System.out.println("--");

}

}

/*

 * Append list members without duplication

 */

public static ArrayList<Node> appendList(ArrayList<Node> list, ArrayList<Node> source){

for(int i=0; i<source.size(); i++){

//System.out.println(">> "+source.get(i).x+","+source.get(i).y);

if(!list.contains(source.get(i))){

list.add(source.get(i));

//System.out.println("add");

}

}

return list;

}

public static boolean isAdjacent(Node a, Node b){

if( (a.x==b.x && Math.abs(a.y-b.y)==1) || (a.y==b.y && Math.abs(a.x-b.x)==1)){

return true;

}else{

return false;

}

}

public static ArrayList<Node> getNearby(Node node){

ArrayList<Node> ret=new ArrayList<Node>();

if(node.x>0){

if(getNodeValue(node.x-1,node.y)==1){

ret=addNearbyNode(ret,node.x-1,node.y);

}

addCheckedNode(node.x-1,node.y);

}

if(node.x<WIDTH-1){

if(getNodeValue(node.x+1,node.y)==1){

ret=addNearbyNode(ret,node.x+1,node.y);

}

addCheckedNode(node.x+1,node.y);

}

if(node.y>0){

if(getNodeValue(node.x,node.y-1)==1){

ret=addNearbyNode(ret,node.x,node.y-1);

}

addCheckedNode(node.x,node.y-1);

}

if(node.y<HEIGHT-1){

if(getNodeValue(node.x,node.y+1)==1){

ret=addNearbyNode(ret,node.x,node.y+1);

}

addCheckedNode(node.x,node.y+1);

}

return ret;

}

private static void addCheckedNode(int x, int y){

for(int i=0; i<checked.size(); i++){

if(checked.get(i).x==x && checked.get(i).y==y){

return;

}

}

checked.add(new Node(x,y));

}

public static ArrayList<Node> addNearbyNode(ArrayList<Node> list, int x, int y){

if(!expandedTo(x,y)){

//System.out.print("checking "+x+","+y+"\t");

Node member=new Node(x, y);

for(int i=0; i<lastround.size(); i++){

//System.out.println("to "+lastround.get(i).x+","+lastround.get(i).y);

if(isAdjacent(member, lastround.get(i))){

member.approaches++;

//System.out.println(member.approaches+ "here");

}

}

list.add(member);

//System.out.print(" ...added");

if(x==target.x && y==target.y){

reachedTarget=true;

}

}

//System.out.println();

return list;

}

public static boolean expandedTo(int x, int y){

for(int i=0; i<expanded.size(); i++){

if(expanded.get(i).x==x && expanded.get(i).y==y){

return true;

}

}

return false;

}

public static int getNodeValue(int x, int y){

return map.get(x+","+y).intValue();

}

public static int getNodeApproaches(int x, int y){

for(int i=0; i<expanded.size(); i++){

if(x==expanded.get(i).x && y==expanded.get(i).y){

return expanded.get(i).approaches;

}

}

return -1;

}



}



