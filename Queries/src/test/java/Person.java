import lambdas.Selector;
import org.junit.Test;
import queries.collections.GroupBy;
import queries.stracture.NestedQuery;

import java.util.ArrayList;
import java.util.Collection;

public class Person {
    public Person(){}

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String name;
    public Integer age;

    @Test
    public void test(){
        Collection<Person> people = new ArrayList<Person>();
        people.add(new Person("pie", 28));
        people.add(new Person("shush", 26));
        people.add(new Person("gur", 27));
        people.add(new Person("dagi", 25));

        Collection<Person> friends = new ArrayList<Person>();
        friends.add(new Person("dagi", 25));

        Collection<Integer> counts = NestedQuery.create(Person.class).groupBy(new Selector<Person, Integer>() {
            public Integer select(Person value) {
                return value.age % 4;
            }
        }).select(new Selector<GroupBy.Group<Integer, Person>, Integer>() {
            public Integer select(GroupBy.Group<Integer, Person> value) {
                return value.getGroup().size();
            }
        }).execute(people);


        int i = 0;

        /*String firstPersonBigger27 = NestedQuery.create(Person.class)
        .where(new Predicate<Person>() {
            public boolean predict(Person value) {
                return value.age >= 27;
            }
        }).orderBy(new Comparator<Person>() {
                    public int compare(Person o1, Person o2) {
                        return o1.age - o2.age;
                    }
                }).select(new Selector<Person, String>() {
                    public String select(Person value) {
                        return value.name;
                    }
                }).first().execute(people);
                */
    }
}
