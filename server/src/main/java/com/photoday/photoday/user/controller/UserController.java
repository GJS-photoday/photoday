package com.photoday.photoday.user.controller;

import com.photoday.photoday.dto.SingleResponseDto;
import com.photoday.photoday.user.dto.FollowDto;
import com.photoday.photoday.user.dto.UserDto;
import com.photoday.photoday.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping
    public ResponseEntity postUser(@RequestBody UserDto.Post userPostDto) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getUser() {
        UserDto.Response response = new UserDto.Response(1L, "hihihi", "", "안녕하세용 사진 찍는걸 좋아하는 사람입니다!", 100, 0, 20, 20);
        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity patchUser() {
        UserDto.Response response = new UserDto.Response(1L, "hihihi", "", "안녕하세용 사진 찍는걸 좋아하는 사람입니다!", 100, 0, 20, 20);
        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/follow")
    public ResponseEntity getFollowUsers() {
        User user1 = new User(1L, "hi");
        User user2 = new User(2L, "hello");
        int follower = 10;
        int following = 10;
        List<User> followers = List.of(user1, user2);
        List<User> followings = List.of(user1, user2);
        FollowDto.ResponseFollowUsers response = new FollowDto.ResponseFollowUsers(followers, followings, follower, following);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @PostMapping("/follow/{following-id}")
    public ResponseEntity followingUser(@PathVariable("following-id") long followingId) {
        User user1 = new User(1L, "hi");
        User user2 = new User(2L, "hello");
        int follower = 10;
        int following = 10;
        List<User> followers = List.of(user1, user2);
        List<User> followings = List.of(user1, user2);
        FollowDto.ResponseFollowUsers response = new FollowDto.ResponseFollowUsers(followers, followings, follower, following);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }
}
