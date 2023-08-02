package com.example.onepiece.domain.user.domain;

import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.global.entity.BaseEntity;
import lombok.*;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {

    @Column(nullable = false, length = 20)
    private String accountId;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 9)
    private String nickname;

    @Column(nullable = false, length = 3)
    private Integer grade;

    @Column(nullable = false, length = 4)
    private Integer classNumber;

    @Column(nullable = false, length = 16)
    private Integer number;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<Board>();

    @Builder
    public User(String accountId, String password, String nickname, Integer grade, Integer classNumber, Integer number) {
        this.accountId = accountId;
        this.password = password;
        this.nickname = nickname;
        this.grade = grade;
        this.classNumber = classNumber;
        this.number = number;
    }

    public void nicknameUpdate(String nickname) {
        this.nickname = nickname;
    }

}
