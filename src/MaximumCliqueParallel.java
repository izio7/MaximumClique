import edu.rit.pj2.Job;
import edu.rit.pj2.tuple.EmptyTuple;
import edu.rit.pj2.tuple.ObjectArrayTuple;

import java.util.HashSet;

public class MaximumCliqueParallel extends Job {
    HashSet[] graph;
    int size = 0;
    HashSet<Integer> maximum;

    @Override
    public void main(String[] strings) throws Exception {
        CreateGraph g = new CreateGraph("./res/200N987E.txt");
        graph = g.GenerateGraph();

        putTuple(new ObjectArrayTuple<HashSet>(graph));

        //putTuple(new EmptyTuple());

        masterFor(0, graph.length - 1, WorkerTask.class);
        rule().atFinish().task(ReduceTask.class);
    }
}
