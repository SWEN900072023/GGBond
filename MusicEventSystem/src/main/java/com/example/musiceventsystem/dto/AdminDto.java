package com.example.musiceventsystem.dto;

public class AdminDto {

    private Integer id; // 管理员的唯一标识符
    private String username; // 管理员用户名
    private String email; // 管理员邮箱
    // 其他与管理员相关的属性

    // 构造函数
    public AdminDto() {
    }

    public AdminDto(Integer id, String username, String email /* 其他属性 */) {
        this.id = id;
        this.username = username;
        this.email = email;
        // 初始化其他属性
    }

    // Getter 和 Setter 方法
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 其他属性的 Getter 和 Setter 方法

    @Override
    public String toString() {
        return "AdminDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                // 其他属性
                '}';
    }
}
