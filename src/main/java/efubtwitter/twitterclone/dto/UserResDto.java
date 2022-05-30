package efubtwitter.twitterclone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResDto {
    private Long userNumber;
    private String userId;
    private String name;

    @Builder
    public UserResDto(Long userNumber, String userId, String name){
        this.userNumber = userNumber;
        this.userId = userId;
        this.name = name;
    }
}
