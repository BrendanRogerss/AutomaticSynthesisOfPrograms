package Graph;

import java.util.ArrayList;

/**
 * Created by Brendan on 8/09/2017.
 */
public class Vertex {

    public int index;
    public ArrayList<Vertex> neighbours = new ArrayList<Vertex>();

    public Vertex(int v){
        index = v;
    }

    public int getNumber(){
        return index;
    }

    public String toString(){
        String vertices = Integer.toString(index)+": ";
        for (Vertex v : neighbours) {
            vertices+=Integer.toString(v.getNumber())+" ";
        }
        return vertices;
    }

}
