package spring2;

/**
 * Created by bobsang89@gmail.com on 2018-09-17
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import spring2.ChangePasswordService;
import spring2.MemberDao;
import spring2.MemberInfoPrinter;
import spring2.MemberListPrinter;
import spring2.MemberPrinter;
import spring2.MemberRegisterService;
import spring2.VersionPrinter;

@Configuration
public class AppConf2 {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    public MemberRegisterService memberRegisterService(){
        return new MemberRegisterService(memberDao);
    }

    @Bean
    public ChangePasswordService changePasswordService(){
        ChangePasswordService passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao);
        return passwordService;
    }

    @Bean
    public MemberListPrinter memberListPrinter(){
        return new MemberListPrinter(memberDao, memberPrinter);
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
        memberInfoPrinter.setMemberDao(memberDao);
        memberInfoPrinter.setMemberPrinter(memberPrinter);
        return memberInfoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(1);
        versionPrinter.setMinorVersion(2);
        return versionPrinter;
    }
}
