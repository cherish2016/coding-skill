package com.cherish.optinal;

import java.util.*;

/**
 * Java8 optional学习
 * Created by Administrator on 2017/2/20.
 */
public class OptionalTest {

    public static void main(String[] args) {

        Optional<String> name = Optional.of("cherish");
        Optional empty = Optional.empty();
        if (name.isPresent()) {
            System.out.println(name.get());
        }
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        name.ifPresent(s -> System.out.println("sout length: " + s.length()));

        System.out.println(empty.orElse("There is no value present"));
        System.out.println(name.orElse("There is some value!"));

        System.out.println(empty.orElseGet(() -> "Default value"));
        System.out.println(name.orElseGet(() -> "Default value"));

        User cherish = new User("cherish", null);
        Optional<User> user = Optional.ofNullable(cherish);
        System.out.println(user.map(User::getAge).orElse("age is null"));

        List<String> jobs = new ArrayList<>();
        jobs.add("job1");
        jobs.add("job2");
        jobs.add(null);
        Person value = new Person("cherish", jobs);
        Optional<Person> person = Optional.of(value);

        System.out.println(person.map(Person::getJobs).orElse(Collections.emptyList()));
        System.out.println(person.map(Person::getJobs).map(List::size).orElse(0));


    }

    private static class Person {
        private String name;
        private List<String> jobs;

        public Person(String name, List<String> jobs) {
            this.name = name;
            this.jobs = jobs;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getJobs() {
            return jobs;
        }

        public void setJobs(List<String> jobs) {
            this.jobs = jobs;
        }
    }

    private static class User {
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
