package spring3;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;
    //Dependent object is injected through constructor
    public MemberRegisterService(){

    }

    public long regist(RegisterRequest req){
        //Use method of the dependent object
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null){
            throw new DuplicateMemberException("Duplicated Email" + req.getEmail());
        }
        Member newMember =new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
