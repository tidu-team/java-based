package com.java.based.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author honglixiang@tiduyun.com
 * @date 2022/7/14
 */
public class ObjectInputOutputStream {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setAge(20);
        user.setIdCard("43072315641232");
        user.setName("张三");
        user.setSex("男");

        String path = "object.text";
        ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream(path));
        out.writeObject(user);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Object o = in.readObject();
        System.err.println(o);
    }


    public static class User implements Serializable {

        private static final long serialVersionUID = 1L;

        private String name;

        private String sex;

        private Integer age;

        private transient String idCard;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    ", idCard='" + idCard + '\'' +
                    '}';
        }
    }
}
