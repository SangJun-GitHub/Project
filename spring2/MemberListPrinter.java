package spring2;

/**
 * Created by bobsang89@gmail.com on 2018-09-11
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */

import java.util.Collection;

public class MemberListPrinter {

    private  MemberDao memberDao;
    private  MemberPrinter printer;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer){
        this.memberDao= memberDao;
        this.printer = printer;
    }

    public void printAll(){
        Collection<Member> members = memberDao.selecAll();
        members.forEach(member -> printer. memberPrint(member));
    }
}
