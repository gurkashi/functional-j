package queries.scalars;

import queries.stracture.ScalarQuery;

import java.util.Collection;

/**
 * Created by gur on 8/25/2015.
 */
public class Count<T> implements ScalarQuery<T, Integer> {
    public Integer execute(Collection<T> collection){
        return collection.size();
    }
}

