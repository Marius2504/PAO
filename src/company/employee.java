package company;

import java.util.*;

import client.history;
import client.human;
import client.settings;

public class employee extends human {
        private List<Double> salaries;
        private List<String> comments;
        private Integer overall;
        private Map<Integer,Boolean> workDays;
        public employee() {
            super();
            this.workDays = new LinkedHashMap<Integer, Boolean>(Collections.emptyMap());
            this.salaries = new LinkedList<Double>(Collections.emptyList());
            this.comments = new LinkedList<String>(Collections.emptyList());
            this.overall = 0;
        }

        public employee(String name, String surname, String phone, String email, String password, Date birthDate, List<Double> salaries, List<String> comments, Integer overall, Map<Integer, Boolean> workDays) {
            super(name,surname,phone,email,password,birthDate);
            this.salaries = salaries;
            this.comments = comments;
            this.overall = overall;
            this.workDays = workDays;
        }

        public List<Double> getSalaries() {
            return salaries;
        }

        public void setSalaries(List<Double> salaries) {
            this.salaries = salaries;
        }

        public List<String> getComments() {
            return comments;
        }

        public void setComments(List<String> comments) {
            this.comments = comments;
        }

        public void addComment(String co)
        {
            this.comments.add(co);
        }
        public void addSalary(Double sa)
        {
            this.salaries.add(sa);
        }

        public Integer getOverall() {
            return overall;
        }
        public void setOverall(Integer overall) {
            this.overall = overall;
        }

        public Map<Integer, Boolean> getWorkDays() {
            return workDays;
        }

        public void setWorkDays(Map<Integer, Boolean> workDays) {
            this.workDays = workDays;
        }
        public void addWorkDay(int day) throws Exception {
            if(!this.workDays.isEmpty())
                workDays.put(day,Boolean.TRUE);
        }
    }

