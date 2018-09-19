package spring3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * Created by bobsang89@gmail.com on 2018-09-11
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */
public class MemberPrinter {
//    @Autowired
//    private Optional<DateTimeFormatter> formatOpt;

    private DateTimeFormatter dateTimeFormatter;

//    public  void print(Member member){
//        this.dateTimeFormatter = formatOpt.orElse(null);
//        if(dateTimeFormatter == null){
//            System.out.printf("Member Information: ID=%d, Email=%s, Name=%s, Date of enrollment=%tF\n",
//                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
//        }else{
//            System.out.printf("Member Information: ID=%d, Email=%s, Name=%s, Date of enrollment=%tF\n",
//                    member.getId(), member.getEmail(), member.getName(),
//                    dateTimeFormatter.format(member.getRegisterDateTime()));
//        }
//    }

//    @Autowired(required = false)
//    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter){
//        this.dateTimeFormatter = dateTimeFormatter;
//    }

//    @Autowired
//    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter){
//        this.dateTimeFormatter = dateTimeFormatter;
//    }

//    @Autowired
//    public void setDateTimeFormatter(Optional<DateTimeFormatter> formatOpt){
//        this.formatOpt = formatOpt;
//        if(formatOpt.isPresent()) {
//            this.dateTimeFormatter = formatOpt.get();
//        }else{
//            this.dateTimeFormatter = null;
//        }
//    }

    public MemberPrinter(){
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
    }

    public void print(Member member){
        if(dateTimeFormatter == null){
            System.out.printf("Member Information: ID=%d, Email=%s, Name=%s, Date of enrollment=%tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        }else{
            System.out.printf("Member Information: ID=%d, Email=%s, Name=%s, Date of enrollment=%s\n",
                    member.getId(), member.getEmail(), member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
}
