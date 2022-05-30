package efubtwitter.twitterclone.service;

import efubtwitter.twitterclone.domain.entity.Post;
import efubtwitter.twitterclone.domain.entity.User;
import efubtwitter.twitterclone.domain.repository.PostRepository;
import efubtwitter.twitterclone.domain.repository.UserRepository;
import efubtwitter.twitterclone.dto.PostReqDto;
import efubtwitter.twitterclone.dto.PostResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 트위터 게시글 작성
    @Transactional
    public PostResDto createPost(PostReqDto postReqDto){
        User user = userRepository.getById(postReqDto.getUserNumber());
        Post post = Post.builder()
                .userNumber(user.getUserNumber())
                .contents(postReqDto.getContents())
                .build();
        Post newPost = postRepository.save(post);
        return new PostResDto(newPost);
    }

    // 트위터 게시글 전체 조회
    @Transactional
    public List<PostResDto> getPostList() {
        List<Post> postList = postRepository.findAll();
        List<PostResDto> postResDtoList = new ArrayList<>();
        for (Post post : postList) {
            PostResDto postResDto = new PostResDto(post);
            postResDtoList.add(postResDto);
        }
        return postResDtoList;
    }
    // 트위터 특정 게시글 조회
    @Transactional
    public List<PostResDto> getPostListByUser(Long userNumber) {
        List<Post> postList = postRepository.findAllByUserNumber(userNumber);
        List<PostResDto> postResDtoList = new ArrayList<>();
        for (Post post : postList) {
            PostResDto postResDto = new PostResDto(post);
            postResDtoList.add(postResDto);
        }
        return postResDtoList;

    }
    // 트위터 게시글 삭제
    @Transactional
    public void deletePost(Long postNumber){
        postRepository.deleteByPostNumber(postNumber);
    }


}

