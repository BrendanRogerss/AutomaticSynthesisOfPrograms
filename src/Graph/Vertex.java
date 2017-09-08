package Graph;

import java.util.ArrayList;

/**
 * Created by Brendan on 8/09/2017.
 */
public class Vertex {

    public int vertexNumber;
    public int color;
    public ArrayList<Vertex> neighbours = new ArrayList<Vertex>();

    public Vertex(int v){
        vertexNumber = v;
    }

    public int getNumber(){
        return vertexNumber;
    }

    public String toString(){
        String vertices = Integer.toString(vertexNumber)+": ";
        for (Vertex v : neighbours) {
            vertices+=Integer.toString(v.getNumber())+" ";
        }
        return vertices;
    }

}
