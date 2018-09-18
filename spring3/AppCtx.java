package spring3;

/**
 * Created by bobsang89@gmail.com on 2018-09-11
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring3.ChangePasswordService;
import spring3.MemberDao;
import spring3.MemberRegisterService;
import spring3.MemberPrinter;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterService(){
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePasswordService(){
//        ChangePasswordService PasswordService = new ChangePasswordService();
//        PasswordService.setMemberDao(memberDao());  //DI
        return new ChangePasswordService();
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
//        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
//        memberInfoPrinter.setMemberDao(memberDao());
//        memberInfoPrinter.setMemberPrinter(memberPrinter());
        return new MemberInfoPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(1);
        versionPrinter.setMinorVersion(3);
        return versionPrinter;
    }
}
