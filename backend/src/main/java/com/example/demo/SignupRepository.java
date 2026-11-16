package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// SignupRepository：接口
// 尖括号里：Signup：管的是哪种实体  Long：主键id的类型
// JpaRepository<T,ID>是泛型接口，T是要操作的实体类，ID是实体主键的数据类型
public interface SignupRepository extends JpaRepository<Signup, Long> {
}
// 文件名含义：注册仓库（数据访问层），和数据库打交道，增删改查