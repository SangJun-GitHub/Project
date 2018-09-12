package spring2;

/**
 * Created by bobsang89@gmail.com on 2018-09-11
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring2.ChangePasswordService;
import spring2.MemberDao;
import spring2.MemberRegisterService;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterService(){
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordService(){
        ChangePasswordService PasswordService = new ChangePasswordService();
        PasswordService.setMemberDao(memberDao());
        return PasswordService;
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter(memberDao(), memberPrinter());
    }
}
