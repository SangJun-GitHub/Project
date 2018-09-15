package spring2;

/**
 * Created by bobsang89@gmail.com on 2018-09-15
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */
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

    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void setMemberPrinter(MemberPrinter memberPrinter){
        this.memberPrinter = memberPrinter;
    }
}
