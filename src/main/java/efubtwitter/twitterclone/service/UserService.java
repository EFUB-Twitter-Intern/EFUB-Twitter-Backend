package efubtwitter.twitterclone.service;

import efubtwitter.twitterclone.domain.entity.User;
import efubtwitter.twitterclone.domain.repository.UserRepository;
import efubtwitter.twitterclone.dto.UserReqDto;
import efubtwitter.twitterclone.dto.UserResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserReqDto userDto){
        userRepository.save(userDto.toEntity(userDto));
    }


    @Transactional
    public UserResDto getUser(Long userNumber){
        User user = userRepository.findById(userNumber).orElseThrow(RuntimeException::new);
        return UserResDto.builder()
                .name(user.getName())
                .userId(user.getUserId())
                .userNumber(userNumber)
                .build();
    }

}
