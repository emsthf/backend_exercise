package com.mapping.table.post.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data   // ToString, 게터세터, 컨스트럭터 모두 Lombok으로 자동 생성
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;

    // userName 컬럼의 이름을 DB에서는 name으로 하고 길이는 20으로 한다
    @Column(name = "name", length = 20)
    private String userName;
    private String password;   // 패스워드를 해시로 만들어주는 롬복 에노테이션도 있다. 나중에 할 것
    private String email;
    private String address;
    private String birth;
    private String phone;
    private String legDate;

    public User() {
    }

    @Builder
    public User(String loginId, String userName, String password, String email, String address, String birth, String phone, String legDate) {
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.phone = phone;
        this.legDate = legDate;
    }
}
