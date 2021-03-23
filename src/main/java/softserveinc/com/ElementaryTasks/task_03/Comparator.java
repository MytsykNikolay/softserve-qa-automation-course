package softserveinc.com.ElementaryTasks.task_03;

import java.util.Comparator;

class TriangleComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getArea() - o2.getArea());
    }
}
