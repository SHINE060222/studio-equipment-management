package com.example.demo;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;


// @Entity + @Table(name = "signups")：这个类对应 signups 表
@Entity
@Table(name = "signups")
public class Signup {

    // @Id + GenerationType.IDENTITY：id 由数据库的 IDENTITY 生成，替代 nextId++
    // @Id:标明这个 id 字段是表的主键
    // @GeneratedValue：告诉数据库，这个主键的值不自己写，由数据库自动生成
    // GenerationType.IDENTITY：具体生成策略是自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String major;
    private String gender;
    // @ElementCollection：表示这是一个简单的集合
    // fetch = ：抓取策略
    // FetchType.EAGER 的意思是：查报名时，顺带把兴趣一起查出来。
    @ElementCollection(fetch = FetchType.EAGER)
    // @CollectionTable(... "signup_interests" ... "signup_id")：
    // @CollectionTable：集合存在哪张表
    // name = "signup_interests"：副表表名
    // joinColumns：副表用哪一列挂回主表
    // @JoinColumn(name = "signup_id")：那一列叫 signup_id，值等于主表 signups.id
    // 兴趣存在 signup_interests 表，用它的 signup_id 列关联
    @CollectionTable(name = "signup_interests", joinColumns = @JoinColumn(name = "signup_id"))
    // @Column(name = "interest")：每个兴趣字符串存在副表的 interest 列
    @Column(name = "interest")
    private List<String> interests = new ArrayList<>();

    // protected：同包/子类能用；提醒「主要给框架用，业务少用」
    // Signup()：构造器：名字与类名相同，没有返回类型（这是硬性语法）
    // { }：方法体为空：先造一个「空壳对象」
    // 注意：硬性（JPA）：实体通常要有无参构造器。Hibernate 读库时：先 new 空对象 → 再往字段填列值。
    // protected Signup() {}：满足“必须有无参构造器”，给 Hibernate 用
    protected Signup() {
    }

    // Signup有参构造器
    // 类 = 有哪些格子；构造器 = 填格子的那一次动作。
    public Signup(String name, String major, String gender, List<String> interests) {
        this.name = name;
        this.major = major;
        this.gender = gender;
        if (interests != null) {
            this.interests = new ArrayList<>(interests);
        }
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public String getGender() { return gender; }
    public List<String> getInterests() { return interests; }
}
// 文件名含义：注册实体类（Entity），对应数据库的注册表，存id、姓名等字段，和数据库映射