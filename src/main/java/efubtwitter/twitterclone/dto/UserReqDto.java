package efubtwitter.twitterclone.dto;

import efubtwitter.twitterclone.domain.entity.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserReqDto {
    @NotBlank
    private String name;
    @NotBlank
    private String userId;

    @Builder
    public UserReqDto(String name, String userId){
        this.name = name;
        this.userId = userId;
    }

    public User toEntity(UserReqDto user){
        return User.builder()
                .name(user.getName())
                .userId(user.getUserId())
                .build();
    }
}
