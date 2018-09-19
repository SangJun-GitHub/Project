package spring3;

/**
 * Created by bobsang89@gmail.com on 2018-09-11
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */
public class MemberPrinter {
    public  void print(Member member){
        System.out.println(
                "Member Information: ID = "+ member.getId() +" Email = " + member.getEmail() +
                        " Name = " + member.getName() + " Date of enrollment = " + member.getRegisterDateTime());
    }
}
