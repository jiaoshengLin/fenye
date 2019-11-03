package com.qf.entity;

/**
 * Stu 实体类
 */
public class Stu {
    private Integer id;

    private String username;

    private String card;

    private String department;

    public Stu() {
    }

    public Stu(Integer id, String username, String card, String department) {
        this.id = id;
        this.username = username;
        this.card = card;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", card='" + card + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
