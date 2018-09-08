package spring2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import spring2.Assembler;
import spring2.ChangePasswordService;
import spring2.DuplicateMemberException;
import spring2.MemberNotFoundException;
import spring2.MemberRegisterService;
import spring2.RegisterRequest;
import spring2.WrongIdPasswordException;

public class MainForAssembler {

    public static void main(String[] args) throws IOException {
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
            }
            printHelp();
        }
    }

    private static Assembler assembler = new Assembler();

    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }


        MemberRegisterService registerService = assembler.getMemberRegisterService();
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
            System.out.println("It already exit the Eamail.\n");
        }
    }
    private static void processChangeCommand(String[] args){
        if(args.length !=4){
            printHelp();
            return;
        }
        ChangePasswordService changePasswordService = assembler.getChangePasswordService();
        try{
            changePasswordService.changePassword(args[1],args[2],args[3]);
            System.out.println("password was changed.\n");
        }catch(MemberNotFoundException e){
            System.out.println("Not exist Email\n");
        }catch(WrongIdPasswordException e){
            System.out.println("Not matched Email and password\n");
        }
    }

}
