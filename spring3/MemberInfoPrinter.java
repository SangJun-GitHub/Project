package spring3;

/**
 * Created by bobsang89@gmail.com on 2018-09-15
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);
        if(member == null){
            System.out.println("No data");
            return;
        }
        memberPrinter.memberPrint(member);
        System.out.println();
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    @Autowired
    public void setMemberPrinter(MemberPrinter memberPrinter){
        this.memberPrinter = memberPrinter;
    }
}