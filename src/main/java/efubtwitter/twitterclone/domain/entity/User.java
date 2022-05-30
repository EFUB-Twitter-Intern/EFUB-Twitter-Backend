package efubtwitter.twitterclone.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNumber;
    private String userId;
    private String name;

    @Builder
    public User(Long userNumber, String userId, String name){
        this.userNumber = userNumber;
        this.userId = userId;
        this.name = name;
    }

}
