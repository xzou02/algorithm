public class commandline {
    static ParsedCommand commandline(String cmdline) {
        ParsedCommand pc = new ParsedCommand();
        String s = cmdline;
        s = s.trim();
        int len = s.length();

        String arg = new String("");
        String switches = new String("");

        int backslash = 0;
        int blank = 0;
        int cancel = 0;

        for (int i = 0; i < len; i++){
            char ch = s.charAt(i);
            int num = ch;

            if (ch == '/'){
                backslash = 1;
                blank = 0;
                cancel = 0;
            }
            else if (ch == '-' && backslash == 1 && cmdline.charAt(i - 1) == '/'){
                cancel = 1;
            }
            else if ( (((65 <= num) && (num <= 90))|| ((97 <= num) && (num <= 122))) && backslash == 1){
                switches += Character.toString(ch);

                if(backslash == 1 && cancel == 0){
                    switches = switches.toUpperCase();
                    pc.switches.add(switches);
                }
                else if (backslash == 1 && cancel == 1){
                    switches = switches.toUpperCase();
                    if (pc.switches.contains(switches)){
                        pc.switches.remove(switches);
                    }
                }
                switches = "";
                blank = 0;
            }
            else {
                if (ch == ' ') {
                    blank = 1;
                }
                else if((blank == 1 || backslash == 1) && !arg.equals("")) {
                    pc.argv.add(arg);
                    arg = "";
                    blank = 0;
                    arg += Character.toString(ch);
                }
                else{
                    System.out.println(ch);
                    blank = 0;
                    arg += Character.toString(ch);
                }
                backslash = 0;
                cancel = 0;
            }
        }
        if(!arg.equals("")){
            pc.argv.add(arg);
        }
        if (pc.argv.size() == 0) return null;
        return pc;
    }
}
