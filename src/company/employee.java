package company;

import java.sql.Date;

import client.history;
import client.human;
import client.settings;

public class employee extends human {
        //private List<Double> salaries;
        //private List<String> comments;
        private Integer overall;
        //private Map<Integer,Boolean> workDays;
        private Integer Id;
        private static Integer count=0;
        public employee() {
            super();
            //this.workDays = new LinkedHashMap<Integer, Boolean>(Collections.emptyMap());
            //this.salaries = new LinkedList<Double>(Collections.emptyList());
            //this.comments = new LinkedList<String>(Collections.emptyList());
            this.overall = 0;
            this.Id = ++count;
        }

        public employee(String name, String surname, String phone, String email, String password, Date birthDate, Integer overall) {
            super(name,surname,phone,email,password,birthDate);
            this.overall = overall;
            //this.salaries = salaries;
            //this.comments = comments;
            //this.overall = overall;
            //this.workDays = workDays;
        }

        public employee(int id, int overall) {
                this.Id = id;
                this.overall = overall;
        }

    public employee(int id, String name, String surname, String phone, String email, String password, java.sql.Date birthdate, int overall) {
        super(name,surname,phone,email,password,birthdate);
        this.Id = id;
        this.overall = overall;
    }


    public Integer getOverall() {
            return overall;
        }
        public void setOverall(Integer overall) {
            this.overall = overall;
        }



        public String toCVS(){
            return getName()+","+getSurname()+","+getPhone()+","+getEmail()+","+getPassword()+","+getBirthDate();
        }

        public Integer getId() {
            return Id;
        }

    public void setId(Integer id) {
        Id = id;
    }
}

