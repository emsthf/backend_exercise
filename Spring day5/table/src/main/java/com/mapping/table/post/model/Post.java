package com.mapping.table.post.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String postName;
    private String postTitle;
    private String postContentText;    // 변수명이 길어도 되는 이유는 @Column 으로 이름을 바꾸면 되기 때문. 그래서 알아보기 쉬운 변수명이 좋으
    private String postTitleImg;
    private String postCreate;
    private String postUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }
}
