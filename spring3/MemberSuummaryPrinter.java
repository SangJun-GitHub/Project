package spring3;

/**
 * Created by bobsang89@gmail.com on 2018-09-18
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */
public class MemberSuummaryPrinter extends MemberPrinter{

    @Override
    public void print(Member member){
        System.out.printf("Member Info: Email = %s, Name = %s\n", member.getEmail(), member.getName());
    }

}
