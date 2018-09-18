package spring3;

/**
 * Created by bobsang89@gmail.com on 2018-09-11
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberListPrinter(){
    }

    public void printAll(){
        Collection<Member> members = memberDao.selecAll();
        members.forEach(member -> printer. memberPrint(member));
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    @Autowired
    @Qualifier("printer")
    public void setMemberPrinter(MemberPrinter printer){
        this.printer = printer;
    }

}
