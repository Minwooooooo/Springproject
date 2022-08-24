/*
package com.project.project_week3.test;



import com.project.project_week3.Entity.Authority;
import com.project.project_week3.Entity.User;
import com.project.project_week3.Repository.AuthorityRepository;
import com.project.project_week3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataRunner implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 테스트 User 생성
        User testUser1 = new User.test("asdf", "123", "admin1", true);
        User testUser2 = new User.test("zxcv", "123", "test2", true);
        testUser1 = userRepository.save(testUser1);
        testUser2 = userRepository.save(testUser2);

        Authority authority1 = new Authority("ROLE_ADMIN");
        Authority authority2 = new Authority("ROLE_USER");
        authority1 = authorityRepository.save(authority1);
        authority2 = authorityRepository.save(authority2);


    }
}
 */