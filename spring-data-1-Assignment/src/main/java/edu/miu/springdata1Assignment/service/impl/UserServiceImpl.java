package edu.miu.springdata1Assignment.service.impl;

import edu.miu.springdata1Assignment.dto.UserDto;
import edu.miu.springdata1Assignment.entity.User;
import edu.miu.springdata1Assignment.model.LoginRequest;
import edu.miu.springdata1Assignment.model.LoginResponse;
import edu.miu.springdata1Assignment.model.RefreshTokenRequest;
import edu.miu.springdata1Assignment.repository.UserRepo;
import edu.miu.springdata1Assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    @Override
    public List<UserDto> findAll(){
        var users = (List<User>) userRepo.findAll();
        return users.stream().map(x->modelMapper.map(x, UserDto.class)).toList();
    }
    @Override
    public UserDto findById(int id){
        var user = userRepo.findById(id);
        return modelMapper.map(user,UserDto.class);
    }
    @Override
    public void save(User user){
        userRepo.save(user);
    }
    @Override
    public void update(int id, User user){
        userRepo.findById(id).orElseThrow(() -> new RuntimeException("User does not exists"));;
        userRepo.save(user);
    }
    @Override
    public void delete(int id){
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User does not exists"));
        userRepo.delete(user);
    }
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}
