package Graph;

import java.util.ArrayList;

/**
 * Created by Brendan on 8/09/2017.
 */
public class Graph {

    public ArrayList<Vertex> verticies;

    public Graph(int size){
        verticies = new ArrayList<Vertex>(size);
        for (int i = 0; i < size; i++) {
            verticies.add(new Vertex(i));
        }
    }

    public void removeLonelyVertex(){
        for (int i = verticies.size()-1; i >= 0; i--) {
            if (verticies.get(i).neighbours.size() == 0){
                verticies.remove(i);
                //System.out.println("removing: "+i);
            }
        }
    }

    public void add(int a, int b){
        addV(a,b);
        addV(b,a);
    }

    public void addV(int a, int b){
        if(!verticies.get(a).neighbours.contains(verticies.get(b))){
            verticies.get(a).neighbours.add(verticies.get(b));
        }
    }

    public String toString(){
        String output = Integer.toString(verticies.size());
        for (Vertex v : verticies) {
            output+="\n    "+v.toString();
        }
        return output;
    }
}
