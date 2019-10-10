package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.repository.RoleRepository;
import com.pubsite.pubsite.repository.UserRepository;
import com.pubsite.pubsite.service.SecurityService;
import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SecurityService securityService;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void saveReg(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public void add(User user) {
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRoles(user.getRoles());

        userRepository.saveAndFlush(user);
    }


    @Override
    public List findAllByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    private SqlParameterSource getSqlParameterByModel(User user) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("username", user.getUsername());
        paramSource.addValue("email", user.getEmail());
        paramSource.addValue("password", user.getPassword());
        paramSource.addValue("password_confirm", user.getPasswordConfirm());
        return paramSource;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE USER SET USERNAME=:username, EMAIL=:email, PASSWORD=:password, PASSWORD_CONFIRM=:password_confirm where id=" + user.getId();
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
    }

    @Override
    public void addNewUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findCurrentLoggedUser() {
        return userRepository.findByUsername(securityService.findLoggedInUsername());
    }

    @Override
    public List<User> findAllUserByPartName(String name) {
        List<User> list = new ArrayList<>();
        list = userRepository.findAllByUsernameIsStartingWith(name);
        return list;
    }

    @Override
    public Optional findUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

}
