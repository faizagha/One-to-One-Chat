package com.faiz.one_on_one_chat.Services;

import com.faiz.one_on_one_chat.Model.Status;
import com.faiz.one_on_one_chat.Model.User;
import com.faiz.one_on_one_chat.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnectUser(User user) {
        var userExists = userRepository.findById(user.getNickName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (userExists != null) {
            user.setStatus(Status.OFFLINE);
        }
        userRepository.save(user);
    }

    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
