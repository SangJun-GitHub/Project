package spring2;

/**
 * Created by bobsang89@gmail.com on 2018-09-15
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring2.MemberDao;
import spring2.MemberPrinter;

@Configuration
public class AppConf1 {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
}
