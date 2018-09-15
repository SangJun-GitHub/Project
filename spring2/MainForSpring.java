package spring2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring2.AppCtx;
//import spring2.Assembler;
import spring2.ChangePasswordService;
import spring2.DuplicateMemberException;
import spring2.MemberNotFoundException;
import spring2.MemberRegisterService;
import spring2.RegisterRequest;
import spring2.WrongIdPasswordException;
import spring2.MemberListPrinter;
import spring2.MemberInfoPrinter;
import spring2.VersionPrinter;

public class MainForSpring {

    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {

        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter the command : ");
            String command = reader.readLine();
            if(command.equalsIgnoreCase("exit")){
                System.out.println("exit");
                break;
            }
            if(command.startsWith("new")){
                processNewCommand(command.split(" "));
                continue;
            } else if(command.startsWith("change")){
                processChangeCommand(command.split(" "));
                continue;
            } else if(command.equals("list")){
                processListCommand();
                continue;
            } else if(command.startsWith("info ")){
                processInfoCommand(command.split(" "));
                continue;
            } else if(command.equals("version")){
                processVersionCommand();
                continue;
            }
            printHelp();
        }
    }

    //private static Assembler assembler = new Assembler();

    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }
        //MemberRegisterService registerService = assembler.getMemberRegisterService();
        MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(args[1]);
        req.setName(args[2]);
        req.setPassword(args[3]);
        req.setConfirmPassword(args[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("The password is not matched");
            return;
        }
        try {
            registerService.regist(req);
            System.out.println("enrolled");
        } catch (DuplicateMemberException e) {
            System.out.println("It already exit the Email.\n");
        }
    }

    private static void processChangeCommand(String[] args){
        if(args.length !=4){
            printHelp();
            return;
        }
        //ChangePasswordService changePasswordService = assembler.getChangePasswordService();
        ChangePasswordService changePasswordService = ctx.getBean("changePasswordService", ChangePasswordService.class);
        try{
            changePasswordService.changePassword(args[1],args[2],args[3]);
            System.out.println("password was changed.\n");
        }catch(MemberNotFoundException e){
            System.out.println("Not exist Email\n");
        }catch(WrongIdPasswordException e){
            System.out.println("Not matched Email and password\n");
        }
    }

    private static void processListCommand(){
        MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    private static void processInfoCommand(String[] arg){
        if(arg.length != 2){
            printHelp();
            return;
        }
        MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
        memberInfoPrinter.printMemberInfo(arg[1]);
    }

    private static void processVersionCommand(){
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }

    private static void printHelp(){
        System.out.println();
        System.out.println("Wrong command");
        System.out.println("Command manual:");
        System.out.println("new Email Name Password passwordConfirm");
        System.out.println("change Email CurrentPassword NewPassword");
        System.out.println();
    }

}
