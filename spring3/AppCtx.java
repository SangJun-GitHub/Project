package spring3;//package spring2;

/**
 * Created by bobsang89@gmail.com on 2018-09-11
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring3.ChangePasswordService;
import spring3.MemberDao;
import spring3.MemberRegisterService;

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

        return new ChangePasswordService();
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1(){
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSuummaryPrinter memberPrinter2(){
        return new MemberSuummaryPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
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
