package com.guier.configclient.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
@Entity
@Table(name = "worker")
public class Worker {
    /**
     * Id 是主键的标识
     * GenerationType: 自增策略
     * TABLE: 使用一个特定的数据库表去保存主键
     * SEQUENCE: 根据底层数据库序列生成主键
     * IDENTITY: 主键由数据库自动生成
     * AUTO: 由程序控制, 是 GenerationType 的默认值
     * Column: 数据表列与属性的映射关系
     * name: 数据表中字段的名称
     * nullable: 该字段是否允许为 null, 默认是 true
     * unique: 字段值是否唯一, 默认是 false
     * length: 字段的大小， 仅仅对 String 类型的字段有效
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 员工类型
     */
    @Basic  // 标识一个属性到数据表字段的映射
    @Column(name = "type", nullable = false)
    private String type;

    /**
     * 员工姓名
     */
    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 员工薪水
     */
    @Basic
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    /**
     * 省份
     */
    @Basic
    @Column(name = "province", nullable = false)
    private String province;

    /**
     * 城市
     */
    @Basic
    @Column(name = "city", nullable = false)
    private String city;

    /**
     * ORM 框架将忽略这个属性
     */
    @Transient
    private String extraInfo;


    /**
     * 构造函数
     */
    public Worker() {
    }

    public Worker(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public Worker(Long id, String type, String province, String city, String extraInfo) {
        this.id = id;
        this.type = type;
        this.province = province;
        this.city = city;
        this.extraInfo = extraInfo;
    }
}
